package com.hdl.redis.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
public class RedisUtil {

    @Autowired
    StringRedisTemplate redisTemplate;

    /**
     * 保存key，value
     * @param k
     * @param v
     */
    public void set(String k,String v){
        redisTemplate.boundValueOps(k).set(v);
    }

    /**
     * 查询value
     * @param k
     * @return
     */
    //获取value
    public String get(String k){
        return redisTemplate.boundValueOps(k).get();
    }

    /**
     * 设置key的超时时间
     * @param k key
     * @param l 时间
     * @param timeUnit 时间类型
     * @return
     */
    public boolean expire(String k,long l,TimeUnit timeUnit){
        return redisTemplate.boundValueOps(k).expire(l, timeUnit);
    }

    /**
     * set并设置时间
     * @param k
     * @param v
     * @param l
     * @param timeUnit
     */
    public void setAndExpire(String k,String v,long l,TimeUnit timeUnit){
        redisTemplate.boundValueOps(k).set(v,l,timeUnit);
    }

    /**
     * 原子性自增1
     * @param k
     * @return 返回自增后的数值
     */
    public long incr(String k){
        return redisTemplate.boundValueOps(k).increment(1);
    }

    /**
     * 删除key
     * @param k
     * @return
     */
    public boolean del(String k){
        return redisTemplate.delete(k);
    }

}
