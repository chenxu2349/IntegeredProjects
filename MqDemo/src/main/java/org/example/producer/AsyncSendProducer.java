package org.example.producer;

import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendCallback;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.exception.RemotingException;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;


/**
 * 生产者发送异步消息
 */
public class AsyncSendProducer {

    public static void main(String[] args) throws MQClientException, RemotingException, InterruptedException, MQBrokerException {

        int messageCount = 100;
        // 创建一个producer，参数为生产者组名称
        DefaultMQProducer producer = new DefaultMQProducer("apg");
        // 指定nameServer地址
        producer.setNamesrvAddr("101.35.244.157:9876");
        // 指定异步发送失败后不进行重试发送
        producer.setRetryTimesWhenSendAsyncFailed(0);

        // 指定新创建的Topic的Queue数量为2，默认为4
        producer.setDefaultTopicQueueNums(2);
        // 开启生产者
        producer.start();
        // 生产并发送100条消息
        //由于是异步发送，这里引入一个countDownLatch，保证所有Producer发送消息的回调方法都执行完了再停止Producer服务。
        final CountDownLatch countDownLatch = new CountDownLatch(messageCount);
        for (int i = 0; i < messageCount; i++) {
            try {
                final int index = i;
                byte[] body = ("Hi," + i).getBytes();
                Message msg = new Message("AsyncProductTopic", "AsyncTopic", body);

                producer.send(msg, new SendCallback() {
                    //异步发送的回调
                    @Override
                    public void onSuccess(SendResult sendResult) {
                        countDownLatch.countDown();
                        System.out.printf("%-10d OK %s %n", index, sendResult.getMsgId());
                    }

                    @Override
                    public void onException(Throwable e) {
                        countDownLatch.countDown();
                        System.out.printf("%-10d Exception %s %n", index, e);
                        e.printStackTrace();
                    }
                });
                System.out.println("消息发送完成");
            } catch (Exception e) {
                e.printStackTrace();
            }

        }

        countDownLatch.await(5, TimeUnit.SECONDS);
        // 关闭生产者
        producer.shutdown();

    }
}
