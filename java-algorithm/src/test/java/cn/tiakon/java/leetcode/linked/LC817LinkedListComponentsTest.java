package cn.tiakon.java.leetcode.linked;

import cn.tiakon.java.leetcode.datastructure.ListNode;
import org.junit.Assert;
import org.junit.Test;

public class LC817LinkedListComponentsTest {
    @Test
    public void case01Test() {
        final LC817LinkedListComponents linkedListComponents = new LC817LinkedListComponents();
        ListNode node3 = new ListNode(3);
        ListNode node2 = new ListNode(2, node3);
        ListNode node1 = new ListNode(1, node2);
        ListNode node = new ListNode(0, node1);
        int[] nums = new int[]{0, 1, 3};
        int ans = linkedListComponents.numComponents(node, nums);
        Assert.assertEquals(2, ans);
    }

    @Test
    public void case02Test() {
        final LC817LinkedListComponents linkedListComponents = new LC817LinkedListComponents();
        ListNode node4 = new ListNode(4);
        ListNode node3 = new ListNode(3, node4);
        ListNode node2 = new ListNode(2, node3);
        ListNode node1 = new ListNode(1, node2);
        ListNode node = new ListNode(0, node1);
        int[] nums = new int[]{0, 3, 1, 4};
        int ans = linkedListComponents.numComponents(node, nums);
        Assert.assertEquals(2, ans);
    }

    @Test
    public void case03Test() {
        final LC817LinkedListComponents linkedListComponents = new LC817LinkedListComponents();
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4, node3);
        ListNode node = new ListNode(0, node4);
        ListNode node1 = new ListNode(1, node);
        ListNode node2 = new ListNode(2, node1);
        ListNode node5 = new ListNode(5, node2);
        int[] nums = new int[]{0, 3, 1, 4};
        int ans = linkedListComponents.numComponents(node5, nums);
        Assert.assertEquals(1, ans);
    }

}
