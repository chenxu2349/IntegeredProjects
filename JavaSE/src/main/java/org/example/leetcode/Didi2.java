package org.example.leetcode;

import java.util.Scanner;

public class Didi2 {
    public static int[][] arr;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), k = sc.nextInt();
        arr = new int[k][k];
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < k; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        sc.nextLine();
        String str = sc.nextLine();

        System.out.println(maxCount(str));
    }

    public static String deleteString(String str, int index) {
        int len = str.length();
        if (len == 2) {
            return "";
        }
        // length >= 4
        return str.substring(0, index) + str.substring(index + 2, len);
    }

    public static int maxCount(String str) {
        int len = str.length();
        if (len == 2) {
            return arr[str.charAt(0) - 'a'][str.charAt(1) - 'a'];
        }
        int maxSum = 0;
        for (int i = 0; i < len - 1; i++) {
            int cost = arr[str.charAt(i) - 'a'][str.charAt(i + 1) - 'a'] + maxCount(deleteString(str, i));
            maxSum = Math.max(maxSum, cost);
        }
        return maxSum;
    }
}
