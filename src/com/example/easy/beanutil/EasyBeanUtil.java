package com.example.easy.beanutil;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.example.easy.beanutil.annotation.DatetimeCopy;
import com.example.easy.beanutil.annotation.EnumCopy;
import com.example.easy.beanutil.annotation.IgnoreCopy;
import com.example.easy.beanutil.annotation.ListCopy;
import com.example.easy.beanutil.bean.EnumTest;

public class EasyBeanUtil {

	public static void copyProperty(Object src, Object dest) throws Exception {
		long start = System.currentTimeMillis();
		Field[] srcFields = src.getClass().getDeclaredFields();
		Field[] destFields = dest.getClass().getDeclaredFields();
		for (Field srcField : srcFields) {
			for (Field destField : destFields) {
				// when field name is different, does not copy.
				if (!srcField.getName().equals(destField.getName())) {
					continue;
				}
				// IgnoreCopy annotation does not copy.
				if (srcField.getAnnotation(IgnoreCopy.class) != null) {
					continue;
				}

				// accessible is true.
				srcField.setAccessible(true);
				destField.setAccessible(true);

				Class<?> srcType = srcField.getType();
				Class<?> destType = destField.getType();

				// Datetime annotation process.
				if (srcField.getAnnotation(DatetimeCopy.class) != null) {
					if (String.class.equals(srcType)) {
						String timeStr = (String) srcField.get(src);
						SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
						Date parseDate = format.parse(timeStr);
						long time = parseDate.getTime();
						destField.set(dest, time);
						continue;
					} else if (long.class.equals(srcType) || Long.class.equals(srcType)) {
						Long time = (Long) srcField.get(src);
						SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
						String timeStr = format.format(new Date(time));
						destField.set(dest, timeStr);
						continue;
					} else {
						throw new Exception(
								String.format("failed Datetime process. srcType=%s, destType=%s", srcType, destType));
					}
				}

				// EnumCopy annotation process.
				if (srcField.getAnnotation(EnumCopy.class) != null) {
					if (EnumTest.class.equals(srcType)) {
						EnumTest val = (EnumTest) srcField.get(src);
						destField.set(dest, val.getCode());
						continue;
					} else if (Integer.class.equals(srcType) || int.class.equals(srcType)) {
						Object val = (Object) srcField.get(src);
						for (EnumTest eVal : EnumTest.values()) {
							if (val.equals(eVal.getCode())) {
								destField.set(dest, eVal);
								break;
							}
						}
						continue;
					} else {
						throw new Exception(
								String.format("failed EnumCopy process. srcType=%s, destType=%s", srcType, destType));
					}
				}

				// Process When Field type is List.
				// When ListCopy annotation is added, recursively call
				// copyProperty.
				if (srcField.getAnnotation(ListCopy.class) != null) {
					List<?> srcLists = (List<?>) srcField.get(src);
					ParameterizedType pt = (ParameterizedType) destField.getGenericType();
					Class<?> destClazz = (Class<?>) pt.getActualTypeArguments()[0];
					List<Object> destLists = new ArrayList<>();
					for (Object s : srcLists) {
						Object d = destClazz.getDeclaredConstructor().newInstance();
						copyProperty(s, d);
						destLists.add(d);
					}
					destField.set(dest, destLists);
					continue;
				}

				destField.set(dest, srcField.get(src));
			}
		}

		long end = System.currentTimeMillis();
		System.out.println("copyProperty tile : " + (end - start));
	}
}
