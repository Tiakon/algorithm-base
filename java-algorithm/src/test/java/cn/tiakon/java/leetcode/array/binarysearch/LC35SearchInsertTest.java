package cn.tiakon.java.leetcode.array.binarysearch;

import cn.tiakon.java.utils.MathRandomUtil;
import org.junit.Assert;
import org.junit.Test;

import java.util.Random;

public class LC35SearchInsertTest {

    @Test
    public void searchInsertTest() {
        final LC35SearchInsert lc35SearchInsert = new LC35SearchInsert();
        int[] nums = {1, 3, 5, 6};
        Assert.assertEquals(0, lc35SearchInsert.searchInsert(nums, 0));
        Assert.assertEquals(2, lc35SearchInsert.searchInsert(nums, 5));
        Assert.assertEquals(4, lc35SearchInsert.searchInsert(nums, 7));
    }

    @Test
    public void searchInsertBenchmarkTest() {
        final LC35SearchInsert lc35SearchInsert = new LC35SearchInsert();
        final Random random = new Random();
        for (int i = 0; i < 100000; i++) {
            // length -> [1,104]
            final int length = random.nextInt(104) + 1;
            // target -> [-104,104]
            final int targetValue = random.nextInt(105) * (random.nextInt() > 0.5 ? 1 : -1);
            // nums[i] -> [0,104]
            final int maxValue = random.nextInt(105);
            int[] nums = MathRandomUtil.createRandomArrayWithSorted(length, maxValue);
            final int searchInsertIndex = lc35SearchInsert.searchInsert(nums, targetValue);
            final int searchInsertV2Index = lc35SearchInsert.searchInsertV2(nums, targetValue);
            Assert.assertEquals(searchInsertV2Index, searchInsertIndex);
        }
    }
}
