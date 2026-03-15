package com.gyqstd.visualassets.exception;

import lombok.Data;

/**
 * 自定义业务异常类，用于封装业务逻辑中的错误信息
 *
 * @author gyqstd
 * @version 1.0
 */
@Data
public class BusinessException extends RuntimeException{

    /**
     * 错误码
     */
    private final int code;

    public BusinessException(int code, String message) {
        super(message);
        this.code = code;
    }

    public BusinessException(ErrorCode errorCode) {
        super(errorCode.getMessage());
        this.code = errorCode.getCode();
    }

    public BusinessException(ErrorCode errorCode, String message) {
        super(message);
        this.code = errorCode.getCode();
    }
}