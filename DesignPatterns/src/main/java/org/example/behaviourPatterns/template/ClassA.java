package org.example.behaviourPatterns.template;

public class ClassA {
    public static void main(String[] args) {
        // 所谓回调，就是A调用B，同时还一个传递包裹函数的对象，留个函数入口，等B回过头来调用自己
        // 简述：A调用B，B还能回过头调用A
        ClassB classB = new ClassB();
        classB.process(new ICallback() {
            @Override
            public void methodToCallback() {
                System.out.println("Call me back...");
            }
        });
    }
}
