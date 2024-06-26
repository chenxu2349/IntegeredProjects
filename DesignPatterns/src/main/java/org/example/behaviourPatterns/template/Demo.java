package org.example.behaviourPatterns.template;

public class Demo {
    public static void main(String[] args) {
        AbstractTemplateClass demo = new ConcreteClass1();
        demo.templateMethod();
    }
}
