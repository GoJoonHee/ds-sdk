package com.bluecloud.vnet.sdk.java.config;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import java.time.Duration;

/**
 * @author dong.liping3
 * @version 1.0
 * @description RestTemplate 忽略ssl 检查
 * @date 2022/3/28
 * @see
 */
@Configuration
public class RestTemplateConfig {

    @Bean
    public RestTemplate restTemplateSDK(RestTemplateBuilder builder) {
        return builder.requestFactory(SslIngoreClientHttpRequestFactory::new)
                .setConnectTimeout(Duration.ofMillis(50000)).build();

    }
}
