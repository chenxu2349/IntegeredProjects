package org.example.leetcode;

import java.util.Scanner;

public class PDD1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String s = sc.next();
        int ans = 0, countA = 0, countB = 0;
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c == 'A') {
                countA++;
            } else {
                countB++;
            }
            if (countA == countB) {
                ans = 2 * countA;
            } else if (Math.min(countA, countB) == 1 || Math.min(countA, countB) == 0) {
                ans = Math.max(ans, 2 * Math.min(countA, countB));
            } else {
                int cA = 0, cB = 0;
                for (int j = i; j >= 0; j--) {
                    char c2 = s.charAt(j);

                    if (c2 == 'A') {
                        cA++;
                    } else {
                        cB++;
                    }
                    if (cA == cB) {
                        ans = Math.max(ans, 2 * cA);
                        if (cA == Math.min(countA, countB)) {
                            break;
                        }
                    }
                }
            }
        }

        System.out.println(ans);
    }
}
