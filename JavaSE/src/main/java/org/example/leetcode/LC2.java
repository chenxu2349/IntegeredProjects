package org.example.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class LC2 {
    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        // 注意 hasNext 和 hasNextLine 的区别
//        int n = in.nextInt();
//        int k = in.nextInt();
//        int[] nums = new int[n];
//        for (int i = 0; i < n; i++) {
//            nums[i] = in.nextInt();
//        }
//
//        Map<Integer, Integer> map = new HashMap<>();
//        int maxLength = 0, sum = 0;
//        for (int i = 0; i < n; i++) {
//            sum += nums[i];
//            if (sum == k * (i + 1)) {
//                maxLength = i + 1;
//            } else if (map.containsKey(sum - k)) {
//                maxLength = Math.max(maxLength, i - map.get(sum - k));
//            }
//
//            if (!map.containsKey(sum)) {
//                map.put(sum, i);
//            }
//        }
//        Arrays.sort(new int[]{1,2,3});
//
//        System.out.println(maxLength == 0 ? -1 : maxLength);

        int[] nums = new int[]{3,2,1};
        int t = minNumberDisappeared(nums);
        String lcs = LCS("1AB2345CD", "12345EF");
    }


    public static int minNumberDisappeared (int[] nums) {
        // write code here
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int k = nums[i];
            if (k <= 0) {
                nums[i] = n + 1;
            }
        }
        for (int i = 0; i < n; i++) {
            int k = nums[i];
            if (k >= 1 && k <= n) {
                nums[k - 1] = -1;
            }
        }
        int ans = -1;
        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) {
                ans = i + 1;
                break;
            }
        }
        return ans < 0 ? (n + 1) : ans;
    }

    public static String LCS (String s1, String s2) {
        // write code here
        int len1 = s1.length();
        int len2 = s2.length();
        int[][] dp = new int[len1][len2];
        for (int i = 0; i < len1; i++) {
            for (int j = 0; j < len2; j++) {
                if (s1.charAt(i) == s2.charAt(j)) {
                    int same = 1;
                    for (int k = 1; (i + k) < len1 && (j + k) < len2; k++) {
                        if (s1.charAt(i + k) == s2.charAt(j + k)) {
                            same++;
                        } else {
                            // dp[i + same][j + same] = same;
                            break;
                        }
                    }
                    dp[i + same][j + same] = same;
                }
            }
        }
        int x = 0, y = 0, maxSame = Integer.MIN_VALUE;
        for (int i = 0; i < len1; i++) {
            for (int j = 0; j < len2; j++) {
                if (dp[i][j] > maxSame) {
                    x = i;
                    y = j;
                    maxSame = dp[i][j];
                }
            }
        }
        return s1.substring(x - maxSame + 1, x + 1);
    }



}

/**
 * 5 2
 * 1 3 2 4 1
 * 1:0
 * 4:1
 * 6:2
 *
 * */