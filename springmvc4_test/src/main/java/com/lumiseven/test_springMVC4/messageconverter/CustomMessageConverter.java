package com.lumiseven.test_springMVC4.messageconverter;

import java.io.IOException;
import java.nio.charset.Charset;

import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.AbstractHttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.util.StreamUtils;

import com.lumiseven.test_springMVC4.domain.DemoObj;

public class CustomMessageConverter extends AbstractHttpMessageConverter<DemoObj>{

	/*
	 * create custom mediaType
	 */
	public CustomMessageConverter(){
		super(new MediaType("application", "lumiseven", Charset.forName("UTF-8")));
	}
	
	@Override
	protected boolean supports(Class<?> clazz) {
		return DemoObj.class.isAssignableFrom(clazz);
	}

	@Override
	protected DemoObj readInternal(Class<? extends DemoObj> clazz, HttpInputMessage inputMessage)
			throws IOException, HttpMessageNotReadableException {
		/*
		 * temp format: int-string
		 */
		String temp = StreamUtils.copyToString(inputMessage.getBody(), Charset.forName("UTF-8"));
		String[] tempArr = temp.split("-");
		return new DemoObj(new Long(tempArr[0]), tempArr[1]);
	}

	@Override
	protected void writeInternal(DemoObj t, HttpOutputMessage outputMessage)
			throws IOException, HttpMessageNotWritableException {
		String output = "springmvc message converter test: " + t.getId() + "-" + t.getName();
		outputMessage.getBody().write(output.getBytes());
	}

}
