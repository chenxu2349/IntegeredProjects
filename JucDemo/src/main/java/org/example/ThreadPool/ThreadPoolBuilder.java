package org.example.ThreadPool;

import java.util.concurrent.*;

/**
 * @author xuchen22
 */
public class ThreadPoolBuilder {
    private int corePoolSize;
    private int maxPoolSize;
    private int keepAliveTime;
    private TimeUnit unit;
    private BlockingQueue<Runnable> workQueue;
    private ThreadFactory threadFactory;
    private RejectedExecutionHandler handler;

    // 默认参数设置
    public ThreadPoolBuilder() {
        this.corePoolSize = 4;
        this.maxPoolSize = 9;
        this.keepAliveTime = 60;
        this.unit = TimeUnit.SECONDS;
        this.workQueue = new LinkedBlockingDeque<>();
        this.threadFactory = Executors.defaultThreadFactory();
        this.handler = new ThreadPoolExecutor.AbortPolicy();
    }

    public ThreadPoolBuilder corePoolSize(int corePoolSize) {
        this.corePoolSize = corePoolSize;
        return this;
    }

    public ThreadPoolBuilder maxPoolSize(int maxPoolSize) {
        this.maxPoolSize = maxPoolSize;
        return this;
    }

    public ThreadPoolBuilder keepAliveTime(int keepAliveTime) {
        this.keepAliveTime = keepAliveTime;
        return this;
    }

    public ThreadPoolBuilder unit(TimeUnit unit) {
        this.unit = unit;
        return this;
    }

    public ThreadPoolBuilder workQueue(BlockingQueue<Runnable> workQueue) {
        this.workQueue = workQueue;
        return this;
    }

    public ThreadPoolBuilder threadFactory(ThreadFactory threadFactory) {
        this.threadFactory = threadFactory;
        return this;
    }

    public ThreadPoolBuilder handler(RejectedExecutionHandler handler) {
        this.handler = handler;
        return this;
    }

    public ThreadPoolExecutor build() {
        return new ThreadPoolExecutor(
                corePoolSize,
                maxPoolSize,
                keepAliveTime,
                unit,
                workQueue,
                threadFactory,
                handler);
    }
}
