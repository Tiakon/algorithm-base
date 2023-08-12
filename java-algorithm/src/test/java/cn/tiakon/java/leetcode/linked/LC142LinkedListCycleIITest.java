package cn.tiakon.java.leetcode.linked;

import cn.tiakon.java.leetcode.datastructure.ListNode;
import org.junit.Assert;
import org.junit.Test;

public class LC142LinkedListCycleIITest {
    @Test
    public void case01Test() {
        final ListNode<Integer> node4 = new ListNode<>(4);
        final ListNode<Integer> node0 = new ListNode<>(0, node4);
        final ListNode<Integer> node2 = new ListNode<>(2, node0);
        final ListNode<Integer> node3 = new ListNode<>(3, node2);
        node4.next = node2;
        final LC142LinkedListCycleII lc142LinkedListCycleII = new LC142LinkedListCycleII();
        Assert.assertEquals(node2, lc142LinkedListCycleII.detectCycle(node3));
    }

}
