package org.example;

public class Deadlock {

    private static Object resource1 = new Object();
    private static Object resource2 = new Object();

    public static void main(String[] args) {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                // 获取到资源1后先睡眠1秒，再去获取资源2
                synchronized (resource1) {
                    System.out.println(Thread.currentThread() + " has locked resource1...");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (resource2) {
                        System.out.println(Thread.currentThread() + " has locked resource2...");
                    }
                }
            }
        }, "thread-1");
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (resource2) {
                    System.out.println(Thread.currentThread() + " has locked resource2...");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (resource1) {
                        System.out.println(Thread.currentThread() + " has locked resource1...");
                    }
                }
            }
        }, "thread-2");
        t1.start();
        t2.start();
    }
}
