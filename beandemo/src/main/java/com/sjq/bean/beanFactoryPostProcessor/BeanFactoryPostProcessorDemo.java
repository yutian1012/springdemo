package com.sjq.bean.beanFactoryPostProcessor;

import org.springframework.beans.BeansException;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

@Component
public class BeanFactoryPostProcessorDemo implements BeanFactoryPostProcessor{

	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
		
		System.out.println("【BeanFactoryPostProcessor】调用postProcessBeanFactory方法");
		
		BeanDefinition bd=beanFactory.getBeanDefinition("student");//获取student对象的配置信息
		MutablePropertyValues pv =  bd.getPropertyValues();
		//相当于在xml中通过property设置属性
		/*<bean id="xxx" class="xxxx" >
			<property name="name" value="zhangsan"></property>
		</bean>*/
		pv.addPropertyValue("name", "zhangsan");
	}

}
