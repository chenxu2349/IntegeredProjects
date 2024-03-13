package org.example.leetcode;

import java.util.Scanner;

/**
 * @ClassName XC3
 * @Description
 * @Author chenxu
 * @Date 2024/3/13 20:26
 **/
public class XC3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String in = sc.nextLine();
        StringBuilder original = new StringBuilder();
        String[] strings = in.substring(1, in.length() - 1).split(",");
        for (int i = 0; i < strings.length; i++) {
            String[] info = strings[i].split("\\(");
            int v = Integer.valueOf(info[0]);
            int count = Integer.valueOf(info[1].substring(0, info[1].length() - 1));
            while (count > 0) {
                original.append(v + ",");
                count--;
            }
        }
        String realOrigin = original.substring(0, original.length() - 1);
        String[] vals = realOrigin.split(",");

        int left = 0;
        int len = vals.length;
        StringBuilder ans = new StringBuilder("[");
        while (left < len) {
            String head = vals[left];
            int count = 1;
            int right = left + 1;
            // count
            while (right < len) {
                if (vals[right].equals(head)) {
                    count++;
                    right++;
                } else {
                    left = right;
                    break;
                }
            }
            if (right == len) {
                left = len;
            }
            // append
            ans.append(head + "(" + count + ")" + ",");
        }


        System.out.println(ans.substring(0, ans.length() - 1) + "]");
    }
}
