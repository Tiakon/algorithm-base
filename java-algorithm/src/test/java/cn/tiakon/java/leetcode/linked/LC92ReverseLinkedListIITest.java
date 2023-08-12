package cn.tiakon.java.leetcode.linked;

import cn.tiakon.java.leetcode.datastructure.ListNode;
import org.junit.Test;

public class LC92ReverseLinkedListIITest {
    @Test
    public void case01Test() {
        LC92ReverseLinkedListII reverseLinkedListII = new LC92ReverseLinkedListII();
        ListNode node8 = new ListNode(8);
        ListNode node7 = new ListNode(7, node8);
        ListNode node6 = new ListNode(6, node7);
        ListNode node5 = new ListNode(5, node6);
        ListNode node4 = new ListNode(4, node5);
        ListNode node3 = new ListNode(3, node4);
        ListNode node2 = new ListNode(2, node3);
        ListNode node1 = new ListNode(1, node2);

        int left = 2, right = 6;
        ListNode ans = reverseLinkedListII.reverseBetween(node1, left, right);
        System.out.println(ans);
    }

    @Test
    public void case02Test() {
        LC92ReverseLinkedListII reverseLinkedListII = new LC92ReverseLinkedListII();
        ListNode node5 = new ListNode(5);
        ListNode node4 = new ListNode(4, node5);
        ListNode node3 = new ListNode(3, node4);
        ListNode node2 = new ListNode(2, node3);
        ListNode node1 = new ListNode(1, node2);
        int left = 2, right = 4;
        ListNode ans = reverseLinkedListII.reverseBetween(node1, left, right);
        System.out.println(ans);
    }

    @Test
    public void case03Test() {
        LC92ReverseLinkedListII reverseLinkedListII = new LC92ReverseLinkedListII();
        ListNode node5 = new ListNode(5);
        ListNode node4 = new ListNode(4, node5);
        ListNode node3 = new ListNode(3, node4);
        ListNode node2 = new ListNode(2, node3);
        ListNode node1 = new ListNode(1, node2);
        int left = 2, right = 3;
        ListNode ans = reverseLinkedListII.reverseBetween(node1, left, right);
        System.out.println(ans);
    }

    @Test
    public void case04Test() {
        LC92ReverseLinkedListII reverseLinkedListII = new LC92ReverseLinkedListII();
        ListNode node2 = new ListNode(2);
        ListNode node1 = new ListNode(1, node2);
        int left = 1, right = 2;
        ListNode ans = reverseLinkedListII.reverseBetween(node1, left, right);
        System.out.println(ans);
    }
}
