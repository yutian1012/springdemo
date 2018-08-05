package com.sjq.bean.postprocessor.before;

import org.springframework.stereotype.Service;

@Service
public class HelloServiceImplV1 implements IHelloService{

	@Override
	public void hello() {
		System.out.println("【HelloServiceImplV1】 version 1");
	}

}
