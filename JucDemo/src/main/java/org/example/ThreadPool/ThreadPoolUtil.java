package org.example.ThreadPool;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;

public class ThreadPoolUtil {
    public static void printStatus(ThreadPoolExecutor executor, String name) {
        BlockingQueue<Runnable> queue = executor.getQueue();
        System.out.println(Thread.currentThread().getName() + "-" + name + "-" +
                " 核心线程数:" + executor.getCorePoolSize() +
                " 活动线程数:" + executor.getActiveCount() +
                " 最大线程数:" + executor.getMaximumPoolSize() +
                " 线程池活跃度:" + divide(executor.getActiveCount(), executor.getMaximumPoolSize()) +
                " 任务完成数:" + executor.getCompletedTaskCount() +
                " 队列大小:" + (queue.size() + queue.remainingCapacity()) +
                " 当前排队线程数:" + queue.size() +
                " 队列剩余大小:" + queue.remainingCapacity() +
                " 队列使用占比:" + divide(queue.size(), queue.size() + queue.remainingCapacity())
                );
    }

    /**
     * 保留两位小数
     * */
    private static String divide(int a, int b) {
        double divideResult = Double.parseDouble(a + "") / Double.parseDouble(b + "");
        return String.format("%1.2f%%", divideResult * 100);
    }
}
