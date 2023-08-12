package cn.tiakon.java.leetcode.linked;

import cn.tiakon.java.leetcode.datastructure.NodeV2;
import cn.tiakon.java.leetcode.linked.doubly.LC430FlattenMultilevelDoublyLinkedList;
import org.junit.Test;

public class LC430FlattenMultilevelDoublyLinkedListTest {
    @Test
    public void case01Test() {
        final LC430FlattenMultilevelDoublyLinkedList flattenMultilevelDoublyLinkedList = new LC430FlattenMultilevelDoublyLinkedList();

        final NodeV2 node6 = new NodeV2(6);
        final NodeV2 node5 = new NodeV2(5, node6);
        final NodeV2 node4 = new NodeV2(4, node5);
        final NodeV2 node3 = new NodeV2(3, node4);
        final NodeV2 node2 = new NodeV2(2, node3);
        final NodeV2 node1 = new NodeV2(1, node2);
        node2.prev = node1;
        node3.prev = node2;
        node4.prev = node3;
        node5.prev = node4;
        node6.prev = node5;

        final NodeV2 node10 = new NodeV2(10);
        final NodeV2 node9 = new NodeV2(9, node10);
        final NodeV2 node8 = new NodeV2(8, node9);
        final NodeV2 node7 = new NodeV2(7, node8);
        node3.child = node7;
        node8.prev = node7;
        node9.prev = node8;
        node10.prev = node9;

        final NodeV2 node12 = new NodeV2(12);
        final NodeV2 node11 = new NodeV2(11, node12);
        node8.child = node11;
        node12.prev = node11;

        final NodeV2 ans = flattenMultilevelDoublyLinkedList.flatten(node1);
        System.out.println(ans);
    }

    @Test
    public void case02Test() {
        final LC430FlattenMultilevelDoublyLinkedList flattenMultilevelDoublyLinkedList = new LC430FlattenMultilevelDoublyLinkedList();

        final NodeV2 node3 = new NodeV2(3);
        final NodeV2 node2 = new NodeV2(2);
        final NodeV2 node1 = new NodeV2(1);
        node1.child = node2;
        node2.child = node3;

        final NodeV2 ans = flattenMultilevelDoublyLinkedList.flatten(node1);
        System.out.println(ans);
    }
}
