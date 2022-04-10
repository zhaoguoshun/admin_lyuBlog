package com.wanou.common.exception;

import lombok.Data;

/**
 * @author txh
 * @date 2021/8/20 17:29
 * 小程序用户未绑定信息
 */
@Data
public class NoBindMiniUserException extends RuntimeException {
    private static final long serialVersionUID = 8716742867963438537L;

    private String openid;

    public NoBindMiniUserException(){
        super("用户未绑定");
    }

    public NoBindMiniUserException(String openid){
        super("用户未绑定");
        this.openid = openid;
    }
}
