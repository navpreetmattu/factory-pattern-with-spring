package com.spring.factory.factory;

import com.spring.factory.base.BaseClass1;
import com.spring.factory.base.BaseClass2;
import com.spring.factory.base.BaseClass3;
import com.spring.factory.helper.ClassType;

public interface FactoryClass {

	BaseClass1 getFirstClass(ClassType type);

	BaseClass2 getSecondClass(ClassType type);

	BaseClass3 getThirdClass(ClassType type);
}
