package com.mini.base.model;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.util.Map;

/**
 * @author root
 * app请求日志详情
 */
@Getter
@ToString
@Builder
@EqualsAndHashCode(callSuper = false)
public class Log {

    /**
     * 请求路径
     */
    private String url;
    /**
     * 请求方法
     */
    private String method;
    /**
     * 头文件
     */
    String headers;

    /**
     * 请求参数
     */
    Map<String, Object> paramMap;
    /**
     * 参数
     */
    private Map<String, String[]> parameterMap;
    /**
     * requestBody
     */
    private Object requestBody;
    /**
     * 日志需要打印的json字符串
     */
    private Object result;
    /**
     * 接口运行时间 单位:ms
     */
    private String runTime;
    /**
     * IP地址
     */
    private String ip;

}
