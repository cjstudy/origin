package com.mini.base.utils;

import org.springframework.lang.Nullable;

import java.lang.reflect.Field;

/**
 * 对象工具类
 */
public class ObjectUtil extends org.springframework.util.ObjectUtils {

	/**
	 * 判断元素不为空
	 * @param obj object
	 * @return boolean
	 */
	public static boolean isNotEmpty(@Nullable Object obj) {
		return !ObjectUtil.isEmpty(obj);
	}

	/**
	 * 判断元素属性均为空
	 * @param object
	 * @return
	 */
	public static boolean checkAllPropertyIsEmpty(@Nullable Object object){
		Class clazz = (Class)object.getClass(); // 得到类对象
		Field fields[] = clazz.getDeclaredFields(); // 得到所有属性
		boolean flag = true; //定义返回结果，默认为true
		for(Field field : fields){
			field.setAccessible(true);
			Object fieldValue = null;
			try {
				fieldValue = field.get(object); //得到属性值
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
			if(fieldValue != null){  //只要有一个属性值不为null 就返回false 表示对象不为null
				flag = false;
				break;
			}
		}
		return flag;
	}

}
