package com.hdl.redis.demo;

import com.hdl.redis.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.concurrent.TimeUnit;

public class RedisUtilTest {

    @Autowired
    RedisUtil redisUtil;

    public void setTest(){
        redisUtil.set("name","hdl");
    }


    public void getTest(){
        String value = redisUtil.get("name");
        System.out.println(value);
    }


    public void exTest(){
        redisUtil.expire("java",1, TimeUnit.MINUTES);
    }


    public void setExTest(){
        redisUtil.setAndExpire("age","17",1,TimeUnit.MINUTES);
    }

    public void incr(){
        long l = redisUtil.incr("java");
        System.out.println(l);
    }
}
