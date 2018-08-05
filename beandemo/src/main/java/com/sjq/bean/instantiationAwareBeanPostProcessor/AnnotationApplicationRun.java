package com.sjq.bean.instantiationAwareBeanPostProcessor;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AnnotationApplicationRun {
	public static void main(String[] args) {
		new AnnotationConfigApplicationContext(InstantiationAwareConfig.class);
	}
}
