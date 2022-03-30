package com.bluecloud.vnet.sdk.java.tool.validation.notrepeat;

/**
 * @author hexinyu
 * @version 1.0
 * @description 候选对象提取器（用于判定是否重复）
 * @date 2021/08/13
 * @see
 */
public interface RepeatCandidateValueExtractor {

    boolean support(Object obj);

    Object extract(Object obj);
}
