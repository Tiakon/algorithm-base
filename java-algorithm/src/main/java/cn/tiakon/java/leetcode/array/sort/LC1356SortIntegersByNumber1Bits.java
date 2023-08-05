package cn.tiakon.java.leetcode.array.sort;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * 1356. 根据数字二进制下 1 的数目排序
 * https://leetcode.cn/problems/sort-integers-by-the-number-of-1-bits/
 *
 * @author tiankai.me@gmail.com on 2022/11/24 下午11:25.
 */
public class LC1356SortIntegersByNumber1Bits {

    public int[] sortByBits(int[] arr) {
        int[] counts = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            counts[i] = getCount1Bits(arr[i]);
        }
        for (int i = 1; i < counts.length; i++) {
            for (int j = i; j > 0; j--) {
                if (counts[j - 1] > counts[j] || (counts[j - 1] == counts[j] && arr[j - 1] > arr[j])) {
                    swap(counts, j - 1, j);
                    swap(arr, j - 1, j);
                }
            }
        }
        return arr;
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    // 统计正整数二进制时1的个数
    public int getCount1Bits(int value) {
        int ans = 0;
        while (value > 0) {
            if (value % 2 == 1) ++ans;
            value /= 2;
        }
        return ans;
    }

    public int hammingWeight(int n) {
        int ans = 0;
        for (int i = 31; i >= 0; i--) {
            if ((n >> i & 1) != 0) ++ans;
        }
        return ans;
    }

    public int[] sortByBitsV2(int[] arr) {
        int[] ints = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            ints[i] = Integer.bitCount(arr[i]) * 10000000 + arr[i];
        }
        Arrays.sort(ints);
        for (int i = 0; i < ints.length; i++) {
            ints[i] = ints[i] % 10000000;
        }
        return ints;
    }

    @Test
    public void getCount1BitsTest() {
        LC1356SortIntegersByNumber1Bits lc1356SortIntegersByNumber1Bits = new LC1356SortIntegersByNumber1Bits();

        int ans = lc1356SortIntegersByNumber1Bits.getCount1Bits(5);
        Assert.assertEquals(2, ans);

        ans = lc1356SortIntegersByNumber1Bits.getCount1Bits(10);
        Assert.assertEquals(2, ans);

        ans = lc1356SortIntegersByNumber1Bits.getCount1Bits(15);
        Assert.assertEquals(4, ans);

        ans = lc1356SortIntegersByNumber1Bits.hammingWeight(10);
        Assert.assertEquals(2, ans);

        ans = lc1356SortIntegersByNumber1Bits.hammingWeight(15);
        Assert.assertEquals(4, ans);

        int[] nums = new int[]{5, 2, 3, 6, 4, 1};
        lc1356SortIntegersByNumber1Bits.sortByBits(nums);
    }

}
