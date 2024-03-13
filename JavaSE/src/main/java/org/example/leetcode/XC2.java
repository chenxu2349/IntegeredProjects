package org.example.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @ClassName XC2
 * @Description
 * @Author chenxu
 * @Date 2024/3/13 19:18
 **/
public class XC2 {
    public static Map<Integer, Integer> map = new HashMap<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        int[] copy = new int[n];
        long sum = 0;
        long[] sums = new long[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
            copy[i] = nums[i];
        }
        Arrays.sort(copy);
        for (int i = 0; i < n; i++) {
            map.put(copy[i], i);
            sum += copy[i];
            sums[i] = sum;
        }

        for (int i = 0; i < n; i++) {
            System.out.println(getMinOps(sums, copy, n, nums[i]));
        }
    }

    public static long getMinOps(long[] sums, int[] copy, int n, int ai) {
        int index = map.get(ai);
        long count = 0;

        count += (index + 1) * ai - sums[index];
        count += (sums[n - 1] - sums[index] - (n - 1 - index) * ai);

        return count;
    }

}
