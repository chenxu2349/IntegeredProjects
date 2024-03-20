package org.example.threadpool;

import java.util.concurrent.ThreadFactory;

/**
 * @author xuchen22
 * 给这组线程加上统一的名字，这样不同的线程池才能区分开，排查日志时才有意义
 */
public class NamedThreadFactory implements ThreadFactory {
    private final String namePrefix;

    public NamedThreadFactory(String namePrefix) {
        this.namePrefix = namePrefix;
    }

    @Override
    public Thread newThread(Runnable r) {
        Thread t = new Thread(r);
        t.setName(namePrefix + "-" + t.getId());
        return t;
    }
}
