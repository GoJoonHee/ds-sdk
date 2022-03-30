package com.bluecloud.vnet.sdk.java.tool.validation.notrepeat;

import java.util.Set;

/**
 * @author hexinyu
 * @version 1.0
 * @description 是否重复的判别器
 * @date 2021/08/13
 * @see
 */
public class DefaultRepeatPredicate implements RepeatPredicate{

    @Override
    public boolean judge(Set<Object> compareSet, Object currentObj) {
        return compareSet.contains(currentObj);
    }
}
