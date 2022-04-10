package com.wanou.common.exception;

/**
 * @author txh
 * @date 2021/9/3 11:02
 * 小程序无权限异常
 */
public class MiniNoAccessException extends RuntimeException {
    private static final long serialVersionUID = -1247494792035744102L;

    public MiniNoAccessException(){
        super("无权限");
    }
}
