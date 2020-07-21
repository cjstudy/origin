package com.mini.base.utils;

import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Field;

/**
 * @author LIUDONGFANG002
 * @version 1.0
 * @date 2019/7/22
 */
@Slf4j
public class ThreadLocalClearer {

    private ThreadLocalClearer() {
    }

    public static void clear(Object obj) {
        log.info(Thread.currentThread().getId() + "-" + Thread.currentThread().getName() + "-ThreadLocalClearer.clear()-进入");
        Field[] fields = obj.getClass().getDeclaredFields();
        try {
            for (Field field : fields) {
                if (field.getType().equals(ThreadLocal.class)) {
                    field.setAccessible(true);
//                    String getMethod = "get" + field.getName().substring(0, 1).toUpperCase() + field.getName().substring(1);
//                    Method method = obj.getClass().getMethod(getMethod);
//                    Object value = method.invoke(obj);

                    String fieldName = field.getName();
                    Object value = field.get(fieldName);

                    if (value == null) {
                        continue;
                    }
                    if (value instanceof ThreadLocal) {
                        @SuppressWarnings("rawtypes")
                        ThreadLocal threadLocal = (ThreadLocal) value;
                        threadLocal.remove();
                        field.setAccessible(false);
                    }
                }
            }
        } catch (Exception e) {
            log.error(Thread.currentThread().getId() + "-" + Thread.currentThread().getName() + "-ThreadLocalClearer.clear()-Exception:{}", e.getMessage(), e);
        } finally {
            log.info(Thread.currentThread().getId() + "-" + Thread.currentThread().getName() + "-ThreadLocalClearer.clear()-完成");
        }
    }

}
