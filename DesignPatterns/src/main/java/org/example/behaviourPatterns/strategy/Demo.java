package org.example.behaviourPatterns.strategy;

/**
 * @ClassName Demo
 * @Description
 * @Author chenxu
 * @Date 2024/3/10 23:34
 **/
public class Demo {
    public static void main(String[] args) {

        int[] nums = new int[]{7, 8, 0, 2, 1, 8, 7};
        int fileSize = 1024 * 1024 * 3;
        String type = chooseStrategy(fileSize);
        try {
            ISort sort = SortFactory.getSort(type);
            sort.doSort(nums);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static String chooseStrategy(int fileSize) {
        if (fileSize < 1024 * 1024 * 10) {
            return "QuickSort";
        } else if (fileSize < 1024 * 1024 * 100) {
            return "ExternalSort";
        } else {
            return "MapReduceSort";
        }
    }
}
