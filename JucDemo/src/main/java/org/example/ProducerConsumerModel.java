package org.example;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class ProducerConsumerModel {
    public static int baseSleepTime = 1000;
    public static void main(String[] args) {
        // 全局唯一资源
        Resource resource = new Resource();

        // 生产者组
        Producer p1 = new Producer(resource);
        Producer p2 = new Producer(resource);
        Producer p3 = new Producer(resource);

        // 消费者组
        Consumer c1 = new Consumer(resource);
        Consumer c2 = new Consumer(resource);
        Consumer c3 = new Consumer(resource);

        p1.start();
        p2.start();
        p3.start();

        c1.start();
        c2.start();
        c3.start();
    }

    static class Producer extends Thread {
        private Resource resource;

        public Producer(Resource r) {
            this.resource = r;
        }

        public void run () {
            while (true) {
                try {
                    Thread.sleep((long) (baseSleepTime * Math.random()));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    throw new RuntimeException(e);
                }
                resource.add();
            }
        }
    }

    static class Consumer extends Thread {
        private Resource resource;

        public Consumer(Resource r) {
            this.resource = r;
        }

        public void run () {
            while (true) {
                try {
                    Thread.sleep((long) (baseSleepTime * Math.random()));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    throw new RuntimeException(e);
                }
                resource.remove();
            }
        }
    }

    static class Resource {
        private final BlockingQueue<Integer> queue = new LinkedBlockingQueue<>(10);

        public void add() {
            try {
                //超过最大会报错IllegalStateException
//                queue.add(1);
                queue.put(1); //1当做生产和消费的Integer资源，超过最大会阻塞
                System.out.println("生产者" + Thread.currentThread().getName() + "生产一件资源,"
                        + "当前资源池有" + queue.size() + "个资源");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        public void remove() {
            try {
//                queue.remove();//找不到元素会报错NoSuchElementException
                queue.take();//找不到元素会阻塞
                System.out.println("消费者" + Thread.currentThread().getName() + "消耗一件资源,"
                        + "当前资源池有" + queue.size() + "个资源");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
