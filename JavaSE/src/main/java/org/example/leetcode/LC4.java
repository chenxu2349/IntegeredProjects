package org.example.leetcode;

import java.util.*;

/**
 * @ClassName LC4
 * @Description
 * @Author chenxu
 * @Date 2024/4/4 21:28
 **/
public class LC4 {
    public static void main(String[] args) {
        int[] num = new int[]{1, 1, 2};
        ArrayList<ArrayList<Integer>> permute = permute(num);
        System.out.println(permute);
        char[] cc = new char[]{'a', 'c', 'a', 'A', 'D', 'B'};
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "abc");
        Arrays.sort(cc);
        System.out.println(cc);

        ArrayList<Integer> integers = maxInWindows(new int[]{2,3,4,2,6,2,5,1}, 3);
        System.out.println(integers);
    }

    static boolean[] vis;
    public static ArrayList<ArrayList<Integer>> permute(int[] num) {
        // write code here
        Arrays.sort(num);
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> temp = new ArrayList<>();
        vis = new boolean[num.length];
        backtrack(num, temp, ans);
        return ans;
    }

    public static void backtrack(int[] num, ArrayList<Integer> temp, ArrayList<ArrayList<Integer>> ans) {
        if (temp.size() == num.length) {
            // if (!have(ans, temp))
            ans.add(new ArrayList<>(temp));
            return;
        }

        for (int i = 0; i < num.length; i++) {
            // int k = num[i];
            if (vis[i]) continue;
            if (i > 0 && num[i - 1] == num[i] && !vis[i-1]) continue;

            vis[i] = true;
            temp.add(num[i]);
            backtrack(num, temp, ans);

            // back
            vis[i] = false;
            temp.remove(temp.size() - 1);
        }

    }

    public static ArrayList<Integer> maxInWindows (int[] num, int size) {
        // write code here
        ArrayList<Integer> ans = new ArrayList<>();
        if (num.length < size || size == 0) {
            return ans;
        }
        PriorityQueue<Integer> max = new PriorityQueue<>((v1, v2) -> v2 - v1);
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < size; i++) {
            max.offer(num[i]);
            queue.offer(num[i]);
        }
        ans.add(max.peek());
        for (int i = size; i < num.length; i++) {
            int drop = num[i - size];
            if (drop == max.peek()) {
                max.poll();
            }
            max.offer(num[i]);
            ans.add(max.peek());
        }
        return ans;
    }
}
