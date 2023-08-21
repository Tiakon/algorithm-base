package cn.tiakon.java.leetcode.array.doublepointer;

import cn.tiakon.java.utils.MathRandomUtil;
import org.junit.Assert;
import org.junit.Test;

import java.util.Random;

public class LC283MoveZeroesTest {

    @Test
    public void moveZeroesTest() {
        final LC283MoveZeroes lc283MoveZeroes = new LC283MoveZeroes();
        int[] nums = new int[]{0, 1, 0, 3, 12};
        int[] ans1 = lc283MoveZeroes.moveZeroes(nums);
        Assert.assertArrayEquals(new int[]{1, 3, 12, 0, 0}, ans1);

        nums = new int[]{0};
        ans1 = lc283MoveZeroes.moveZeroes(nums);
        Assert.assertArrayEquals(new int[]{0}, ans1);
    }

    @Test
    public void moveZeroesV2Test() {
        final LC283MoveZeroes lc283MoveZeroes = new LC283MoveZeroes();
        int[] nums = new int[]{0, 1, 0, 3, 12};
        int[] ans1 = lc283MoveZeroes.moveZeroesV2(nums);
        Assert.assertArrayEquals(new int[]{1, 3, 12, 0, 0}, ans1);

        nums = new int[]{0};
        ans1 = lc283MoveZeroes.moveZeroesV2(nums);
        Assert.assertArrayEquals(new int[]{0}, ans1);
    }

    @Test
    public void moveZeroesV3Test() {
        final LC283MoveZeroes lc283MoveZeroes = new LC283MoveZeroes();
        int[] nums = new int[]{0, 1, 0, 3, 12};
        int[] ans1 = lc283MoveZeroes.moveZeroesV3(nums);
        Assert.assertArrayEquals(new int[]{1, 3, 12, 0, 0}, ans1);

        nums = new int[]{0};
        ans1 = lc283MoveZeroes.moveZeroesV3(nums);
        Assert.assertArrayEquals(new int[]{0}, ans1);
    }

    @Test
    public void moveZeroesBenchmarkTest() {
        final LC283MoveZeroes lc283MoveZeroes = new LC283MoveZeroes();
        final Random random = new Random();
        for (int i = 0; i < 1000; i++) {
            // length -> [1,1000]
            int length = random.nextInt(1000) + 1;
            // maxValue -> [-MAX_VALUE,MAX_VALUE]
            int maxValue = random.nextInt(Integer.MAX_VALUE);
            final int[] nums = MathRandomUtil.createRandomArray(length, maxValue);
            final int[] ans1 = lc283MoveZeroes.moveZeroes(nums);
            final int[] ans2 = lc283MoveZeroes.moveZeroesV2(nums);
            Assert.assertArrayEquals(ans1, ans2);
        }
    }

}
