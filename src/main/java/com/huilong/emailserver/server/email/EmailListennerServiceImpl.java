package com.huilong.emailserver.server.email;

import com.huilong.emailserver.model.MailEntity;
import com.huilong.emailserver.service.EmailSendService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Desc:
 * Author: zhanghl2
 * Date: 2016/11/28
 * Time: 16:32
 * Version:
 */
public class EmailListennerServiceImpl implements EmailListennerService {
    @Autowired
    private EmailSendService emailSendService;
    private static MailEntity mailEntity = new MailEntity();;
    @Override
    public boolean send(String emailAddress) {
        mailEntity.setReceiver(emailAddress.trim());
        boolean result = emailSendService.send(mailEntity);

        return result;
    }

    @Override
    public boolean send(String emailAddress, String sendWay) {
        mailEntity.setMessage(mailEntity.getMessage()+"\n"+"mq发送方式:"+ sendWay);
        mailEntity.setReceiver(emailAddress);
        boolean result = emailSendService.send(mailEntity);

        return result;
    }


    static {
        mailEntity.setHost("smtp.163.com");
        mailEntity.setSender("zhanghl7365@163.com");
        mailEntity.setName("监控主机");
        mailEntity.setPassword("？？？？？");
        mailEntity.setMessage("监控——测试邮件");
        mailEntity.setSubject("服务异常");
        mailEntity.setUsername("zhanghl7365@163.com");
    }
}
