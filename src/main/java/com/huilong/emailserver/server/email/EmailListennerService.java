package com.huilong.emailserver.server.email;

/**
 * Desc:
 * Author: zhanghl2
 * Date: 2016/11/28
 * Time: 16:31
 * Version:
 */
public interface EmailListennerService {
    boolean send(String emailAddress);
    boolean send(String emailAddress,String sendWay);
}
