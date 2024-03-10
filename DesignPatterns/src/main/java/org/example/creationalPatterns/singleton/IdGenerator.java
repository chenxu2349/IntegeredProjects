package org.example.creationalPatterns.singleton;

import java.util.concurrent.atomic.AtomicLong;

/**
 * @ClassName IdGenerator
 * @Description 单例模式ID生成器
 * @Author chenxu
 * @Date 2023/11/7 10:02
 **/
public class IdGenerator {

    private AtomicLong id = new AtomicLong(0);
    private static final IdGenerator instance = new IdGenerator();

    private IdGenerator() {}

    public static IdGenerator getInstance() {
        return instance;
    }

    public long getId() {
        return id.incrementAndGet();
    }
}
