package org.example.common;

/**
 * @author xuchen22
 */
public class Basic {
    public static void main(String[] args) {

        String s1 = "abc";
        String s2 = new String("abc");
        System.out.println(s1 == s2);

        Integer i1 = 40;
        Integer i2 = new Integer(40);
        System.out.println(i1 == i2);
    }
}
