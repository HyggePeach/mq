package com.jun.mq.producer.api;

import com.jun.mq.common.dto.MqMessage;
import com.jun.mq.producer.dto.SendResult;

/**
 * @author wangjun
 * @date 2024/9/2 9:34
 */
public interface IMqProducer {
    /**
     * 同步发送消息
     * @param mqMessage 消息类型
     * @return 结果
     */
    SendResult send(final MqMessage mqMessage);

    /**
     * 单向发送消息
     * @param mqMessage 消息类型
     * @return 结果
     */
    SendResult sendOneWay(final MqMessage mqMessage);
}
