package com.sjq.bean.instantiationAwareBeanPostProcessor;

import org.springframework.stereotype.Component;

@Component
public class Student {
	private String name;
	
	public Student() {
		System.out.println("【student类】构造函数");
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
