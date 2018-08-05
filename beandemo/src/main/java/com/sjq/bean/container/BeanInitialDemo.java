package com.sjq.bean.container;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class BeanInitialDemo implements BeanFactoryAware, BeanNameAware,
         InitializingBean, DisposableBean, ApplicationContextAware{
	// 对象属性
	private String name;
	
	// 对象引用属性
	private Student student;
	
	// 接收spring注入到bean实例的beanFactory
	private BeanFactory beanFactory;
	
	// 接收spring实例化该bean的ID
	private String beanName;
	
	// 接收spring注入到bean实例的ApplicationContext实例（容器应用上下文）
	private ApplicationContext applicationContext;
	
	public BeanInitialDemo() {
		System.out.println("第一步：【构造器】调用构造器实例化");
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		System.out.println("第二步：【注入属性】注入属性name");
		this.name = name;
	}
	
	public Student getStudent() {
		return student;
	}

	@Autowired
	public void setStudent(Student student) {
		System.out.println("第二步：【装配属性】spring装配引用对象Student");
		this.student = student;
	}
	
	// 用于获取容器的BeanFactory实例
	public BeanFactory getBeanFactory() {
		return beanFactory;
	}
	// 用于获取该bean在容器的ID
	public String getBeanName() {
		return beanName;
	}
	// 用于获取spring容器引用上下文对象
	public ApplicationContext getApplicationContext() {
		return applicationContext;
	}

	// BeanNameAware接口
	@Override
	public void setBeanName(String beanName) {
		System.out.println("第三步：【BeanNameAware接口】调用BeanNameAware.setBeanName()");
		this.beanName=beanName;
	}
	
	// BeanFactoryAware接口
	@Override
	public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
		System.out.println("第四步：【BeanFactoryAware接口】调用BeanFactoryAware.setBeanFactory()");
		this.beanFactory=beanFactory;
	}
	
	// ApplicationContextAware接口
	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		System.out.println("第五步：【ApplicationContextAware接口】调用ApplicationContextAware.setApplicationContext()");
		this.applicationContext=applicationContext;
	}
	
	// InitializingBean接口
	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("第七步：【InitializingBean接口】调用InitializingBean.afterPropertiesSet()");
	}

	// 对象自定义的init方法
	public void initMethod() {
		System.out.println("第八步：【init-method】调用<bean>的init-method属性指定的初始化方法");
	}
	
	// DisposableBean接口
	@Override
	public void destroy() throws Exception {
		System.out.println("第十一步：【DiposibleBean接口】调用DiposibleBean.destory()");
	}
	
	// 对象自定义的destroy方法
	public void destroyMethod() {
		System.out.println("第十二步：【destroy-method】调用<bean>的destroy-method属性指定的初始化方法");
	}

}
