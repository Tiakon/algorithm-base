package cn.tiakon.java.leetcode.array.doublepointer;

import org.junit.Assert;
import org.junit.Test;

public class LC6939MaxPairSumInAnArrayTest {

    @Test
    public void case01Test() {
        LC6939MaxPairSumInAnArray maxPairSumInAnArray = new LC6939MaxPairSumInAnArray();
        int[] nums = new int[]{51, 71, 17, 24, 42};
        int ans = maxPairSumInAnArray.maxSum(nums);
        Assert.assertEquals(88, ans);
        nums = new int[]{1, 2, 3, 4};
        ans = maxPairSumInAnArray.maxSum(nums);
        Assert.assertEquals(-1, ans);
        nums = new int[]{31, 25, 72, 79, 74};
        ans = maxPairSumInAnArray.maxSum(nums);
        Assert.assertEquals(146, ans);
    }
}
