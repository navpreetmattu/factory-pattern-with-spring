package com.spring.factory.derived;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;

import com.spring.factory.base.BaseClass2;
import com.spring.factory.common.InjectionClass;
import com.spring.factory.common.MyDto;

public class DerivedClass21 extends BaseClass2 {

	@Value("${factory.name}")
	private String name;

	@Autowired
	private MyDto dto;

	@Autowired
	@Qualifier("Injection1")
	private InjectionClass injClass;

	@Override
	public String abstractMethod2(String input) {
		return String.format(name, this, injClass.getString()) + "\nEnclosed Data{" + input + "}";
	}

	@Override
	public String toString() {
		return "DerivedClass21 " + dto;
	}
}
