package com.sjq.bean.postprocessor.before;

import org.springframework.stereotype.Service;

@Service
public class HelloServiceImplV2 implements IHelloService{

	@Override
	public void hello() {
		System.out.println("【HelloServiceImplV2】 version 2");
	}

}
