package org.example;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @ClassName MultiPrint
 * @Description
 * @Author chenxu
 * @Date 2024/3/29 13:26
 **/
public class MultiPrint {

    public static int Loop = 5;

    public static int loop = Loop;

    public static void main(String[] args) throws InterruptedException {
        printABC();
    }

    public static void printABC() throws InterruptedException {

        ReentrantLock basicLock = new ReentrantLock();
        Thread t1 = new Thread(() -> {
            while (true) {
                basicLock.lock();
                System.out.print("A");
                loop--;

                basicLock.unlock();

                try {
                    if (loop <= 0) break;
                    Thread.sleep(3000);

                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        Thread t2 = new Thread(() -> {
            while (true) {
                basicLock.lock();
                System.out.print("B");
//                loop--;

                basicLock.unlock();
                try {
                    if (loop <= 0) break;
                    Thread.sleep(3000);

                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        Thread t3 = new Thread(() -> {
            while (true) {
                basicLock.lock();
                System.out.print("C");
//                loop--;

                basicLock.unlock();
                try {
                    if (loop <= 0) break;
                    Thread.sleep(3000);

                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        t1.start();
        Thread.sleep(1000);
        t2.start();
        Thread.sleep(1000);
        t3.start();

        t1.join();
        t2.join();
        t3.join();

    }
}
