package com.sjq.bean.beanFactoryPostProcessor;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AnnotationApplicationRun {
	public static void main(String[] args) {
		ApplicationContext context=new AnnotationConfigApplicationContext(BeanFactoryPostProcessorConfig.class);
		Student student=context.getBean(Student.class);
		System.out.println(student.getName());
	}
}
