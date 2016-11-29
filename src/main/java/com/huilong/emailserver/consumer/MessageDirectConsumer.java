package com.huilong.emailserver.consumer;

import com.huilong.emailserver.server.email.EmailListennerService;
import com.huilong.emailserver.util.BaseinfoMessage;
import com.huilong.emailserver.util.FastJsonMessageConverter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;
import org.springframework.beans.factory.annotation.Autowired;


/**
 * direct 点对点
 * 监听mq消息
 */
public class MessageDirectConsumer implements MessageListener {
    private Logger logger = LoggerFactory.getLogger(MessageDirectConsumer.class);
    @Autowired
    private EmailListennerService emailListennerService;
    @Override
    public void onMessage(Message message) {
        logger.info("consumer receive message------->:{}", message);

        BaseinfoMessage messageObject = new BaseinfoMessage();
        // 转换为java对象
        FastJsonMessageConverter jsonMessageConverter = new FastJsonMessageConverter();
        messageObject= jsonMessageConverter.fromMessage(message,messageObject);

        emailListennerService.send(messageObject.getEmailAddress());
    }
}
