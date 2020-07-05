package com.example.easy.beanutil;

import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;

import com.example.easy.beanutil.annotation.DatetimeCopy;
import com.example.easy.beanutil.annotation.EnumCopy;
import com.example.easy.beanutil.annotation.IgnoreCopy;
import com.example.easy.beanutil.bean.EnumTest;
import com.example.easy.beanutil.bean.Pojo;
import com.example.easy.beanutil.bean.Src;

public class EasyBeanUtil {

	public static void copyProperty(Object src, Object dest) throws Exception {
		long start = System.currentTimeMillis();
		Field[] srcFields = src.getClass().getDeclaredFields();
		Field[] destFields = dest.getClass().getDeclaredFields();
		for (Field sf : srcFields) {
			for (Field df : destFields) {
				if (!sf.getName().equals(df.getName())) {
					continue;
				}
				if (sf.getAnnotation(IgnoreCopy.class) != null) {
					continue;
				}

				sf.setAccessible(true);
				df.setAccessible(true);

				if (sf.getAnnotation(DatetimeCopy.class) != null) {
					if (String.class.equals(sf.getType())) {
						String timeStr = (String) sf.get(src);
						SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
						Date parseDate = format.parse(timeStr);
						long time = parseDate.getTime();
						df.set(dest, time);
						continue;
					} else if (long.class.equals(sf.getType()) || Long.class.equals(sf.getType())) {
						Long time = (Long) sf.get(src);
						SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
						String timeStr = format.format(new Date(time));
						df.set(dest, timeStr);
						continue;
					} else {
						throw new Exception();
					}
				}

				if (sf.getAnnotation(EnumCopy.class) != null) {
					if (EnumTest.class.equals(sf.getType())) {
						EnumTest val = (EnumTest) sf.get(src);
						df.set(dest, val.getCode());
						continue;
					} else {
						throw new Exception();
					}
				}
				df.set(dest, sf.get(src));
			}
		}
		long end = System.currentTimeMillis();
		System.out.println("copyProperty tile : " + (end - start));
	}

	private static void test(Object src) {
		Field[] srcFields = src.getClass().getDeclaredFields();
		for (Field f : srcFields) {
			System.out.println(f.getName() + ":" + f.getType());
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
		// src.setDate("2020-07-05 00:00:00");
		return src;
	}
}
