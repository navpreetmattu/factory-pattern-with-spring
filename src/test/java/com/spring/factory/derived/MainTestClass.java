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
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.test.util.ReflectionTestUtils;

import com.spring.factory.common.InjectionClass;
import com.spring.factory.common.MyDto;

@RunWith(JUnitPlatform.class)
class MainTestClass {

	public void runAll() {
		DerivedClass11Test test1 = new DerivedClass11Test();
		DerivedClass12Test test2 = new DerivedClass12Test();
		DerivedClass13Test test3 = new DerivedClass13Test();

		test1.init();
		test2.init();
		test3.init();

		String result1 = test1.testAbstractMethod1();
		String result2 = test2.testAbstractMethod2(result1);
		String result3 = test3.testAbstractMethod3(result2);

		System.out.println(result1 + "\n");
		System.out.println(result2 + "\n");
		System.out.println(result3 + "\n");
	}

	@Test
	void runAll2() {

		String result1 = testAbstractMethod1();
		String result2 = testAbstractMethod2(result1);
		String result3 = testAbstractMethod3(result2);

		System.out.println(result1 + "\n");
		System.out.println(result2 + "\n");
		System.out.println(result3 + "\n");
	}

	@Mock
	InjectionClass injectionClass;

	@Mock
	ObjectFactory<InjectionClass> mockFactory;

	@Mock
	MyDto myDto;

	@InjectMocks
	DerivedClass11 derivedClass11;

	@InjectMocks
	DerivedClass21 derivedClass21;

	@InjectMocks
	DerivedClass31 derivedClass31;

	@BeforeEach
	void init() {
		MockitoAnnotations.initMocks(this);
		ReflectionTestUtils.setField(derivedClass11, "name", "The factory name is %s, dependency injected %s.");
		ReflectionTestUtils.setField(derivedClass21, "name", "The factory name is %s, dependency injected %s.");
		ReflectionTestUtils.setField(derivedClass31, "name", "The factory name is %s, dependency injected %s.");
	}

	String testAbstractMethod1() {
		when(mockFactory.getObject()).thenReturn(injectionClass);
		when(injectionClass.getString()).thenReturn("From Injection 1");
		String result = derivedClass11.abstractMethod1();
		assertNotNull(result);
		return result;
	}

	String testAbstractMethod2(String input) {
		when(injectionClass.getString()).thenReturn("From Injection 2");
		String result = derivedClass21.abstractMethod2(input);
		assertNotNull(result);
		return result;
	}

	String testAbstractMethod3(String input) {
		when(injectionClass.getString()).thenReturn("From Injection 3");
		String result = derivedClass31.abstractMethod3(input);
		assertNotNull(result);
		return result;
	}
}
