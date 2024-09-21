package org.example.leetcode;

import java.util.Scanner;

public class Honor3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str1 = sc.nextLine();
        String str2 = sc.nextLine();
        String str3 = sc.nextLine();
        String str4 = sc.nextLine();
        String[] s1 = str1.split(",");
        String[] s2 = str2.split(",");
        String[] s3 = str3.split(",");
        String[] s4 = str4.split(",");
        int n = s1.length;
        int[] len = new int[n];
        int[] crowded = new int[n];
        int[] signals = new int[n];
        int[] score = new int[n];
        int[] time = new int[n];
        int minTime = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            len[i] = Integer.parseInt(s1[i]);
            crowded[i] = Integer.parseInt(s2[i]);
            signals[i] = Integer.parseInt(s3[i]) ;
            score[i] = Integer.parseInt(s4[i]);
            time[i] = (len[i] - crowded[i]) / 10 + crowded[i] / 2 + signals[i] * 15 / 2;
            minTime = Math.min(minTime, time[i]);
        }

        int ansIndex = 0, ansTime = 0, ansScore = 0;
        for (int i = 0; i < n; i++) {
            if (time[i] >= minTime && time[i] < minTime + 60) {
                if (score[i] > ansScore) {
                    ansIndex = i + 1;
                    ansTime = time[i];
                    ansScore = score[i];
                }
            }
        }
        System.out.println(ansIndex + "," + ansTime);
    }
}
