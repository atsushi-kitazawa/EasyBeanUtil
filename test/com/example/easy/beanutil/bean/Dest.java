package com.example.easy.beanutil.bean;

import java.util.List;
import java.util.Map;
import java.util.Set;

// Entity
public class Dest {
	private boolean b;
	private short s;
	private long l;

	private Integer i;
	private Double d;
	private String string;

	private List<String> list;
	private Map<String, String> map;
	private Set<String> set;

	private Pojo pojo;
	private List<Pojo> pojoList;
	private Map<String, Pojo> pojoMap;

	private long date;
	private String dateL;
	private String datel;

	public boolean isB() {
		return b;
	}

	public void setB(boolean b) {
		this.b = b;
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

	public long getL() {
		return l;
	}

	public void setL(long l) {
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
		return pojoList;
	}

	public void setPojoList(List<Pojo> pojoList) {
		this.pojoList = pojoList;
	}

	public Map<String, Pojo> getPojoMap() {
		return pojoMap;
	}

	public void setPojoMap(Map<String, Pojo> pojoMap) {
		this.pojoMap = pojoMap;
	}

	public long getDate() {
		return date;
	}

	public void setDate(long date) {
		this.date = date;
	}

	public String getDateL() {
		return dateL;
	}

	public void setDateL(String dateL) {
		this.dateL = dateL;
	}

	public String getDatel() {
		return datel;
	}

	public void setDatel(String datel) {
		this.datel = datel;
	}

	@Override
	public String toString() {
		return "Dest [b=" + b + ", s=" + s + ", l=" + l + ", i=" + i + ", d=" + d + ", string=" + string + ", list="
				+ list + ", map=" + map + ", set=" + set + ", pojo=" + pojo + ", pojoList=" + pojoList + ", pojoMap="
				+ pojoMap + ", date=" + date + ", dateL=" + dateL + ", datel=" + datel + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (b ? 1231 : 1237);
		result = prime * result + ((d == null) ? 0 : d.hashCode());
		result = prime * result + (int) (date ^ (date >>> 32));
		result = prime * result + ((dateL == null) ? 0 : dateL.hashCode());
		result = prime * result + ((datel == null) ? 0 : datel.hashCode());
		result = prime * result + ((i == null) ? 0 : i.hashCode());
		result = prime * result + (int) (l ^ (l >>> 32));
		result = prime * result + ((list == null) ? 0 : list.hashCode());
		result = prime * result + ((map == null) ? 0 : map.hashCode());
		result = prime * result + ((pojo == null) ? 0 : pojo.hashCode());
		result = prime * result + ((pojoList == null) ? 0 : pojoList.hashCode());
		result = prime * result + ((pojoMap == null) ? 0 : pojoMap.hashCode());
		result = prime * result + s;
		result = prime * result + ((set == null) ? 0 : set.hashCode());
		result = prime * result + ((string == null) ? 0 : string.hashCode());
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
		Dest other = (Dest) obj;
		if (b != other.b)
			return false;
		if (d == null) {
			if (other.d != null)
				return false;
		} else if (!d.equals(other.d))
			return false;
		if (date != other.date)
			return false;
		if (dateL == null) {
			if (other.dateL != null)
				return false;
		} else if (!dateL.equals(other.dateL))
			return false;
		if (datel == null) {
			if (other.datel != null)
				return false;
		} else if (!datel.equals(other.datel))
			return false;
		if (i == null) {
			if (other.i != null)
				return false;
		} else if (!i.equals(other.i))
			return false;
		if (l != other.l)
			return false;
		if (list == null) {
			if (other.list != null)
				return false;
		} else if (!list.equals(other.list))
			return false;
		if (map == null) {
			if (other.map != null)
				return false;
		} else if (!map.equals(other.map))
			return false;
		if (pojo == null) {
			if (other.pojo != null)
				return false;
		} else if (!pojo.equals(other.pojo))
			return false;
		if (pojoList == null) {
			if (other.pojoList != null)
				return false;
		} else if (!pojoList.equals(other.pojoList))
			return false;
		if (pojoMap == null) {
			if (other.pojoMap != null)
				return false;
		} else if (!pojoMap.equals(other.pojoMap))
			return false;
		if (s != other.s)
			return false;
		if (set == null) {
			if (other.set != null)
				return false;
		} else if (!set.equals(other.set))
			return false;
		if (string == null) {
			if (other.string != null)
				return false;
		} else if (!string.equals(other.string))
			return false;
		return true;
	}

}
