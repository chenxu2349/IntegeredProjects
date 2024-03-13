package org.example.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class LC2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        int n = in.nextInt();
        int k = in.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = in.nextInt();
        }

        Map<Integer, Integer> map = new HashMap<>();
        int maxLength = 0, sum = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            if (sum == k * (i + 1)) {
                maxLength = i + 1;
            } else if (map.containsKey(sum - k)) {
                maxLength = Math.max(maxLength, i - map.get(sum - k));
            }

            if (!map.containsKey(sum)) {
                map.put(sum, i);
            }
        }
        Arrays.sort(new int[]{1,2,3});

        System.out.println(maxLength == 0 ? -1 : maxLength);

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