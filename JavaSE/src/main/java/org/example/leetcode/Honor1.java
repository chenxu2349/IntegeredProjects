package org.example.leetcode;

import java.util.Scanner;

public class Honor1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str1 = sc.nextLine();
        String str2 = sc.nextLine();
        str1 = str1.replaceAll("\\s+", "");
        int count = 0;
        for (int i = 0; i <= str1.length() - str2.length(); i++) {
            if (str1.charAt(i) == str2.charAt(0)) {
                boolean check = true;
                for (int j = 0; j < str2.length(); j++) {
                    if (str1.charAt(i + j) != str2.charAt(j)) {
                        check = false;
                        break;
                    }
                }
                if (check) {
                    count++;
                }
            }
        }
        System.out.println(count);
    }
}
