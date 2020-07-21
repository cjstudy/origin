package com.mini.base.exception;

public class WXCheckUserInfoException extends Exception {

    private static Integer count = 0;

    private int code;

    public WXCheckUserInfoException(int code) {
        super();
        this.code = code;
        count++;
    }

    public WXCheckUserInfoException(int code, String message) {
        super(message);
        this.code = code;
        count++;
    }

    public WXCheckUserInfoException(int code, String message, Throwable cause) {
        super(message, cause);
        this.code = code;
        count++;
    }

    public WXCheckUserInfoException(int code, Throwable cause) {
        super(cause);
        this.code = code;
        count++;
    }

    protected WXCheckUserInfoException(int code, String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.code = code;
        count++;
    }

    public Integer getExceptionCount() {
        return count;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
