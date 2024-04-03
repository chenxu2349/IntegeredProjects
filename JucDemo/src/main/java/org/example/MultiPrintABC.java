package org.example;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @ClassName MultiPrint
 * @Description
 * @Author chenxu
 * @Date 2024/3/29 13:26
 **/
public class MultiPrintABC {

    public static int Loop = 5;

    public static int loop = Loop;

    public static void main(String[] args) throws InterruptedException {
//        printABC1();
        printABC2();
    }

    public static void printABC1() throws InterruptedException {

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

    public static volatile int lock = 0;
    public static void printABC2() throws InterruptedException {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    if (lock == 0) {
                        System.out.print("A");
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                        lock++;
                        lock %= 3;
                    }

                }
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    if (lock == 1) {
                        System.out.print("B");
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                        lock++;
                        lock %= 3;
                    }

                }
            }
        });
        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    if (lock == 2) {
                        System.out.print("C");
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                        lock++;
                        lock %= 3;
                    }

                }
            }
        });

        t1.start();
//        Thread.sleep(1000);
        t2.start();
//        Thread.sleep(1000);
        t3.start();
    }
}
