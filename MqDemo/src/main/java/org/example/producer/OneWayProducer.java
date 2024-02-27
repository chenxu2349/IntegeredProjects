package org.example.producer;

import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.exception.RemotingException;

// 单向发送消息
public class OneWayProducer {

    public static void main(String[] args) throws MQClientException, RemotingException, InterruptedException {

        int messageCount = 10;
        DefaultMQProducer producer = new DefaultMQProducer("pg");
        producer.setNamesrvAddr("101.35.244.157:9876");
        producer.start();
        for (int i = 0; i < messageCount; i++) {
            byte[] body = ("Hi," + i).getBytes();
            Message msg = new Message("OneWayTopic", "oneWay", body);
            // 单向发送
            producer.sendOneway(msg);
        }
        System.out.println("消息发送完毕");
        producer.shutdown();
        System.out.println("producer shutdown");
    }
}


