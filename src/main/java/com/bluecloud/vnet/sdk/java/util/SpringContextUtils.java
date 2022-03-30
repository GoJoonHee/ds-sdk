package com.bluecloud.vnet.sdk.java.util;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.lang.annotation.Annotation;
import java.util.Map;

/**
 * @author chenchen
 * @version 1.0
 * @description SpringContext工具类
 * @date 2021/5/14
 * @link
 * @see
 */
@Component
@Lazy(false)
public final class SpringContextUtils implements ApplicationContextAware {

    private static ApplicationContext applicationContext;
    private static ConfigurableApplicationContext configurableApplicationContext;
    private static BeanDefinitionRegistry beanDefinitionRegistry;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        SpringContextUtils.applicationContext = applicationContext;
        SpringContextUtils.configurableApplicationContext = (ConfigurableApplicationContext) SpringContextUtils.applicationContext;
        SpringContextUtils.beanDefinitionRegistry = (BeanDefinitionRegistry) SpringContextUtils.configurableApplicationContext;
    }

    public static ApplicationContext getApplicationContext() {
        checkApplicationContext();
        return applicationContext;
    }

    public static <T> T getBean(String name) {
        checkApplicationContext();
        return (T) applicationContext.getBean(name);
    }

    public static <T> T getBean(Class<T> clazz) {
        checkApplicationContext();
        return (T) applicationContext.getBean(clazz);
    }

    public static boolean containsBean(String name) {
        checkApplicationContext();
        return applicationContext.containsBean(name);
    }

    public static <T extends Annotation> Map<String, Object> getBeansWithAnnotation(Class<T> clazz) {
        checkApplicationContext();
        return applicationContext.getBeansWithAnnotation(clazz);
    }

    public static void removeBean(String beanName) {
        checkApplicationContext();
        beanDefinitionRegistry.removeBeanDefinition(beanName);
    }

    private static void checkApplicationContext() throws IllegalStateException {
        if (applicationContext == null) {
            throw new IllegalStateException("applicaitonContext hasn't been autowired");
        }
    }
}
