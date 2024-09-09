package org.example.leetcode;

import java.util.Arrays;
import java.util.Scanner;

public class PDD2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int MOD = 1000000007;
        while (T-- > 0) {
            int n = sc.nextInt(), k = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
            // sum of array
            long sum = Arrays.stream(arr).sum();
            long subSum = maxSubArraySum(arr);
            if (subSum > 0) {
                while (k-- > 0) {
                    sum += subSum;
                    sum %= MOD;
                    subSum *= 2;
                    subSum %= MOD;
                }
            }

            System.out.println(sum >= 0 ? sum : sum + MOD);
        }
    }

    public static int maxSubArraySum(int[] nums) {
        int len = nums.length;
        if (len == 0) return 0;
        if (len == 1) return nums[0];
        int[] dp = new int[len];
        dp[0] = nums[0];
        int ans = Integer.MIN_VALUE;
        for (int i = 1; i < len; i++) {
            if (dp[i - 1] >= 0) {
                dp[i] = dp[i - 1] + nums[i];
            } else {
                dp[i] = nums[i];
            }
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }
}
