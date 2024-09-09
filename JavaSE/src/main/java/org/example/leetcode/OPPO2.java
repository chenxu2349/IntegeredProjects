package org.example.leetcode;

import java.util.Random;
import java.util.Scanner;

public class OPPO2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        // X是一个大于100到200的随机数
        int X = new Random().nextInt(101) + 100;
        while (T-- > 0) {
            int n = sc.nextInt();
            int[][] A = new int[n][n];
            int[][] B = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    A[i][j] = sc.nextInt();
                }
            }
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    B[i][j] = sc.nextInt();
                }
            }
            int minFlip = minFlip(A, B, n);
            System.out.println(minFlip);
        }
    }

    public static int minFlip(int[][] A, int[][] B, int n) {
        boolean[] rowFlip = new boolean[n];
        boolean[] colFlip = new boolean[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (A[i][j] != B[i][j]) {
                    rowFlip[i] = !rowFlip[i];
                    colFlip[j] = !colFlip[j];
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if ((A[i][j] ^ (rowFlip[i] ? 1 : 0) ^ (colFlip[j] ? 1 : 0)) != B[i][j]) {
                    return -1;
                }
            }
        }

        int rowCount = 0, colCount = 0;
        for (int i = 0; i < n; i++) {
            if (rowFlip[i]) {
                rowCount++;
            }
        }
        for (int i = 0; i < n; i++) {
            if (colFlip[i]) {
                colCount++;
            }
        }

        return rowCount + colCount;
    }

    public static int minFlip2(int[][] A, int[][] B, int n) {
//        int n = A.length;
        int[] rowCountA  = new int[n];
        int[] rowCountB  = new int[n];
        int[] colCountA  = new int[n];
        int[] colCountB  = new int[n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                rowCountA[i] += A[i][j];
                colCountA[i] += A[i][j];
                rowCountB[i] += B[i][j];
                colCountB[i] += B[i][j];
            }
        }

        for (int i = 0; i < n; i++) {
            if (rowCountA[i] != rowCountB[i] || colCountA[i] != colCountB[i]) {
                return -1;
            }
        }

        int minFlip = 0;
        for (int i = 0; i < n; i++) {
            boolean needFlip = false;
            for (int j = 0; j < n; j++) {
                if (A[i][j] != B[i][j]) {
                    needFlip = !needFlip;
                }
            }
            if (needFlip) {
                minFlip++;
            }
        }
        return minFlip;
    }
}
