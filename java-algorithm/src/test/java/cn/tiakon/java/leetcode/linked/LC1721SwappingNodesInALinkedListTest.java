package cn.tiakon.java.leetcode.linked;

import cn.tiakon.java.leetcode.datastructure.ListNode;
import cn.tiakon.java.utils.MathRandomUtil;
import org.junit.Test;

public class LC1721SwappingNodesInALinkedListTest {
    @Test
    public void case01Test() {
        LC1721SwappingNodesInALinkedList swappingNodesInALinkedList = new LC1721SwappingNodesInALinkedList();
        final ListNode node5 = new ListNode(5);
        final ListNode node4 = new ListNode(4, node5);
        final ListNode node3 = new ListNode(3, node4);
        final ListNode node2 = new ListNode(2, node3);
        final ListNode node1 = new ListNode(1, node2);
        int k = 2;
        ListNode ans = swappingNodesInALinkedList.swapNodes(node1, k);
        MathRandomUtil.printListNode(ans);
    }

    @Test
    public void case02Test() {
        LC1721SwappingNodesInALinkedList swappingNodesInALinkedList = new LC1721SwappingNodesInALinkedList();
        ListNode node1 = new ListNode(1);
        int k = 1;
        ListNode ans = swappingNodesInALinkedList.swapNodes(node1, k);
        MathRandomUtil.printListNode(ans);
    }

    @Test
    public void case03Test() {
        LC1721SwappingNodesInALinkedList swappingNodesInALinkedList = new LC1721SwappingNodesInALinkedList();
        ListNode node10 = new ListNode(10);
        ListNode node9 = new ListNode(9,node10);
        ListNode node8 = new ListNode(8,node9);
        ListNode node7 = new ListNode(7,node8);
        ListNode node6 = new ListNode(6,node7);
        ListNode node5 = new ListNode(5,node6);
        ListNode node4 = new ListNode(4, node5);
        ListNode node3 = new ListNode(3, node4);
        ListNode node2 = new ListNode(2, node3);
        ListNode node1 = new ListNode(1, node2);
        int k = 5;
        ListNode ans = swappingNodesInALinkedList.swapNodes(node1, k);
        MathRandomUtil.printListNode(ans);
    }

}
