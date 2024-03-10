package org.example.structurePatterns.adaptor;

/**
 * @author xuchen22
 */
public class CSensitiveWordsFilterAdaptor implements ISensitiveWordsFilter{

    private CSensitiveWordsFilter cSensitiveWordsFilter;

    @Override
    public String filter(String text) {
        String maskedText = cSensitiveWordsFilter.filter(text, "***");
        return maskedText;
    }
}
