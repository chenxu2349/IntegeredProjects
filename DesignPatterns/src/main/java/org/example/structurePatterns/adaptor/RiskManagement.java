package org.example.structurePatterns.adaptor;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xuchen22
 */
public class RiskManagement {

    private List<ISensitiveWordsFilter> filters = new ArrayList<>();

    public void addFilter(ISensitiveWordsFilter filter) {
        filters.add(filter);
    }

    public String filterSensitiveWords(String text) {
        String maskedText = text;

        for (ISensitiveWordsFilter filter : filters) {
            maskedText = filter.filter(maskedText);
        }

        return maskedText;
    }
}
