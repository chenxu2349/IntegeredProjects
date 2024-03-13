package org.example.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @ClassName XC1
 * @Description
 * @Author chenxu
 * @Date 2024/3/13 19:02
 **/
public class XC1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int groups = 0;
        if (!map.keySet().contains('y') || !map.keySet().contains('o') || !map.keySet().contains('u')) {
            System.out.println(str);
            return;
        }
        groups = Math.min(map.get('y'), Math.min(map.get('o'), map.get('u')));
        map.put('y', map.get('y') - groups);
        map.put('o', map.get('o') - groups);
        map.put('u', map.get('u') - groups);

        StringBuilder ans = new StringBuilder();
        while (groups > 0) {
            ans.append("you");
            groups--;
        }
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            char c = entry.getKey();
            int count = entry.getValue();
            while (count > 0) {
                ans.append(c);
                count--;
            }
        }

        System.out.println(ans.toString());
    }
}
