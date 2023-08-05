package cn.tiakon.java.leetcode.math;

import org.junit.Assert;
import org.junit.Test;

/**
 * 1523. 在区间范围内统计奇数数目
 * https://leetcode.cn/problems/count-odd-numbers-in-an-interval-range
 *
 * @author tiankai.me@gmail.com on 2022/11/3 下午2:35.
 */
public class LC1523CountOddNumbersIntervalRange {
    public int countOddsV1(int low, int high) {
        if (low == high) return low % 2 != 0 ? 1 : 0;
        int ans;
        if (low % 2 != 0 && high % 2 != 0) ans = (high - low - 2) / 2 + 2;
        else if (low % 2 == 0 && high % 2 == 0) ans = (high - low) / 2;
        else ans = (high - low) / 2 + 1;
        return ans;
    }

    // 前缀和思想
    public int countOdds(int low, int high) {
        // 先算出 [0,high]中的奇数数目.
        // 再算出 [0,low-1]中奇数的数目.
        // 二者相减集就可以得到[low,high]区间的奇数数目.
        return pre(high) - pre(low - 1);
    }
    // 得到在区间 [0, x] 中奇数的个数;无论x奇偶,奇数的个数都是正确的. +1 则包含了右边界
    public int pre(int x) {
        return (x + 1) >> 1;
    }

    @Test
    public void countOddsTest() {
        LC1523CountOddNumbersIntervalRange lc1523CountOddNumbersIntervalRange = new LC1523CountOddNumbersIntervalRange();

        int ans = lc1523CountOddNumbersIntervalRange.countOdds(3, 7);
        Assert.assertEquals(3, ans);
    }
}
