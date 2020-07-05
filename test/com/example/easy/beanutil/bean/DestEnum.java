package com.example.easy.beanutil.bean;

public class DestEnum {

	private int e;

	public int getE() {
		return e;
	}

	public void setE(int e) {
		this.e = e;
	}

	@Override
	public String toString() {
		return "DestEnum [e=" + e + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + e;
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
		return true;
	}

}
