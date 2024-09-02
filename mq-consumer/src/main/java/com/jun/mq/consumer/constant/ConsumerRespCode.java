package com.jun.mq.consumer.constant;

import com.github.houbb.heaven.response.respcode.RespCode;

/**
 * @author wangjun
 * @date 2024/9/2 9:30
 */
public enum ConsumerRespCode implements RespCode {
    RPC_INIT_FAILED("C00001", "消费者启动失败");

    private final String code;
    private final String msg;

    ConsumerRespCode(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    @Override
    public String getCode() {
        return code;
    }

    @Override
    public String getMsg() {
        return msg;
    }
}
