package com.huilong.emailserver.service;


import com.huilong.emailserver.model.MailEntity;

/**
 * Created by 18358 on 2016/11/21.
 */
public interface EmailSendService {

    public boolean send(MailEntity mailEntity);
    }
