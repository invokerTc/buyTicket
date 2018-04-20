package com.wwwy.liuxing.utils;

import redis.clients.jedis.Jedis;

/**
 * Created by wanghao on 2018/4/20.
 * 获取jedis
 */
public class RedisUtil {
    public static Jedis getRedis(){
        Jedis jedis = new Jedis("192.168.71.117");
        return  jedis;
    }
}
