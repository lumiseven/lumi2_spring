package com.lumiseven.springdatajpatest01.support;

import java.io.Serializable;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;

/*
 * 构造一个自定义Respository接口同时实现JpaRepository, JpaSpecificationExecutor(非必要)
 */
@NoRepositoryBean
public interface CustomRepository<T, ID extends Serializable> extends JpaRepository<T, ID>, JpaSpecificationExecutor<T> {
	
	Page<T> findByAuto(T example, Pageable pageable);

}
