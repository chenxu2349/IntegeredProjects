package org.example.leetcode;

import java.util.*;

public class HW1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.nextLine();
//        Map<String, Set<String>> timeMap = new HashMap<>();
        Map<String, Map<String, Map<String, Integer>>> logMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String log = in.nextLine();
            String[] strs = log.split(",");
            String time = strs[0], uid = strs[1], factor = strs[2], count = strs[3];
            int cc = Integer.valueOf(count);
            if (cc < 0 || cc > 100) {
                cc = 0;
            }
            if (logMap.keySet().contains(uid)) { // old user
                Map<String, Map<String, Integer>> timeMap = logMap.get(uid);
                Map<String, Integer> factorMap = timeMap.get(time);
                if (timeMap.keySet().contains(time)) { // old time
                    if (factorMap.keySet().contains(factor)) {
                        continue;
                    } else {
                        factorMap.put(factor, factorMap.getOrDefault(factor, 0) + cc);
                        timeMap.put(time, factorMap);
                        logMap.put(uid, timeMap);
                    }
                } else { // new time
                    Map<String, Integer> map = new HashMap<>();
                    map.put(factor, cc);
                    timeMap.put(time, map);
                }
            } else {
                // new user
                Map<String, Map<String, Integer>> timeMap = new HashMap<>();
                Map<String, Integer> factorMap = new HashMap<>();
                factorMap.put(factor, cc);
                timeMap.put(time, factorMap);
                logMap.put(uid, timeMap);
            }
        }
        int m = in.nextInt();
        in.nextLine();
        Map<String, Integer> price = new HashMap<>();
        for (int i = 0; i < m; i++) {
            String price1 = in.nextLine();
            String[] prices = price1.split(",");
            String factor = prices[0];
            int pp = Integer.valueOf(prices[1]);
            price.put(factor, pp);
        }

        // count payment
        ArrayList<String> users = new ArrayList<>(logMap.keySet());
        Collections.sort(users);
        for (String uid : users) {
            int sum = 0;
            Map<String, Map<String, Integer>> timeMap = logMap.get(uid);
            for (String time : timeMap.keySet()) {
                Map<String, Integer> map = timeMap.get(time);
                for (String factor : map.keySet()) {
                    sum += (price.get(factor) * map.get(factor));
                }
            }
            System.out.println(uid + "," + sum);
        }
    }
}

//
//5
//1627845600,client1,factorA,10
//1627845605,client2,factorB,15
//1627845610,client1,factorA,5
//1627845610,client1,factorB,8
//1627845620,client2,factorB,20
//2
//factorA,5
//factorB,7