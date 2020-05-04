package com.game.wegame.service.impl;

import org.springframework.stereotype.Repository;

/**
 *  @author liang
 *  @date 2020-5-4
 * 封装API的错误码
 */
@Repository
public interface IErrorCode {
    long getCode();
    String getMessage();
}
