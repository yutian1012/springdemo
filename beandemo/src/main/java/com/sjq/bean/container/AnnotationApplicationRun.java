package com.sjq.bean.container;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AnnotationApplicationRun {
	public static void main(String[] args) {
		System.out.println("************************************************************************");
		
		System.out.println("开始初始化容器并创建对象.........");
		
		ApplicationContext context=new AnnotationConfigApplicationContext(BeaninitialConfig.class);
		
		System.out.println("************************************************************************");
		
		System.out.println("第十步：对象创建就绪，可以使用容器内的对象了");
		
		BeanInitialDemo demo=context.getBean(BeanInitialDemo.class);
		
		System.out.println(demo.getBeanName());
		
		System.out.println("现在开始关闭容器！");
		
		System.out.println("************************************************************************");
		
		((AnnotationConfigApplicationContext)context).registerShutdownHook();
	}
}
