package org.example.timer;

import java.util.Timer;
import java.util.TimerTask;

public class TimerDemo {
    public static void main(String[] args) {
        Timer timer = new Timer();
        TimerTask task = new MyTask();
        // 延迟5秒执行
        long delay = 5000;
        // 每隔2秒执行一次
        long period = 2000;
        timer.schedule(task, delay, period);
    }
}
