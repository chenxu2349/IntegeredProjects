package org.example.leetcode;

import java.util.Scanner;

public class XHS1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        if (n < 3) {
            System.out.println(0);
            return;
        }

        int[] left = new int[n];
        int[] right = new int[n];

        // 计算每个位置左边最长的递增子序列
        for (int i = 1; i < n; i++) {
            if (arr[i] > arr[i - 1]) {
                left[i] = left[i - 1] + 1;
            }
        }

        // 计算每个位置右边最长的递减子序列
        for (int i = n - 2; i >= 0; i--) {
            if (arr[i] > arr[i + 1]) {
                right[i] = right[i + 1] + 1;
            }
        }

        int maxLength = 0;

        // 找出最长的“山峰数组”
        for (int i = 1; i < n - 1; i++) {
            if (left[i] > 0 && right[i] > 0) { // 必须左右都有山才能算是山峰
                maxLength = Math.max(maxLength, left[i] + right[i] + 1);
            }
        }

        System.out.println(maxLength);
    }
}