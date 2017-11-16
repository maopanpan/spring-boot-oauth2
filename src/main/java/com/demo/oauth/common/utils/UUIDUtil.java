package com.demo.oauth.common.utils;

import java.util.UUID;

/**
 * @Author: maopanpan
 * @Description: 生成唯一标识
 * @Date: 2017/10/16.
 **/
public class UUIDUtil {

    /**
     * 生成字符串型的UUID
     * UUID由以下几部分的组合：
     * （1）当前日期和时间，UUID的第一个部分与时间有关，如果你在生成一个UUID之后，过几秒又生成一个UUID，则第一个部分不同，其余相同。
     * （2）时钟序列。
     * （3）全局唯一的IEEE机器识别号，如果有网卡，从网卡MAC地址获得，没有网卡以其他方式获得。
     */
    public static String genUUIDString() {
        String uuidStr = UUID.randomUUID().toString().replace("-", "");
        return uuidStr;
    }
}
