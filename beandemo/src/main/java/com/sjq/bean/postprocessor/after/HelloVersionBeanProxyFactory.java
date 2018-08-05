package com.sjq.bean.postprocessor.after;

import java.lang.reflect.Method;
import java.util.Map;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.util.StringUtils;

public class HelloVersionBeanProxyFactory {
	
	/**
	 * 创建代理对象
	 * @param targetClass
	 * @param beans
	 * @return
	 */
	public static Object createProxy(Class<?> targetClass, Map<String, ?> beans) {
		ProxyFactory proxyFactory = new ProxyFactory();
		proxyFactory.setInterfaces(targetClass);
		proxyFactory.addAdvice(new HelloVersionMethodInterceptor(targetClass, beans)); 
		return proxyFactory.getProxy(); 
	} 
	
	/**
	 * 实现代理对象，当调用代理对象的方法时，都会执行invoke方法
	 * MethodInterceptor实现了Advice接口
	 */
	static class HelloVersionMethodInterceptor implements MethodInterceptor {
		private String classSwitch; 
		private Object beanOfSwitchOn; //开关打开时使用V2实现类
		private Object beanOfSwitchOff; //开关关闭时使用V1实现类
		
		public HelloVersionMethodInterceptor(Class<?> targetClass, Map<String, ?> beans) {
			String interfaceName = StringUtils.uncapitalize(targetClass.getSimpleName()); 
			if(targetClass.isAnnotationPresent(HelloVersionSwitch.class)){ 
				this.classSwitch =((HelloVersionSwitch)targetClass.getAnnotation(HelloVersionSwitch.class)).value();
			} 
			this.beanOfSwitchOn = beans.get(this.buildBeanName(interfaceName, true));
			this.beanOfSwitchOff = beans.get(this.buildBeanName(interfaceName, false));
		} 
		/**
		 * 获取类名称，实现类名称的命名与接口是有规则的
		 * @param interfaceName
		 * @param isSwitchOn
		 * @return
		 */
		private String buildBeanName(String interfaceName, boolean isSwitchOn) {
			String className=interfaceName;
			if(interfaceName.startsWith("i")) {
				className= StringUtils.uncapitalize(interfaceName.replaceFirst("i", ""));//首字母小写
			}
			
			return className + "Impl" + (isSwitchOn ? "V2" : "V1"); 
		}
		
		@Override 
		public Object invoke(MethodInvocation invocation) throws Throwable {
			Method method = invocation.getMethod(); 
			String switchName = this.classSwitch; //类上的注解value值
			if (method.isAnnotationPresent(HelloVersionSwitch.class)) { 
				switchName = method.getAnnotation(HelloVersionSwitch.class).value(); //获取方法上注解的value值
			} 
			if (StringUtils.isEmpty(switchName)) { 
				throw new IllegalStateException("HelloVersionSwitch's value is blank, method:" + method.getName());
			} 
			return invocation.getMethod().invoke(getTargetBean(switchName), invocation.getArguments()); 
		} 
		
		public Object getTargetBean(String switchName) { 
			boolean switchOn; 
			if (HelloVersion.A.equals(switchName)) { 
				switchOn = false; 
			} else if (HelloVersion.B.equals(switchName)) {
				switchOn = true; 
			} else { 
				switchOn = true;
			} 
			return switchOn ? beanOfSwitchOn : beanOfSwitchOff; 
		}

	}

}
