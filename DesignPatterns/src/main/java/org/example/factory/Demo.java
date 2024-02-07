package org.example.factory;

/**
 * @ClassName Main
 * @Description
 * @Author chenxu
 * @Date 2023/11/7 10:36
 **/
public class Demo {
    public static void main(String[] args) {
        int category = 1;
        Person p = PersonFactory.createPerson(category);
        if (p == null) {
            System.out.println("category is not supported!");
            return;
        }
        System.out.println(p.getName() + ";" + p.getAge());
    }
}
