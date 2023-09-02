package cn.tiakon.java.leetcode.simple;

import cn.tiakon.java.utils.MathRandomUtil;
import org.junit.Assert;
import org.junit.Test;

import java.util.Random;

public class LC1413MinStartValueTest {
    @Test
    public void minStartValueTest() {
        final LC1413MinStartValue lc1413MinStartValue = new LC1413MinStartValue();
        int[] nums = new int[]{-3, 2, -3, 4, 2};
        int minStartValue = lc1413MinStartValue.minStartValue(nums);
        Assert.assertEquals(5, minStartValue);
        nums = new int[]{1, 2};
        minStartValue = lc1413MinStartValue.minStartValue(nums);
        Assert.assertEquals(1, minStartValue);
        nums = new int[]{1, -2, -3};
        minStartValue = lc1413MinStartValue.minStartValue(nums);
        Assert.assertEquals(5, minStartValue);
    }

    @Test
    public void minStartValueBenchmarkTest() {
        final LC1413MinStartValue lc1413MinStartValue = new LC1413MinStartValue();
        final Random random = new Random();
        for (int i = 0; i < 10000; i++) {
            // length -> [1,100]
            int length = random.nextInt(100) + 1;
            // maxValue -> [-100,100]
            int maxValue = random.nextInt(101);
            final int[] nums = MathRandomUtil.createRandomArray(length, maxValue);
            final int minStartValue = lc1413MinStartValue.minStartValue(nums);
            final int minStartValueV2 = lc1413MinStartValue.minStartValueV2(nums);
            Assert.assertEquals(minStartValue, minStartValueV2);
        }
    }
}