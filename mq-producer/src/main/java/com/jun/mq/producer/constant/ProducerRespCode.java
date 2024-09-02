package com.jun.mq.producer.constant;

import com.github.houbb.heaven.response.respcode.RespCode;

/**
 * @author wangjun
 * @date 2024/9/2 9:47
 */
public enum ProducerRespCode implements RespCode {
    RPC_INIT_FAILED("P00001", "生产者启动失败");

    private final String code;
    private final String msg;

    ProducerRespCode(String code, String msg) {
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
