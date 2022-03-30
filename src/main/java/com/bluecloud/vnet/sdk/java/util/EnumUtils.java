package com.bluecloud.vnet.sdk.java.util;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * @author hexinyu
 * @version 1.0
 * @description 反射初始化枚举类
 * @date 2021/07/12
 * @see
 */
public final class EnumUtils {

    private EnumUtils(){}

    private static final Map<Item<? extends Enum<?>, ?>, Map<?, ? extends Enum<?>>> CACHE_MAP = new HashMap<>();

    /**
     * 通过给定value和匹配函数，去初始化枚举类实例 <br />
     * 执行<u>匹配函数（compareFun）</u>，用该函数的<u>返回值</u>去等值匹配<u>目标值（compareVal）</u>，
     * 相等则返回枚举类实例，否则，返回提供的<u>默认枚举值（defaultEnum）</u>
     *
     * @param enumClass 需要初始化的枚举类的class
     * @param compareFun    匹配函数
     * @param compareVal         给定的值，用于与匹配
     * @param defaultEnum   默认枚举值
     * @param <T>           枚举类型
     * @param <V>           初始值类型
     * @return 一个枚举值
     */
    public static <T extends Enum<T>, V> T initEnumBy(Class<T> enumClass, Function<T, V> compareFun, V compareVal, Supplier<T> defaultEnum) {
        return Optional.ofNullable(initEnum(enumClass, compareFun, compareVal)).orElseGet(defaultEnum);
    }

    public static <T extends Enum<T>, V> T initEnum(Class<T> enumClass, Function<T, V> compareFun, V compareVal) {
        EnumUtils.Item<T, V> item = EnumUtils.Item.instance( enumClass, compareFun);
        //首先从缓存中获取
        Map<?, ? extends Enum<?>> enumMap = CACHE_MAP.get(item);
        if(enumMap != null){
            return (T) enumMap.get(compareVal);
        }
        //未命中则建立枚举缓存Map
        HashMap<V, T> newEnumMap = new HashMap<>();
        for (T enumConstant : enumClass.getEnumConstants()) {
            newEnumMap.put(compareFun.apply(enumConstant), enumConstant);
        }
        CACHE_MAP.put(item, newEnumMap);
        return newEnumMap.get(compareVal);
    }

    public static <T extends Enum<T>, V> T initEnum(Class<T> enumClazz, Function<T, V> compareEnumVal, V compareVal, T defaultEnum) {
        return initEnumBy(enumClazz, compareEnumVal, compareVal, () -> defaultEnum);
    }

    public static <T extends Enum<T>, V> T initEnum(Class<T> enumClazz, Function<T, V> compareEnumVal, V compareVal, int defaultIndex) {
        T[] enumConstants = enumClazz.getEnumConstants();
        return initEnumBy(enumClazz, compareEnumVal, compareVal, () -> enumConstants[defaultIndex % enumConstants.length]);
    }

    public static <T extends Enum<T>, V> T initEnumDefaultFirst(Class<T> enumClazz, Function<T, V> compareEnumVal, V compareVal) {
        T[] enumConstants = enumClazz.getEnumConstants();
        return initEnumBy(enumClazz, compareEnumVal, compareVal, () -> enumConstants[0]);
    }

    public static <E extends Enum<?>> E valueOf(Class<E> enumClass, Object value, Method method) {
        E[] es = enumClass.getEnumConstants();
        for (E e : es) {
            Object evalue;
            try {
                method.setAccessible(true);
                evalue = method.invoke(e);
            } catch (IllegalAccessException | InvocationTargetException e1) {
                throw new RuntimeException(String.format("Error: NoSuchMethod in %s.  Cause:", enumClass.getName()), e1);
            }
            if (value instanceof Number && evalue instanceof Number
                    && new BigDecimal(String.valueOf(value)).compareTo(new BigDecimal(String.valueOf(evalue))) == 0) {
                return e;
            }
            if (Objects.equals(evalue, value) || evalue.toString().equals(value.toString())) {
                return e;
            }
        }
        return null;
    }

    public static class Item<T extends Enum<T>, V>{

        private Class<T> enumClass;

        private Function<T, V> valueFun;

        public static <T extends Enum<T>, V> EnumUtils.Item<T, V> instance(Class<T> enumClass, Function<T, V> valueFun) {
            return new EnumUtils.Item<T, V>().setEnumClass(enumClass).setValueFun(valueFun);
        }

        public Class<T> getEnumClass() {
            return enumClass;
        }

        public Function<T, V> getValueFun() {
            return valueFun;
        }

        public EnumUtils.Item<T, V> setEnumClass(Class<T> enumClass) {
            this.enumClass = enumClass;
            return this;
        }

        public EnumUtils.Item<T, V> setValueFun(Function<T, V> valueFun) {
            this.valueFun = valueFun;
            return this;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (!(o instanceof EnumUtils.Item)) {
                return false;
            }
            EnumUtils.Item<?, ?> item = (EnumUtils.Item<?, ?>) o;
            return Objects.equals(getEnumClass(), item.getEnumClass()) && Objects.equals(getValueFun(), item.getValueFun());
        }

        @Override
        public int hashCode() {
            return Objects.hash(getEnumClass(), getValueFun());
        }
    }
}
