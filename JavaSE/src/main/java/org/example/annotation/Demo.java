package org.example.annotation;
public class Demo {

    @LogExecutionTime
    public static void fun() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        fun();
    }
}
