package org.example.behaviourPatterns.template;

public class ConcreteClass2 extends AbstractTemplateClass{
    @Override
    protected void methodA() {
        System.out.println("A2...");
    }

    @Override
    protected void methodB() {
        System.out.println("B2...");
    }
}
