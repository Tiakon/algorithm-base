package cn.tiakon.java.leetcode.linked;

import cn.tiakon.java.leetcode.datastructure.ListNode;
import org.junit.Assert;
import org.junit.Test;

public class LC1290ConvertBinaryNumberInLinkedToIntegerTest {
    @Test
    public void case01Test() {
        LC1290ConvertBinaryNumberInLinkedToInteger binaryNumberInLinkedToInteger = new LC1290ConvertBinaryNumberInLinkedToInteger();
        ListNode<Integer> node1 = new ListNode<>(1);
        ListNode<Integer> node2 = new ListNode<>(0, node1);
        ListNode<Integer> node3 = new ListNode<>(1, node2);
        int ans = binaryNumberInLinkedToInteger.getDecimalValue(node3);
        Assert.assertEquals(5, ans);

        // [1,0,0,1,0,0,1,1,1,0,0,0,0,0,0]
        ListNode<Integer> node15 = new ListNode<>(0);
        ListNode<Integer> node14 = new ListNode<>(0, node15);
        ListNode<Integer> node13 = new ListNode<>(0, node14);
        ListNode<Integer> node12 = new ListNode<>(0, node13);
        ListNode<Integer> node11 = new ListNode<>(0, node12);
        ListNode<Integer> node10 = new ListNode<>(0, node11);
        ListNode<Integer> node9 = new ListNode<>(1, node10);
        ListNode<Integer> node8 = new ListNode<>(1, node9);
        ListNode<Integer> node7 = new ListNode<>(1, node8);
        ListNode<Integer> node6 = new ListNode<>(0, node7);
        ListNode<Integer> node5 = new ListNode<>(0, node6);
        ListNode<Integer> node4 = new ListNode<>(1, node5);
        node3 = new ListNode<>(0, node4);
        node2 = new ListNode<>(0, node3);
        node1 = new ListNode<>(1, node2);
        ans = binaryNumberInLinkedToInteger.getDecimalValue(node1);
        Assert.assertEquals(18880, ans);
    }

    @Test
    public void case02Test() {
        Assert.assertEquals(1, 1 << 0);
        Assert.assertEquals(2, 1 << 1);
        Assert.assertEquals(4, 1 << 2);
    }
}
