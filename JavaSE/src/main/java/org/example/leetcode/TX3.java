package org.example.leetcode;

import java.util.Scanner;

public class TX3 {

    public static int ans = 0;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(), m = in.nextInt();
        char[][] graph = new char[n][m];
        for (int i = 0; i < n; i++) {
            String s = in.next();
            graph[i] = s.toCharArray();
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (graph[i][j] == 't') {
                    dfs(graph, n, m, i+1, j, 6, graph[i+1][j]);
                    dfs(graph, n, m, i-1, j, 6, graph[i-1][j]);
                    dfs(graph, n, m, i, j+1, 6, graph[i][j+1]);
                    dfs(graph, n, m, i, j-1, 6, graph[i][j-1]);
                }
            }
        }
        System.out.println(ans);
    }

    public static void dfs(char[][] graph, int n, int m, int x, int y, int step, char c) {
        if (x < 0 || x >= n || y < 0 || y >= m) {
            return;
        }
        if (step == 1 && c == 't') {
            ans++;
            return;
        }
        if (step == 2 && c == 'n') {
            dfs(graph, n, m, x + 1, y, step - 1, graph[x + 1][y]);
            dfs(graph, n, m, x - 1, y, step - 1, graph[x - 1][y]);
            dfs(graph, n, m, x, y + 1, step - 1, graph[x][y + 1]);
            dfs(graph, n, m, x, y - 1, step - 1, graph[x][y - 1]);
        }
        if (step == 3 && c == 'e') {
            dfs(graph, n, m, x + 1, y, step - 1, graph[x + 1][y]);
            dfs(graph, n, m, x - 1, y, step - 1, graph[x - 1][y]);
            dfs(graph, n, m, x, y + 1, step - 1, graph[x][y + 1]);
            dfs(graph, n, m, x, y - 1, step - 1, graph[x][y - 1]);
        }
        if (step == 4 && c == 'c') {
            dfs(graph, n, m, x + 1, y, step - 1, graph[x + 1][y]);
            dfs(graph, n, m, x - 1, y, step - 1, graph[x - 1][y]);
            dfs(graph, n, m, x, y + 1, step - 1, graph[x][y + 1]);
            dfs(graph, n, m, x, y - 1, step - 1, graph[x][y - 1]);
        }
        if (step == 5 && c == 'n') {
            dfs(graph, n, m, x + 1, y, step - 1, graph[x + 1][y]);
            dfs(graph, n, m, x - 1, y, step - 1, graph[x - 1][y]);
            dfs(graph, n, m, x, y + 1, step - 1, graph[x][y + 1]);
            dfs(graph, n, m, x, y - 1, step - 1, graph[x][y - 1]);
        }
        if (step == 6 && c == 'e') {
            dfs(graph, n, m, x + 1, y, step - 1, graph[x + 1][y]);
            dfs(graph, n, m, x - 1, y, step - 1, graph[x - 1][y]);
            dfs(graph, n, m, x, y + 1, step - 1, graph[x][y + 1]);
            dfs(graph, n, m, x, y - 1, step - 1, graph[x][y - 1]);
        }
    }
}
