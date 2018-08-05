package com.sjq.bean.container;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class BeanPostProcessorDemo implements BeanPostProcessor{
	
	public BeanPostProcessorDemo() {
		super();
		System.out.println("【BeanPostProcessor】实现类构造器！！");
	}
	/**
	 * 第一个参数都是要处理的Bean对象，第二个参数都是Bean的name。
	 */
	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("第六步：【BeanPostProcessor接口】方法postProcessBeforeInitialization对属性进行更改！");
		System.out.println("【BeanPostProcessor接口】方法postProcessBeforeInitialization，beanName="+beanName);
		return bean;
	}
	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("第九步：【BeanPostProcessor接口】方法postProcessAfterInitialization对属性进行更改！");
		System.out.println("【BeanPostProcessor接口】方法postProcessAfterInitialization，beanName="+beanName);
		return bean;
	}
}
