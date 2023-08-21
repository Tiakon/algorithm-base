package cn.tiakon.java.leetcode.array;

import cn.tiakon.java.utils.MathRandomUtil;
import org.junit.Assert;
import org.junit.Test;

public class LC189RotateArrayTest {

    @Test
    public void rotateTest() {
        final LC189RotateArray lc189RotateArray = new LC189RotateArray();
        int[] nums = new int[]{1, 2, 3, 4, 5, 6, 7};
        lc189RotateArray.rotate(nums, 3);
        Assert.assertArrayEquals(new int[]{5, 6, 7, 1, 2, 3, 4}, nums);

        nums = new int[]{-1, -100, 3, 99};
        lc189RotateArray.rotate(nums, 2);
        Assert.assertArrayEquals(new int[]{3, 99, -1, -100}, nums);
    }

    @Test
    public void rotateV2Test() {
        final LC189RotateArray lc189RotateArray = new LC189RotateArray();
        int[] nums = new int[]{1, 2, 3, 4, 5, 6, 7};
        lc189RotateArray.rotateV2(nums, 3);
        Assert.assertArrayEquals(new int[]{5, 6, 7, 1, 2, 3, 4}, nums);

        nums = new int[]{-1, -100, 3, 99};
        lc189RotateArray.rotateV2(nums, 2);
        Assert.assertArrayEquals(new int[]{3, 99, -1, -100}, nums);

        nums = new int[]{-1};
        lc189RotateArray.rotateV2(nums, 2);
        Assert.assertArrayEquals(new int[]{-1}, nums);

        nums = new int[]{1, 2};
        lc189RotateArray.rotateV2(nums, 5);
        Assert.assertArrayEquals(new int[]{2, 1}, nums);
    }

    @Test
    public void rotateV3Test() {
        final LC189RotateArray lc189RotateArray = new LC189RotateArray();
        int[] nums = new int[]{1, 2, 3, 4, 5, 6, 7};
        lc189RotateArray.rotateV3(nums, 3);
        MathRandomUtil.printArray(nums);
        Assert.assertArrayEquals(new int[]{5, 6, 7, 1, 2, 3, 4}, nums);

        nums = new int[]{-1, -100, 3, 99};
        lc189RotateArray.rotateV3(nums, 2);
        MathRandomUtil.printArray(nums);
        Assert.assertArrayEquals(new int[]{3, 99, -1, -100}, nums);

        nums = new int[]{-1};
        lc189RotateArray.rotateV3(nums, 2);
        MathRandomUtil.printArray(nums);
        Assert.assertArrayEquals(new int[]{-1}, nums);

        nums = new int[]{1, 2};
        lc189RotateArray.rotateV3(nums, 5);
        MathRandomUtil.printArray(nums);
        Assert.assertArrayEquals(new int[]{2, 1}, nums);

        nums = new int[]{1, 2, 3, 4, 5, 6};
        lc189RotateArray.rotateV3(nums, 2);
        MathRandomUtil.printArray(nums);
        Assert.assertArrayEquals(new int[]{5, 6, 1, 2, 3, 4}, nums);
    }

}
