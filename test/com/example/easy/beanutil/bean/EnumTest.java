package com.example.easy.beanutil.bean;

public enum EnumTest {
	AAA(0), BBB(1), CCC(2);

	private int code;

	private EnumTest(int code) {
		this.code = code;
	}

	public int getCode() {
		return code;
	}
}
