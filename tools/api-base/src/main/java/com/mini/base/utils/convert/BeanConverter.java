package com.mini.base.utils.convert;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.cglib.beans.BeanMap;

import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.*;

/**
 * @author root
 */
@Slf4j
public class BeanConverter {

    private BeanConverter() {

    }

    public static <T> T convert(Class<T> targetClass, Object source) {
        if (source == null) {
            return null;
        }

        T obj = newInstance(targetClass);
        BeanUtils.copyProperties(source, obj);
        return obj;
    }


    public static <T> List<T> convertList(List sources, Class<T> classType) {
        if (sources == null || sources.isEmpty()) {
            return new ArrayList<>();
        }
        List<T> newList = new ArrayList<>();
        for (Object source : sources) {
            T newInstance = newInstance(classType);
            BeanUtils.copyProperties(source, newInstance);
            newList.add(newInstance);
        }
        return newList;
    }

    /**
     * map转为bean
     *
     * @param map       the map
     * @param beanClass the bean class
     * @return t
     */
    public static <T> T mapToBean(Map<String, Object> map, Class<T> beanClass) {
        T entity = newInstance(beanClass);
        BeanMap beanMap = BeanMap.create(entity);
        beanMap.putAll(map);
        return entity;
    }

    /**
     * 将对象装换为map
     *
     * @param bean
     * @return
     */
    public static <T> Map<String, Object> beanToMap(T bean) {
        Map<String, Object> map = new HashMap<>();
        if (bean != null) {
            BeanMap beanMap = BeanMap.create(bean);
            for (Object key : beanMap.keySet()) {
                map.put(key + "", beanMap.get(key));
            }
        }
        return map;
    }

    public static <T> T newInstance(Class<T> clazz) {
        try {
            Constructor<T> constructor = clazz.getDeclaredConstructor();
            constructor.setAccessible(true);
            return constructor.newInstance();
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException | InstantiationException var2) {
            throw new RuntimeException("实例化对象时出现错误,请尝试给 " + clazz.getName() + " 添加无参的构造方法:" + clazz.getName(), var2);
        }
    }

    /**
     * copy bean 过滤掉空字段
     *
     * @param src
     * @param target
     */
    public static void copyPropertiesIgnoreNull(Object src, Object target) {
        if (src == null || target == null) {
            return;
        }
        BeanUtils.copyProperties(src, target, getNullPropertyNames(src));
    }

    /**
     * add by xujie
     * copy bean 过滤掉空字段并且返回值
     *
     * @param e
     * @param t
     * @param <T>
     * @param <E>
     * @return
     */
    public static <T, E> T copyPropertiesIgnoreNullAndReturn(E e, T t) {
        BeanUtils.copyProperties(e, t, getNullPropertyNames(e));
        return t;
    }


    private static String[] getNullPropertyNames(Object source) {
        final BeanWrapper src = new BeanWrapperImpl(source);
        java.beans.PropertyDescriptor[] pds = src.getPropertyDescriptors();

        Set<String> emptyNames = new HashSet<>();
        for (java.beans.PropertyDescriptor pd : pds) {
            Object srcValue = src.getPropertyValue(pd.getName());
            if (srcValue == null) {
                emptyNames.add(pd.getName());
            }
        }
        String[] result = new String[emptyNames.size()];
        return emptyNames.toArray(result);
    }

    /**
     * 对象深度复制(对象必须是实现了Serializable接口)
     *
     * @param obj 对象
     * @return T 类
     * @author haohaozhi
     * @date 2019-9-23 15:57:29
     */
    @SuppressWarnings("unchecked")
    public static <T extends Serializable> T deepClone(final T obj) {
        T clonedObj = null;
        try {
            final ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            final ObjectOutputStream oos = new ObjectOutputStream(byteArrayOutputStream);
            oos.writeObject(obj);
            oos.close();

            final ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
            final ObjectInputStream ois = new ObjectInputStream(byteArrayInputStream);
            clonedObj = (T) ois.readObject();
            ois.close();
        } catch (final Exception e) {
            log.error("对象深度复制-Exception:{}", e.getMessage(), e);
        }
        return clonedObj;
    }

}
