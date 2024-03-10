package org.example.creationalPatterns.factory;

/**
 * @ClassName PersonFactory
 * @Description 简单工厂模式，将重复的对象创建工作剥离出来放到一个单独的类中
 * @Author chenxu
 * @Date 2023/11/7 10:32
 **/
public class PersonFactory {
    public static Person createPerson(int category) {
        Person person = null;
        if (category == 0) person = new Student("Tom", 18);
        else if (category == 1) person = new Teacher("Alice", 33);
        return person;
    }
}
