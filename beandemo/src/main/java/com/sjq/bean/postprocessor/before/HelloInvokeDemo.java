package com.sjq.bean.postprocessor.before;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class HelloInvokeDemo {
	@Resource
	private HelloServiceImplV1 helloServiceImplV1;
	@Resource
	private HelloServiceImplV2 helloServiceImplV2;
	
	@Value("${hello.version}")
	private String version;
	
	public void hello(){
        if("A".equals(version)){
             helloServiceImplV1.hello();
        }else{
             helloServiceImplV2.hello();
        }
   }
}
