package com.example.easy.beanutil.bean;

import com.example.easy.beanutil.annotation.EnumCopy;

public class SrcEnum {

	@EnumCopy
	private EnumTest e;

	public EnumTest getE() {
		return e;
	}

	public void setE(EnumTest e) {
		this.e = e;
	}

	@Override
	public String toString() {
		return "SrcEnum [e=" + e + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((e == null) ? 0 : e.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SrcEnum other = (SrcEnum) obj;
		if (e != other.e)
			return false;
		return true;
	}

}
