package com.sjq.bean.instantiationAwareBeanPostProcessor;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ClasspathXmlApplicationRun {
	public static void main(String[] args) {
		new ClassPathXmlApplicationContext("applicationContext_InstantiationAware.xml");
	}
}
