package com.example.easy.beanutil.bean;

public class DestEnum {

	private int e;
	private EnumTest i;

	public int getE() {
		return e;
	}

	public void setE(int e) {
		this.e = e;
	}

	public EnumTest getI() {
		return i;
	}

	public void setI(EnumTest i) {
		this.i = i;
	}

	@Override
	public String toString() {
		return "DestEnum [e=" + e + ", i=" + i + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + e;
		result = prime * result + ((i == null) ? 0 : i.hashCode());
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
		DestEnum other = (DestEnum) obj;
		if (e != other.e)
			return false;
		if (i != other.i)
			return false;
		return true;
	}

}
