package com.lumiseven.springbatch.batch;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.ValidatorFactory;

import org.springframework.batch.item.validator.ValidationException;
import org.springframework.batch.item.validator.Validator;
import org.springframework.beans.factory.InitializingBean;

/*
 * 数据校验
 */
public class DemoBeanValidator<T> implements Validator<T>, InitializingBean{

	private javax.validation.Validator validator;
	
	@Override
	public void afterPropertiesSet() throws Exception {
		/*
		 * 使用JSR-303的Validator校验数据
		 * 此处仅用于validator初始化
		 */
		ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
		validator = validatorFactory.usingContext().getValidator();
	}

	@Override
	public void validate(T value) throws ValidationException {
		Set<ConstraintViolation<T>> constraintViolations = validator.validate(value);
		if (constraintViolations.size() > 0){
			StringBuilder message = new StringBuilder();
			for (ConstraintViolation<T> constraintViolation : constraintViolations){
				message.append(constraintViolation.getMessage() + "\n");
			}
			throw new ValidationException(message.toString());
		}
	}

}
