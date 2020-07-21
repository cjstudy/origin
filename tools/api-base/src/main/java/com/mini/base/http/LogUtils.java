package com.mini.base.http;

import com.mini.base.exception.BizRuntimeException;
import com.mini.base.model.Log;
import com.mini.base.utils.JsonUtils;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;
import java.util.Optional;

/**
 * 请求日志工具类
 */
@Slf4j
public abstract class LogUtils {

    /**
     * 获取日志对象
     *
     * @param beginTime
     * @param headers
     * @param paramMap
     * @param parameterMap
     * @param requestBody
     * @param url
     * @param method
     * @param ip
     * @param object
     */
    public static void printLog(Long beginTime, String headers, Map<String, Object> paramMap, Map<String, String[]> parameterMap, String requestBody, String url, String method, String ip, Object object) {
        try {
            Log logInfo = Log.builder()
                    //请求路径
                    .url(url)
                    //请求方法
                    .method(method)
                    .headers(headers)
                    .paramMap(paramMap)
                    //查询参数
                    .parameterMap(parameterMap)
                    //请求体
                    .requestBody(Optional.ofNullable(JsonUtils.parse(requestBody)).orElse(requestBody))
                    .runTime((beginTime != null ? System.currentTimeMillis() - beginTime : 0) + "ms")
                    .result(object)
                    .ip(ip)
                    .build();
            boolean cantoJson = JsonUtils.isCantoJson(logInfo);
            if (cantoJson) {
                log.info(JsonUtils.toJson(logInfo));
            }
        } catch (BizRuntimeException e) {
            log.error("打印日志出错-BizRuntimeException:{}", e.getMessage(), e);
        } catch (Exception e) {
            log.error("打印日志出错-Exception:{}", e.getMessage(), e);
        }
    }

}
