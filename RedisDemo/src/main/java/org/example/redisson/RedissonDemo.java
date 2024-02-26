package org.example.redisson;

import org.redisson.Redisson;
import org.redisson.api.RBucket;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;

public class RedissonDemo {
    public static void main(String[] args) {
        Config config = new Config();
        config.useSingleServer()
                .setAddress("redis://101.35.244.157:6379")
                .setPassword("CX185813");

        RedissonClient redissonClient = null;
        try {
            redissonClient = Redisson.create(config);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // redisson客户端操作
        // 获取一个 String 类型的对象
        RBucket<String> bucket = redissonClient.getBucket("myBucket");
        bucket.set("Hello, Redis!");

        // 获取一个分布式锁
        RLock lock = redissonClient.getLock("myLock");
        lock.lock();
        try {
            // 执行临界区代码
            System.out.println("myBucket value : " + bucket.get());
        } finally {
            lock.unlock();
        }

        redissonClient.shutdown();
    }
}
