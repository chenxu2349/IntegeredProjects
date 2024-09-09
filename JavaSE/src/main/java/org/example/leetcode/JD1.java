package org.example.leetcode;

import java.util.Scanner;

public class JD1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        if (isAllZ(str)) {
            System.out.println(-1);
            return;
        }
        char[] chars = str.toCharArray();
        int cin =1;
        for (int i = str.length() - 1; i >= 0; i--) {
            char c1 = chars[i];
            if (c1 == 'z') {
                if (cin == 1) {
                    chars[i] = 'a';
                    cin = 1;
                }
            } else {
                chars[i] = (char) (c1 + cin);
                break;
            }
        }

        System.out.println(new String(chars));
    }

    public static boolean isAllZ(String str) {
        boolean flag = true;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != 'z') {
                flag = false;
                break;
            }
        }
        return flag;
    }
}
