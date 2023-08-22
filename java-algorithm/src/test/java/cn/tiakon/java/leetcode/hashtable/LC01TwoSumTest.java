package cn.tiakon.java.leetcode.hashtable;

import cn.tiakon.java.utils.MathRandomUtil;
import org.junit.Assert;
import org.junit.Test;

public class LC01TwoSumTest {
    @Test
    public void twoSumTest() {
        final LC01TwoSum lc01TwoSum = new LC01TwoSum();
        int[] arr = {2, 7, 11, 15};
        int target = 9;
        int[] twoSum = lc01TwoSum.twoSum(arr, target);
        MathRandomUtil.printArray(twoSum);
        Assert.assertArrayEquals(new int[]{0, 1}, twoSum);

        arr = new int[]{3, 2, 4};
        target = 6;
        twoSum = lc01TwoSum.twoSum(arr, target);
        MathRandomUtil.printArray(twoSum);
        Assert.assertArrayEquals(new int[]{1, 2}, twoSum);


        arr = new int[]{2, 5, 5, 11};
        target = 10;
        twoSum = lc01TwoSum.twoSum(arr, target);
        MathRandomUtil.printArray(twoSum);
        Assert.assertArrayEquals(new int[]{1, 2}, twoSum);

        arr = new int[]{3, 3};
        target = 6;
        twoSum = lc01TwoSum.twoSum(arr, target);
        MathRandomUtil.printArray(twoSum);
        Assert.assertArrayEquals(new int[]{0, 1}, twoSum);

        arr = new int[]{1, 1, 1, 1, 1, 4, 1, 1, 1, 1, 1, 7, 1, 1, 1, 1, 1};
        target = 11;
        twoSum = lc01TwoSum.twoSum(arr, target);
        MathRandomUtil.printArray(twoSum);
        Assert.assertArrayEquals(new int[]{5, 11}, twoSum);
    }

}
