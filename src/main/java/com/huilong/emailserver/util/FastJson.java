package com.huilong.emailserver.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;

/**
 * Desc:
 * Author: zhanghl2
 * Date: 2016/11/29
 * Time: 10:15
 * Version:
 */
public class FastJson {
    public static <T> T fromJson(String json, Class<T> clazz) {
        return JSON.parseObject(json,clazz);
    }


    /**
     * po类转换成json String
     * @param obj
     * @return
     */
    public static String toJson(Object obj) {
        String result=JSON.toJSONString(obj, SerializerFeature.WriteMapNullValue);
        return result;
    }
}
