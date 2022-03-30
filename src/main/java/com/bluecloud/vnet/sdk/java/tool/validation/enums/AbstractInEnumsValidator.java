package com.bluecloud.vnet.sdk.java.tool.validation.enums;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author chenchen
 * @version 1.0
 * @description 描述
 * @date 2021/8/20
 * @link
 * @see
 */
public abstract class AbstractInEnumsValidator<T> extends AbstractEnumsValidator<InEnums, T> {
    @Override
    protected Set<String> extractEnumsValue() {
        return new HashSet<>(Arrays.asList(annotation.value()));
    }

    @Override
    protected String extractSplitter() {
        return annotation.split();
    }
}
