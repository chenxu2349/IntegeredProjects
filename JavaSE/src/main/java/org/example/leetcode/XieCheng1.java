package org.example.leetcode;

import java.util.Scanner;

public class XieCheng1 {

    public static int N, M;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int q = sc.nextInt();
        while (q-- > 0) {
            int n = sc.nextInt(), m = sc.nextInt(), k = sc.nextInt();
            N = n;
            M = m;
            // n * m
            int x = 0, y = 0;
            long sum = 0;
            while (k-- > 0) {
                int x1 = x, y1 = y, value = 0;
                if (getValue(x, y + 1) > value) {
                    value = getValue(x, y + 1);
                    x1 = x;
                    y1 = y + 1;
                }
                if (getValue(x, y - 1) > value) {
                    value = getValue(x, y - 1);
                    x1 = x;
                    y1 = y - 1;
                }
                if (getValue(x + 1, y) > value) {
                    value = getValue(x + 1, y);
                    x1 = x + 1;
                    y1 = y;
                }
                if (getValue(x - 1, y) > value) {
                    value = getValue(x - 1, y);
                    x1 = x - 1;
                    y1 = y;
                }
                sum += value;
                x = x1;
                y = y1;
            }
            System.out.println(sum);
        }
    }

    public static int getValue(int x, int y) {
        if (x < 0 || x >= N || y < 0 || y >= M) {
            return -1;
        }
        return y + x * M;
    }
}
