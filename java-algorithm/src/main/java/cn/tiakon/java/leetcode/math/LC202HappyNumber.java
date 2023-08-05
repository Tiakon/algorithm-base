package cn.tiakon.java.leetcode.math;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * 202. 快乐数
 * https://leetcode.cn/problems/happy-number/
 *
 * @author tiankai.me@gmail.com on 2022/11/9 下午3:35.
 */
public class LC202HappyNumber {
    public boolean isHappy(int n) {
        Set<Integer> hashSet = new HashSet<>();
        while (n != 1) {
            int powSum = getPowSum(n);
            if (!hashSet.contains(powSum)) hashSet.add(powSum);
            else return false;
            n = powSum;
        }
        return true;
    }

    // 得到数字n各个位置平方和
    public int getPowSum(int n) {
        int powSum = 0;
        while (n > 0) {
            int powN = (n % 10) * (n % 10);
            powSum += powN;
            n = n / 10;
        }
        return powSum;
    }

    public int getNext(int n) {
        int totalSum = 0;
        while (n > 0) {
            int d = n % 10;
            n = n / 10;
            totalSum += d * d;
        }
        return totalSum;
    }

    public boolean isHappyV2(int n) {
        int slowRunner = n;
        int fastRunner = getNext(n);
        while (fastRunner != 1 && slowRunner != fastRunner) {
            slowRunner = getNext(slowRunner);
            fastRunner = getNext(getNext(fastRunner));
        }
        return fastRunner == 1;
    }


    @Test
    public void getPowSumTest() {
        LC202HappyNumber happyNumber = new LC202HappyNumber();
        Assert.assertEquals(4, happyNumber.getPowSum(2));
        Assert.assertEquals(16, happyNumber.getPowSum(4));
        Assert.assertEquals(37, happyNumber.getPowSum(16));
        Assert.assertEquals(58, happyNumber.getPowSum(37));
        Assert.assertEquals(89, happyNumber.getPowSum(58));
        Assert.assertEquals(145, happyNumber.getPowSum(89));
    }

    @Test
    public void isHappyTest() {
        LC202HappyNumber happyNumber = new LC202HappyNumber();
        Assert.assertFalse(happyNumber.isHappy(2));
        Assert.assertFalse(happyNumber.isHappy(4));
        Assert.assertTrue(happyNumber.isHappy(10));
        Assert.assertTrue(happyNumber.isHappy(19));
    }

}
