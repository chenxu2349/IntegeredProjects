package org.example.adaptor;

/**
 * @author xuchen22
 */
public class ASensitiveWordsFilterAdaptor implements ISensitiveWordsFilter{

    private ASensitiveWordsFilter aSensitiveWordsFilter;

    @Override
    public String filter(String text) {
        String maskedText = aSensitiveWordsFilter.politicalWordsFilter(text);
        maskedText = aSensitiveWordsFilter.pornWordsFilter(maskedText);
        return maskedText;
    }
}
