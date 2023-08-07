package cn.tiakon.java.leetcode.dp;

import org.junit.Assert;
import org.junit.Test;

/**
 * <a href="https://leetcode.cn/problems/fibonacci-number">509. 斐波那契数</a>
 *
 * @author tiankai.me@gmail.com on 2022/12/21 下午10:44.
 */
public class LC509FibonacciNumber {
    /**
     * 递归法
     * 时间复杂度:O(n^2)
     * 空间复杂度:O(n)，不论总递归次数为多少，总递归深度为 n
     * @author tiankai.me@gmail.com on 2022/12/21 下午11:24.
     */
    public static int fib(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        return fib(n - 1) + fib(n - 2);
    }

    /**
     * 动态规划,利用滚动数组解决
     * 由于斐波那契数存在递推关系，因此可以使用动态规划求解。动态规划的状态转移方程即为上述递推关系，边界条件为 F(0)F(0) 和 F(1)F(1)。
     * 复杂度分析:
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     * @author tiankai.me@gmail.com on 2022/12/21 下午11:18.
     */
    public int fibWithDP(int n) {
        if (n < 2) return n;
        int n1 = 0, n2 = 0, ans = 1;
        for (int i = 2; i <= n; ++i) {
            n1 = n2;
            n2 = ans;
            ans = n1 + n2;
        }
        return ans;
    }


    @Test
    public void fibTest() {
        Assert.assertEquals(5, fib(5));
        Assert.assertEquals(3, fib(4));
        Assert.assertEquals(2, fib(3));
        Assert.assertEquals(1, fib(1));
        Assert.assertEquals(0, fib(0));
    }

}
