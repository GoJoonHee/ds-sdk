package com.bluecloud.vnet.sdk.java.util;


import com.bluecloud.vnet.sdk.java.common.exception.ReflectionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.CollectionUtils;

import java.lang.annotation.Annotation;
import java.lang.reflect.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author chenchen
 * @version 1.0
 * @description 反射工具
 * @date 6/1/2021
 * @link
 * @see
 */
public final class ReflectUtil {

    private static final Logger LOGGER = LoggerFactory.getLogger(ReflectUtil.class);

    private ReflectUtil() {
    }

    /**
     * @param clazzAnnotation        bean上的注解
     * @param methodAnnotation       方法上的注解
     * @param annotationAttributeMap 指定注解属性和值
     * @return 返回查询到的方法集合，有可能查询不到方法
     * @throws
     * @author chenchen
     * @description 根据携带指定注解的bean获取bean中携带指定注解的方法
     * @date 2020/6/1
     * @todo
     */
    public static List<Method> queryMethodsBySpecialBean(Class clazzAnnotation,
                                                         Class methodAnnotation,
                                                         Map<String, Object> annotationAttributeMap) {
        try {
            List<Method> methodWithAnnotation = new ArrayList<>();
            //找到携带指定注解的Bean
            Map<String, Object> beansWithAnnotation = SpringContextUtils.getBeansWithAnnotation(clazzAnnotation);
            //通过bean找到携带指定注解的接口
            beansWithAnnotation.values().forEach(bean -> {
                Method[] declaredMethods = bean.getClass().getDeclaredMethods();
                for (Method method : declaredMethods) {
                    if (method.isAnnotationPresent(methodAnnotation)) {
                        if (CollectionUtils.isEmpty(annotationAttributeMap)) {
                            methodWithAnnotation.add(method);
                        } else {
                            Annotation declaredAnnotation = method.getDeclaredAnnotation(methodAnnotation);
                            //获取注解对象的属性值
                            InvocationHandler invocationHandler = Proxy.getInvocationHandler(declaredAnnotation);
                            try {
                                Field memberValuesField = invocationHandler.getClass().getDeclaredField("memberValues");
                                memberValuesField.setAccessible(true);
                                Map memberValueMap = (Map) memberValuesField.get(invocationHandler);
                                if (MapUtil.contain(memberValueMap, annotationAttributeMap)) {
                                    methodWithAnnotation.add(method);
                                }
                            } catch (Exception e) {
                                LOGGER.error("", e);
                            }
                        }
                    }
                }
            });
            return CollectionUtils.isEmpty(methodWithAnnotation) ? null : methodWithAnnotation;
        } catch (Exception e) {
            LOGGER.error("", e);
        }
        return null;
    }


    /**
     * @param object     对象
     * @param fieldClazz 属性类型
     * @return 返回提取好的属性Map，key是属性名，value是属性值
     * @throws
     * @author chenchen
     * @description
     * @date 2021/12/23
     * @todo
     */
    public static Map<String, Object> extractField(Object object, Class fieldClazz) throws IllegalArgumentException, IllegalAccessException {
        Map<String, Object> map = new HashMap();
        Class<?> clazz = object.getClass();
        for (; clazz != Object.class; clazz = clazz.getSuperclass()) {
            Field[] field = clazz.getDeclaredFields();
            for (Field f : field) {
                f.setAccessible(true);
                if (f.getType().equals(fieldClazz)) {
                    Object o = f.get(object);
                    if (o != null) {
                        map.put(f.getName(), o);
                    }

                }
            }
        }
        if (CollectionUtils.isEmpty(map)) {
            return null;
        }
        return map;
    }

    public static <T> T newInstance(Class<T> clazz) {
        try {
            return clazz.newInstance();
        } catch (Exception e) {
            throw new ReflectionException(e);
        }
    }

    public static Type getSuperGenericType(Class<?> clazz, int index) {
        Type superClass = clazz.getGenericSuperclass();
        if (superClass instanceof Class<?>) { // sanity check, should never happen
            throw new IllegalArgumentException("Internal error: TypeReference constructed without actual type information");
        }
        /* 22-Dec-2008, tatu: Not sure if this case is safe -- I suspect
         *   it is possible to make it fail?
         *   But let's deal with specific
         *   case when we know an actual use case, and thereby suitable
         *   workarounds for valid case(s) and/or error to throw
         *   on invalid one(s).
         */
        return  ((ParameterizedType) superClass).getActualTypeArguments()[index];
    }
}
