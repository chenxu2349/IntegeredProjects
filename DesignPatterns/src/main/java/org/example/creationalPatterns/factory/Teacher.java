package org.example.creationalPatterns.factory;

/**
 * @ClassName Teacher
 * @Description
 * @Author chenxu
 * @Date 2023/11/7 10:31
 **/
public class Teacher extends Person{

    private int category = 1;

    public Teacher(String name, int age) {
        super(name, age);
    }
}
