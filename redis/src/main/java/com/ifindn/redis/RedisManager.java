package com.ifindn.redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * @author Guo Yan
 * @date 2020/4/11-21:03
 */
public class RedisManager {


    private static JedisPool jedisPool;
    static {
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxTotal(20);
        config.setMaxIdle(10);
        jedisPool = new JedisPool(config,"172.24.14.120",6379);
    }

    public static Jedis getJedis()throws Exception{
        if(null != jedisPool){
            jedisPool.getResource();
        }
        throw new Exception("jedis was not init");
    }


}
