package com.lumiseven.springbatch.config;

import javax.sql.DataSource;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.launch.support.SimpleJobLauncher;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.repository.support.JobRepositoryFactoryBean;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.batch.item.validator.Validator;
import org.springframework.batch.support.DatabaseType;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.transaction.PlatformTransactionManager;

import com.lumiseven.springbatch.batch.DemoBeanValidator;
import com.lumiseven.springbatch.batch.DemoItemProcessor;
import com.lumiseven.springbatch.batch.DemoJobListener;
import com.lumiseven.springbatch.domain.Member;

/*
 * spring batch 自动触发
 */
//@Configuration
@EnableBatchProcessing
public class DemoBatchConfig {
	/*
	 * 配置JobRepository
	 */
	@Bean
	public JobRepository jobRepository(DataSource dataSource, PlatformTransactionManager platformTransactionManager) throws Exception {
		JobRepositoryFactoryBean jobRepositoryFactoryBean = new JobRepositoryFactoryBean();
		jobRepositoryFactoryBean.setDataSource(dataSource);
		jobRepositoryFactoryBean.setTransactionManager(platformTransactionManager);
		jobRepositoryFactoryBean.setDatabaseType(DatabaseType.MYSQL.name());
		return jobRepositoryFactoryBean.getObject();
	}
	
	/*
	 * 配置jobLauncher
	 */
	@Bean
	public SimpleJobLauncher jobLauncher(DataSource dataSource, PlatformTransactionManager platformTransactionManager) throws Exception {
		SimpleJobLauncher jobLauncher = new SimpleJobLauncher();
		jobLauncher.setJobRepository(jobRepository(dataSource, platformTransactionManager));
		return jobLauncher;
	}
	
	/*
	 * 配置job
	 */
	@Bean
	public Job importJob(JobBuilderFactory jobs, Step s1){
		return jobs.get("importJob")
				.incrementer(new RunIdIncrementer())
				.flow(s1)
				.end()
				.listener(demoJobListener())//job listener
				.build();
	}
	
	/*
	 * 配置step
	 */
	@Bean
	public Step step1(StepBuilderFactory stepBuilderFactory, ItemReader<Member> reader, ItemWriter<Member> writer, ItemProcessor<Member, Member> processor){
		return stepBuilderFactory.get("step1")
				.<Member, Member>chunk(65000)
				.reader(reader)
				.processor(processor)
				.writer(writer)
				.build();
	}
	
	/*
	 * 配置itemReader
	 */
	@Bean
	public ItemReader<Member> reader() throws Exception {
		FlatFileItemReader<Member> reader = new FlatFileItemReader<Member>();
		reader.setResource(new ClassPathResource("testmember.data"));//设置data文件路径
		reader.setLineMapper(new DefaultLineMapper<Member>(){{//设置文件数据和domain model 的对应映射关系
			setLineTokenizer(new DelimitedLineTokenizer(){{
				setNames(new String[] {"name", "age", "nation", "address"});
			}});
			setFieldSetMapper(new BeanWrapperFieldSetMapper<Member>(){{
				setTargetType(Member.class);
			}});
		}});
		return reader;
	}

	/*
	 * 配置itemProcessor
	 */
	@Bean
	public ItemProcessor<Member, Member> processor(){
		DemoItemProcessor processor = new DemoItemProcessor();
		processor.setValidator(demoBeanValidator());
		return processor;
	}
	
	/*
	 * 配置itemWriter
	 */
	@Bean
	public ItemWriter<Member> writer(DataSource dataSource){
		JdbcBatchItemWriter<Member> writer = new JdbcBatchItemWriter<Member>();
		writer.setItemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<Member>());
		String sql = "insert into member " + "(name, age, nation, address) " + "values (:name, :age, :nation, :address)";
		writer.setSql(sql);
		writer.setDataSource(dataSource);
		return writer;
	}
	
	@Bean
	public Validator<Member> demoBeanValidator(){
		return new DemoBeanValidator<Member>();
	}
	
	@Bean
	public DemoJobListener demoJobListener(){
		return new DemoJobListener();
	}
}
