package com.spring.factory.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("Injection1")
@Scope("prototype")
public class InjectionClass1 extends InjectionClass {

	@Autowired
	private InsideInjection inside;

	private int i;

	public String getI() {
		int j = inside.getJ();
		return i++ + " -- " + j;
	}

	public InsideInjection getInside() {
		return inside;
	}
}
