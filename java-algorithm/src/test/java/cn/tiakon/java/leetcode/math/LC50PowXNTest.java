package cn.tiakon.java.leetcode.math;

import org.junit.Assert;
import org.junit.Test;

public class LC50PowXNTest {
    @Test
    public void case01Test() {
        LC50PowXN powXN = new LC50PowXN();
        double ans = powXN.myPow(2.0d, 10);
        Assert.assertEquals(1024d, ans, 0);

        ans = powXN.myPow(2.1d, 3);
        Assert.assertEquals(9.261000000000001d, ans, 0);

        ans = powXN.myPow(-1d, Integer.MAX_VALUE);
        Assert.assertEquals(-1.0d, ans, 0);

        ans = powXN.myPow(2.0d, -2);
        Assert.assertEquals(0.25d, ans, 0);

        ans = powXN.myPow(-1d, Integer.MIN_VALUE);
        Assert.assertEquals(1.0d, ans, 0);
    }

    @Test
    public void case02Test() {
        LC50PowXN powXN = new LC50PowXN();
        double ans = powXN.myPow(1.0000000000001d, Integer.MIN_VALUE);
        Assert.assertEquals(0.99979d, ans, 0.00001);
    }

    @Test
    public void case03Test() {
        LC50PowXN powXN = new LC50PowXN();
        double ans = powXN.myPow(2.0d, Integer.MIN_VALUE);
        Assert.assertEquals(0d, ans, 0);
    }

    @Test
    public void case04Test() {
        LC50PowXN powXN = new LC50PowXN();
        double ans = powXN.myPowV2(2.0d, 5);
        Assert.assertEquals(32d, ans, 0);
    }
}
