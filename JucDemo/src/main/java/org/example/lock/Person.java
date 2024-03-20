package org.example.lock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @ClassName Person
 * @Description
 * @Author chenxu
 * @Date 2024/3/20 16:01
 **/
public class Person {
    private String name;
    private int age;
    private volatile int money;

    private ReentrantLock lock = new ReentrantLock();

    public void fun1() {
        synchronized (this) {
            System.out.println("fun1...");
        }
    }

    public void fun2() {

        lock.lock();
        try {
            System.out.println("fun2...");
        } catch (Exception e) {
            e.printStackTrace();
        }
        lock.unlock();
    }

    public void fun3() {
        this.money++;
    }
}
