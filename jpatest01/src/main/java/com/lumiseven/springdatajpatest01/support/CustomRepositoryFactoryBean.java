package com.lumiseven.springdatajpatest01.support;

import java.io.Serializable;

import javax.persistence.EntityManager;

import org.springframework.data.jpa.repository.support.JpaRepositoryFactory;
import org.springframework.data.jpa.repository.support.JpaRepositoryFactoryBean;
import org.springframework.data.jpa.repository.support.QueryDslJpaRepository;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.core.RepositoryInformation;
import org.springframework.data.repository.core.RepositoryMetadata;
import org.springframework.data.repository.core.support.RepositoryFactorySupport;

/*
 * 自定义RepostitoryFactoryBean
 * 
 * 1.继承JpaRepositoryFactoryBean类，实现createRepositoryFactory方法
 * 2.创建RepositoryFactory类，选择继承JpaRepositoryFactory，
 * 	覆盖JpaRepositoryFactory 的getTargetRepository方法返回自定义repository
 * 	覆盖JpaRepositoryFactory 的getRepositoryBaseClass方法返回自定义repository的class
 */
public class CustomRepositoryFactoryBean<T extends Repository<S, ID>, S, ID extends Serializable> extends JpaRepositoryFactoryBean<T, S, ID>{
	
	public CustomRepositoryFactoryBean(Class<? extends T> repositoryInterface) {
		super(repositoryInterface);
	}

	@Override
	protected RepositoryFactorySupport createRepositoryFactory(EntityManager entityManager) {
		return new CustomRepositoryFactory(entityManager);
	}
	
	private static class CustomRepositoryFactory extends JpaRepositoryFactory{

		public CustomRepositoryFactory(EntityManager entityManager) {
			super(entityManager);
		}
		
		@SuppressWarnings("unchecked")
		@Override
		protected <T, ID extends Serializable> SimpleJpaRepository<?, ?> getTargetRepository(
				RepositoryInformation information, EntityManager entityManager) {
			return new CustomRepositoryImpl<T, ID>((Class<T>) information.getDomainType(), entityManager);
		}
		
		@Override
		protected Class<?> getRepositoryBaseClass(RepositoryMetadata metadata) {
			return CustomRepositoryImpl.class;
		}
		
	}


}
