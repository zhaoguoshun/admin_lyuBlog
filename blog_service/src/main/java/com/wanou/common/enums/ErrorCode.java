package com.wanou.common.enums;

import com.google.gson.internal.$Gson$Types;

/**
 * @program: wanou
 * @description:
 * @author: guoshun
 * @create: 2021/09/02 15:06
 **/
public enum ErrorCode implements com.wanou.common.constant.ErrorCode {
    CREATE_FAILED("CREATE_FAILED", "创建失败."),
    UPDATE_FAILED("UPDATE_FAILED", "更新失败."),
    PARAM_INVALID_ERROR("PARAM_INVALID_ERROR", "参数不合法."),
    DATA_NOT_EXIST("DATA_NOT_EXIST", "目标数据不存在."),
    DATA_EXIST("DATA_EXIST", "目标数据已存在."),
    UNKNOWN_EXCEPTION_FOR_CLIENT("UNKNOWN_EXCEPTION_FOR_CLIENT", "未知异常."),
    INTERNAL_SERVE_ERROR("INTERNAL_SERVE_ERROR","服务器内部错误"),
    CREATE_PRODUCT_ILLEGAL("CREATE_PRODUCT_ILLEGAL","您发布的帖子存在违规行为"),
    PAY_FAILED("PAY_FAILED","支付失败"),
    UNKNOWN_ERROR("UNKNOWN_ERROR","未知错误"),

    ;
    private String code;

    private String message;

    ErrorCode(String code, String message) {
        this.code = code;
        this.message = message;
    }
    @Override
    public String getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
