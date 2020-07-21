package com.mini.mybatisplus;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.mini.base.base.ApiContext;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Objects;

/**
 * @author Jesse
 * @version 1.0
 * @date 2020/03/01 11:19
 */
@Component
public class PmsMetaObjectHandler implements MetaObjectHandler {
    private static final String DEFAULT_LOGIN_USER = "system";

    @Autowired
    private ApiContext apiContext;

    @Override
    public void insertFill(MetaObject metaObject) {
        if (!Objects.isNull(apiContext)) {
            String userName = apiContext.getLoginUserInfo();
            if (userName == null) {
                setFieldValByName("createUser", DEFAULT_LOGIN_USER, metaObject);
                setFieldValByName("updateUser", DEFAULT_LOGIN_USER, metaObject);
            } else {
                String createUser = (String)getFieldValByName("createUser", metaObject);
                String updateUser = (String)getFieldValByName("updateUser", metaObject);
                if (StringUtils.isBlank(createUser)) {
                    setFieldValByName("createUser", userName, metaObject);
                }
                if (StringUtils.isBlank(updateUser)) {
                    setFieldValByName("updateUser", userName, metaObject);
                }
            }
        }
//        Object status = getFieldValByName("status", metaObject);
        setFieldValByName("createTime", LocalDateTime.now(), metaObject);
        setFieldValByName("updateTime", LocalDateTime.now(), metaObject);
//        if (Objects.isNull(status)) {
//            setFieldValByName("status", PmsConstant.STATUS_ENABLE, metaObject);
//        } else {
//            setFieldValByName("status", status, metaObject);
//        }
        setFieldValByName("isDelete", 0, metaObject);
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        if (!Objects.isNull(apiContext)) {
            String userName = apiContext.getLoginUserInfo();
            if (userName == null) {
                setFieldValByName("updateUser", DEFAULT_LOGIN_USER, metaObject);
            } else {
                setFieldValByName("updateUser", userName, metaObject);
            }
        }
//        LoginUserDto loginUserDto = apiContext.getLoginUserInfo();
//        if (loginUserDto == null) {
//            setFieldValByName("updateUser", DEFAULT_LOGIN_USER, metaObject);
//        } else {
//            setFieldValByName("updateUser", loginUserDto.getUserName(), metaObject);
//        }
        setFieldValByName("updateTime", LocalDateTime.now(), metaObject);
    }

}
