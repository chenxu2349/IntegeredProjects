package org.example.leetcode;

import java.util.HashMap;
import java.util.Map;

public class LC6 {
    public static void main(String[] args) {
        int[][] q = new int[][]{{2, 4}, {0, 2}, {0, 4}};
        int[] ints = shortestDistanceAfterQueries(5, q);
        lengthOfLongestSubstring("tmmzuxt");
    }

    public static int[] shortestDistanceAfterQueries(int n, int[][] queries) {
        int len = queries.length;
        int[] ans = new int[len];
        // 到达i号节点的最小跳数
        int[] dp = new int[n];

        for (int i = 0; i < len; i++) dp[i] = i;
        for (int i = 0; i < len; i++) {
            // 更新这座新桥
            int from = queries[i][0], to = queries[i][1];
            dp[to] = Math.min(dp[to - 1] + 1, dp[from] + 1);

            // 每建一座新桥，连锁更新后面的
            for (int j = 0; j <= i; j++) {
                int from1 = queries[j][0], to1 = queries[j][1];
                if (from1 >= to) {
                    dp[to1] = Math.min(dp[to1 - 1] + 1, dp[from1] + 1);
                }
            }

            ans[i] = dp[n - 1];
        }

        return ans;
    }

    public static int lengthOfLongestSubstring(String s) {
        int len = s.length();
        int L = 0, R = 0, maxSubLen = 0;
        Map<Character, Integer> map = new HashMap<>();
        while (R < len) {
            char c = s.charAt(R);
            if (map.getOrDefault(c, 0) == 0) {
                map.put(c, 1);
            } else {
                while (L < R) {
                    if (s.charAt(L) == c) {
                        break;
                    }
                    map.put(s.charAt(L), map.get(s.charAt(L)) - 1);
                    L++;
                }
                L++;
            }
            maxSubLen = Math.max(maxSubLen, R - L + 1);
            R++;
        }

        return maxSubLen;
    }
}
