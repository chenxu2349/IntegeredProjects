package org.example;

/**
 * @author xuchen22
 */
public class LockedSingleton {
    private volatile static LockedSingleton uniqueInstance;

    private LockedSingleton() {
    }

    public static LockedSingleton getUniqueInstance() {
        //先判断对象是否已经实例过，没有实例化过才进入加锁代码
        if (uniqueInstance == null) {
            //类对象加锁
            synchronized (LockedSingleton.class) {
                if (uniqueInstance == null) {
                    uniqueInstance = new LockedSingleton();
                }
            }
        }
        return uniqueInstance;
    }

}
