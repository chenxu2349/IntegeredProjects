package org.example.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TX2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(), m = in.nextInt();
        if (m < n - 2) {
            System.out.println(0);
            return;
        }
        // int[][] graph = new int[n][n];
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>(n);
        boolean[] visited = new boolean[n];
        for (int i = 0; i < m; i++) {
            int a = in.nextInt() - 1, b = in.nextInt() - 1;
            // graph[a][b] = 1;
            // graph[b][a] = 1;
            graph.get(a).add(b);
            graph.get(b).add(a);
            if (graph.get(a) == null) {
                ArrayList<Integer> list = new ArrayList<>();
                list.add(b);
                graph.add(a, list);
            }
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                list.add(bfs(graph, n, visited, i));
            }
        }
        long ans = 1;
        for (int k : list) {
            ans *= k;
        }
        System.out.println(ans);
    }

    public static int bfs(ArrayList<ArrayList<Integer>> graph, int n, boolean[] visited, int k) {
        // 记录本层染色点数
        visited[k] = true;
        int newVisit = 1;
        for (int i : graph.get(k)) {
            if (!visited[i]) {
                newVisit += bfs(graph, n, visited, i);
            }
        }
        return newVisit;
    }
}