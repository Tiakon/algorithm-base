package cn.tiakon.java.leetcode.linked;

import cn.tiakon.java.leetcode.datastructure.ListNode;
import org.junit.Test;

public class LC725SplitLinkedListInPartsTest {
    @Test
    public void case01Test() {
        final LC725SplitLinkedListInParts splitLinkedListInParts = new LC725SplitLinkedListInParts();
        int k = 3;
        final ListNode node10 = new ListNode<>(10);
        final ListNode node9 = new ListNode<>(9, node10);
        final ListNode node8 = new ListNode<>(8, node9);
        final ListNode node7 = new ListNode<>(7, node8);
        final ListNode node6 = new ListNode<>(6, node7);
        final ListNode node5 = new ListNode<>(5, node6);
        final ListNode node4 = new ListNode<>(4, node5);
        final ListNode node3 = new ListNode<>(3, node4);
        final ListNode node2 = new ListNode<>(2, node3);
        final ListNode node1 = new ListNode<>(1, node2);

        final ListNode[] listNodes = splitLinkedListInParts.splitListToParts(node1, k);

        for (int i = 0; i < listNodes.length; i++) {
            System.out.println(listNodes[i]);
        }
    }

    @Test
    public void case02Test() {
        final LC725SplitLinkedListInParts splitLinkedListInParts = new LC725SplitLinkedListInParts();
        int k = 3;
        final ListNode node7 = new ListNode<>(7);
        final ListNode node6 = new ListNode<>(6, node7);
        final ListNode node5 = new ListNode<>(5, node6);
        final ListNode node4 = new ListNode<>(4, node5);
        final ListNode node3 = new ListNode<>(3, node4);
        final ListNode node2 = new ListNode<>(2, node3);
        final ListNode node1 = new ListNode<>(1, node2);

        final ListNode[] listNodes = splitLinkedListInParts.splitListToParts(node1, k);

        for (int i = 0; i < listNodes.length; i++) {
            System.out.println(listNodes[i]);
        }
    }

    @Test
    public void case03Test() {
        final LC725SplitLinkedListInParts splitLinkedListInParts = new LC725SplitLinkedListInParts();
        int k = 3;
        final ListNode node8 = new ListNode<>(8);
        final ListNode node7 = new ListNode<>(7, node8);
        final ListNode node6 = new ListNode<>(6, node7);
        final ListNode node5 = new ListNode<>(5, node6);
        final ListNode node4 = new ListNode<>(4, node5);
        final ListNode node3 = new ListNode<>(3, node4);
        final ListNode node2 = new ListNode<>(2, node3);
        final ListNode node1 = new ListNode<>(1, node2);

        final ListNode[] listNodes = splitLinkedListInParts.splitListToParts(node1, k);

        for (int i = 0; i < listNodes.length; i++) {
            System.out.println(listNodes[i]);
        }
    }

    @Test
    public void case04Test() {
        final LC725SplitLinkedListInParts splitLinkedListInParts = new LC725SplitLinkedListInParts();
        int k = 5;
        final ListNode node3 = new ListNode<>(3);
        final ListNode node2 = new ListNode<>(2, node3);
        final ListNode node1 = new ListNode<>(1, node2);
        final ListNode[] listNodes = splitLinkedListInParts.splitListToParts(node1, k);
        for (int i = 0; i < listNodes.length; i++) {
            System.out.println(listNodes[i]);
        }
    }

}
