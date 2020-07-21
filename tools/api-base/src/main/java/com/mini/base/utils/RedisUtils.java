package com.mini.base.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.concurrent.TimeUnit;

@Component
public class RedisUtils {

    @Value("${spring.application.name}")
    private String sername;

    private static String serverName;

    private static RedisTemplate template;

    @Autowired
    private AppContext appContext;

    @PostConstruct
    public void init() {
        serverName = sername;
        getStringRedisTemplate();
    }

    private static void getStringRedisTemplate() {
        template = AppContext.getBean(StringRedisTemplate.class);
    }

    public static <T> T getString(String key, Class<T> valueType) {
        String value = (String) template.opsForValue().get(serverName + ":" + key);
        if(StringUtils.isEmpty(value)){
            return null;
        }
        return JacksonUtil.readValue(value, valueType);
    }

    public static void delString(String key) {
        template.delete(serverName + ":" + key);
    }

    public static <T> T getStringNoServerName(String key, Class<T> valueType) {
        String value = (String) template.opsForValue().get(key);
        if(StringUtils.isEmpty(value)){
            return null;
        }
        return JacksonUtil.readValue(value, valueType);
    }

    public static <T> Boolean setString(String key, T value, long time) {
        String valueStr = JacksonUtil.toJSon(value);
        template.opsForValue().set(serverName + ":" + key, valueStr);
        if (time > 0) {
            template.expire(serverName + ":" + key, time, TimeUnit.SECONDS);
        }
        return true;
    }

    public static <T> Boolean setStringNoServerName(String key, T value, long time) {
        String valueStr = JacksonUtil.toJSon(value);
        template.opsForValue().set(key, valueStr);
        if (time > 0) {
            template.expire(key, time, TimeUnit.SECONDS);
        }
        return true;
    }

    public static <T> T getMapValue(String mapKey, String key) {
        return (T) template.opsForHash().get(serverName + ":" + mapKey, key);
    }

    public static <T> void putHashValue(String mapKey, String key, T value, long time) {
        template.opsForHash().put(serverName + ":" + mapKey, key, value);
        if (time > 0) {
            template.expire(serverName + ":" + mapKey, time, TimeUnit.SECONDS);
        }
    }


//    public
}
