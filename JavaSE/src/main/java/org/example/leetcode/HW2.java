package org.example.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class HW2 {

    public static boolean[] vis;
    public static List<Integer> ans;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        vis = new boolean[N];
        int[][] M = new int[N][N];
        ans = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                M[i][j] = in.nextInt();
            }
        }

        for (int i = 0; i < N; i++) {
            if (!vis[i]) {
                ans.add(dfs(M, N, i, 0));
            }
        }

        StringBuilder str = new StringBuilder();
        Collections.sort(ans);
        Collections.reverse(ans);
        for (int k : ans) {
            if (k > 0) {
                str.append(k + " ");
            }
        }
        if (ans.size() == 1) {
            //
            System.out.println(ans.get(0));
        } else {
            System.out.println(str.toString().substring(0, str.length() - 1));
        }
    }

    public static int dfs (int[][] M, int N, int index, int sum) {
//        boolean find = false;
        int i = index;
        int local = 0;
        for (int j = 0; j < N; j++) {
            if (M[i][j] > 0 && !vis[j]) {
                vis[i] = true;
                sum += dfs(M, N, j, M[i][j]);
            }
        }
        return sum;
    }
}

//5
//0  5 42  0  0
//5  0  0 91  0
//42  0  0  0 15
//0 91  0  0  0
//0  0 15  0  0


//5
//0  0 50  0  0
//0  0  0 25  0
//50  0  0  0 15
//0 25  0  0  0
//0  0 15  0  0

//7
//0 1 3 0 0 0 0
//1 0 2 0 0 0 0
//3 2 0 0 0 0 0
//0 0 0 0 3 0 9
//0 0 0 3 0 5 0
//0 0 0 0 5 0 7
//0 0 0 9 0 7 0