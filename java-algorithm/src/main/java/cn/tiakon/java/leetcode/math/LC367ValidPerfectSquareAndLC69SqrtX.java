package cn.tiakon.java.leetcode.math;

import org.junit.Assert;
import org.junit.Test;

/**
 * 367. 有效的完全平方数
 * https://leetcode.cn/problems/valid-perfect-square/
 * <p>
 * 69. x 的平方根
 * https://leetcode.cn/problems/sqrtx/
 *
 * @author tiankai.me@gmail.com on 2022/12/5 下午10:47.
 */
public class LC367ValidPerfectSquareAndLC69SqrtX {

    /**
     * 如果一个正整数a是某一个整数b的平方，那么这个正整数a叫做完全平方数。零也可称为完全平方数
     * 执行用时： 0 ms , 在所有 Java 提交中击败了 100.00% 的用户
     * 内存消耗： 38.4 MB , 在所有 Java 提交中击败了 33.74% 的用户
     * 通过测试用例： 70 / 70
     *
     * @author tiankai.me@gmail.com on 2022/12/6 下午2:00.
     */
    public boolean isPerfectSquare(int num) {
        int x = (int) Math.sqrt(num);
        return x * x == num;
    }

    /**
     * 执行用时： 0 ms , 在所有 Java 提交中击败了 100.00% 的用户
     * 内存消耗： 38.7 MB , 在所有 Java 提交中击败了 5.22% 的用户
     * 通过测试用例： 70 / 70
     * <p>
     * 因为 2^31-1=2147483647
     * 46340^2=2147395600
     * 46341^2=2147488281
     * 所以所有32位整数的完全平方数都在 [1,46340] 区间内.
     *
     * @author tiankai.me@gmail.com on 2022/12/6 下午2:08.
     */
    public boolean isPerfectSquareV2(int num) {
        int left = 1, right = 46340;
        while (left <= right) {
            int middle = left + (right - left) / 2;
            if (middle * middle < num) left = middle + 1;
            else if (middle * middle > num) right = middle - 1;
            else return true;
        }
        return false;
    }

    public boolean isPerfectSquareV3(int num) {
        int left = 0, right = num;
        while (left <= right) {
            int mid = (right - left) / 2 + left;
            long square = (long) mid * mid;
            if (square < num) left = mid + 1;
            else if (square > num) right = mid - 1;
            else return true;
        }
        return false;
    }

    @Test
    public void isPerfectSquareTest() {
        LC367ValidPerfectSquareAndLC69SqrtX validPerfectSquare = new LC367ValidPerfectSquareAndLC69SqrtX();
        Assert.assertTrue(validPerfectSquare.isPerfectSquare(1));
        Assert.assertTrue(validPerfectSquare.isPerfectSquare(808201));
        Assert.assertFalse(validPerfectSquare.isPerfectSquare(2147483647));
    }

    /**
     * 如果一个非负数x的平方等于a，那么这个非负数x叫做a的算术平方根
     * <p>
     * 执行用时： 1 ms , 在所有 Java 提交中击败了 93.70% 的用户
     * 内存消耗： 39.2 MB , 在所有 Java 提交中击败了 5.22% 的用户
     * 通过测试用例： 1017 / 1017
     *
     * @author tiankai.me@gmail.com on 2022/12/6 下午3:28.
     */
    public int mySqrt(int x) {
        int left = 0, right = x;
        while (left <= right) {
            int middle = left + (right - left) / 2;
            long temp = (long) middle * middle;
            if (temp < x) left = middle + 1;
            else if (temp > x) right = middle - 1;
            else return middle;
        }
        return right;
    }

}
