import org.example.leetcode.SimpleMessageQueue;
import org.junit.Test;

import javax.annotation.Resource;

public class SimpleMessageQueueTest {

    @Resource
    private SimpleMessageQueue simpleMessageQueue;

    @Test
    public void sendTest() {
        simpleMessageQueue = new SimpleMessageQueue(10);

        Thread t = new Thread(() -> {
            try {
                Thread.sleep(2000);
                simpleMessageQueue.send("hello");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        t.start();

        System.out.println(simpleMessageQueue.receive());
    }
}
