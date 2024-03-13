package org.example.leetcode;

import java.util.*;

public class LC3 {
    public static void main(String[] args) {
        String[] arr = new String[]{"vbb","grg","lexn","oklqe","yxav"};
        String[] strings = shortestSubstrings(arr);
    }

    public static int minimumBoxes(int[] apple, int[] capacity) {
        int n = apple.length, m = capacity.length;
        int sumApple = 0;
        for (int i = 0; i < n; i++) {
            sumApple += apple[i];
        }
        Arrays.sort(capacity);
        int sumCap = 0, box = 0;
        for (int i = m - 1; i >= 0; i--) {
            sumCap += capacity[i];
            box++;
            if (sumCap >= sumApple) {
                return box;
            }
        }
        return box;
    }

    public static long maximumHappinessSum(int[] happiness, int k) {
        int len = happiness.length;
        Arrays.sort(happiness);
        long ans = 0;
        int count = 0;
        for (int i = len - 1; i >= 0; i--) {
            ans += (happiness[i] - count >= 0 ? (happiness[i] - count) : 0);
            count++;
            if (count == k) {
                break;
            }
        }
        return ans;
    }

    // ["gfnt","xn","mdz","yfmr","fi","wwncn","hkdy"]
    // "vbb","grg","lexn","oklqe","yxav"
    public static String[] shortestSubstrings(String[] arr) {
        int len = arr.length;
        Map<String, Integer> map = new HashMap<>();
        // 穷举全部子串存入hashmap并计数
        for (String s : arr) {
            Set<String> set = new HashSet<>();
            for (int i = 0; i < s.length(); i++) {
                for (int j = i + 1; j <= s.length(); j++) {
                    String subString = s.substring(i, j);
                    // 对外提供不重复的子串
                    set.add(subString);
                }
            }
            for (String str : set) map.put(str, map.getOrDefault(str, 0) + 1);
        }

        String[] ans = new String[len];
        for (int k = 0; k < len; k++) {
            ans[k] = "";
            List<String> subList = new ArrayList<>();
            // 穷举自身全部子串
            String s = arr[k];
            for (int i = 0; i < s.length(); i++) {
                for (int j = i + 1; j <= s.length(); j++) {
                    String subString = s.substring(i, j);
                    if (map.get(subString) == 1) {
                        subList.add(subString);
                    }
                }
            }
            // 找到字典序最小的
            Collections.sort(subList);
            int minLen = Integer.MAX_VALUE;
            for (String s1 : subList) {
                if (s1.length() < minLen) {
                    minLen = s1.length();
                    ans[k] = s1;
                }
            }
        }
        return ans;
    }
}
