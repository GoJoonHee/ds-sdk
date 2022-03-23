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
public class DSAddressConfiguration {

    @Value("${ds.address.protocol}")
    private String protocol;

    @Value("${ds.address.host}")
    private String host;

    @Value("${ds.address.port}")
    private String port;

    //zhushi ...
    public void testConn() {
        //测试链接方法
    }
}
