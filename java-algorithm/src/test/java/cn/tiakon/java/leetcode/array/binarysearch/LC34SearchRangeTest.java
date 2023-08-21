package cn.tiakon.java.leetcode.array.binarysearch;

import cn.tiakon.java.utils.MathRandomUtil;
import org.junit.Assert;
import org.junit.Test;

import java.util.Random;

public class LC34SearchRangeTest {

    @Test
    public void searchRangeTest() {
        final LC34SearchRange lc34SearchRange = new LC34SearchRange();
        int target = 8;
        int[] nums = new int[]{5, 7, 7, 8, 8, 10};
        int[] searchRange = lc34SearchRange.searchRange(nums, target);
        Assert.assertArrayEquals(new int[]{3, 4}, searchRange);

        target = 10;
        searchRange = lc34SearchRange.searchRange(nums, target);
        Assert.assertArrayEquals(new int[]{5, 5}, searchRange);

        target = 0;
        searchRange = lc34SearchRange.searchRange(nums, target);
        Assert.assertArrayEquals(new int[]{-1, -1}, searchRange);

        target = 0;
        nums = new int[]{};
        searchRange = lc34SearchRange.searchRange(nums, target);
        Assert.assertArrayEquals(new int[]{-1, -1}, searchRange);
    }

    @Test
    public void searchRangeBenchmarkTest() {
        final LC34SearchRange lc34SearchRange = new LC34SearchRange();
        for (int i = 0; i < 10000; i++) {
            final Random random = new Random();
            // length -> [0,105]
            final int length = random.nextInt(106);
            // num[i] -> [-109,109]
            final int maxValue = random.nextInt(110);
            // target -> [-109,109]
            final int target = random.nextInt(110) * (random.nextInt() > 0.5 ? 1 : -1);
            final int[] arrayWithNonDecreasing = MathRandomUtil.createRandomArrayWithNonDecreasing(length, maxValue);
            int[] searchRange = lc34SearchRange.searchRange(arrayWithNonDecreasing, target);
            int[] searchRangeV2 = lc34SearchRange.searchRangeV2(arrayWithNonDecreasing, target);
            Assert.assertArrayEquals(searchRange, searchRangeV2);
        }
    }

}
