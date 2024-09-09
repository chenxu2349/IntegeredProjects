package org.example.leetcode;

import java.util.Scanner;
import java.util.Stack;

public class Dewu3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        String s = sc.nextLine();
        //       (()())((
        // (()(()(((
        int ans = 0;
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stack.push(c);
            } else {
                // 遇到右括号了
                if (!stack.isEmpty()) {
                    stack.pop();
                    if (stack.empty()) ans = i + 1;
                } else {
                    break;
                }
            }
        }

        System.out.println(ans);
    }
}
