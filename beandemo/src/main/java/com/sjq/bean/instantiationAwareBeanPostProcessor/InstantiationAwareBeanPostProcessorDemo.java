package com.sjq.bean.instantiationAwareBeanPostProcessor;

import java.beans.PropertyDescriptor;

import org.springframework.beans.BeansException;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessorAdapter;
import org.springframework.stereotype.Component;

@Component
public class InstantiationAwareBeanPostProcessorDemo extends InstantiationAwareBeanPostProcessorAdapter  {
	
	public InstantiationAwareBeanPostProcessorDemo() {
		super();
		System.out.println("【InstantiationAwareBeanPostProcessorDemo类】构造函数");
	}
	
	/**
	 * 实例化对象之前调用，即调用对象的构造函数之前执行
	 */
	@Override
	public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {
		 System.out.println("【InstantiationAwareBeanPostProcessorDemo】调用postProcessBeforeInstantiation方法");
		 //System.out.println("【InstantiationAwareBeanPostProcessorDemo】"+beanName);
		 return null;
	}
	
	/**
	 * 实例化对象后，且设置对象属性前执行
	 */
	@Override
	public PropertyValues postProcessPropertyValues(PropertyValues pvs, PropertyDescriptor[] pds, Object bean,
			String beanName) throws BeansException {
		System.out.println("【InstantiationAwareBeanPostProcessorDemo】调用postProcessPropertyValues方法");
		//System.out.println("【InstantiationAwareBeanPostProcessorDemo】"+beanName);
		return pvs;
	}
	/**
	 * BeanPostProcessor的after方法执行之后才执行
	 */
	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("【InstantiationAwareBeanPostProcessorDemo】调用postProcessAfterInitialization方法");
		//System.out.println("【InstantiationAwareBeanPostProcessorDemo】"+beanName);
		return bean;
	}
	
}
