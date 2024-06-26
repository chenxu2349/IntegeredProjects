package org.example.behaviourPatterns.template;

public class ConcreteClass1 extends AbstractTemplateClass{

    @Override
    protected void methodA() {
        System.out.println("A1...");
    }

    @Override
    protected void methodB() {
        System.out.println("B1...");
    }

}
