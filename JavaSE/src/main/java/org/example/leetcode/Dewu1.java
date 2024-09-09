package org.example.leetcode;

import java.util.Scanner;

public class Dewu1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] arr = str.split(" ");
        String s1 = arr[0];
        String s2 = arr[1];
        int ans = 0;
        for (int i = 0; i < 4; i++) {
            int num1 = s1.charAt(i) - '0', num2 = s2.charAt(i) - '0';
            if (num1 > num2) {
                ans += num1 - num2;
            } else {
                ans += (num1 + 10 - num2);
            }
        }

        System.out.println(ans);
    }
}
