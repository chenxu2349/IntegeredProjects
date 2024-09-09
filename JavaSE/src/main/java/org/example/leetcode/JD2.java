package org.example.leetcode;

import java.util.Scanner;

public class JD2 {

    static int N;
    static boolean[][] visited;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        N = n;
        int[][] arr = new int[2][n];
        for (int i = 0; i < n; i++) {
            arr[0][i] = scanner.nextInt();
        }
        for (int i = 0; i < n; i++) {
            arr[1][i] = scanner.nextInt();
        }

        visited = new boolean[2][n];
        int sum = 0;
        sum += arr[0][0];
        visited[0][0] = true;
        int player = 1; // 0-max, 1-min
        int x = 0, y = 0;
        // 没到终点时
        while (!visited[1][n - 1]) {
            if (player == 1) {
                // up
                int up = (valid(x-1, y) ? arr[x-1][y] : 10001);
                // down
                int down = (valid(x+1, y) ? arr[x-1][y] : 10001);
                // right
                int right = (valid(x, y+1) ? arr[x-1][y] : 10001);

                int min = Math.min(up, Math.min(down, right));
                sum += min;
                if (min == up) {
                    x--;
                } else if (min == down) {
                    x++;
                } else {
                    y++;
                }
                visited[x][y] = true;
            } else {
                // up
                int up = (valid(x-1, y) ? arr[x-1][y] : -10001);
                // down
                int down = (valid(x+1, y) ? arr[x-1][y] : -10001);
                // right
                int right = (valid(x, y+1) ? arr[x-1][y] : -10001);

                int max = Math.max(up, Math.max(down, right));
                sum += max;
                if (max == up) {
                    x--;
                } else if (max == down) {
                    x++;
                } else {
                    y++;
                }
                visited[x][y] = true;
            }

            player = 1 - player;
        }
    }

    public static boolean valid(int x, int y) {
        if ((x == 0 || x == 1) && (y >= 0 && y < N) && !visited[x][y]) {
            return true;
        } else {
            return false;
        }
    }
}