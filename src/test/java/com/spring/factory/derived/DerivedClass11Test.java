package com.spring.factory.derived;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.util.ReflectionTestUtils;

import com.spring.factory.common.InjectionClass;
import com.spring.factory.common.MyDto;

@RunWith(JUnitPlatform.class)
class DerivedClass11Test {

	@Mock
	InjectionClass injectionClass;

	@Mock
	MyDto myDto;

	@InjectMocks
	DerivedClass11 derivedClass11;

	@BeforeEach
	void init() {
		MockitoAnnotations.initMocks(this);
		ReflectionTestUtils.setField(derivedClass11, "name", "The factory name is %s, dependency injected %s.");
	}

	@Test
	String testAbstractMethod1() {
		when(injectionClass.getString()).thenReturn("From Injection 1");
		String result = derivedClass11.abstractMethod1();
		assertNotNull(result);
		return result;
	}
}
