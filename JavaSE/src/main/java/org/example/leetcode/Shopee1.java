package org.example.leetcode;

public class Shopee1 {
    public static void main(String[] args) {
        //
        int[] nums = {1,7,4,9,2,5};
        int le = wiggleMaxLength(nums);
    }

    public static int minPathSum(int[][] grid) {
        // write code here
        int m = grid.length, n = grid[0].length;
        int[][] dp = new int[m][n];
        dp[0][0] = grid[0][0];
        for (int i = 1; i < m; i++) {
            dp[i][0] = grid[i][0] + dp[i - 1][0];
        }
        for (int j = 1; j < n; j++) {
            dp[0][j] = grid[0][j] + dp[0][j - 1];
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }
        return dp[m - 1][n - 1];
    }

    public static int wiggleMaxLength(int[] nums) {
        // nums: [1,7,4,9,2,5]
        // diff: [6,-3,5,-7,3]
        // dp: [0,1,2, 3,
        int len = nums.length;
        int[] diff = new int[len - 1];
        for (int i = 0; i < len - 1; i++) {
            diff[i] = nums[i + 1] - nums[i];
        }
//        int[] dp = new int[len];
//        dp[0] = 0;
//        dp[1] = 1;
//        int ans = 0;
//        for (int i = 2; i < len; i++) {
//            if (diff[i - 1] == 0) {
//                dp[i] = Math.max(dp[i - 1], dp[i - 2]);
//            } else {
//                for (int j = i - 2; j >= 0; j--) {
//                    if (diff[j] * diff[i - 1] < 0) {
//                        dp[i] = dp[j + 1] + 1;
//                    }
//                }
//            }
//            ans = Math.max(ans, dp[i]);
//        }
        int firstPositive = -1, firstNegative = -1;
        for (int i = 0; i < len - 1; i++) {
            if (diff[i] > 0) {
                firstPositive = i;
                break;
            }
        }
        for (int i = 0; i < len - 1; i++) {
            if (diff[i] < 0) {
                firstNegative = i;
                break;
            }
        }
        if (firstNegative == -1 || firstPositive == -1) {
            return len == 1 ? 1 : 2;
        }
        int len1 = 1, len2 = 1;
        int pos = firstPositive, neg = firstNegative;
        for (int i = pos + 1; i < len - 1; i++) {
            if (diff[i] * diff[pos] < 0) {
                len1++;
                pos = i;
            }
        }
        for (int i = neg + 1; i < len - 1; i++) {
            if (diff[i] * diff[neg] < 0) {
                len2++;
                neg = i;
            }
        }

        return Math.max(len1 + 1, len2 + 1);
    }
}
