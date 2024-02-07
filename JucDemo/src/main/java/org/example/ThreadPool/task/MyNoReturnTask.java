package org.example.ThreadPool.task;

public class MyNoReturnTask implements Runnable{
    private int param;

    public MyNoReturnTask(int param) {
        this.param = param;
    }

    @Override
    public void run() {
        System.out.println("No return task is running..." + param);
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            new NullPointerException("haha");
            e.printStackTrace();
        }
    }
}
