package org.example.leetcode;

import java.util.Scanner;
import java.util.Stack;

public class SF2 {

    public static int sum, N;
    public static int[] A, B;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sum = 0;
        N = n;
        A = new int[n];
        B = new int[n];
        for (int i = 0; i < n; i++) {
            A[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            B[i] = sc.nextInt();
        }
        solve(0, new Stack<>());
        System.out.println(sum);
    }

    public static void solve(int indexA, Stack<Integer> stack) {
        if (indexA == N && stack.isEmpty()) {
            return;
        }
        // A not null, op1
        if (indexA < N) {
            stack.push(A[indexA]);
            solve(indexA + 1, stack);
            if (!stack.isEmpty()) {
                stack.pop();
            }
        }

        // stack not null, op2
        if (!stack.isEmpty()) {
            sum += stack.peek() * B[stack.size() - 1];
            int head = stack.pop();
            solve(indexA, stack);
            stack.push(head);
        }
    }
}
