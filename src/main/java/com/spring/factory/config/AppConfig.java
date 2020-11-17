package com.spring.factory.config;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.config.ServiceLocatorFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.spring.factory.derived.DerivedClass12;
import com.spring.factory.derived.DerivedClass21;
import com.spring.factory.derived.DerivedClass22;
import com.spring.factory.derived.DerivedClass31;
import com.spring.factory.derived.DerivedClass32;
import com.spring.factory.factory.FactoryClass;

@Configuration
public class AppConfig {

	@Bean
	public FactoryBean<Object> serviceLocatorFactoryBean() {
		ServiceLocatorFactoryBean sb = new ServiceLocatorFactoryBean();
		sb.setServiceLocatorInterface(FactoryClass.class);
		return sb;
	}

	@Bean(name = "DERIVEDCLASS21")
	public DerivedClass12 derivedClass12() {
		return new DerivedClass12();
	}

	@Bean(name = "DERIVEDCLASS12")
	public DerivedClass21 derivedClass21() {
		return new DerivedClass21();
	}

	@Bean(name = "DERIVEDCLASS22")
	public DerivedClass22 derivedClass22() {
		return new DerivedClass22();
	}

	@Bean(name = "DERIVEDCLASS13")
	public DerivedClass31 derivedClass31() {
		return new DerivedClass31();
	}

	@Bean(name = "DERIVEDCLASS23")
	public DerivedClass32 derivedClass32() {
		return new DerivedClass32();
	}
}
