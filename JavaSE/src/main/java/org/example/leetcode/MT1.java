package org.example.leetcode;

import java.util.Scanner;

public class MT1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), k = sc.nextInt();
        sc.nextLine();
        String str = sc.nextLine();

        int countMT = 0, maxMT = 0;
        for (int i = 0; i < n; i++) {
            if (str.charAt(i) == 'M' || str.charAt(i) == 'T') {
                countMT++;
            }
        }

        if (countMT + k >= n) maxMT = n;
        else maxMT = countMT + k;

        System.out.println(maxMT);
    }
}
