package com.jun.mq.consumer.constant;

/**
 * @author wangjun
 * @date 2024/9/2 8:51
 */
public enum ConsumerStatus {
    SUCCESS("SUCCESS", "消费成功"),
    FAILED("FAILED", "消费失败"),
    CONSUMER_LATER("CONSUMER_LATER", "稍后消费"),
    ;

    private final String code;
    private final String desc;

    ConsumerStatus(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public String getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }
}
