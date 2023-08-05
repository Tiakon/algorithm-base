package cn.tiakon.java.leetcode.math;

import org.junit.Assert;
import org.junit.Test;

/**
 * 1281. 整数的各位积和之差
 * https://leetcode.cn/problems/subtract-the-product-and-sum-of-digits-of-an-integer/
 *
 * @author tiankai.me@gmail.com on 2022/11/5 下午8:53.
 */
public class LC1281SubtractProductAndSumOfDigitsOfInteger {
    /**
     * 1 <= n <= 10^5
     * @author tiankai.me@gmail.com on 2022/11/5 下午9:01.
     */
    public int subtractProductAndSum(int n) {
        int product = 1;
        int sum = 0;
        while (n > 0) {
            int i = n % 10;
            product *= i;
            sum += i;
            n /= 10;
        }
        return product - sum;
    }

    @Test
    public void subtractProductAndSumTest() {
        LC1281SubtractProductAndSumOfDigitsOfInteger subtractProductAndSumOfDigitsOfInteger = new LC1281SubtractProductAndSumOfDigitsOfInteger();

        int n = 234;
        int ans = subtractProductAndSumOfDigitsOfInteger.subtractProductAndSum(n);
        Assert.assertEquals(15, ans);

        n = 4421;
        ans = subtractProductAndSumOfDigitsOfInteger.subtractProductAndSum(n);
        Assert.assertEquals(21, ans);
    }

}
