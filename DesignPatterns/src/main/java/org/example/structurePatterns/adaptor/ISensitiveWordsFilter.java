package org.example.structurePatterns.adaptor;

/**
 * @author xuchen22
 */
public interface ISensitiveWordsFilter {

    /**
     * 统一接口定义
     * @Param: 需要过滤的内容
     * @Return: 过滤后的内容
     * */
    String filter(String text);
}
