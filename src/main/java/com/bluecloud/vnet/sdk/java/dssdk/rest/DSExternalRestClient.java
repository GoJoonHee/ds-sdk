package com.bluecloud.vnet.sdk.java.dssdk.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * @author chenchen
 * @version 1.0
 * @description 这是请求外部系统专用的rest客户端
 * @date 2022/2/21
 * @link
 * @see
 */
@Component
public class DSExternalRestClient {

    private static final Logger LOGGER = LoggerFactory.getLogger(DSExternalRestClient.class);

    public RestTemplate restTemplate;

    /**
     * @param
     * @return
     * @throws
     * @author chenchen
     * @description 不需要同步等待返回值的post方法
     * @date 2022/2/21
     * @todo
     */
    @Async
    public void post(String url, Object object) {
        LOGGER.info("external rest to [{}] !", url);
        try {
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            HttpEntity request = new HttpEntity(object, headers);
            Object o = restTemplate.postForObject(url, request, Object.class);
            System.out.println(o);
        } catch (Exception e) {
            LOGGER.error("", e);
        }
    }

    /**
     * @param url   请求路径
     * @param clazz 指定返回对象的类型
     * @return 返回查询到的响应结果
     * @throws
     * @author chenchen
     * @description rest的GET方法
     * @date 2022/3/10
     * @todo
     */
    public <T> T get(String url, Class<T> clazz) {
        return restTemplate.getForEntity(url, clazz).getBody();
    }
}
