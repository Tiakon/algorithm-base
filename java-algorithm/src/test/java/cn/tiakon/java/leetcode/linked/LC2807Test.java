package cn.tiakon.java.leetcode.linked;

import cn.tiakon.java.leetcode.datastructure.ListNode;
import cn.tiakon.java.utils.MathRandomUtil;
import org.junit.Assert;
import org.junit.Test;

public class LC2807Test {
    @Test
    public void case01Test() {
        final LC2807 lc2807 = new LC2807();
        int ans = lc2807.getGreatestCommonDivisors(18, 6);
        Assert.assertEquals(6, ans);
        ans = lc2807.getGreatestCommonDivisors(17, 6);
        Assert.assertEquals(1, ans);
        ans = lc2807.getGreatestCommonDivisors(15, 6);
        Assert.assertEquals(3, ans);
        ans = lc2807.getGreatestCommonDivisors(150, 600);
        Assert.assertEquals(150, ans);
        ans = lc2807.getGreatestCommonDivisors(150, 603);
        Assert.assertEquals(3, ans);
        ans = lc2807.getGreatestCommonDivisors(150, 601);
        Assert.assertEquals(1, ans);
    }

    @Test
    public void case02Test() {
        final LC2807 lc2807 = new LC2807();
        int ans = lc2807.gcd(18, 6);
        Assert.assertEquals(6, ans);
        ans = lc2807.gcd(17, 6);
        Assert.assertEquals(1, ans);
        ans = lc2807.gcd(15, 6);
        Assert.assertEquals(3, ans);
        ans = lc2807.gcd(150, 600);
        Assert.assertEquals(150, ans);
        ans = lc2807.gcd(150, 603);
        Assert.assertEquals(3, ans);
        ans = lc2807.gcd(150, 601);
        Assert.assertEquals(1, ans);
    }

    @Test
    public void case03Test() {
        final LC2807 lc2807 = new LC2807();
        final ListNode node3 = new ListNode(3);
        final ListNode node10 = new ListNode(10, node3);
        final ListNode node6 = new ListNode(6, node10);
        final ListNode node18 = new ListNode(18, node6);
        final ListNode ans = lc2807.insertGreatestCommonDivisors(node18);
        MathRandomUtil.printListNode(ans);
    }
}
