package com.lumiseven.springeip_integrationdsl;

import static java.lang.System.getProperty;

import java.io.File;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.Resource;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.IntegrationFlows;
import org.springframework.integration.dsl.channel.MessageChannels;
import org.springframework.integration.dsl.core.Pollers;
import org.springframework.integration.dsl.file.Files;
import org.springframework.integration.dsl.mail.Mail;
import org.springframework.integration.feed.inbound.FeedEntryMessageSource;
import org.springframework.integration.file.support.FileExistsMode;
import org.springframework.integration.scheduling.PollerMetadata;

import com.rometools.rome.feed.synd.SyndEntry;

@SpringBootApplication
public class SpringeipIntegrationdslApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringeipIntegrationdslApplication.class, args);
	}
	
	
	@Value("https://spring.io/blog.atom")//通过@Vaue获取网络资源
	Resource resource;
	
	/*
	 * 配置默认 轮询方式
	 */
	@Bean(name = PollerMetadata.DEFAULT_POLLER)
	public PollerMetadata poller(){
		return Pollers.fixedRate(500).get();
	}
	
	@Bean
	public FeedEntryMessageSource feedMessageSource() throws IOException{//构造feed的入站通道适配器作为数据输入
		FeedEntryMessageSource messageSource = new FeedEntryMessageSource(resource.getURL(), "news");
		return messageSource;
	}
	
	/*
	 * flow从from开始
	 * 通过route选择路由
	 */
	@Bean
	public IntegrationFlow myFlow() throws IOException {
		return IntegrationFlows.from(feedMessageSource())
				.<SyndEntry, String> route(payload -> payload.getCategories().get(0).getName(),//通过不同消息头的值转向不同的通道
						mapping -> mapping.channelMapping("releases", "releasesChannel")
						.channelMapping("engineering", "engineeringChannel")
						.channelMapping("news", "newsChannel"))
				.get();
	}
	
	/*
	 * release流程
	 */
	@Bean
	public IntegrationFlow releasesFlow(){
		return IntegrationFlows.from(MessageChannels.queue("releasesChannel", 7))
				.<SyndEntry, String> transform(payload -> "<" + payload.getTitle() + ">" + payload.getLink() + getProperty("line.separator"))
				.handle(Files.outboundAdapter(new File("/home/seven/se_ven/springblog"))
						.fileExistsMode(FileExistsMode.APPEND)
						.charset("UTF-8")
						.fileNameGenerator(message -> "releases.txt")
						.get())
				.get();
	}
	
	/*
	 * engineering流程
	 */
	@Bean
	public IntegrationFlow engineeringFlow(){
		return IntegrationFlows.from(MessageChannels.queue("engineeringChannel", 7))
				.<SyndEntry, String> transform(payload -> "<" + payload.getTitle() + ">" + payload.getLink() + getProperty("line.separator"))
				.handle(Files.outboundAdapter(new File("/home/seven/se_ven/springblog"))
						.fileExistsMode(FileExistsMode.APPEND)
						.charset("UTF-8")
						.fileNameGenerator(message -> "engineering.txt")
						.get())
				.get();
	}
	
	/*
	 * news流程
	 */
	@Bean
	public IntegrationFlow newsFlow(){
		return IntegrationFlows.from(MessageChannels.queue("newsChannel", 7))
				.<SyndEntry, String> transform(payload -> "<" + payload.getTitle() + ">" + payload.getLink() + getProperty("line.separator"))
				.enrichHeaders(
						Mail.headers()
						.subject("news from spring")
						.to("lumiseven@yahoo.com")
						.from("lumiseven@yahoo.com"))
				.handle(Mail.outboundAdapter("smtp.yahoo.com")
						.port(25)
						.protocol("smtp")
						.credentials("lumiseven@yahoo.com", "******")
						.javaMailProperties(m -> m.put("mail.debug", "false"))
						, e -> e.id("smtpOut"))
				.get();
	}
}
