package org.example.creationalPatterns.singleton;

/**
 * @ClassName Main
 * @Description
 * @Author chenxu
 * @Date 2023/11/7 10:02
 **/
public class Demo {
    public static void main(String[] args) {
        System.out.println(IdGenerator.getInstance().getId());
        System.out.println(IdGenerator.getInstance().getId());
        System.out.println(IdGenerator.getInstance().getId());

    }
}
