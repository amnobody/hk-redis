package com.howard.hkredis.controller;

import com.howard.hkredis.common.util.R;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * @author ChenJiWei
 * @version V1.0
 * @date 2020/11/03
 * @description 过期测试
 */
@RestController
@RequestMapping(value = "/expiration")
public class ExpirationController {

    @Resource
    StringRedisTemplate stringRedisTemplate;

    @RequestMapping(value = "/string/set")
    public R stringSet(String key, String value) {
        System.out.println("当前时间：" + new Date());
        stringRedisTemplate.opsForValue().set(key, value, 1, TimeUnit.MINUTES);
        Object obj = stringRedisTemplate.opsForValue().get(key);
        return R.ok(obj);
    }
}
