package org.example.behaviourPatterns.template;

public class ClassB {
    public void process(ICallback callback) {
        System.out.println("ClassB process 1...");
        System.out.println("ClassB process 2...");
        // 回调
        callback.methodToCallback();
        System.out.println("ClassB process 3...");
    }
}
