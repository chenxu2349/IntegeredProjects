package org.example.atomic;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author xuchen22
 */
public class Increment {
    public volatile static int inc = 0;

    // 存在问题：volatile只保证可见性，不保证原子性
    public void increase() {
        inc++;
    }

//    // 改进1
//    public synchronized void increase() {
//        inc++;
//    }
//
//    // 改进2
//    public AtomicInteger inc1 = new AtomicInteger();
//    public void increase() {
//        inc1.getAndIncrement();
//    }
//
//    // 改进3
//    Lock lock = new ReentrantLock();
//    public void increase() {
//        lock.lock();
//        try {
//            inc++;
//        } finally {
//            lock.unlock();
//        }
//    }

    public static void main(String[] args) throws InterruptedException {
        ExecutorService threadPool = Executors.newFixedThreadPool(5);
        Increment volatileAtomicityDemo = new Increment();
        for (int i = 0; i < 5; i++) {
            threadPool.execute(() -> {
                for (int j = 0; j < 500; j++) {
                    volatileAtomicityDemo.increase();
                }
            });
        }
        // 等待1.5秒，保证上面程序执行完成
        Thread.sleep(1500);
        System.out.println(inc);
        threadPool.shutdown();
    }
}

