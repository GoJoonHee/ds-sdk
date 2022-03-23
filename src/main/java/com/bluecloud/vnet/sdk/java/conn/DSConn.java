package com.bluecloud.vnet.sdk.java.dssdk;

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
    private Resttemplate resttemplate;

    @Autowired
    private DSAddressConfiguration addressConfiguration;

    //zhushi...
    public <Req> CommonResult get(Req req){
        resttemplate.getForObject(addressConfiguration.getAddress(),req,Object.class);
        return null;
    }

    //zhushi...
    public <Req> CommonResult post(Req req){
        resttemplate.postForObject(addressConfiguration.getAddress(),req,Object.class);
        return null;
    }

    //zhushi...
    public void requestHeadSetter(){
        //set`Codeless-Token` Inhead
    }
}
