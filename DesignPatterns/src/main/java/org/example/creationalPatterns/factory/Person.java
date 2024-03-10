package org.example.creationalPatterns.factory;

/**
 * @ClassName Person
 * @Description
 * @Author chenxu
 * @Date 2023/11/7 10:28
 **/
public class Person {

    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }
}
