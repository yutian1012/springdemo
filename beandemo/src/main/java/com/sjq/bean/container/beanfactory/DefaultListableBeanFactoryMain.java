package com.sjq.bean.container.beanfactory;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.ClassPathResource;

import com.sjq.bean.container.beanfactory.bean.CompactDisc;

public class DefaultListableBeanFactoryMain {
	public static void main(String[] args) {
        ClassPathResource res=new ClassPathResource("META-INF/spring/app-context.xml");
        DefaultListableBeanFactory factory=new DefaultListableBeanFactory();
        XmlBeanDefinitionReader reader=new XmlBeanDefinitionReader(factory);
        reader.loadBeanDefinitions(res);
        
        CompactDisc disc=factory.getBean(CompactDisc.class);
        disc.play();
    }
}
