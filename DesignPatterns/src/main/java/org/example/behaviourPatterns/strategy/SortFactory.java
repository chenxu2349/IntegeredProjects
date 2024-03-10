package org.example.behaviourPatterns.strategy;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName SortFactory
 * @Description
 * @Author chenxu
 * @Date 2024/3/10 23:28
 **/
public class SortFactory {

    // 如果所用的对象无需变化，可以直接将建立好的对象用map缓存起来
    public static Map<String, ISort> map = new HashMap<>();
    static {
        map.put("QuickSort", new QuickSort());
        map.put("ExternalSort", new ExternalSort());
        map.put("MapReduceSort", new MapReduceSort());
    }

    public static ISort getSort(String type) throws Exception {
        if (type == null || "".equals(type)) {
            throw new Exception("selected type is null...");
        }

        if (!map.keySet().contains(type)) {
            throw new Exception("selected type is not supported...");
        }

        return map.get(type);
    }
}
