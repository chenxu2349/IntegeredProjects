package org.example.leetcode;

import java.util.*;

public class XP1 {
    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        n1.next = n2;
        n2.next = n3;
        ListNode ans = Rotate(n1, 1);
        while (ans != null) {
            System.out.println(ans.val);
            ans = ans.next;
        }


        // "Shopee is Our family 123"
        // "Seepoh si Oru ylimaf 123"
    }

    public static class ListNode {
        int val;
        ListNode next = null;

        public ListNode(int val) {
            this.val = val;
        }
    }
    public static ListNode Rotate(ListNode head, int k) {
        // write code here
        int len = 0;
        ListNode p = head;
        while (p != null) {
            len++;
            p = p.next;
        }
        k %= len;
        if (k == 0) return head;
        p = head;
        int count = 0;
        ListNode p2 = null;
        while (p != null) {
            count++;
            if (count == (len - k)) {
                p2 = p.next;
                p.next = null;
                break;
            }
            p = p.next;
        }
        p = head;
        ListNode newHead = p2;
        while (p2 != null && p2.next != null) {
            p2 = p2.next;
        }
        p2.next = p;
        return newHead;
    }

    // "Shopee is Our family 123"
    // "Seepoh si Oru ylimaf 123"
    public static String reverses(String original_str) {
        // write code here
        String[] strs = original_str.split(" ");
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < strs.length; i++) {
            if (i < strs.length - 1) {
                ans.append(helper(strs[i]) + " ");
            } else {
                ans.append(helper(strs[i]));
            }
        }
        return ans.toString();
    }

    public static String helper(String s) {
        char[] arr = s.toCharArray();
        Set<Integer> set = new HashSet<>();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            char c = arr[i];
            if (c >= 'a' && c <= 'z') {
                stack.push(c);
            } else {
                set.add(i);
            }
        }
        for (int i = 0; i < arr.length; i++) {
            if (!set.contains(i)) {
                arr[i] = stack.pop();
            }
        }
        return new String(arr);
    }

    // [10,5,6,11,2,3],10
    // [5,2,3]
    public static int[] solution(int[] costs, int coins) {
        // write code here
        int[] copy = new int[costs.length];
        for (int i = 0; i < costs.length; i++) copy[i] = costs[i];
        Map<Integer, ArrayList<Integer>> map = new HashMap<>();
        for (int i = 0; i < costs.length; i++) {
            int k = costs[i];
            if (!map.keySet().contains(k)) {
                ArrayList<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(k, list);
            } else {
                ArrayList<Integer> list = map.get(k);
                list.add(i);
                map.put(k, list);
            }
        }
        Arrays.sort(costs);
        int sum = coins;
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < costs.length; i++) {
            if (sum < costs[i]) {
                break;
            } else {
                sum -= costs[i];
                ArrayList<Integer> list = map.get(costs[i]);
                int index = list.get(0);
                list.remove(0);
                ans.add(index);
                map.put(costs[i], list);
            }
        }
        Collections.sort(ans);
        List<Integer> ans1 = new ArrayList<>();
        for (int i = 0; i < ans.size(); i++) {
            ans1.add(copy[ans.get(i)]);
        }
        int[] realAns = new int[ans1.size()];
        for (int i = 0; i < ans1.size(); i++) {
            realAns[i] = ans1.get(i);
        }
        return realAns;
    }
}
