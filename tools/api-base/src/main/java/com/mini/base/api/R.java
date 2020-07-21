package com.mini.base.api;


import com.mini.base.constant.PmsConstant;
import com.mini.base.exception.BizException;
import com.mini.base.exception.BizRuntimeException;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.lang.Nullable;

import javax.servlet.http.HttpServletResponse;
import java.io.Serializable;
import java.util.Optional;

import static org.springframework.util.ObjectUtils.nullSafeEquals;

/**
 * @author root
 * 统一API响应结果封装
 */
@Getter
@Setter
@ToString
@ApiModel(description = "返回信息")
@NoArgsConstructor
public class R<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "状态码", required = true)
    private int errorCode;
    @ApiModelProperty(value = "是否成功", required = true)
    private boolean success;
    @ApiModelProperty(value = "承载数据")
    private T data;
    @ApiModelProperty(value = "返回消息", required = true)
    private String msg;

    public R(IResultCode resultCode) {
        this(resultCode, null, resultCode.getMessage());
    }

    public R(IResultCode resultCode, String msg) {
        this(resultCode, null, msg);
    }

    public R(IResultCode resultCode, T data) {
        this(resultCode, data, resultCode.getMessage());
    }

    public R(IResultCode resultCode, T data, String msg) {
        this(resultCode.getCode(), data, msg);
    }

    private R(int errorCode, T data, String msg) {
        this.errorCode = errorCode;
        this.data = data;
        this.msg = msg;
        this.success = ResultCode.SUCCESS.code == errorCode;
    }

    /**
     * 判断返回是否为成功
     *
     * @param result Result
     * @return 是否成功
     */
    public static boolean isSuccess(@Nullable R<?> result) {
        return Optional.ofNullable(result)
                .map(x -> nullSafeEquals(ResultCode.SUCCESS.code, x.errorCode))
                .orElse(Boolean.FALSE);
    }

    /**
     * 判断返回是否为成功
     *
     * @param result Result
     * @return 是否成功
     */
    public static boolean isNotSuccess(@Nullable R<?> result) {
        return !R.isSuccess(result);
    }

    /**
     * 返回R
     *
     * @param data 数据
     * @param <T>  T 泛型标记
     * @return R
     */
    public static <T> R<T> data(T data) {
        return data(data, PmsConstant.DEFAULT_SUCCESS_MESSAGE);
    }

    /**
     * 返回R
     *
     * @param data 数据
     * @param msg  消息
     * @param <T>  T 泛型标记
     * @return R
     */
    public static <T> R<T> data(T data, String msg) {
        return data(HttpServletResponse.SC_OK, data, msg);
    }

    /**
     * 返回R
     *
     * @param code 状态码
     * @param data 数据
     * @param msg  消息
     * @param <T>  T 泛型标记
     * @return R
     */
    public static <T> R<T> data(int code, T data, String msg) {
        return new R<>(code, data, data == null ? PmsConstant.DEFAULT_NULL_MESSAGE : msg);
    }

    /**
     * 返回R
     *
     * @param <T> T 泛型标记
     * @return R
     */
    public static <T> R<T> success() {
        return new R<>(ResultCode.SUCCESS);
    }

    /**
     * 返回R
     *
     * @param msg 消息
     * @param <T> T 泛型标记
     * @return R
     */
    public static <T> R<T> success(String msg) {
        return new R<>(ResultCode.SUCCESS, msg);
    }

    /**
     * 返回R
     *
     * @param resultCode 业务代码
     * @param <T>        T 泛型标记
     * @return R
     */
    public static <T> R<T> success(IResultCode resultCode) {
        return new R<>(resultCode);
    }

    /**
     * 返回R
     *
     * @param resultCode 业务代码
     * @param msg        消息
     * @param <T>        T 泛型标记
     * @return R
     */
    public static <T> R<T> success(IResultCode resultCode, String msg) {
        return new R<>(resultCode, msg);
    }

    /**
     * 返回R
     *
     * @param msg 消息
     * @param <T> T 泛型标记
     * @return R
     */
    public static <T> R<T> fail(String msg) {
        return new R<>(ResultCode.FAILURE, msg);
    }


    /**
     * 返回R
     *
     * @param code 状态码
     * @param msg  消息
     * @param <T>  T 泛型标记
     * @return R
     */
    public static <T> R<T> fail(int code, String msg) {
        return new R<>(code, null, msg);
    }

    /**
     * 返回R
     *
     * @param r   返回对象
     * @param <T> T 泛型标记
     * @return R
     */
    public static <T> R<T> fail(R r) {
        return fail(r.getErrorCode(), r.getMsg());
    }

    /**
     * 返回R
     *
     * @param resultCode 业务代码
     * @param <T>        T 泛型标记
     * @return R
     */
    public static <T> R<T> fail(IResultCode resultCode) {
        return new R<>(resultCode);
    }

    /**
     * 返回R
     *
     * @param resultCode 业务代码
     * @param msg        消息
     * @param <T>        T 泛型标记
     * @return R
     */
    public static <T> R<T> fail(IResultCode resultCode, String msg) {
        return new R<>(resultCode, msg);
    }

    /**
     * @param e: 业务异常
     * @author Caesar Liu
     * @date 2019/5/7 16:34
     */
    public static <T> R<T> fail(BizException e) {
        return R.fail(e.getCode(), e.getMessage());
    }

    public static <T> R<T> fail(BizRuntimeException e) {
        return R.fail(e.getCode(), e.getMessage());
    }

    /**
     * 返回R
     *
     * @param flag 成功状态
     * @return R
     */
    public static <T> R<T> status(boolean flag) {
        return flag ? success(PmsConstant.DEFAULT_SUCCESS_MESSAGE) : fail(PmsConstant.DEFAULT_FAILURE_MESSAGE);
    }

}
