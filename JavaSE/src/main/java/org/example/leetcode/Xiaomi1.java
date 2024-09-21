package org.example.leetcode;

import java.util.Arrays;
import java.util.Scanner;

public class Xiaomi1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int N = sc.nextInt(), n = sc.nextInt(), c = sc.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }
            // 只用填充物
            if (c >= N) {
                System.out.println("YES");
                continue;
            }
            Arrays.sort(a);
            int[][] dp = new int[n][2];
            dp[n - 1][0] = N;
            dp[n - 1][1] = (N >= a[n - 1] ? N - a[n - 1] : N);
            for (int i = n - 2; i >= 0; i--) {
                dp[i][0] = Math.min(dp[i + 1][0], dp[i + 1][1]);
                if (dp[i + 1][1] >= a[i]) {
                    dp[i][1] = dp[i + 1][1] - a[i];
                } else if (dp[i + 1][0] >= a[i]) {
                    dp[i][1] = dp[i + 1][0] - a[i];
                } else {
                    dp[i][1] = dp[i][0];
                }
            }
            if (c >= Math.min(dp[0][0], dp[0][1])) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}
