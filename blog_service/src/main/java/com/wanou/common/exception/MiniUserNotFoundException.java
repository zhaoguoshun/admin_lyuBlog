package com.wanou.common.exception;

public class MiniUserNotFoundException extends RuntimeException{
    private static final long serialVersionUID = -4671055395609901152L;

    public MiniUserNotFoundException(){
        super("小程序用户未找到");
    }
}
