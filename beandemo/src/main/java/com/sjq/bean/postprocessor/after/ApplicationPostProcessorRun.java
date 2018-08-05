package com.sjq.bean.postprocessor.after;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ApplicationPostProcessorRun {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext_PostProcessor.xml");
		
		//调用类
		HelloInvokeDemo invoke=context.getBean(HelloInvokeDemo.class);
		
		invoke.hello();
	}
}
