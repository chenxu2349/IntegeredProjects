package org.example.creationalPatterns.factory;

/**
 * @ClassName Student
 * @Description
 * @Author chenxu
 * @Date 2023/11/7 10:29
 **/
public class Student extends Person{

    private int category = 0;

    public Student(String name, int age) {
        super(name, age);
    }
}
