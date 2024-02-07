package org.example.ThreadPool.task;

import org.example.ThreadPool.ThreadPoolBuilder;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;

public class Task {
    public static void main(String[] args) {
        ThreadPoolExecutor threadPool = new ThreadPoolBuilder().build();

        // 非lambda形式提交任务
        MyNoReturnTask task = new MyNoReturnTask(100);
        threadPool.execute(task);

        // 无返回结果任务
        threadPool.submit(() -> {
            try {
                // 模拟任务执行
                Thread.sleep(2000);
                System.out.println("No result task has completed...");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        // 有返回结果任务
        Future<Integer> future = threadPool.submit(() -> {
            Thread.sleep(3000);
            return 4399;
        });

        threadPool.shutdown();
        try {
            // 异步回调获取结果，如果任务完成即可输出
            Integer result = future.get();
            System.out.printf("Have return task has completed, result: %d\n", result);
        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
