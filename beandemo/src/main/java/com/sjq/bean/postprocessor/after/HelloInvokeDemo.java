package com.sjq.bean.postprocessor.after;

import org.springframework.stereotype.Component;

@Component
public class HelloInvokeDemo {
	@HelloVersionInjected
	private IHelloService helloService;
	
	public void hello(){
        helloService.hello();
   }
}
