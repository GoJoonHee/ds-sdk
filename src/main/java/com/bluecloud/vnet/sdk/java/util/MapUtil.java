package com.bluecloud.vnet.sdk.java.util;

import java.util.Map;
import java.util.Objects;

/**
 * @author chenchen
 * @version 1.0
 * @description 描述
 * @date 6/1/2021
 * @link
 * @see
 */
public final class MapUtil {

    private MapUtil(){}

    /**
     * @param map1 前者
     * @param map2 后者
     * @return 包含返回true，不包含返回false
     * @throws
     * @author chenchen
     * @description 比较两个Map，前者是否完全包含后者。
     * @description 包含指的是，后者map的每一个Key在前者map里都有，而且对应的value的equals()也要完全取值相同。
     * @description 被比较的对象，没overRide equals方法的话，比较的就是对象的内存地址，要求内存地址相同。
     * @description 被比较的对象，如果overRide了equals方法的话，比较内容要看equals方法的实现。
     * @description 为的就是降低比较value的标准的严格性，不是非要内存地址一样才叫value相等。只要equals就算相等。
     * @date 2021/6/1
     * @todo
     */
    public static boolean contain(Map<?, ?> map1, Map<?, ?> map2) {
        for( Map.Entry<?, ?> entry : map2.entrySet()) {
            Object key2 = entry.getKey();
            if (!map1.containsKey(key2)) {
                return false;
            }
            Object value1 = map1.get(key2);
            Object value2 = entry.getValue();
            if(!Objects.equals(value1, value2)){
                return false;
            }
        }
        return true;
    }
}
