package com.gyqstd.visualassets.common;

import com.gyqstd.visualassets.exception.ErrorCode;
import lombok.Data;

import java.io.Serializable;

/**
 * 基础响应包装类，配合 ResultUtil
 * @param <T>
 */
@Data
public class BaseResponse<T> implements Serializable {

    private int code;

    private T data;

    private String message;

    public BaseResponse(int code, T data, String message) {
        this.code = code;
        this.data = data;
        this.message = message;
    }

    public BaseResponse(int code, T data) {
        this(code, data, ""); // 直接调用另一个构造方法
    }

    public BaseResponse(ErrorCode errorCode) {
        this(errorCode.getCode(), null, errorCode.getMessage());
    }

}