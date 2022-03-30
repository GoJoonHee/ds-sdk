package com.bluecloud.vnet.sdk.java.dssdk;

import com.bluecloud.vnet.sdk.java.DsSdkApplication;
import com.bluecloud.vnet.sdk.java.api.WorkFlowApi;
import com.bluecloud.vnet.sdk.java.entity.CommonResult;
import com.bluecloud.vnet.sdk.java.entity.resp.CreateDeploymentResponse;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = DsSdkApplication.class)
public class DsSdkApplicationTests {
    @Autowired
    private WorkFlowApi workFlowApi;


    @Test
    public void initTemplate() {
        String filePath="D:\\research_evaluation_new.json";
        CommonResult<CreateDeploymentResponse> deploymentByJSONFile = workFlowApi.createDeploymentByJSONFile(filePath);

    }

}
