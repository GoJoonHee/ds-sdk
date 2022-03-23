package com.bluecloud.vnet.sdk.java.dssdk.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author dong.liping3
 * @version 1.0
 * @description TODO
 * @date 2022/3/23
 * @see
 */
@Component
@ConfigurationProperties(prefix = "conn.lists")
public class ConConfig {

    private List<Conns> conns;
}
