package com.gyqstd.visualassets.utils;

import cn.hutool.core.util.StrUtil;
import com.gyqstd.visualassets.exception.BusinessException;
import com.gyqstd.visualassets.exception.ErrorCode;

/**
 * 异常抛出工具类
 * 简化条件判断抛异常的代码，替代繁琐的 if-throw 写法
 * 
 * 使用示例：
 * <pre>
 * // 条件成立则抛异常
 * AssertUtil.throwIf(user == null, ErrorCode.USER_NOT_FOUND);
 * 
 * // 条件成立则抛异常（带自定义信息）
 * AssertUtil.throwIf(user == null, ErrorCode.USER_NOT_FOUND, "用户不存在");
 * 
 * // 条件不成立则抛异常
 * AssertUtil.throwIfNot(user.getStatus() == 1, ErrorCode.USER_STATUS_ERROR);
 * </pre>
 * 
 * @author GuYuqi
 * @version 1.0
 */
public class AssertUtil {

    /**
     * 条件成立则抛出业务异常
     * @param condition 条件
     * @param runtimeException 异常
     */
    public static void throwIf(boolean condition, RuntimeException runtimeException) {
        if (condition) {
            throw runtimeException;
        }
    }

    /**
     * 条件成立则抛出业务异常
     * @param condition 条件
     * @param errorCode 错误码
     */
    public static void throwIf(boolean condition, ErrorCode errorCode) {
        throwIf(condition, new BusinessException(errorCode));
    }

    /**
     * 条件成立则抛出业务异常（自定义错误信息）
     * @param condition 条件
     * @param errorCode 错误码
     * @param message 自定义错误信息
     */
    public static void throwIf(boolean condition, ErrorCode errorCode, String message) {
        throwIf(condition, new BusinessException(errorCode, message));
    }

    /**
     * 条件不成立则抛出业务异常
     * @param condition 条件
     * @param errorCode 错误码
     */
    public static void throwIfNot(boolean condition, ErrorCode errorCode) {
        if (!condition) {
            throw new BusinessException(errorCode);
        }
    }

    /**
     * 条件不成立则抛出业务异常（自定义错误信息）
     * @param condition 条件
     * @param errorCode 错误码
     * @param message 自定义错误信息
     */
    public static void throwIfNot(boolean condition, ErrorCode errorCode, String message) {
        if (!condition) {
            throw new BusinessException(errorCode, message);
        }
    }

    /**
     * 字符串为空（null 或空白字符）则抛异常
     * @param str 字符串
     * @param errorCode 错误码
     */
    public static void throwIfBlank(String str, ErrorCode errorCode) {
        throwIf(StrUtil.isBlank(str), errorCode);
    }

    /**
     * 字符串为空（null 或空白字符）则抛异常（自定义错误信息）
     * @param str 字符串
     * @param errorCode 错误码
     * @param message 自定义错误信息
     */
    public static void throwIfBlank(String str, ErrorCode errorCode, String message) {
        throwIf(StrUtil.isBlank(str), errorCode, message);
    }

}
