package org.example.structurePatterns.adaptor;

/**
 * @author xuchen22
 */
public class Demo {
    public static void main(String[] args) {

        ISensitiveWordsFilter aSensitiveWordsFilterAdaptor = new ASensitiveWordsFilterAdaptor();
        ISensitiveWordsFilter bSensitiveWordsFilterAdaptor = new BSensitiveWordsFilterAdaptor();
        ISensitiveWordsFilter cSensitiveWordsFilterAdaptor = new CSensitiveWordsFilterAdaptor();
        RiskManagement riskManagement = new RiskManagement();

        riskManagement.addFilter(aSensitiveWordsFilterAdaptor);
        riskManagement.addFilter(bSensitiveWordsFilterAdaptor);
        riskManagement.addFilter(cSensitiveWordsFilterAdaptor);

        String originalText = "U Stupid Motherfxxker!!!";
        String maskedText = riskManagement.filterSensitiveWords(originalText);
        System.out.println(maskedText);
    }
}
