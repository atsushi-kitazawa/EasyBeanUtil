package com.example.easy.beanutil.bean;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Dest2 {
	private boolean b2;
	private short s;

	private Integer i;
	private Long l;
	private Double d;
	private String string;

	private List<String> list;
	private Map<String, String> map;
	private Set<String> set;

	private Pojo pojo;
	private List<Pojo> pojoList2;
	private Map<String, Pojo> pojoMap2;

	public boolean isB() {
		return b2;
	}

	public void setB(boolean b) {
		this.b2 = b;
	}

	public short getS() {
		return s;
	}

	public void setS(short s) {
		this.s = s;
	}

	public Integer getI() {
		return i;
	}

	public void setI(Integer i) {
		this.i = i;
	}

	public Long getL() {
		return l;
	}

	public void setL(Long l) {
		this.l = l;
	}

	public Double getD() {
		return d;
	}

	public void setD(Double d) {
		this.d = d;
	}

	public String getString() {
		return string;
	}

	public void setString(String string) {
		this.string = string;
	}

	public List<String> getList() {
		return list;
	}

	public void setList(List<String> list) {
		this.list = list;
	}

	public Map<String, String> getMap() {
		return map;
	}

	public void setMap(Map<String, String> map) {
		this.map = map;
	}

	public Set<String> getSet() {
		return set;
	}

	public void setSet(Set<String> set) {
		this.set = set;
	}

	public Pojo getPojo() {
		return pojo;
	}

	public void setPojo(Pojo pojo) {
		this.pojo = pojo;
	}

	public List<Pojo> getPojoList() {
		return pojoList2;
	}

	public void setPojoList(List<Pojo> pojoList) {
		this.pojoList2 = pojoList;
	}

	public Map<String, Pojo> getPojoMap() {
		return pojoMap2;
	}

	public void setPojoMap(Map<String, Pojo> pojoMap) {
		this.pojoMap2 = pojoMap;
	}

	@Override
	public String toString() {
		return "Dest2 [b2=" + b2 + ", s=" + s + ", i=" + i + ", l=" + l + ", d=" + d + ", string=" + string + ", list="
				+ list + ", map=" + map + ", set=" + set + ", pojo=" + pojo + ", pojoList2=" + pojoList2 + ", pojoMap2="
				+ pojoMap2 + "]";
	}

}
