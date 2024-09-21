package org.example.leetcode;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class ManBang2 {

    public static boolean isLuckyNumber(int n) {
        while (n >= 10) {
            int nextNum = 0;
            String numStr = Integer.toString(n);
            for (int i = 0; i < numStr.length() - 1; i++) {
                nextNum = nextNum * 10 + Math.abs(numStr.charAt(i) - numStr.charAt(i + 1));
            }
            n = nextNum;
        }
        return n == 7;
    }

    public static void main(String[] args) {
        boolean[] ans = new boolean[1000000000];
        for (int i = 1; i <= 10000000; i++) {
            if (isLuckyNumber(i)) {
                System.out.printf("set.add(%d);\n", i);
            }
        }
        System.out.println(1);
    }
}