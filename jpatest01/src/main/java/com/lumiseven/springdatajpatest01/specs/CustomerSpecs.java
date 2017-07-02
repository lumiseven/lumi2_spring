package com.lumiseven.springdatajpatest01.specs;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.persistence.metamodel.Attribute;
import javax.persistence.metamodel.EntityType;
import javax.persistence.metamodel.SingularAttribute;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.ReflectionUtils;
import org.springframework.util.StringUtils;

import com.google.common.collect.Iterables;

/*
 * 使用Spring Data JPA Specification规范(接口) 构造准则查询
 * 
 * CustomerSpecs通过Specification构造了一个模糊查询准则
 * 当实体类字段为String类型时使用like查询，即 A like '%value%'
 * 当实体类字段为非String时使用=查询，即 A = value
 */
public class CustomerSpecs {
	
	public static <T> Specification<T> byAuto(final EntityManager entityManager, final T example){
		
		//获取当前实体类对象类的类型
		final Class<T> type = (Class<T>) example.getClass();
		
		return new Specification<T>(){

			@Override
			public Predicate toPredicate(Root<T> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				//新建Predicate列表存储构造的查询条件
				List<Predicate> predicates = new ArrayList<Predicate>();
				
				/*
				 * 1.获取实体类的EntityType
				 * 2.通过EntityType获取实体类的属性list
				 */
				EntityType<T> entity = entityManager.getMetamodel().entity(type);
				
				for (Attribute<T, ?> attr : entity.getDeclaredAttributes()){
					//获得实体类对象某一个属性的值
					Object attrValue = getValue(example, attr);
					if (attrValue != null){
						/*
						 * 属性类型是字符串时
						 */
						if (attr.getJavaType() == String.class){
							if (!StringUtils.isEmpty(attrValue)){
								predicates.add(cb.like(root.get(attribute(entity, attr.getName(), String.class)), pattern((String) attrValue)));
							}
						} else {
							predicates.add(cb.equal(root.get(attribute(entity, attr.getName(), attrValue.getClass())), attrValue));
						}
					}
				}
				
				//将条件列表转换为Predicate
				return predicates.isEmpty() ? cb.conjunction() : cb.and(Iterables.toArray(predicates, Predicate.class));
			}
			
			//getValue 反射获取实体类对象对应属性的属性值
			private <T> Object getValue(T example, Attribute<T, ?> attr){
				return ReflectionUtils.getField((Field) attr.getJavaMember(), example);
			}
			
			//获得实体类的当前属性的SingularAttribute, SingularAttribute包含的时实体类的摸个单独属性
			private <E, T> SingularAttribute<T, E> attribute(EntityType<T> entity, String fieldName, Class<E> fieldClass){
				return entity.getDeclaredSingularAttribute(fieldName, fieldClass);
			}
			
		};
		
	}
	
	//构造like的查询条件
	static private String pattern(String str){
		return "%" + str + "%";
	}

}
