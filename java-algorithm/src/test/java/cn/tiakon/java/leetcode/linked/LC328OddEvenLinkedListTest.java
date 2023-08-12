package cn.tiakon.java.leetcode.linked;

import cn.tiakon.java.leetcode.datastructure.ListNode;
import org.junit.Test;

public class LC328OddEvenLinkedListTest {

    @Test
    public void case01Test() {
        final LC328OddEvenLinkedList oddEvenLinkedList = new LC328OddEvenLinkedList();
        final ListNode<Integer> node5 = new ListNode<>(5);
        final ListNode<Integer> node4 = new ListNode<>(4, node5);
        final ListNode<Integer> node3 = new ListNode<>(3, node4);
        final ListNode<Integer> node2 = new ListNode<>(2, node3);
        final ListNode<Integer> node = new ListNode<>(1, node2);
        System.out.println(oddEvenLinkedList.oddEvenList(node));
    }

    @Test
    public void case02Test() {
        final LC328OddEvenLinkedList oddEvenLinkedList = new LC328OddEvenLinkedList();
        final ListNode<Integer> node6 = new ListNode<>(6);
        final ListNode<Integer> node5 = new ListNode<>(5, node6);
        final ListNode<Integer> node4 = new ListNode<>(4, node5);
        final ListNode<Integer> node3 = new ListNode<>(3, node4);
        final ListNode<Integer> node2 = new ListNode<>(2, node3);
        final ListNode<Integer> node = new ListNode<>(1, node2);
        System.out.println(oddEvenLinkedList.oddEvenList(node));
    }
}
