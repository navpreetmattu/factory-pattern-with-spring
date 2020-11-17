package com.spring.factory.helper;

public enum ClassType {

	DERIVEDCLASS11("DERIVEDCLASS11"), DERIVEDCLASS21("DERIVEDCLASS21"), DERIVEDCLASS12("DERIVEDCLASS12"),
	DERIVEDCLASS22("DERIVEDCLASS22"), DERIVEDCLASS13("DERIVEDCLASS13"), DERIVEDCLASS23("DERIVEDCLASS23");

	private final String value;

	ClassType(String value) {
		this.value = value;
	}

	public String getValue() {
		return this.value;
	}

	@Override
	public String toString() {
		return this.value;
	}
}
