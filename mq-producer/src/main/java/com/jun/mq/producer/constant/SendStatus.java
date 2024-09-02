package com.jun.mq.producer.constant;

public enum SendStatus {
    S("S", "成功"),
    F("F", "失败"),
    ;

    private final String code;
    private final String desc;

    SendStatus(String code, String desc) {
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
