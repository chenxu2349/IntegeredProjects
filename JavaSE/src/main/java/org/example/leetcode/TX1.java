package org.example.leetcode;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class TX1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(), m = in.nextInt();
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < m; i++) {
            int n1 = in.nextInt(), n2 = in.nextInt();
            String s = in.nextLine();
            if (s.equals("W")) {
                set.add(n1);
                set.add(n2);
            }
        }
        System.out.println(n - set.size());
    }
}
