package com.howard.hkredis.controller;

import com.howard.hkredis.common.util.R;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author ChenJiWei
 * @version V1.0
 * @date 2020/10/15
 * @description string数据结果测试
 */
@RestController
public class RedisStringController {

    @Resource
    RedisTemplate redisTemplate;
    @Resource
    StringRedisTemplate stringRedisTemplate;


    @RequestMapping(value = "/jdk/set")
    public R jdkSet(String key, String value) {
        redisTemplate.opsForValue().set(key, value);
        Object obj = redisTemplate.opsForValue().get(key);
        return R.ok(obj);
    }

    @RequestMapping(value = "/string/set")
    public R stringSet(String key, String value) {
        stringRedisTemplate.opsForValue().set(key, value);
        Object obj = stringRedisTemplate.opsForValue().get(key);
        return R.ok(obj);
    }


    @RequestMapping(value = "/jdk/get")
    public R jdkGet(String key) {
        Object obj = redisTemplate.opsForValue().get(key);
        return R.ok(obj);
    }

    @RequestMapping(value = "/string/get")
    public R stringGet(String key) {
        Object obj = stringRedisTemplate.opsForValue().get(key);
        return R.ok(obj);
    }
}
