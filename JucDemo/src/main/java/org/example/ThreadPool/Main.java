package org.example.ThreadPool;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author xuchen22
 */
public class Main {
    public static void main(String[] args) {
        ThreadPoolExecutor threadPool = new ThreadPoolBuilder()
                .corePoolSize(2)
                .maxPoolSize(5)
                .keepAliveTime(60)
                .unit(TimeUnit.SECONDS)
                .workQueue(new LinkedBlockingDeque<>(1000))
                .threadFactory(new NamedThreadFactory("MyThreadPool"))
                .handler(new ThreadPoolExecutor.AbortPolicy())
                .build();

        for (int i = 0; i < 15; i++) {
            threadPool.submit(() -> {
                ThreadPoolUtil.printStatus(threadPool, "Task");
                try {
                    TimeUnit.SECONDS.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }

        // 这是一个动态修改线程池参数的案例
        ThreadPoolUtil.printStatus(threadPool, "改变前");
        threadPool.setCorePoolSize(5);
        threadPool.setMaximumPoolSize(11);
        ThreadPoolUtil.printStatus(threadPool, "改变后");

        threadPool.shutdown();
    }
}
