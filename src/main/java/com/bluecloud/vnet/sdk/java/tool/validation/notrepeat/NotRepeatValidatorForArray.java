package com.bluecloud.vnet.sdk.java.tool.validation.notrepeat;

import java.util.function.Function;
import java.util.stream.Stream;

/**
 * @author hexinyu
 * @version 1.0
 * @description
 * @date 2021/08/12
 * @see
 */
@SuppressWarnings("rawtypes")
public class NotRepeatValidatorForArray extends NotRepeatValidator<Object[]>{

    @Override
    protected Function<Object[], Integer> sizeGetter() {
        return array -> array.length;
    }

    @Override
    protected Iterable<Object> iterator(Object[] value) {
        return () -> Stream.of(value).iterator();
    }
}
