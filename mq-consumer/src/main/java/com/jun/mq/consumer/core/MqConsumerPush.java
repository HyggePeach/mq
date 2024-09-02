package com.jun.mq.consumer.core;

import com.jun.mq.common.exception.MqException;
import com.jun.mq.consumer.api.IMqConsumer;
import com.jun.mq.consumer.api.IMqConsumerListener;
import com.jun.mq.consumer.constant.ConsumerConst;
import com.jun.mq.consumer.constant.ConsumerRespCode;
import com.jun.mq.consumer.handler.MqConsumerHandler;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;
import lombok.extern.slf4j.Slf4j;

/**
 * @author wangjun
 * @date 2024/9/2 8:56
 */
@Slf4j
public class MqConsumerPush extends Thread implements IMqConsumer {

    /**
     * 组名称
     */
    private final String groupName;

    /**
     * 端口号
     */
    private final int port;

    /**
     * 中间人地址
     */
    private String brokerAddress  = "";

    public MqConsumerPush(String groupName, int port) {
        this.groupName = groupName;
        this.port = port;
    }

    public MqConsumerPush(String groupName) {
        this(groupName, ConsumerConst.DEFAULT_PORT);
    }

    public MqConsumerPush() {
        this(ConsumerConst.DEFAULT_GROUP_NAME, ConsumerConst.DEFAULT_PORT);
    }

    public void setBrokerAddress(String brokerAddress) {
        this.brokerAddress = brokerAddress;
    }

    public void subscribe(String topicName, String tagRegex) {

    }

    public void registerListener(IMqConsumerListener listener) {

    }

    @Override
    public void run(){

        // 启动服务端
        log.info("MQ 消费者开始启动客户端 GROUP: {}, PORT: {}, brokerAddress: {}",
                groupName, port, brokerAddress);

        EventLoopGroup workerGroup = new NioEventLoopGroup();

        try {
            Bootstrap bootstrap = new Bootstrap();
            ChannelFuture channelFuture = bootstrap.group(workerGroup)
                    .channel(NioSocketChannel.class)
                    .option(ChannelOption.SO_KEEPALIVE, true)
                    .handler(new ChannelInitializer<Channel>(){
                        @Override
                        protected void initChannel(Channel ch) throws Exception {
                            ch.pipeline()
                                    .addLast(new LoggingHandler(LogLevel.INFO))
                                    .addLast(new MqConsumerHandler());
                        }
                    })
                    .connect("localhost", port)
                    .syncUninterruptibly();

            log.info("MQ 消费者启动客户端完成，监听端口：" + port);
            channelFuture.channel().closeFuture().syncUninterruptibly();
            log.info("MQ 消费者开始客户端已关闭");
        } catch (Exception e) {
            log.error("MQ 消费者启动遇到异常", e);
            throw new MqException(ConsumerRespCode.RPC_INIT_FAILED);
        } finally {
            workerGroup.shutdownGracefully();
        }
    }
}
