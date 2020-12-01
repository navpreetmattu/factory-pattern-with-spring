package com.spring.factory.derived;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.spring.factory.base.BaseClass1;
import com.spring.factory.common.InjectionClass1;
import com.spring.factory.common.MyDto;

@Component("DERIVEDCLASS11")
public class DerivedClass11 extends BaseClass1 {

	@Value("${factory.name}")
	private String name;

	@Autowired
	private MyDto dto;
	
	@Autowired
	@Qualifier("Injection1")
	protected ObjectFactory<InjectionClass1> injClass;

	@Override
	public String abstractMethod1() {
		count = 1;
		return String.format(name, this, injClass.getObject().toString());
	}

	@Override
	public String toString() {
		return "DerivedClass11Navpreet " + dto + "count is " + count + " i is changed to " + injClass.getObject().getI();
	}

}
