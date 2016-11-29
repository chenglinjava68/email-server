package com.huilong.emailserver.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;

/**
 * Desc:接受topic的消息 模糊匹配
 * Author: zhanghl2
 * Date: 2016/11/28
 * Time: 15:50
 * Version:
 */
public class MessageTopicConsumer implements MessageListener {
    private Logger logger = LoggerFactory.getLogger(MessageTopicConsumer.class);
    @Override
    public void onMessage(Message message) {
        logger.info("consumer receive message------->:{}", message);

    }
}
