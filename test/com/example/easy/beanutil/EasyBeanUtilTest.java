package com.example.easy.beanutil;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

import org.junit.Test;

import com.example.easy.beanutil.bean.Dest;
import com.example.easy.beanutil.bean.DestCollection;
import com.example.easy.beanutil.bean.DestEnum;
import com.example.easy.beanutil.bean.EnumTest;
import com.example.easy.beanutil.bean.Pojo;
import com.example.easy.beanutil.bean.Pojo2;
import com.example.easy.beanutil.bean.Src;
import com.example.easy.beanutil.bean.SrcCollection;
import com.example.easy.beanutil.bean.SrcEnum;

public class EasyBeanUtilTest {
	@Test
	public void copy1() throws Exception {
		Dest dest = new Dest();
		EasyBeanUtil.copyProperty(createSrc(), dest);
		assertThat(dest, is(createDest()));
	}

	@Test
	public void copy2() throws Exception {
		DestEnum dest = new DestEnum();
		EasyBeanUtil.copyProperty(createSrcEnum(), dest);
		assertThat(dest, is(createDestEnum()));
	}

	@Test
	public void copy3() throws Exception {
		DestCollection dest = new DestCollection();
		EasyBeanUtil.copyProperty(createSrcCollection(), dest);
		assertThat(dest, is(createDestCollection()));
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

	// @Test
	public void test2() throws Exception {
		class Hoge {
			public List<String> list = new ArrayList<>();
		}

		Hoge h = new Hoge();
		Field f = h.getClass().getField("list");
		Type genericType = f.getGenericType();
		System.out.println(genericType.getTypeName());
		for (Type p : ((ParameterizedType) genericType).getActualTypeArguments()) {
			System.out.println(p.getTypeName());
		}
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

	private SrcEnum createSrcEnum() {
		SrcEnum src = new SrcEnum();
		src.setE(EnumTest.AAA);
		src.setI(2);
		return src;
	}

	private DestEnum createDestEnum() {
		DestEnum dest = new DestEnum();
		dest.setE(0);
		dest.setI(EnumTest.CCC);
		return dest;
	}

	private SrcCollection createSrcCollection() {
		SrcCollection src = new SrcCollection();
		// src.setList(Arrays.asList("aaa", "bbb", "ccc"));
		src.setList(Arrays.asList(new Pojo("a", 0), new Pojo("b", 1), new Pojo("c", 2)));
		return src;
	}

	private DestCollection createDestCollection() {
		DestCollection dest = new DestCollection();
		// dest.setList(Arrays.asList("aaa", "bbb", "ccc"));
		dest.setList(Arrays.asList(new Pojo2("a"), new Pojo2("b"), new Pojo2("c")));
		return dest;
	}
}
