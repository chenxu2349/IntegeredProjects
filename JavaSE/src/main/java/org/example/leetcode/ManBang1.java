package org.example.leetcode;

import java.util.ArrayList;
import java.util.Scanner;

public class ManBang1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        String color = sc.nextLine();
        long red = 0, black = 0;
        for (int i = 0; i < n; i++) {
            if (color.charAt(i) == 'R') {
                red+=(arr[i]);
            } else {
                black+=(arr[i]);
            }
        }
        int MOD = 1000000007;
        long ans = 0;
        ans += red * black;
        ans %= MOD;
        System.out.println(ans);
    }
}
