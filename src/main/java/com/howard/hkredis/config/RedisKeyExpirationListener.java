package com.howard.hkredis.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.listener.KeyExpirationEventMessageListener;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;

/**
 * @author ChenJiWei
 * @version V1.0
 * @date 2020/11/03
 * @description 实现...KeyExpirationEventMessageListener 接口 查看源码发现，该接口监听所有db的过期时间 key event@*:expired"
 */
@Configuration
public class RedisKeyExpirationListener extends KeyExpirationEventMessageListener {

    private static final Logger logger = LoggerFactory.getLogger(RedisKeyExpirationListener.class);

    public RedisKeyExpirationListener(RedisMessageListenerContainer listenerContainer) {
        super(listenerContainer);
    }

    /**
     * 此处真正处理redis key过期事件进行数据处理
     *
     * @param message 过期key
     * @param pattern
     */
    @Override
    public void onMessage(Message message, byte[] pattern) {
        String expireKey = message.toString();
        logger.info("过期key=[{}]", expireKey);
    }
}
