package org.example.leetcode;

import java.util.Scanner;

public class Honor2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt();
        int[] nums = new int[M];
        int sum = 0;
        for (int i = 0; i < M; i++) {
            nums[i] = sc.nextInt();
            sum += nums[i];
        }
        int target = sum / 2;
        boolean[] dp = new boolean[target + 1];
        dp[0] = true;
        for (int k : nums) {
            for (int i = target; i >= k; i--) {
                dp[i] = dp[i] || dp[i - k];
            }
        }
        int best = 0;
        for (int i = target; i >= 0; i--) {
            if (dp[i]) {
                best = i;
                break;
            }
        }
        System.out.println(Math.max(best, sum - best));
    }
}
