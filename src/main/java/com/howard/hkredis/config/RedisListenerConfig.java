package com.howard.hkredis.config;

import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.stereotype.Component;

/**
 * @author ChenJiWei
 * @version V1.0
 * @date 2020/10/15
 * @description 定义redis配置 实现监听redis key过期时间
 */
@Component
public class RedisListenerConfig {

    @Bean
    RedisMessageListenerContainer  MessageListenerContainer(RedisConnectionFactory connectionFactory) {
        RedisMessageListenerContainer messageListenerContainer = new RedisMessageListenerContainer();
        messageListenerContainer.setConnectionFactory(connectionFactory);
        return messageListenerContainer;
    }
}
