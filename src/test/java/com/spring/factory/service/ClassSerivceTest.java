package com.spring.factory.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.spring.factory.base.BaseClass1;
import com.spring.factory.base.BaseClass2;
import com.spring.factory.base.BaseClass3;
import com.spring.factory.common.MyDto;
import com.spring.factory.derived.DerivedClass11;
import com.spring.factory.derived.DerivedClass21;
import com.spring.factory.derived.DerivedClass31;
import com.spring.factory.factory.FactoryClass;
import com.spring.factory.helper.ClassType;

@RunWith(JUnitPlatform.class)
class ClassSerivceTest {
	
	@Mock
	FactoryClass classFactory;

	@Mock
	MyDto myDto;

	@InjectMocks
	ClassService service;
	
	@BeforeEach
	void init() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	void testDoStuff() {

		when(classFactory.getFirstClass(ClassType.valueOf("DERIVEDCLASS11"))).thenReturn(new DerivedClass11());
		when(classFactory.getSecondClass(ClassType.valueOf("DERIVEDCLASS12"))).thenReturn(new DerivedClass21());
		when(classFactory.getThirdClass(ClassType.valueOf("DERIVEDCLASS13"))).thenReturn(new DerivedClass31());

		BaseClass1 firstClass = classFactory.getFirstClass(ClassType.valueOf("DERIVEDCLASS11"));
		String result1 = firstClass.abstractMethod1();

		BaseClass2 secondClass = classFactory.getSecondClass(ClassType.valueOf("DERIVEDCLASS12"));
		String result2 = secondClass.abstractMethod2(result1);

		BaseClass3 thirdClass = classFactory.getThirdClass(ClassType.valueOf("DERIVEDCLASS13"));
		String result3 = thirdClass.abstractMethod3(result2);

		assertNotNull(result3);
	}
}
