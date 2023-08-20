package cn.tiakon.java.leetcode.linked;

import cn.tiakon.java.leetcode.datastructure.Node;
import cn.tiakon.java.leetcode.linked.doubly.LC430FlattenMultilevelDoublyLinkedList;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class LC430FlattenMultilevelDoublyLinkedListTest {
    LC430FlattenMultilevelDoublyLinkedList flattenMultilevelDoublyLinkedList;

    @Before
    public void initTest() {
        flattenMultilevelDoublyLinkedList = new LC430FlattenMultilevelDoublyLinkedList();
    }

    @Test
    public void case01Test() {
        final Node node6 = new Node(6);
        final Node node5 = new Node(5, node6);
        final Node node4 = new Node(4, node5);
        final Node node3 = new Node(3, node4);
        final Node node2 = new Node(2, node3);
        final Node node1 = new Node(1, node2);
        node2.prev = node1;
        node3.prev = node2;
        node4.prev = node3;
        node5.prev = node4;
        node6.prev = node5;

        final Node node10 = new Node(10);
        final Node node9 = new Node(9, node10);
        final Node node8 = new Node(8, node9);
        final Node node7 = new Node(7, node8);
        node3.child = node7;
        node8.prev = node7;
        node9.prev = node8;
        node10.prev = node9;

        final Node node12 = new Node(12);
        final Node node11 = new Node(11, node12);
        node8.child = node11;
        node12.prev = node11;

        final Node ans = flattenMultilevelDoublyLinkedList.flatten(node1);
        printLinkedNode(ans);
    }

    @Test
    public void case02Test() {

        final Node node3 = new Node(3);
        final Node node2 = new Node(2);
        final Node node1 = new Node(1);
        node1.child = node2;
        node2.child = node3;

        final Node ans = flattenMultilevelDoublyLinkedList.flatten(node1);
        printLinkedNode(ans);
    }

    @Test
    public void case3Test() {
        final Node node3 = new Node(3);
        final Node node2 = new Node(2);
        final Node node1 = new Node(1, node2);
        node1.child = node3;
        Node ans = flattenMultilevelDoublyLinkedList.flatten(node1);
        printLinkedNode(ans);

        ans = flattenMultilevelDoublyLinkedList.flatten(null);
        Assert.assertNull(ans);
    }

    public static void printLinkedNode(Node node) {
        final StringBuilder builder = new StringBuilder();
        while (node != null) {
            builder.append(node.val);
            if (node.next != null) builder.append(",");
            node = node.next;
        }
        System.out.println(builder);
    }


}
