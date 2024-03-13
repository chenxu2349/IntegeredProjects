package org.example.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class LC1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        for (int i = 0; i < N; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            System.out.println(a + b);
        }
        ArrayList<Integer> list = new ArrayList<>();
        Integer[] array = list.toArray(new Integer[0]);
    }
}
