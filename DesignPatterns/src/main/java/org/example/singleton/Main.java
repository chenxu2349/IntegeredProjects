package org.example.singleton;

/**
 * @ClassName Main
 * @Description
 * @Author chenxu
 * @Date 2023/11/7 10:02
 **/
public class Main {
    public static void main(String[] args) {
        System.out.println(IdGenerator.getInstance().getId());
        System.out.println(IdGenerator.getInstance().getId());
        System.out.println(IdGenerator.getInstance().getId());

    }
}
