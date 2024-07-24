package org.example.leetcode;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class SimpleMessageQueue<T> {

    private final BlockingQueue<T> queue;

    public SimpleMessageQueue(int capacity) {
        queue = new ArrayBlockingQueue<>(capacity);
    }

    // 发送消息到队列，如果队列已满，则此方法会阻塞直到有空间可用
    public void send(T message) {
        try {
            queue.put(message);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException("Interrupted while sending message", e);
        }
    }

    // 从队列接收消息，如果队列为空，则此方法会阻塞直到有消息可用
    public T receive() {
        try {
            return queue.take();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException("Interrupted while receiving message", e);
        }
    }
}