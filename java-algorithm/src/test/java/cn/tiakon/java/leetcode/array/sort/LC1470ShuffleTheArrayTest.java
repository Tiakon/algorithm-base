package cn.tiakon.java.leetcode.array.sort;

import cn.tiakon.java.utils.MathRandomUtil;
import org.junit.Assert;
import org.junit.Test;

public class LC1470ShuffleTheArrayTest {
    @Test
    public void shuffleTest() {
        final LC1470ShuffleTheArray lc1470ShuffleTheArray = new LC1470ShuffleTheArray();

        int[] nums = new int[]{2, 5, 1, 3, 4, 7};
        int[] shuffle = lc1470ShuffleTheArray.shuffle(nums, 3);
        Assert.assertArrayEquals(new int[]{2, 3, 5, 4, 1, 7}, shuffle);

        nums = new int[]{1, 2, 3, 4, 4, 3, 2, 1};
        shuffle = lc1470ShuffleTheArray.shuffle(nums, 4);
        Assert.assertArrayEquals(new int[]{1, 4, 2, 3, 3, 2, 4, 1}, shuffle);

        nums = new int[]{1, 1, 2, 2};
        shuffle = lc1470ShuffleTheArray.shuffle(nums, 2);
        Assert.assertArrayEquals(new int[]{1, 2, 1, 2}, shuffle);
    }

    @Test
    public void shuffleV2Test() {
        final LC1470ShuffleTheArray lc1470ShuffleTheArray = new LC1470ShuffleTheArray();

        int[] nums = new int[]{2, 5, 1, 3, 4, 7};
        int[] shuffle = lc1470ShuffleTheArray.shuffleV2(nums, 3);
        MathRandomUtil.printArray(shuffle);
        Assert.assertArrayEquals(new int[]{2, 3, 5, 4, 1, 7}, shuffle);

        nums = new int[]{1, 1, 2, 2};
        shuffle = lc1470ShuffleTheArray.shuffleV2(nums, 2);
        MathRandomUtil.printArray(shuffle);
        Assert.assertArrayEquals(new int[]{1, 2, 1, 2}, shuffle);

        nums = new int[]{1, 2, 3, 4, 4, 3, 2, 1};
        shuffle = lc1470ShuffleTheArray.shuffleV2(nums, 4);
        MathRandomUtil.printArray(shuffle);
        Assert.assertArrayEquals(new int[]{1, 4, 2, 3, 3, 2, 4, 1}, shuffle);
    }
}
