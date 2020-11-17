package com.spring.factory.base;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.spring.factory.common.InjectionClass;

public abstract class BaseClass1 {

	protected int count;

	public abstract String abstractMethod1();
}
