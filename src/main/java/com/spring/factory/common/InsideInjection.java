package com.spring.factory.common;

import org.springframework.stereotype.Component;

@Component
public class InsideInjection {

	int j;

	public int getJ() {
		return j++;
	}
}
