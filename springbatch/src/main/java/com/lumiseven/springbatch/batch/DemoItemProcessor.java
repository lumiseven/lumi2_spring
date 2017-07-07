package com.lumiseven.springbatch.batch;

import org.springframework.batch.item.validator.ValidatingItemProcessor;
import org.springframework.batch.item.validator.ValidationException;

import com.lumiseven.springbatch.domain.Member;

/*
 * 数据处理
 */
public class DemoItemProcessor extends ValidatingItemProcessor<Member>{
	
	@Override
	public Member process(Member item) throws ValidationException {
		super.process(item);
		
		if (item.getName().equals("nation3")){
			item.setNation("nation3");
		} else {
			item.setNation("not nation3");
		}
		return item;
	}
	
}
