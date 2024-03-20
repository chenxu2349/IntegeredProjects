package org.example.leetcode;

import org.example.enums.Demo;

/**
 * @ClassName YZ4
 * @Description
 * @Author chenxu
 * @Date 2024/3/19 16:46
 **/
public class YZ4 {
    class Super {

        int flag = 1;

        Super() {
            test();
        }

        void test() {
            System.out.println("Super.test() flag=" + flag);
        }
    }
    class Sub extends Super {

        Sub(int i) {
            flag = i;
            System.out.println("Sub.Sub()flag=" + flag);
        }
        void test() {
            System.out.println("Sub.test()flag=" + flag);
        }
    }
    public static void main(String[] args) {
        new Demo().new Sub(5);
    }
}