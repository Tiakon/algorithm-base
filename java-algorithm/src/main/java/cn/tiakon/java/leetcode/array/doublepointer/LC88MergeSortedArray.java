package cn.tiakon.java.leetcode.array.doublepointer;

import cn.tiakon.java.utils.MathRandomUtil;
import org.junit.Test;

import java.util.Arrays;

/**
 * 88. 合并两个有序数组
 * https://leetcode.cn/problems/merge-sorted-array/
 *
 * @author tiankai.me@gmail.com on 2023-08-04 23:14.
 */
public class LC88MergeSortedArray {

    /**
     * 双指针
     * 复杂度分析
     * <p>
     * 时间复杂度：O(m+n)。指针移动单调递增，最多移动m+n次。
     * 空间复杂度：O(m)。需要建立长度为m的中间数组。
     *
     * @author tiankai.me@gmail.com on 2023-08-05 10:29.
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (n == 0) return;
        final int[] ints = Arrays.copyOf(nums1, m);
        int l = 0, r = 0;
        for (int i = 0; i < nums1.length; i++) {
            if (l == m) nums1[i] = nums2[r++];
            else if (r == nums2.length) nums1[i] = ints[l++];
            else if (ints[l] < nums2[r]) nums1[i] = ints[l++];
            else nums1[i] = nums2[r++];
        }
    }

    @Test
    public void case01Test() {
        final LC88MergeSortedArray mergeSortedArray = new LC88MergeSortedArray();
        int[] num1 = new int[]{1, 2, 3, 0, 0, 0};
        int[] num2 = new int[]{2, 5, 6};
        mergeSortedArray.merge(num1, 3, num2, 3);
        MathRandomUtil.printArray(num1);
    }

}
