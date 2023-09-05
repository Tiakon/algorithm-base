package cn.tiakon.java.leetcode.math;

import org.junit.Assert;
import org.junit.Test;

/**
 * 50. Pow(x, n)
 * https://leetcode.cn/problems/powx-n
 *
 * @author tiankai.me@gmail.com on 2023-09-01 23:42.
 */
public class LC50PowXN {
    public double myPow(double x, int n) {
        if (n == 0) return 1;
        if (x == 1d || x == -1d) return n % 2 == 0 ? Math.abs(x) : x;
        double ans = x;
        int count = Math.abs(n);
        if (n == Integer.MIN_VALUE) count = Integer.MAX_VALUE;
        for (int i = 1; i < count; i++) {
            ans *= x;
        }
        if (n == Integer.MIN_VALUE) ans *= x;
        if (n < 0) ans = 1 / ans;
        return ans;
    }

    /**
     * 快速幂 + 递归
     * 「快速幂算法」的本质是分治算法。
     * 复杂度分析:
     * 时间复杂度： O(logn)，即为递归的层数。
     * 空间复杂度： O(logn)，即为递归的层数。这是由于递归的函数调用会使用栈空间。
     *
     * @author tiankai.me@gmail.com on 2023-09-03 10:12.
     */
    public double myPowV2(double x, int n) {
        long N = n;  // 将int转换成long,来避免溢出。
        return N >= 0 ? quickMul(x, N) : 1.0 / quickMul(x, -N);
    }

    public double quickMul(double x, long N) {
        if (N == 0) return 1.0;
        double y = quickMul(x, N / 2);
        return N % 2 == 0 ? y * y : y * y * x;
    }

}