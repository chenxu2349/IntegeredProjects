package org.example.leetcode;

import java.util.*;


public class LC1 {

    public static void main(String[] args) {
        String s = "3+2*3*4-1";
        System.out.println(solve(s));
        Queue<Integer> q = new PriorityQueue<>();
    }

    public static int solve(String s) {
        // write code here
        if (s.length() == 0) {
            return 0;
        }
        Stack<Character> optStack = new Stack<>();
        Stack<Integer> valStack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                // 递归计算最外层括号里的值
                int rightIndex = 0;
                for (int j = s.length() - 1; j > i; j--) {
                    if (s.charAt(j) == ')') {
                        rightIndex = j;
                        break;
                    }
                }
                valStack.push(solve(s.substring(i + 1, rightIndex)));
                i = rightIndex;
            } else if (c == '+' || c == '-' || c == '*') {
                optStack.push(c);
            } else {
                // 向后读数据，可能不止一位
                StringBuilder sb = new StringBuilder();
                for (int j = i; j < s.length(); j++) {
                    if (s.charAt(j) >= '0' && s.charAt(j) <= '9') {
                        sb.append(s.charAt(j));
                        i = j;
                    } else break;
                }
                int k = sb.length() > 0 ? Integer.valueOf(sb.toString()) : 0;
                if (!optStack.isEmpty() && optStack.peek() == '*') {
                    valStack.push(k * valStack.pop());
                    optStack.pop();
                } else {
                    valStack.push(k);
                }
            }
        }
        // 无括号，只剩简单数据和运算符
        while (!optStack.isEmpty()) {
            int v1 = valStack.pop(), v2 = valStack.pop();
            char c = optStack.pop();
            if (c == '-') {
                valStack.push(v2 - v1);
            } else if (c == '+') {
                valStack.push(v1 + v2);
            } else {
                valStack.push(v1 * v2);
            }
        }
        return valStack.pop();
    }
}
