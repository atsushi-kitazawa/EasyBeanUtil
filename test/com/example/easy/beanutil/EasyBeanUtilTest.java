package com.example.easy.beanutil;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

import org.junit.Test;

import com.example.easy.beanutil.bean.Dest;
import com.example.easy.beanutil.bean.Pojo;
import com.example.easy.beanutil.bean.Src;

public class EasyBeanUtilTest {

	@Test
	public void copy1() throws Exception {
		Dest dest = new Dest();
		EasyBeanUtil.copyProperty(createSrc(), dest);
		assertThat(dest, is(createDest()));
	}

	@Test
	public void test1() {
		boolean ret1 = long.class.equals(long.class);
		boolean ret2 = long.class.equals(Long.class);
		boolean ret3 = Long.class.equals(long.class);
		boolean ret4 = Long.class.equals(Long.class);
		assertThat(ret1, is(true));
		assertThat(ret2, is(false));
		assertThat(ret3, is(false));
		assertThat(ret4, is(true));
	}

	private static Src createSrc() {
		Src src = new Src();
		src.setB(true);
		src.setS((short) 0);
		src.setI(1);
		src.setL(2l);
		src.setD(10.0);
		src.setString("a");
		src.setList(Arrays.asList("A", "B", "C"));
		src.setMap(new HashMap<String, String>() {
			{
				put("key1", "value1");
				put("key2", "value2");
			}
		});
		src.setSet(new HashSet<String>(Arrays.asList("foo", "bar")));
		src.setPojo(new Pojo("hoge", 100));
		src.setPojoList(Arrays.asList(new Pojo("listPojo1", 0), new Pojo("listPojo2", 1)));
		src.setPojoMap(new HashMap<String, Pojo>() {
			{
				put("key1", new Pojo("mapPojo1", 10));
				put("key2", new Pojo("mapPojo2", 20));
			}
		});
		src.setDate("2020-07-05 00:00:00");
		src.setDateL(1595820600000l);
		src.setDatel(1595103900000l);
		return src;
	}

	private static Dest createDest() {
		Dest dest = new Dest();
		dest.setB(true);
		dest.setS((short) 0);
		dest.setI(1);
		dest.setL(2l);
		dest.setD(10.0);
		dest.setString("a");
		dest.setList(Arrays.asList("A", "B", "C"));
		dest.setMap(new HashMap<String, String>() {
			{
				put("key1", "value1");
				put("key2", "value2");
			}
		});
		dest.setSet(new HashSet<String>(Arrays.asList("foo", "bar")));
		dest.setPojo(new Pojo("hoge", 100));
		dest.setPojoList(Arrays.asList(new Pojo("listPojo1", 0), new Pojo("listPojo2", 1)));
		dest.setPojoMap(new HashMap<String, Pojo>() {
			{
				put("key1", new Pojo("mapPojo1", 10));
				put("key2", new Pojo("mapPojo2", 20));
			}
		});
		dest.setDate(1593874800000l);
		dest.setDateL("2020-07-27 12:30:00");
		dest.setDatel("2020-07-19 05:25:00");
		return dest;
	}
}
