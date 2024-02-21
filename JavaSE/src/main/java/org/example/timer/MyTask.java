package org.example.timer;

import java.util.TimerTask;

public class MyTask extends TimerTask {
    @Override
    public void run() {
        System.out.println("定时任务执行完成...");
    }
}
