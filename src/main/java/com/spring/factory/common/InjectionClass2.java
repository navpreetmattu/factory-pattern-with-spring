package com.spring.factory.common;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("Injection2")
@Scope("prototype")
public class InjectionClass2 extends InjectionClass {

	private int i;

	public int getI() {
		return i++;
	}
}
