package com.superai.supercommon.core.api;

import java.io.Serializable;
import java.util.Optional;

import org.springframework.util.ObjectUtils;

/**
 * @author : XiaoBaiBai
 * @description : T
 * @created : 2025/6/19
 **/
public class R<T> implements Serializable {
    private static final long serialVersionUID = 1L;

    private int code; // 响应码

    private boolean success; // 表示操作是否成功
    private T data; // 返回的数据信息

    private String msg; // 响应消息

    // 私有构造函数，用于创建包含响应码、数据和消息的响应
    private R(int code, T data, String msg) {
        this.code = code;
        this.data = data;
        this.msg = msg;
        this.success = ResultCode.SUCCESS.code == code; // 根据响应码判断是否成功
    }

    // 私有构造函数，使用结果码创建响应，数据为空
    private R(IResultCode resultCode) {
        this(resultCode, (T) null, resultCode.getMessage());
    }

    // 私有构造函数，使用结果码和自定义消息创建响应，数据为空
    private R(IResultCode resultCode, String msg) {
        this(resultCode, (T) null, msg);
    }

    // 私有构造函数，使用结果码和数据创建响应
    private R(IResultCode resultCode, T data) {
        this(resultCode, data, resultCode.getMessage());
    }

    // 私有构造函数，使用结果码、数据和消息创建响应
    private R(IResultCode resultCode, T data, String msg) {
        this(resultCode.getCode(), data, msg);
    }

    // 判断响应是否成功
    public static boolean isSuccess(R<?> result) {
        return (Boolean) Optional.ofNullable(result)
                .map((x) -> ObjectUtils.nullSafeEquals(ResultCode.SUCCESS.code, x.code))
                .orElse(Boolean.FALSE); // 若结果为null，返回false
    }

    // 判断响应是否不成功
    public static boolean isNotSuccess(R<?> result) {
        return !isSuccess(result);
    }

    // 创建成功响应，默认消息为“操作成功”
    public static <T> R<T> data(T data) {
        return data(data, "操作成功");
    }

    // 创建成功响应，支持自定义消息
    public static <T> R<T> data(T data, String msg) {
        return data(200, data, msg); // 默认响应码为200
    }

    // 创建响应，支持自定义响应码、数据和消息
    public static <T> R<T> data(int code, T data, String msg) {
        return new R<T>(code, data, data == null ? "暂无承载数据" : msg);
    }

    // 创建成功响应，支持自定义消息
    public static <T> R<T> success(String msg) {
        return new R<T>(ResultCode.SUCCESS, msg);
    }

    // 创建成功响应，使用结果码
    public static <T> R<T> success(IResultCode resultCode) {
        return new R<T>(resultCode);
    }

    // 创建成功响应，使用结果码和自定义消息
    public static <T> R<T> success(IResultCode resultCode, String msg) {
        return new R<T>(resultCode, msg);
    }

    // 创建失败响应，支持自定义消息
    public static <T> R<T> fail(String msg) {
        return new R<T>(ResultCode.FAILURE, msg);
    }

    // 创建失败响应，支持自定义响应码和消息
    public static <T> R<T> fail(int code, String msg) {
        return new R<T>(code, (T) null, msg);
    }

    // 创建失败响应，使用结果码
    public static <T> R<T> fail(IResultCode resultCode) {
        return new R<T>(resultCode);
    }

    // 创建失败响应，使用结果码和自定义消息
    public static <T> R<T> fail(IResultCode resultCode, String msg) {
        return new R<T>(resultCode, msg);
    }

    // 根据布尔标志创建成功或失败响应
    public static <T> R<T> status(boolean flag) {
        return flag ? success("操作成功") : fail("操作失败");
    }

    // 获取响应码
    public int getCode() {
        return this.code;
    }

    // 判断操作是否成功
    public boolean isSuccess() {
        return this.success;
    }

    // 获取返回的数据
    public T getData() {
        return this.data;
    }

    // 获取响应消息
    public String getMsg() {
        return this.msg;
    }

    // 设置响应码
    public void setCode(final int code) {
        this.code = code;
    }

    // 设置成功状态
    public void setSuccess(final boolean success) {
        this.success = success;
    }

    // 设置返回的数据
    public void setData(final T data) {
        this.data = data;
    }

    // 设置响应消息
    public void setMsg(final String msg) {
        this.msg = msg;
    }

    // 重写toString方法，便于调试
    public String toString() {
        return "R(code=" + this.getCode() + ", success=" + this.isSuccess() + ", data=" + this.getData() + ", msg=" + this.getMsg() + ")";
    }

    // 默认构造函数
    public R() {
    }
}
