package org.example.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class XHS2 {
    static Map<Integer, Integer> backMap = new HashMap<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] categories = new int[n];
        int[] movable = new int[n];
        for (int i = 0; i < n; i++) {
            categories[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            movable[i] = sc.nextInt();
        }

        System.out.println(minUnpleasantness(n, categories, movable));
    }

    public static int minUnpleasantness(int n, int[] categories, int[] movable) {
        if (n == 2) return categories[0] == categories[1] ? 0 : 1;
        if (n <= 1) return 0;

        // op
        int min = calculateUnpleasantness(categories);

        // 尝试移动物品，计算不美观程度的最小值
        for (int i = 0; i < n - 1; i++) {
            if (movable[i] == 1) {
                for (int j = i + 1; j < n; j++) {
                    if (movable[j] == 1 && categories[i] != categories[j]) {
                        // 交换i，j
                        swap(categories, i, j);
                        // 回溯
                        int backJ = 0;
                        if (backMap.containsKey(j)) {
                            backJ = backMap.get(j);
                        } else {
                            backJ = minUnpleasantness(n - j, Arrays.copyOfRange(categories, j, n), Arrays.copyOfRange(movable, j, n));
                            backMap.put(j, backJ);
                        }
                        int newUnpleasantness = calculateUnpleasantness(Arrays.copyOfRange(categories, 0, j + 1))
                                + backJ;
                        min = Math.min(min, newUnpleasantness);
                        // 恢复原状
                        swap(categories, i, j);
                    }
                }
            }
        }

        return min;
    }

    private static int calculateUnpleasantness(int[] categories) {
        int unpleasantness = 0;
        for (int i = 0; i < categories.length - 1; i++) {
            if (categories[i] != categories[i + 1]) {
                unpleasantness++;
            }
        }
        return unpleasantness;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
