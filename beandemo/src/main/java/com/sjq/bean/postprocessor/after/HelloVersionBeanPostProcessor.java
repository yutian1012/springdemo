package com.sjq.bean.postprocessor.after;

import java.lang.reflect.Field;
import java.util.Map;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanCreationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class HelloVersionBeanPostProcessor implements BeanPostProcessor{
	
	@Autowired
    private ApplicationContext applicationContext;

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		return bean;
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		Class<?> clazz = bean.getClass();
		Field[] fields = clazz.getDeclaredFields();
		for (Field f : fields) {
			// 初始化对象时，判断类的属性是否使用了HelloVersionInjected注解修饰
			if (f.isAnnotationPresent(HelloVersionInjected.class)) {
				if (!f.getType().isInterface()) {//判断对象的声明是否是接口
					throw new BeanCreationException("HelloVersionInjected field must be declared as an interface:" 
						+ f.getName() + " @Class " + clazz.getName()); 
				} 
				try { 
					//处理属性的注入
					this.handleVerionInjected(f, bean, f.getType()); 
				} catch (IllegalAccessException e) {
					throw new BeanCreationException("Exception thrown when handleAutowiredRouting", e);
				}
			} 
		} return bean;
	}
	/**
	 * 注入类属性，这里通过代理实现属性的注入
	 */
	private void handleVerionInjected(Field field, Object bean, Class<?> type) throws IllegalAccessException { 
		Map<String, ?> candidates = this.applicationContext.getBeansOfType(type);
		field.setAccessible(true); 
		if (candidates.size() == 1) { 
			field.set(bean, candidates.values().iterator().next());
		} else if (candidates.size() == 2) { 
			Object proxy = HelloVersionBeanProxyFactory.createProxy(type, candidates);
			field.set(bean, proxy); 
		} else { 
			throw new IllegalArgumentException("Find more than 2 beans for type: " + type);
		}
	}

}
