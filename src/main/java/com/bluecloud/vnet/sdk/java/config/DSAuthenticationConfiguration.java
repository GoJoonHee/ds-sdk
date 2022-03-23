package com.bluecloud.vnet.sdk.java.dssdk.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author dong.liping3
 * @version 1.0
 * @description TODO
 * @date 2022/3/23
 * @see
 */
@Component
@ConfigurationProperties
public class DSAuthenticationConfiguration {

    @Value("${ds.auth.secretkey}")
    private String secretKey;

    public void validSecret() throws RuntimeException {
        //valid ...
    }
}
