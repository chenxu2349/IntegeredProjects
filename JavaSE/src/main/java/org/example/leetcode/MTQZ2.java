package org.example.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class MTQZ2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), k = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);

        int ans = 1;
        while (ans++ > 0) {
            int hasPlant = 0;
            for (int i = 0; i < n - 1; i++) {
                int d = arr[i + 1] - arr[i];
                if (d <= ans) {
                    hasPlant += d;
                } else {
                    hasPlant += ans;
                }
            }
            hasPlant += ans;

            if (hasPlant >= k) {
                System.out.println(ans);
                return;
            }
        }
    }
}
