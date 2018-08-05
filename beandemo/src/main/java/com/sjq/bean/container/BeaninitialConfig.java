package com.sjq.bean.container;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeaninitialConfig {
	
	@Bean(initMethod="initMethod",destroyMethod="destroyMethod")
	public BeanInitialDemo beanInitialDemo() {
		return new BeanInitialDemo();
	}
	
	@Bean
	public BeanPostProcessorDemo beanPostProcessorDemo() {
		return new BeanPostProcessorDemo();
	}
	
	@Bean
	public Student student() {
		return new Student();
	}
}
