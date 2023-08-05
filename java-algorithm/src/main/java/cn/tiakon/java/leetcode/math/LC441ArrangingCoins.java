package cn.tiakon.java.leetcode.math;


import org.junit.Assert;
import org.junit.Test;

/**
 * 441. 排列硬币
 * https://leetcode.cn/problems/arranging-coins/
 *
 * @author tiankai.me@gmail.com on 2022/12/7 上午11:59.
 */
public class LC441ArrangingCoins {
    // 求解前n项和的方程组
    public int arrangeCoins(int n) {
        return (int) ((Math.sqrt((long) 8 * n + 1) - 1) / 2);
    }

    public int arrangeCoinsV2(int n) {
        int left = 1, right = n;
        while (left < right) {
            int mid = (right - left + 1) / 2 + left;  // 先加1再除以2是为了让中间值靠右，因为在后序对右边的值处理是 right = mid - 1
            if ((long) mid * (mid + 1) <= (long) 2 * n) left = mid;
            else right = mid - 1;
        }
        return left;
    }

    /**
     * 逆向思维
     * 执行用时： 8 ms , 在所有 Java 提交中击败了 23.60% 的用户
     * 内存消耗： 39.1 MB , 在所有 Java 提交中击败了 16.75% 的用户
     * 通过测试用例： 1335 / 1335
     * @author tiankai.me@gmail.com on 2022/12/7 下午3:13.
     */
    public int arrangeCoinsV3(int n) {
        int res = 0;
        while (n - res > 0)
            n -= ++res;
        return res;
    }

    @Test
    public void arrangeCoinsTest() {
        LC441ArrangingCoins arrangingCoins = new LC441ArrangingCoins();
        Assert.assertEquals(2, arrangingCoins.arrangeCoinsV2(5));
        Assert.assertEquals(3, arrangingCoins.arrangeCoinsV2(9));
        Assert.assertEquals(5, arrangingCoins.arrangeCoinsV2(16));
    }
}
