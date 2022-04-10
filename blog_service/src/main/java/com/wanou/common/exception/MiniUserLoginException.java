package com.wanou.common.exception;

/**
 * @author txh
 * @date 2021/8/31 17:35
 * 小程序用户未登录或登录过期异常
 */
public class MiniUserLoginException extends RuntimeException {
    private static final long serialVersionUID = 6297010274100847309L;

    public MiniUserLoginException(){
        super("未登录或登录已过期");
    }
}
