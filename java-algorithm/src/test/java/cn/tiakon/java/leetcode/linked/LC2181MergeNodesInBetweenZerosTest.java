package cn.tiakon.java.leetcode.linked;

import cn.tiakon.java.leetcode.datastructure.ListNode;
import cn.tiakon.java.leetcode.linked.remove.LC2181MergeNodesInBetweenZeros;
import cn.tiakon.java.utils.MathRandomUtil;
import org.junit.Test;

public class LC2181MergeNodesInBetweenZerosTest {
    @Test
    public void case01Test() {
        final LC2181MergeNodesInBetweenZeros mergeNodesInBetweenZeros = new LC2181MergeNodesInBetweenZeros();
        ListNode nodeEnd = new ListNode(0);
        ListNode node2 = new ListNode(2, nodeEnd);
        ListNode node5 = new ListNode(5, node2);
        ListNode node4 = new ListNode(4, node5);
        ListNode nodeMid = new ListNode(0, node4);
        ListNode node1 = new ListNode(1, nodeMid);
        ListNode node3 = new ListNode(3, node1);
        ListNode head = new ListNode(0, node3);

        ListNode node = mergeNodesInBetweenZeros.mergeNodesV2(head);
        MathRandomUtil.printListNode(node);
    }

    @Test
    public void case02Test() {
        final LC2181MergeNodesInBetweenZeros mergeNodesInBetweenZeros = new LC2181MergeNodesInBetweenZeros();
        ListNode nodeEnd = new ListNode(0);
        ListNode node2 = new ListNode(2, nodeEnd);
        ListNode node5 = new ListNode(5, node2);
        ListNode node4 = new ListNode(4, node5);
        ListNode nodeMid = new ListNode(0, node4);
        ListNode node1 = new ListNode(1, nodeMid);
        ListNode node3 = new ListNode(3, node1);
        ListNode head = new ListNode(0, node3);

        ListNode node = mergeNodesInBetweenZeros.mergeNodesV3(head);
        MathRandomUtil.printListNode(node);
    }
}
