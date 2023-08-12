package cn.tiakon.java.leetcode.linked;

import cn.tiakon.java.leetcode.datastructure.ListNode;
import org.junit.Test;

public class LC143ReorderListTest {
    @Test
    public void case01Test() {
        final LC143ReorderList reorderList = new LC143ReorderList();
        final ListNode<Integer> node5 = new ListNode<>(5);
        final ListNode<Integer> node4 = new ListNode<>(4, node5);
        final ListNode<Integer> node3 = new ListNode<>(3, node4);
        final ListNode<Integer> node2 = new ListNode<>(2, node3);
        final ListNode<Integer> node = new ListNode<>(1, node2);
        reorderList.reorderList(node);
        System.out.println(node);
    }

    @Test
    public void case02Test() {
        final LC143ReorderList reorderList = new LC143ReorderList();
        final ListNode<Integer> node6 = new ListNode<>(6);
        final ListNode<Integer> node5 = new ListNode<>(5, node6);
        final ListNode<Integer> node4 = new ListNode<>(4, node5);
        final ListNode<Integer> node3 = new ListNode<>(3, node4);
        final ListNode<Integer> node2 = new ListNode<>(2, node3);
        final ListNode<Integer> node = new ListNode<>(1, node2);
        reorderList.reorderList(node);
        System.out.println(node);
    }

    @Test
    public void case03Test() {
        final LC143ReorderList reorderList = new LC143ReorderList();
        final ListNode<Integer> node2 = new ListNode<>(2);
        final ListNode<Integer> node = new ListNode<>(1, node2);
        reorderList.reorderList(node);
        System.out.println(node);
    }

    @Test
    public void case04Test() {
        final LC143ReorderList reorderList = new LC143ReorderList();
        final ListNode<Integer> node6 = new ListNode<>(6);
        final ListNode<Integer> node5 = new ListNode<>(5, node6);
        final ListNode<Integer> node4 = new ListNode<>(4, node5);
        final ListNode<Integer> node3 = new ListNode<>(3, node4);
        final ListNode<Integer> node2 = new ListNode<>(2, node3);
        final ListNode<Integer> node = new ListNode<>(1, node2);
        reorderList.reorderListDeque(node);
        System.out.println(node);
    }
}
