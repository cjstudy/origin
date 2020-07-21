package com.mini.base.exception;

public class AuthException extends Exception {

    private static int count = 0;

    private int code;

    public AuthException(int code) {
        super();
        this.code = code;
        count++;
    }

    public AuthException(int code, String message) {
        super(message);
        this.code = code;
        count++;
    }

    public AuthException(int code, String message, Throwable cause) {
        super(message, cause);
        this.code = code;
        count++;
    }

    public AuthException(int code, Throwable cause) {
        super(cause);
        this.code = code;
        count++;
    }

    protected AuthException(int code, String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
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
