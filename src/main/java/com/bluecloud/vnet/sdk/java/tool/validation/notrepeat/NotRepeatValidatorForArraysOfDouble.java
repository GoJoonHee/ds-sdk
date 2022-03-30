package com.bluecloud.vnet.sdk.java.tool.validation.notrepeat;

import java.util.Iterator;
import java.util.function.Function;

/**
 * @author hexinyu
 * @version 1.0
 * @description
 * @date 2021/08/12
 * @see
 */
@SuppressWarnings("rawtypes")
public class NotRepeatValidatorForArraysOfDouble extends NotRepeatValidator<double[]>{

    @Override
    protected Function<double[], Integer> sizeGetter() {
        return array -> array.length;
    }

    @Override
    protected Iterable<Object> iterator(double[] value) {
        return new Iterable<Object>() {

            private int nextIndex = 0;
            private final double[] array = value;

            @Override
            public Iterator<Object> iterator() {
                return new Iterator<Object>() {
                    @Override
                    public boolean hasNext() {
                        return array.length > nextIndex;
                    }

                    @Override
                    public Object next() {
                        return array[nextIndex ++];
                    }
                };
            }
        };
    }
}
