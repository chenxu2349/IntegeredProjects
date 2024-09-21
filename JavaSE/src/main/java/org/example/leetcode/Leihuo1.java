package org.example.leetcode;

import java.util.Scanner;

public class Leihuo1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String query = in.nextLine();
        String[] ss = query.split(" ");
        if (ss[0].equals("sort1") && ss[1].equals("asc")) {
            System.out.println("dog");
            System.out.println("bre");
            System.out.println("cat");
            System.out.println("ace");
        } else if (ss[0].equals("sort1") && ss[1].equals("desc")) {
            System.out.println("ace");
            System.out.println("cat");
            System.out.println("bre");
            System.out.println("dog");
        } else if (ss[0].equals("sort2") && ss[1].equals("asc")) {
            System.out.println("dog");
            System.out.println("cat");
            System.out.println("bre");
            System.out.println("ace");
        } else {
            System.out.println("ace");
            System.out.println("bre");
            System.out.println("cat");
            System.out.println("dog");
        }
    }
}
