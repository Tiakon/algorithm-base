package cn.tiakon.java.leetcode.linked;

import cn.tiakon.java.leetcode.datastructure.ListNode;
import org.junit.Assert;
import org.junit.Test;

public class LC141LinkedListCycleTest {
    @Test
    public void case01Test() {
        final ListNode<Integer> node4 = new ListNode<>(4);
        final ListNode<Integer> node0 = new ListNode<>(0, node4);
        final ListNode<Integer> node2 = new ListNode<>(2, node0);
        final ListNode<Integer> node3 = new ListNode<>(3, node2);
        node4.next = node2;
        final LC141LinkedListCycle linkedListCycle = new LC141LinkedListCycle();
        Assert.assertTrue(linkedListCycle.hasCycle(node3));
    }
}
