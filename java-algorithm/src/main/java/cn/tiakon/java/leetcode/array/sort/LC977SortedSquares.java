package cn.tiakon.java.leetcode.array.sort;

import java.util.Arrays;

/**
 * 977. 有序数组的平方
 * https://leetcode.cn/problems/squares-of-a-sorted-array
 *
 * @author tiankai.me@gmail.com on 2022/8/10 11:12.
 */
public class LC977SortedSquares {

    /**
     * 用快排跟归并两种方式实现
     *https://leetcode.cn/problems/squares-of-a-sorted-array/solution/si-wei-dao-tu-zheng-li-liang-chong-shuan-e3iz/
     * @author tiankai.me@gmail.com on 2022/9/14 10:24.
     */
    public int[] sortedSquares(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            nums[i] = nums[i] * nums[i];
        }
        Arrays.sort(nums);
        return nums;
    }

}
