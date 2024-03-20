package org.example.threadlocal;

import java.util.HashMap;
import java.util.Map;

/**
 * @author xuchen22
 */
public class ThreadLocalDemo {

    // 每个线程中可以有多个ThreadLocal变量，由ThreadLocalMap维护

    // 创建一个 ThreadLocal 变量
    private static ThreadLocal<String> threadLocal = new ThreadLocal<>();
    private static ThreadLocal<Integer> threadLocal2 = new ThreadLocal<>();

    public static void main(String[] args) {
        // 创建并启动两个线程
        Thread thread1 = new Thread(() -> {
            // 在线程1中设置 ThreadLocal 的值为 "Thread 1"
            threadLocal.set("Thread 1");
            // 打印当前线程的 ThreadLocal 值
            System.out.println("Thread 1 - ThreadLocal value: " + threadLocal.get());
            // 确保线程1结束时清除 ThreadLocal 值
            threadLocal.remove();
        });

        Thread thread2 = new Thread(() -> {
            // 在线程2中设置 ThreadLocal 的值为 "Thread 2"
            threadLocal.set("Thread 2");
            // 打印当前线程的 ThreadLocal 值
            System.out.println("Thread 2 - ThreadLocal value: " + threadLocal.get());
            // 确保线程2结束时清除 ThreadLocal 值
            threadLocal.remove();
        });

        // 启动线程1和线程2
        thread1.start();
        thread2.start();

        threadLocal2.set(100);
        System.out.println(threadLocal2.get());
        // 使用完之后及时清除，防止内存泄漏（key为弱引用）
        threadLocal2.remove();

        Map<Integer, Integer> map = new HashMap<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet())

        try {
            // 等待线程1和线程2执行完毕
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
