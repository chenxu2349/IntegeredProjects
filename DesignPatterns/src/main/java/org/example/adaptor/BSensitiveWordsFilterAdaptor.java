package org.example.adaptor;

/**
 * @author xuchen22
 */
public class BSensitiveWordsFilterAdaptor implements ISensitiveWordsFilter{

    private BSensitiveWordsFilter bSensitiveWordsFilter;

    @Override
    public String filter(String text) {
        String maskedText = bSensitiveWordsFilter.filter(text);
        return maskedText;
    }
}
