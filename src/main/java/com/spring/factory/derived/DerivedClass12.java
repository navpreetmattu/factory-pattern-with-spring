package com.spring.factory.derived;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;

import com.spring.factory.base.BaseClass1;
import com.spring.factory.common.InjectionClass;
import com.spring.factory.common.MyDto;

public class DerivedClass12 extends BaseClass1 {

	@Value("${factory.name}")
	private String name;

	@Autowired
	private MyDto dto;
	
	@Autowired
	@Qualifier("Injection2")
	protected ObjectFactory<InjectionClass> injClass;

	@Override
	public String abstractMethod1() {
		count = 2;
		return String.format(name, this, injClass.getObject().getString());
	}

	@Override
	public String toString() {
		return "DerivedClass12 " + dto + "count is " + count;
	}
}
