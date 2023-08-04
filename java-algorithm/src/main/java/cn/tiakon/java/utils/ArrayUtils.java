package cn.tiakon.java.utils;

public class ArrayUtils {

    /**
     * 将传入nums数组的，i1，i2下标的值进行交换
     *
     * @author tiankai.me@gmail.com on 2022/8/10 15:12.
     */
    public static void swap(int[] nums, int i1, int i2) {
        int temp = nums[i2];
        nums[i2] = nums[i1];
        nums[i1] = temp;
    }


}
