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
 * Desc:监听 发布订阅方式的q
 * Author: zhanghl2
 * Date: 2016/11/28
 * Time: 15:48
 * Version:
 */
public class MessageFanoutConsumer implements MessageListener{
    private Logger logger = LoggerFactory.getLogger(MessageFanoutConsumer.class);
    @Autowired
    private  EmailListennerService emailListennerService;
    @Override
    public void onMessage(Message message) {
        logger.info("consumer receive message------->:{}", message);
        BaseinfoMessage messageObject = new BaseinfoMessage();
        // 转换为java对象
        FastJsonMessageConverter jsonMessageConverter = new FastJsonMessageConverter();
        messageObject= jsonMessageConverter.fromMessage(message,messageObject);
        // 发送 邮件 ，发送方式 fanout
        emailListennerService.send(messageObject.getEmailAddress(),"fanout");
    }
}
