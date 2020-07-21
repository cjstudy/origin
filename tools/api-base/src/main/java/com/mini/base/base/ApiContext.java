package com.mini.base.base;

import org.springframework.stereotype.Component;


@Component
public class ApiContext {
    private static final String KEY_USER_LOGIN_INFO = "KEY_USER_LOGIN_INFO";
    private static final ThreadLocal<String> mContext = new ThreadLocal<String>();


    public void setLoginUserInfo(String userName) {
        //mContext.put(KEY_USER_LOGIN_INFO, loginUserDto);
        mContext.set(userName);
    }

    public String getLoginUserInfo() {
        return mContext.get();
    }

    public void deleteLoginUserInfo() {
        if (mContext.get() != null) {
            mContext.remove();
        }
    }
}
