package org.example.leetcode;

import java.util.Scanner;

public class Didi1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            // n, m <= 1000000000
            int n = sc.nextInt(), m = sc.nextInt();
            System.out.print(maxBeauty(n, m) + " ");
        }
    }

    public static int maxBeauty(int n, int m) {
        if (n == 1) {
            return 0;
        }
        if (n == 2) {
            return m;
        }
        return 2 * m;
    }
}
