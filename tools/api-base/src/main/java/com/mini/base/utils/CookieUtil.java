package com.mini.base.utils;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author cmy
 * @create 2017-08-11 9:52
 **/
@Slf4j
public class CookieUtil {
    /**
     * 添加cookie
     *
     * @param response
     * @param name
     * @param value
     * @param maxAge   有效时间
     */
    public static void addCookie(HttpServletResponse response, String name, String value, int maxAge, String domain) {
        Cookie cookie = new Cookie(name, value);
        cookie.setPath("/");
        cookie.setMaxAge(maxAge);
        if (maxAge > 0) {
            cookie.setMaxAge(maxAge);
        }
        if (StringUtil.isNotEmpty(domain)){
            cookie.setDomain(domain);
        }

        response.addCookie(cookie);
    }

    /**
     * 删除cookie
     *
     * @param response
     * @param name
     */
    public static void removeCookie(HttpServletResponse response, String name, String domain) {
        Cookie uid = new Cookie(name, null);
        uid.setPath("/");
        uid.setMaxAge(0);
        if (StringUtil.isNotEmpty(domain)){
            uid.setDomain(domain);
        }
        response.addCookie(uid);
    }

    /**
     * 获取cookie值
     *
     * @param request
     * @return
     */
    public static String getCookie(HttpServletRequest request, String cookieName) {
        Cookie cookies[] = request.getCookies();
       log.info("cookies=========>" + cookies);
        if(cookies!=null){
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals(cookieName)) {
                    return cookie.getValue();
                }
            }
        }
        return null;
    }
}
