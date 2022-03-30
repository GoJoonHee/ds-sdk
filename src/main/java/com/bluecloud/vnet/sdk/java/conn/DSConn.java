package com.bluecloud.vnet.sdk.java.conn;

import com.bluecloud.vnet.sdk.java.entity.CommonResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * @author dong.liping3
 * @version 1.0
 * @description TODO
 * @date 2022/3/23
 * @see
 */
@Component
public class DSConn {

    @Autowired
    private RestTemplate restTemplate;

    private static final Logger LOGGER = LoggerFactory.getLogger(DSConn.class);

    /**
     * @param url
     * @return com.bluecloud.vnet.sdk.java.entity.CommonResult
     * @throws
     * @author dongliping
     * @description
     * @date 2022/3/30
     * @todo
     */
    public <Req> CommonResult get(String url){
        LOGGER.info("external rest to [{}] !", url);
        CommonResult commonResult=new CommonResult();
        try {
            commonResult= restTemplate.getForObject(url, CommonResult.class);
        } catch (Exception e) {
            LOGGER.error("", e);
        }
        return commonResult;
    }

   /**
    * @param url
    * @param req
    * @return com.bluecloud.vnet.sdk.java.entity.CommonResult
    * @throws
    * @author dongliping
    * @description
    * @date 2022/3/30
    * @todo
    */
    public <Req> CommonResult post(String url,Req req){
        LOGGER.info("external rest to [{}] !", url);
        CommonResult commonResult=new CommonResult();
        try {
            HttpHeaders headers = new HttpHeaders();
            requestHeadSetter(new HttpHeaders());
            HttpEntity request = new HttpEntity(req, headers);
            commonResult= restTemplate.postForObject(url, request, CommonResult.class);
        } catch (Exception e) {
            LOGGER.error("", e);
        }
        return commonResult;
    }

    /**
     * @param headers
     * @return void
     * @throws
     * @author dongliping
     * @description 设置请求头
     * @date 2022/3/30
     * @todo
     */
    public void requestHeadSetter(HttpHeaders headers){
        //set`Codeless-Token` Inhead
         headers.setContentType(MediaType.APPLICATION_JSON);
    }
}
