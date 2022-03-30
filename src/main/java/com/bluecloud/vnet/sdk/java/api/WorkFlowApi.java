package com.bluecloud.vnet.sdk.java.api;

import com.bluecloud.vnet.sdk.java.common.exception.DSRuntimeException;
import com.bluecloud.vnet.sdk.java.config.DSAddressConfiguration;
import com.bluecloud.vnet.sdk.java.conn.DSConn;
import com.bluecloud.vnet.sdk.java.entity.CommonResult;
import com.bluecloud.vnet.sdk.java.entity.req.CreateDeploymentRequest;
import com.bluecloud.vnet.sdk.java.entity.resp.CreateDeploymentResponse;
import com.bluecloud.vnet.sdk.java.tool.validation.enums.AbstractInEnumClassValidator;
import com.bluecloud.vnet.sdk.java.util.JSONUtil;
import com.bluecloud.vnet.sdk.java.util.JsonReadFile;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.Set;


/**
 * @author dong.liping3
 * @version 1.0
 * @description TODO
 * @date 2022/3/23
 * @see
 */
@Component
public class WorkFlowApi {
    private static final Logger LOG = LoggerFactory.getLogger(AbstractInEnumClassValidator.class);

    @Autowired
    private DSAddressConfiguration dsAddressConfiguration;

    @Autowired
    private DSConn dsConn;

    @Autowired
    private Validator validator;

    /**
     * @param
     * @return
     * @throws
     * @author chenchen
     * @description 描述
     * @date 2022/3/23
     * @todo
     */
    public CommonResult<CreateDeploymentResponse> createDeploymentByJSONFile(String jsonFilePath) {
        String readJsonFile = JsonReadFile.readJsonFile(jsonFilePath);
        CreateDeploymentRequest createDeploymentRequest = JSONUtil.parseJSONString(readJsonFile, CreateDeploymentRequest.class);
        Set<ConstraintViolation<CreateDeploymentRequest>> validate = validator.validate(createDeploymentRequest);
        if (!validate.isEmpty()) {
            ConstraintViolation<CreateDeploymentRequest> firstValid = validate.stream().findFirst().get();
            LOG.error("参数校验失败,path: {},  message: {},", firstValid.getPropertyPath().toString(), firstValid.getMessage());
            throw new DSRuntimeException(null, firstValid.getMessage(), new String[]{firstValid.getPropertyPath().toString()});
        }
        CommonResult<CreateDeploymentResponse> result = dsConn.post(dsAddressConfiguration.getAddress(), createDeploymentRequest);
        return result;
    }

}
