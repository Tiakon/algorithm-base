package cn.tiakon.java.leetcode.math;

import org.junit.Assert;
import org.junit.Test;

/**
 *
 * <a href="https://leetcode.cn/problems/sum-of-square-numbers/">633. 平方数之和</a>
 *
 * @author tiankai.me@gmail.com on 2022/12/7 下午4:17.
 */
public class LC633SumOfSquareNumbers {
    // 临界情况a*a超出了int范围，被计算机识别为一个负数，从而c > a*a永远为True，进入死循环，提交会显示超时。
    // int a=46341; System.out.println(a*a); 结果是一个负数。
    // 枚举法
    public boolean judgeSquareSum(int c) {
        for (long a = 0; a * a <= c; a++) {
            double b = Math.sqrt(c - a * a);
            if (b == (int) b) return true;
        }
        return false;
    }

    // 双指针
    public boolean judgeSquareSumV2(int c) {
        long left = 0;
        long right = (long) Math.sqrt(c);
        while (left <= right) {
            long sum = left * left + right * right;
            if (sum == c) return true;
            else if (sum > c) right--;
            else left++;
        }
        return false;
    }

    @Test
    public void judgeSquareSumTest() {
        LC633SumOfSquareNumbers lc633SumOfSquareNumbers = new LC633SumOfSquareNumbers();
        Assert.assertTrue(lc633SumOfSquareNumbers.judgeSquareSum(0));
        Assert.assertTrue(lc633SumOfSquareNumbers.judgeSquareSum(0));
        Assert.assertFalse(lc633SumOfSquareNumbers.judgeSquareSum(11));
        Assert.assertFalse(lc633SumOfSquareNumbers.judgeSquareSum(999999999));
        Assert.assertFalse(lc633SumOfSquareNumbers.judgeSquareSum(2147483646));
    }

}
