package org.example.leetcode;

import java.util.*;



public class LC5 {
    class ThreadSafeLinkedList<T> {

        // 节点类
        private class Node<T> {
            T data;
            Node<T> next;

            Node(T data) {
                this.data = data;
                this.next = null;
            }
        }

        private Node<T> head;

        public ThreadSafeLinkedList() {
            head = null;
        }

        // 添加节点
        public synchronized void add(T element) {
            Node<T> node = new Node<>(element);
            if (head == null) {
                head = node;
            } else {
                Node<T> t = head;
                while (t.next != null) {
                    t = t.next;
                }
                t.next = node;
            }
        }

        // 删除节点
        public synchronized void remove(T element) {
            // 头节点为空
            if (head == null) {
                return;
            }
            // 单节点链表
            if (head.next == null) {
                if (head.data.equals(element)) {
                    head = null;
                }
                return;
            }
            Node<T> p = head;
            while (p.next != null) {
                // 逻辑删除此节点
                if (p.data.equals(element)) {
                    p.data = p.next.data;
                    p.next = p.next.next;
                }
                p = p.next;
            }
            // 扫描到最后一个节点
            if (p.data.equals(element)) {
                p = null;
            }
        }

        // 查询是否存在
        public boolean contains(T element) {
            if (head == null) {
                return false;
            }
            Node<T> p = head;
            while (p.next != null) {
                if (p.data.equals(element)) {
                    return true;
                }
                p = p.next;
            }
            return false;
        }

    }

    static List<List<Integer>> ans;
    static int len;

    public static List<List<Integer>> subsets(int[] nums) {
        ans = new ArrayList<>();
        len = nums.length;
        LinkedList<Integer> list = new LinkedList<>();
        backtrack(nums, 0, list);
        return ans;
    }

    public static void backtrack(int[] nums, int index, LinkedList<Integer> list) {
        ans.add(new LinkedList<>(list));
        if (list.size() == len) {
            return;
        }
        for (int i = index; i < len; i++) {
            list.add(nums[i]);
            backtrack(nums, i + 1, list);
            list.removeLast();
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        List<List<Integer>> subsets = subsets(nums);
        for (List<Integer> list : subsets) {
            for (Integer integer : list) {
                System.out.print(integer + " ");
            }
            System.out.println();
        }
    }
}
