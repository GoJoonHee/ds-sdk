package com.bluecloud.vnet.sdk.java.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author dong.liping3
 * @version 1.0
 * @description
 * @date 5/17/2021
 * @see
 */
@Component
public final class JSONUtil {

    private static final Logger LOGGER = LoggerFactory.getLogger(JSONUtil.class);

    private static ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    @Autowired
    public void setObjectMapper(ObjectMapper om) {
        JSONUtil.OBJECT_MAPPER = om;
    }

    /**
     * @param jsonStr
     * @param clazz
     * @return T
     * @throws
     * @author dongliping
     * @description json 转对象
     * @date 2022/4/2
     * @todo
     */
    public static <T> T parseJSONString(String jsonStr, Class<T> clazz) {
        try {
            return OBJECT_MAPPER.readValue(jsonStr, clazz);
        } catch (Exception e) {
            LOGGER.error("", e);
        }
        return null;
    }

}
