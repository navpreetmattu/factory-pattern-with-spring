package com.spring.factory.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.spring.factory.base.BaseClass1;
import com.spring.factory.base.BaseClass2;
import com.spring.factory.base.BaseClass3;
import com.spring.factory.common.MyDto;
import com.spring.factory.factory.FactoryClass;
import com.spring.factory.helper.ClassType;

@RestController
public class ClassService {

	@Autowired
	private FactoryClass classFactory;

	@Autowired
	private MyDto dto;

	@GetMapping("get/{classType}")
	public String doStuff(@PathVariable("classType") String classType) {

		populateDto();
		classType = classType.toUpperCase();
		ClassType classEnum1 = Enum.valueOf(ClassType.class, classType + "1");
		BaseClass1 bc1 = classFactory.getFirstClass(classEnum1);
		String result1 = bc1.abstractMethod1();
		ClassType classEnum2 = Enum.valueOf(ClassType.class, classType + "2");
		BaseClass2 bc2 = classFactory.getSecondClass(classEnum2);
		String result2 = bc2.abstractMethod2(result1);

		ClassType classEnum3 = Enum.valueOf(ClassType.class, classType + "3");
		BaseClass3 bc3 = classFactory.getThirdClass(classEnum3);
		return bc3.abstractMethod3(result2);
	}

	private void populateDto() {
		dto.setValue1("Dto Value 1");
		dto.setValue2("Dto Value 2");
	}
}
