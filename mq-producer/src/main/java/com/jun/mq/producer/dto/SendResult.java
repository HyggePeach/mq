package com.jun.mq.producer.dto;

import com.jun.mq.producer.constant.SendStatus;

/**
 * @author wangjun
 * @date 2024/9/2 9:37
 */
public class SendResult {
    /**
     * 消息唯一标识
     */
    private String messageId;

    /**
     * 发送状态
     */
    private SendStatus status;

    public String getMessageId() {
        return messageId;
    }

    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }

    public SendStatus getStatus() {
        return status;
    }

    public void setStatus(SendStatus status) {
        this.status = status;
    }
}
