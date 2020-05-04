package com.game.wegame.service.impl;

/**
 *  @author liang
 *  @date 2020-5-4
 * 枚举了一些常用API操作码,后续再添加
 */
public enum ResultCode implements IErrorCode {
    SUCCESS(200, "操作成功"),
    FAILED(500, "操作失败"),
    VALIDATE_FAILED(404, "用户不存在或密码错误");

    private long code;
    private String message;

    private ResultCode(long code, String message) {
        this.code = code;
        this.message = message;
    }

    public long getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
