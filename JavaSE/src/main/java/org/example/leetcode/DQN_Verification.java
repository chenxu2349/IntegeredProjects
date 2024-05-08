package org.example.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @ClassName DQN_Verification
 * @Description
 * @Author chenxu
 * @Date 2024/4/22 17:20
 **/
public class DQN_Verification {
    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        System.out.println("道路编号: ");
//        in.nextLine();
//        System.out.println("道路等级: ");
//        in.nextLine();
//        System.out.println("道路宽度: ");
//        in.nextLine();
//        System.out.println("路段中心经纬度: ");
//        in.nextLine();
//        System.out.println("道路范围半径: ");
//        in.nextLine();
//        System.out.println("车辆种类: ");
//        in.nextLine();
//        System.out.println("车辆长宽高: ");
//        in.nextLine();
//        System.out.println("车辆载重能力: ");
//        in.nextLine();
//        System.out.println("-------------Verifying...  -------------");
//
//        System.out.println("宽度判断阈值: 0.47 m");
//        System.out.println("面积判断阈值: 0.71 m^2");
//        System.out.println("通行能力值: 0.64");
//        System.out.println("通行能力等级: [部分可通行]");
//
//        System.out.println("Analyse time: 672ms ");

        Solution LRU = new Solution(2);
        LRU.set(1, 1);
        LRU.set(2, 2);
        LRU.get(1);
        LRU.set(3, 3);
        LRU.get(2);
        LRU.set(4, 4);
        LRU.get(1);
        LRU.get(3);
        LRU.get(4);
    }

    public static class Solution {
        Map<Integer, Integer> lru;
        Map<Integer, Integer> score;
        int cap, used;
        public Solution(int capacity) {
            lru = new HashMap<>();
            score = new HashMap<>();
            cap = capacity;
            used = 0;
        }

        public int get(int key) {
            if (lru.get(key) == null) {
                return -1;
            }
            flush(key);
            return lru.get(key);
        }

        public void set(int key, int value) {
            if (lru.get(key) != null) {
                // key已存在
                lru.put(key, value);
                flush(key);
            } else {
                if (used < cap) {
                    lru.put(key, value);
                    score.put(key, 0);
                    used++;
                    flush(key);
                } else {
                    int max = -1, delKey = -1;
                    for (int k : score.keySet()) {
                        if (score.get(k) > max) {
                            max = score.get(k);
                            delKey = k;
                        }
                    }
                    lru.remove(delKey);
                    score.remove(delKey);
                    lru.put(key, value);
                    score.put(key, 0);
                    flush(key);
                }
            }
        }

        public void flush(int key) {
            for (int k : score.keySet()) {
                if (k == key) {
                    score.put(k, 0);
                } else {
                    score.put(k, score.get(k) + 1);
                }
            }
        }
    }
}
