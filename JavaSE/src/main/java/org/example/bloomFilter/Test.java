package org.example.bloomFilter;

import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;

import java.nio.charset.Charset;

/**
 * @author xuchen22
 */
public class Test {
    public static void main(String[] args) {

        String qq1 = "2201377098";
        String qq2 = "1072329686";
        String qq3 = "953004514";

        /**
         * 自定义布隆过滤器
         * **/
        MyBloomFilter myBloomFilter = new MyBloomFilter();

        // 未加入布隆过滤器之前
        System.out.println(myBloomFilter.contains(qq1));
        System.out.println(myBloomFilter.contains(qq2));
        System.out.println(myBloomFilter.contains(qq3));

        // 加入布隆过滤器之后
        myBloomFilter.add(qq1);
        myBloomFilter.add(qq2);
        myBloomFilter.add(qq3);

        System.out.println(myBloomFilter.contains(qq1));
        System.out.println(myBloomFilter.contains(qq2));
        System.out.println(myBloomFilter.contains(qq3));

        /**
         * Google Guava布隆过滤器
         * **/

        // 容量1500，容忍误判率0.01
        BloomFilter<CharSequence> bloomFilter = BloomFilter.create(
                Funnels.stringFunnel(Charset.defaultCharset()),
                1500,
                0.01
        );
        System.out.println("Guava BloomFilter 初始化成功...");

        // 未加入布隆过滤器之前
        System.out.println(bloomFilter.mightContain(qq1));
        System.out.println(bloomFilter.mightContain(qq2));
        System.out.println(bloomFilter.mightContain(qq3));

        // 加入布隆过滤器之后
        bloomFilter.put(qq1);
        bloomFilter.put(qq2);
        bloomFilter.put(qq3);

        System.out.println(bloomFilter.mightContain(qq1));
        System.out.println(bloomFilter.mightContain(qq2));
        System.out.println(bloomFilter.mightContain(qq3));
    }
}
