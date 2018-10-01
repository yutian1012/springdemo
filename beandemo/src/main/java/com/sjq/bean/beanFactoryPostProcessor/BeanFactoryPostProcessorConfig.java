package com.sjq.bean.beanFactoryPostProcessor;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackageClasses=BeanFactoryPostProcessorDemo.class)
public class BeanFactoryPostProcessorConfig {
	
}
