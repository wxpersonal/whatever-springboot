package me.weix.whatever.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisPassword;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisClientConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import redis.clients.jedis.JedisPoolConfig;

import java.time.Duration;

/**
 * Created by Administrator on 2017/7/4.
 */

@Configuration
public class RedisConfig {

    @Value("${redis.host}")
    private String host;
    @Value("${redis.password}")
    private String password;
    @Value("${redis.port}")
    private int port;
    @Value("${redis.timeout}")
    private int timeout;
    @Value("${redis.pool.max-idle}")
    private int maxIdle;
    @Value("${redis.pool.min-idle}")
    private int minIdle;
    @Value("${redis.pool.max-wait}")
    private long maxWaitMillis;
    @Value("${redis.pool.max-active}")
    private int maxActive;

    @Bean
    public JedisPoolConfig getRedisConfig() {
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxIdle(maxIdle);
        config.setMinIdle(minIdle);
        config.setMaxWaitMillis(maxWaitMillis);
        config.setMaxTotal(maxActive);
        return config;
    }

    @Bean
    JedisConnectionFactory jedisConnectionFactory(RedisStandaloneConfiguration redisStandaloneConfiguration) {
        JedisClientConfiguration.JedisClientConfigurationBuilder jedisClientConfiguration = JedisClientConfiguration.builder();
        jedisClientConfiguration.connectTimeout(Duration.ofMillis(0));//  connection timeout
        JedisConnectionFactory factory = new JedisConnectionFactory(redisStandaloneConfiguration,
                jedisClientConfiguration.build());
        return factory;
    }


    @Bean
    public RedisStandaloneConfiguration redisStandaloneConfiguration() {
        RedisStandaloneConfiguration configuration =
                new RedisStandaloneConfiguration(host, port);
        configuration.setPassword(RedisPassword.of(password));
        return configuration;
    }
}
