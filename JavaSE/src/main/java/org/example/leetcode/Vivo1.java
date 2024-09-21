package org.example.leetcode;

import java.util.*;

public class Vivo1 {
    public static void main(String[] args) {
        TreeSet<Integer> window = new TreeSet<>();
        window.add(1);
        window.add(3);
        window.add(2);
        window.add(5);
        window.add(4);
        System.out.println(window.first() + "," + window.last());
        window.remove(1);
        System.out.println(window);
    }

    public static int staffGroup(int[] staff) {
        int count0 = 0, count1 = 0;
        int ansGroups = 0;
        for (int i = 0; i < staff.length; i++) {
            if (staff[i] == 0) {
                count0++;
            } else {
                count1++;
            }
        }

        if (count1 >= count0) {
            ansGroups += count0;
            ansGroups += (count1 - count0);
        } else {
            ansGroups += count1;
            count0 -= count1;
            ansGroups += count0 / 3;
            count0 %= 3;
            if (count0 > 0) ansGroups++;
        }

        return ansGroups;
    }

    public static int[] findFluctuations (int[] memoryUsage, int k) {
        int len = memoryUsage.length;
        TreeSet<Integer> window = new TreeSet<>();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            window.add(memoryUsage[i]);
        }
        list.add(window.last() - window.first());
        for (int i = 1; i < len - (k - 1); i++) {
            window.remove(memoryUsage[i - 1]);
            window.add(memoryUsage[i + k - 1]);
            list.add(window.last() - window.first());
        }

        int[] ans = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            ans[i] = list.get(i);
        }
        return ans;
    }
}
