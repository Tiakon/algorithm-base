package cn.tiakon.java.leetcode.array;

import org.junit.Assert;
import org.junit.Test;

public class LC1460ReversingSubArraysTest {

    @Test
    public void canBeEqualTest() {
        final LC1460ReversingSubArrays lc1460ReversingSubArrays = new LC1460ReversingSubArrays();
        int[] target = new int[]{1, 2, 3, 4};
        int[] arr = new int[]{2, 4, 1, 3};
        Assert.assertTrue(lc1460ReversingSubArrays.canBeEqual(target, arr));

        target = new int[]{7};
        arr = new int[]{7};
        Assert.assertTrue(lc1460ReversingSubArrays.canBeEqual(target, arr));

        target = new int[]{3, 7, 9};
        arr = new int[]{3, 7, 11};
        Assert.assertFalse(lc1460ReversingSubArrays.canBeEqual(target, arr));

        target = new int[]{1, 2, 2, 3};
        arr = new int[]{1, 1, 2, 3};
        Assert.assertFalse(lc1460ReversingSubArrays.canBeEqual(target, arr));

        target = new int[]{172};
        arr = new int[]{84};
        Assert.assertFalse(lc1460ReversingSubArrays.canBeEqual(target, arr));
    }

    @Test
    public void canBeEqualV2Test() {
        final LC1460ReversingSubArrays lc1460ReversingSubArrays = new LC1460ReversingSubArrays();
        int[] target = new int[]{1, 2, 3, 4};
        int[] arr = new int[]{2, 4, 1, 3};
        Assert.assertTrue(lc1460ReversingSubArrays.canBeEqualV2(target, arr));

        target = new int[]{7};
        arr = new int[]{7};
        Assert.assertTrue(lc1460ReversingSubArrays.canBeEqualV2(target, arr));

        target = new int[]{3, 7, 9};
        arr = new int[]{3, 7, 11};
        Assert.assertFalse(lc1460ReversingSubArrays.canBeEqualV2(target, arr));

        target = new int[]{1, 2, 2, 3};
        arr = new int[]{1, 1, 2, 3};
        Assert.assertFalse(lc1460ReversingSubArrays.canBeEqualV2(target, arr));

        target = new int[]{172};
        arr = new int[]{84};
        Assert.assertFalse(lc1460ReversingSubArrays.canBeEqualV2(target, arr));

        target = new int[]{1, 1, 1, 1, 1};
        arr = new int[]{1, 1, 1, 1, 1};
        Assert.assertTrue(lc1460ReversingSubArrays.canBeEqualV2(target, arr));

        target = new int[]{5, 5, 2, 2};
        arr = new int[]{6, 6, 1, 1};
        Assert.assertFalse(lc1460ReversingSubArrays.canBeEqualV2(target, arr));
    }

    @Test
    public void canBeEqualV3Test() {
        final LC1460ReversingSubArrays lc1460ReversingSubArrays = new LC1460ReversingSubArrays();
        int[] target = new int[]{1, 2, 3, 4};
        int[] arr = new int[]{2, 4, 1, 3};
        Assert.assertTrue(lc1460ReversingSubArrays.canBeEqualV3(target, arr));

        target = new int[]{7};
        arr = new int[]{7};
        Assert.assertTrue(lc1460ReversingSubArrays.canBeEqualV3(target, arr));

        target = new int[]{3, 7, 9};
        arr = new int[]{3, 7, 11};
        Assert.assertFalse(lc1460ReversingSubArrays.canBeEqualV3(target, arr));

        target = new int[]{1, 2, 2, 3};
        arr = new int[]{1, 1, 2, 3};
        Assert.assertFalse(lc1460ReversingSubArrays.canBeEqualV3(target, arr));

        target = new int[]{172};
        arr = new int[]{84};
        Assert.assertFalse(lc1460ReversingSubArrays.canBeEqualV3(target, arr));

        target = new int[]{1, 1, 1, 1, 1};
        arr = new int[]{1, 1, 1, 1, 1};
        Assert.assertTrue(lc1460ReversingSubArrays.canBeEqualV3(target, arr));

        target = new int[]{5, 5, 2, 2};
        arr = new int[]{6, 6, 1, 1};
        Assert.assertFalse(lc1460ReversingSubArrays.canBeEqualV3(target, arr));
    }

}
