package com.jun.mq.consumer.api;


import com.jun.mq.common.dto.MqMessage;
import com.jun.mq.consumer.constant.ConsumerStatus;

/**
 * @author binbin.hou
 * @since 1.0.0
 */
public interface IMqConsumerListener {


    /**
     * 消费
     * @param mqMessage 消息体
     * @param context 上下文
     * @return 结果
     */
    ConsumerStatus consumer(final MqMessage mqMessage,
                            final IMqConsumerListenerContext context);

}
