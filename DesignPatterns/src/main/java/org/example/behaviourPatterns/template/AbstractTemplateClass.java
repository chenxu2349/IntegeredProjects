package org.example.behaviourPatterns.template;

public abstract class AbstractTemplateClass {

    // 模版方法
    public void templateMethod() {
        System.out.println("This is a template method...");
        // ...
        methodA();
        // ...
        methodB();
    }

    protected abstract void methodA();
    protected abstract void methodB();
}
