package com.wanou.common.exception;

/**
 * @author txh
 * @date 2021/8/20 17:14
 * 微信登录换取openid错误
 */
public class OpenIdException extends RuntimeException {
    private static final long serialVersionUID = -1146828701857303316L;

    public OpenIdException() {
        super("获取openid异常");
    }
}
