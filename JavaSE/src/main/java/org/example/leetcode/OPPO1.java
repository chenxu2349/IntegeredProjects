package org.example.leetcode;

import java.util.Arrays;
import java.util.Scanner;

public class OPPO1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int count = 0;
        long originalSum = Arrays.stream(arr).sum();
        for (int k : arr) {
            int flipK = flip(k);
            if (originalSum - k + flipK > originalSum) {
                count++;
            }
        }
        System.out.println(count);
    }

    private static int flip(int n) {
        String str = Integer.toBinaryString(n);
        String reverseStr = new StringBuilder(str).reverse().toString();
        String newStrNo0 = reverseStr.replaceFirst("^0+(?!$)","");
        return Integer.parseInt(newStrNo0, 2);
    }
}
