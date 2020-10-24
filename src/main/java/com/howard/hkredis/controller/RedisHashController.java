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
@RequestMapping(value = "/hash")
public class RedisHashController {

    @Resource
    StringRedisTemplate stringRedisTemplate;

    @RequestMapping(value = "/hset")
    public R stringSet(String key, String hashKey, String value) {
        stringRedisTemplate.opsForHash().put(key, hashKey, value);
        Object obj = stringRedisTemplate.opsForHash().get(key, hashKey);
        return R.ok(obj);
    }
}
