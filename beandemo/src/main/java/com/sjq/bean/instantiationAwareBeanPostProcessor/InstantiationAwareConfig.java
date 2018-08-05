package com.sjq.bean.instantiationAwareBeanPostProcessor;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackageClasses=InstantiationAwareBeanPostProcessorDemo.class)
public class InstantiationAwareConfig {
	
}
