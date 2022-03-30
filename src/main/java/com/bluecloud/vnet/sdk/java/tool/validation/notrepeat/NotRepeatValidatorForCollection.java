package com.bluecloud.vnet.sdk.java.tool.validation.notrepeat;

import java.util.Collection;
import java.util.function.Function;

/**
 * @author hexinyu
 * @version 1.0
 * @description
 * @date 2021/08/12
 * @see
 */
@SuppressWarnings("rawtypes")
public class NotRepeatValidatorForCollection extends NotRepeatValidator<Collection>{

    @Override
    protected Function<Collection, Integer> sizeGetter() {
        return Collection::size;
    }

    @Override
    protected Iterable<Object> iterator(Collection value) {
        return value;
    }
}
