package com.mini.base.exception;

import com.mini.base.api.R;
import com.mini.base.api.ResultCode;
import com.mini.base.constant.RedisContants;
import com.mini.base.utils.RedisUtils;
import com.mini.base.utils.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@ControllerAdvice
public class ExceptionController {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @ExceptionHandler(value = WXCheckUserInfoException.class)
    @ResponseBody
    public R<Object> wXCheckUserInfoExceptionOperate(WXCheckUserInfoException e, HttpServletRequest request, HttpServletResponse response) {
        return new R<>(ResultCode.FAILURE, getErrorMsg(e.getCode()));
    }

    @ExceptionHandler(value = BindEmpException.class)
    @ResponseBody
    public R<Object> bindEmpExceptionOperate(BindEmpException e, HttpServletRequest request, HttpServletResponse response) {
        return new R<>(ResultCode.FAILURE, getErrorMsg(e.getCode()));
    }

    @ExceptionHandler(value = AuthException.class)
    @ResponseBody
    public R<Object> AuthExceptionOperate(AuthException e, HttpServletRequest request) {
        logger.error("系统异常:uri=" + request.getRequestURI(), e);
        return new R<>(ResultCode.FAILURE, getErrorMsg(e.getCode()));
    }

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public R<Object> ExceptionOperate(Exception e, HttpServletRequest request) {
        logger.error("系统异常:uri=" + request.getRequestURI(), e);
        return new R<Object>(ResultCode.FAILURE, getErrorMsg(99999));
    }

    private String getErrorMsg(int code) {
        String content = RedisUtils.getMapValue(RedisContants.ERRORINFO, code+"");
        if (StringUtils.isEmpty(content)) {
            content = "系统异常";
        }
        return content;
    }
}
