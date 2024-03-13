package org.example.leetcode;

import java.util.Scanner;

public class MT3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        int[][] nums = new int[n][n];
        for (int i = 0; i < n; i++) {
            String str = sc.nextLine();
            for (int j = 0; j < n; j++) {
                if (str.charAt(j) == '0') {
                    nums[i][j] = 0;
                } else {
                    nums[i][j] = 1;
                }
            }
        }

        int[] count = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                // length
                for (int l = 1; l <= Math.min(n - 1 - i, n - 1 - j); l++) {
                    int t = count1(nums, i, j, l);
                    if (t == ((l+1)*(l+1) - t)) count[l] += 1;
                }
            }
        }

        for (int i = 0; i < n; i++) System.out.println(count[i]);
    }

    public static int count1(int[][] nums, int x, int y, int l) {
        int count1 = 0;
        for (int i = x; i <= x + l; i++) {
            for (int j = y; j <= y + l; j++) {
                if (nums[i][j] == 1) count1++;
            }
        }
        return count1;
    }
}
