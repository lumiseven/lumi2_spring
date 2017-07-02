package com.lumiseven.springdatajpatest01.support;

import java.io.Serializable;

import javax.persistence.EntityManager;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

import com.lumiseven.springdatajpatest01.specs.CustomerSpecs;

/*
 * 定义实现
 */
public class CustomRepositoryImpl<T, ID extends Serializable> extends SimpleJpaRepository<T, ID> implements CustomRepository<T, ID> {

	
	private final EntityManager em;
	
	public CustomRepositoryImpl(Class<T> domainClass, EntityManager em) {
		super(domainClass, em);
		this.em = em;
	}

	@Override
	public Page<T> findByAuto(T example, Pageable pageable) {
		return findAll(CustomerSpecs.byAuto(em, example), pageable);
	}

}
