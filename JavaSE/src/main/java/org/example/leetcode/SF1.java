package org.example.leetcode;

import java.util.Scanner;

public class SF1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), k = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        // code here
        for (int i = 0; i < n; i++) {
            if (arr[i] <= k) {
                arr[n - 1] += arr[i];
                k -= arr[i];
                arr[i] = 0;
            } else {
                arr[n - 1] += k;
                arr[i] -= k;
                k = 0;
            }
            if (k == 0) {
                break;
            }
        }

        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
