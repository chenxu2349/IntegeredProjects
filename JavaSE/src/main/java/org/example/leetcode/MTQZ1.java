package org.example.leetcode;

import java.util.Scanner;

public class MTQZ1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] words = str.split(" ");
        int ans = 0;
        for (String word : words) {
            if (checkValid(word)) ans++;
        }

        System.out.println(ans);
    }

    public static boolean checkValid(String s) {
        char[] chars = s.toCharArray();
        // 首字母不是大写直接false
        if (!(chars[0] >= 'A' && chars[0] <= 'Z')) {
            return false;
        }
        for (int i = 1; i < chars.length; i++) {
            if (!(chars[i] >= 'a' && chars[i] <= 'z')) {
                return false;
            }
        }
        return true;
    }
}
