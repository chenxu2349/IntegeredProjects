package org.example.leetcode;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class YZ3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        int ans = 0;
        String[] strings = s.split("d");
        for (String k : strings) {
            ans += countStr(k);
        }

        System.out.println(ans);
    }

    public static int countStr(String s) {
        if (s.length() < 2) return 0;
        // 找到最小re区间
        int firstR = -1, firstE = -1;
        Set<Integer> ri = new HashSet<>();
        Set<Integer> ei = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'r') ri.add(i);
            if (s.charAt(i) == 'e') ei.add(i);
        }
        if (ri.size() == 0 || ei.size() == 0) return 0;
        int len = Integer.MAX_VALUE;
        for (int i : ri) {
            for (int j : ei) {
                if (Math.abs(i - j) < len) {
                    firstR = i;
                    firstE = j;
                    len = Math.abs(i - j);
                }
                int x = i & j;
            }
        }
        return  (Math.min(firstR, firstE) + 1) * (s.length() - Math.max(firstR, firstE));
    }
}
