package org.example.threadpool.task;

import java.util.concurrent.Callable;

public class MyReturnTask implements Callable<String> {
    private int param;

    public MyReturnTask(int param) {
        this.param = param;
    }

    @Override
    public String call() throws Exception {
        Thread.sleep(1500);
        return "Hello World" + param;
    }
}
