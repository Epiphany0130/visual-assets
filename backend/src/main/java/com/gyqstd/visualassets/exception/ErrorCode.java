package com.gyqstd.visualassets.exception;

import lombok.Getter;

/**
 * 错误码枚举类
 * 定义系统所有错误码，采用 HTTP 状态码风格 + 业务扩展码设计
 * 
 * 错误码规则：
 * - 前3位：HTTP 状态码风格（便于记忆）
 * - 后2位：业务扩展码（区分具体错误场景）
 * 
 * 错误码范围：
 * - 200xx：成功相关
 * - 400xx：客户端错误（参数错误、请求格式错误等）
 * - 401xx：认证错误（未登录、Token无效等）
 * - 403xx：权限错误（无权限、禁止访问等）
 * - 404xx：资源不存在（用户、图片、团队等）
 * - 409xx：资源冲突（已存在、重复操作等）
 * - 429xx：请求限流（频率超限等）
 * - 500xx：服务端错误（系统异常、第三方服务错误等）
 * 
 * 记忆技巧：
 * - 400 = Bad Request（请求错误）
 * - 401 = Unauthorized（未认证）
 * - 403 = Forbidden（禁止访问）
 * - 404 = Not Found（资源不存在）
 * - 409 = Conflict（资源冲突）
 * - 429 = Too Many Requests（请求过多）
 * - 500 = Internal Server Error（服务器内部错误）
 * 
 * @author GuYuqi
 * @version 1.0
 */
@Getter
public enum ErrorCode {

    /**
     * ========== 成功 (200xx) ==========
     */
    SUCCESS(20000, "success"),
    OPERATION_SUCCESS(20001, "操作成功"),

    /**
     * ========== 客户端错误 (400xx) ==========
     * HTTP 400 Bad Request
     */
    PARAMS_ERROR(40000, "请求参数错误"),
    PARAMS_NULL_ERROR(40001, "请求参数为空"),
    PARAMS_FORMAT_ERROR(40002, "请求参数格式错误"),
    PARAMS_TYPE_ERROR(40003, "请求参数类型错误"),
    PARAMS_LENGTH_ERROR(40004, "请求参数长度错误"),
    REQUEST_FORMAT_ERROR(40005, "请求格式错误"),
    JSON_PARSE_ERROR(40006, "JSON解析错误"),
    METHOD_NOT_ALLOWED(40007, "请求方法不允许"),

    /**
     * ========== 认证错误 (401xx) ==========
     * HTTP 401 Unauthorized
     */
    NOT_LOGIN_ERROR(40100, "未登录"),
    TOKEN_EXPIRED(40101, "登录已过期，请重新登录"),
    TOKEN_INVALID(40102, "登录凭证无效"),
    TOKEN_MISSING(40103, "缺少登录凭证"),
    LOGIN_FAILED(40104, "登录失败"),
    LOGOUT_FAILED(40105, "登出失败"),

    /**
     * ========== 权限错误 (403xx) ==========
     * HTTP 403 Forbidden
     */
    NO_AUTH_ERROR(40300, "无权限访问"),
    FORBIDDEN_ERROR(40301, "禁止访问"),
    ADMIN_ONLY(40302, "仅管理员可操作"),
    VIP_REQUIRED(40303, "需要VIP权限"),
    VIP_EXPIRED(40304, "VIP已过期"),
    TEAM_ADMIN_REQUIRED(40305, "需要团队管理员权限"),
    TEAM_OWNER_REQUIRED(40306, "需要团队创建者权限"),
    PICTURE_NO_PERMISSION(40307, "无权限操作该图片"),
    PICTURE_PRIVATE(40308, "该图片为私有"),
    TEAM_NO_PERMISSION(40309, "无权限操作该团队"),

    /**
     * ========== 资源不存在 (404xx) ==========
     * HTTP 404 Not Found
     */
    NOT_FOUND_ERROR(40400, "请求资源不存在"),
    USER_NOT_FOUND(40401, "用户不存在"),
    PICTURE_NOT_FOUND(40402, "图片不存在"),
    TEAM_NOT_FOUND(40403, "团队不存在"),
    TEAM_MEMBER_NOT_FOUND(40404, "团队成员不存在"),
    TAG_NOT_FOUND(40405, "标签不存在"),
    CONFIG_NOT_FOUND(40406, "配置不存在"),

    /**
     * ========== 资源冲突 (409xx) ==========
     * HTTP 409 Conflict
     */
    RESOURCE_CONFLICT(40900, "资源冲突"),
    USER_ALREADY_EXISTS(40901, "用户已存在"),
    USER_ACCOUNT_EXISTS(40902, "账号已存在"),
    PICTURE_ALREADY_EXISTS(40903, "图片已存在"),
    TEAM_ALREADY_EXISTS(40904, "团队已存在"),
    TEAM_MEMBER_ALREADY_EXISTS(40905, "该用户已是团队成员"),
    DUPLICATE_OPERATION(40906, "重复操作"),

    /**
     * ========== 请求限流 (429xx) ==========
     * HTTP 429 Too Many Requests
     */
    REQUEST_TOO_FREQUENT(42900, "请求过于频繁"),
    RATE_LIMIT_EXCEED(42901, "请求频率超限"),
    AI_RATE_LIMIT_EXCEED(42902, "AI调用频率超限"),

    /**
     * ========== 服务端错误 (500xx) ==========
     * HTTP 500 Internal Server Error
     */
    SYSTEM_ERROR(50000, "系统内部异常"),
    OPERATION_ERROR(50001, "操作失败"),
    OPERATION_TIMEOUT(50002, "操作超时"),
    OPERATION_CANCELLED(50003, "操作已取消"),

    /**
     * ========== 用户相关错误 (501xx) ==========
     */
    USER_PASSWORD_ERROR(50100, "密码错误"),
    USER_STATUS_ERROR(50101, "用户状态异常"),
    USER_REGISTER_FAILED(50102, "注册失败"),
    USER_UPDATE_FAILED(50103, "用户信息更新失败"),
    USER_DELETE_FAILED(50104, "用户删除失败"),

    /**
     * ========== 图片/视觉资产错误 (502xx) ==========
     */
    PICTURE_UPLOAD_FAILED(50200, "图片上传失败"),
    PICTURE_DELETE_FAILED(50201, "图片删除失败"),
    PICTURE_UPDATE_FAILED(50202, "图片更新失败"),
    PICTURE_FORMAT_ERROR(50203, "图片格式不支持"),
    PICTURE_SIZE_EXCEED(50204, "图片大小超出限制"),
    PICTURE_DIMENSION_ERROR(50205, "图片尺寸不符合要求"),
    PICTURE_CORRUPTED(50206, "图片文件损坏"),
    PICTURE_PROCESS_FAILED(50207, "图片处理失败"),
    PICTURE_COMPRESS_FAILED(50208, "图片压缩失败"),
    PICTURE_THUMBNAIL_FAILED(50209, "缩略图生成失败"),

    /**
     * ========== 团队相关错误 (503xx) ==========
     */
    TEAM_CREATE_FAILED(50300, "团队创建失败"),
    TEAM_UPDATE_FAILED(50301, "团队更新失败"),
    TEAM_DELETE_FAILED(50302, "团队删除失败"),
    TEAM_MEMBER_LIMIT_EXCEED(50303, "团队成员数量已达上限"),
    TEAM_OWNER_CANNOT_LEAVE(50304, "团队创建者无法退出"),

    /**
     * ========== AI 分析错误 (504xx) ==========
     */
    AI_ANALYSIS_FAILED(50400, "AI分析失败"),
    AI_TAG_GENERATE_FAILED(50401, "标签生成失败"),
    AI_SERVICE_UNAVAILABLE(50402, "AI服务暂不可用"),
    AI_CONTENT_REJECTED(50403, "内容不符合要求"),
    AI_CONTENT_UNRECOGNIZED(50404, "无法识别图片内容"),

    /**
     * ========== 第三方服务错误 (505xx) ==========
     */
    COS_UPLOAD_FAILED(50500, "文件上传至COS失败"),
    COS_DOWNLOAD_FAILED(50501, "文件从COS下载失败"),
    COS_DELETE_FAILED(50502, "文件从COS删除失败"),
    COS_CONFIG_ERROR(50503, "COS配置错误"),
    DATABASE_ERROR(50504, "数据库操作失败"),
    DATABASE_CONNECTION_ERROR(50505, "数据库连接失败"),
    CACHE_ERROR(50506, "缓存操作失败"),
    CACHE_CONNECTION_ERROR(50507, "缓存连接失败"),
    THIRD_PARTY_SERVICE_ERROR(50508, "第三方服务调用失败");

    /**
     * 错误码
     */
    private final int code;

    /**
     * 错误信息
     */
    private final String message;

    ErrorCode(int code, String message) {
        this.code = code;
        this.message = message;
    }
}
