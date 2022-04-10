package com.wanou.framework.web;

import com.wanou.common.constant.ErrorCode;
import org.springframework.http.HttpStatus;

/**
 * @program: wanou
 * @description:
 * @author: guoshun
 * @create: 2021/09/02 15:26
 **/

public class ResponseWrapper<T> {

    private T data;

    private boolean success;
    private String code;
    private String message;

    public ResponseWrapper() {
    }

    public static <T> ResponseWrapper<T> success(T data) {
        ResponseWrapper<T> wrapper= new ResponseWrapper<>();
        wrapper.data = data;
        wrapper.success = Boolean.TRUE;
        wrapper.code ="OK";
        wrapper.message = "成功";
        return wrapper;
    }

    public static <T> ResponseWrapper<T> success(){
        return success(null);
    }

    public static <T> ResponseWrapper<T> fail(ErrorCode errorCode) {
        return fail(errorCode.getCode(), errorCode.getMessage());
    }

    public static <T> ResponseWrapper<T> fail(ErrorCode errorCode, Object... args) {
        return fail(errorCode.getCode(), errorCode.getMessage());
    }

    public static <T> ResponseWrapper<T> fail(String errorCode, String errorMessage) {
        return fail(HttpStatus.OK, errorCode, errorMessage);
    }

    public static <T> ResponseWrapper<T> fail(HttpStatus httpStatus, String errorCode, String errorMessage) {
        return fail(httpStatus, errorCode, errorMessage, null);
    }

    public static <T> ResponseWrapper<T> fail(HttpStatus httpStatus, String errorCode, T data) {
        return fail(httpStatus, errorCode, errorCode, data);
    }

    public static <T> ResponseWrapper<T> fail(HttpStatus httpStatus, String errorCode, String errorMessage, T data) {
        ResponseWrapper<T> responseWrapper = new ResponseWrapper<>();
        responseWrapper.success = false;
        responseWrapper.code = errorCode;
        responseWrapper.message = errorMessage;
        responseWrapper.data = data;
        return responseWrapper;
    }

}
