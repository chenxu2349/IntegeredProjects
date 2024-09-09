package org.example.leetcode;

import java.util.Map;
import java.util.Scanner;

public class Dewu2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];int[] b = new int[n];
        for (int i = 0; i < n; i++) a[i] = sc.nextInt();
        for (int i = 0; i < n; i++) b[i] = sc.nextInt();
        int[] diff1 = new int[n - 1];int[] diff2 = new int[n - 1];
        for (int i = 1; i < n; i++) {
            diff1[i - 1] = a[i] - a[i - 1];
            diff2[i - 1] = b[i] - b[i - 1];
        }
        int maxGap = 0, index = -1;
        for (int i = 0; i < n - 1; i++) {
            if(diff1[i] != diff2[i]) {
                maxGap = Math.max(maxGap, i - index);
                index = i;
            }
        }
        System.out.println(maxGap);
    }
}
