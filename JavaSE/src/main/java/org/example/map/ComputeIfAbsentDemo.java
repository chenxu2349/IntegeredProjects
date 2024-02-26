package org.example.map;

import java.util.HashMap;
import java.util.Map;

public class ComputeIfAbsentDemo {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();

        // 使用 computeIfAbsent 方法向 Map 中添加键值对
        map.computeIfAbsent("key1", k -> 1);
        map.computeIfAbsent("key2", k -> 2);

        // 输出 Map 的内容
        System.out.println(map); // 输出：{key1=1, key2=2}

        // 再次使用 computeIfAbsent 方法，对已存在的键不会修改值
        map.computeIfAbsent("key1", k -> 100);

        // 输出 Map 的内容
        System.out.println(map); // 输出：{key1=1, key2=2}
    }
}
