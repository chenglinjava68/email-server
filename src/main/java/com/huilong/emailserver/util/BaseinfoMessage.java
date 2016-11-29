package com.huilong.emailserver.util;

import java.io.Serializable;

/**
 * Desc:
 * Author: zhanghl2
 * Date: 2016/11/28
 * Time: 18:05
 * Version:
 */
public class BaseinfoMessage implements Serializable {

    private static final long serialVersionUID = 1036906216937370229L;
    private String emailAddress;

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }
}
