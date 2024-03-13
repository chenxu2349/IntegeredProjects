package org.example.leetcode;

import java.math.BigInteger;
import java.util.Scanner;

public class MT2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), q = sc.nextInt();
        int[] nums = new int[n];
        // make array
        int sum = 0, count0 = 0;
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
            sum += nums[i];
            if (nums[i] == 0) {
                count0++;
            }
        }
        // do query
        for (int i = 0; i < q; i++) {
            int l = sc.nextInt(), r = sc.nextInt();
            System.out.println((sum + count0 * l) + " " + (sum + count0 * r));
        }
    }
}
