package com.bluecloud.vnet.sdk.java.util;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.Type;
import java.util.Map;
import java.util.function.Consumer;

/**
 * @author chenchen
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

    public static <T> T parseMap(Map<String, ?> map, TypeReference<T> typeRef) {
        try {
            return OBJECT_MAPPER.convertValue(map, typeRef);
        } catch (Exception e) {
            LOGGER.error("", e);
        }
        return null;
    }

    public static <T> T parseJSONString(String jsonStr, TypeReference<T> typeRef) {
        try {
            return OBJECT_MAPPER.readValue(jsonStr, typeRef);
        } catch (Exception e) {
            LOGGER.error("", e);
        }
        return null;
    }

    public static <T> T parseJSONString(String jsonStr, Class<T> clazz) {
        try {
            return OBJECT_MAPPER.readValue(jsonStr, clazz);
        } catch (Exception e) {
            LOGGER.error("", e);
        }
        return null;
    }

    public static String toJSONString(Object object) {
        String jsonStr = null;
        try {
            jsonStr = OBJECT_MAPPER.writeValueAsString(object);
        } catch (Exception e) {
            LOGGER.error("", e);
        }
        return jsonStr;
    }

    public static <T> T convertValue(Object fromValue, Class<T> clazz) {
        T t = null;
        try {
            t = OBJECT_MAPPER.convertValue(fromValue, clazz);
        } catch (Exception e) {
            LOGGER.error("", e);
        }
        return t;
    }

    public static <T> T convertValue(Object fromValue, Class<T> clazz, Consumer<T> callBack) {
        T t = null;
        try {
            t = OBJECT_MAPPER.convertValue(fromValue, clazz);
            callBack.accept(t);
        } catch (Exception e) {
            LOGGER.error("", e);
        }
        return t;
    }

    public static byte[] writeValueAsBytes(Object object) {
        byte[] bytes = null;
        try {
            bytes = OBJECT_MAPPER.writeValueAsBytes(object);
        } catch (Exception e) {
            LOGGER.error("", e);
        }
        return bytes;
    }

    public static <T> TypeReference<T> getTypeReference(Type type){
        return new InnerTypeReference<T>(type);
    }

    private static class InnerTypeReference<T> extends TypeReference<T> {

        protected final Type type;

        public InnerTypeReference(Type type){
            this.type = type;
        }

        @Override
        public Type getType() {
            return type;
        }
    }
}
