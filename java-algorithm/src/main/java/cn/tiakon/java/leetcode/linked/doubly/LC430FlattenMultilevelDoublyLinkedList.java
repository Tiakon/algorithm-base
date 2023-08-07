package cn.tiakon.java.leetcode.linked.doubly;

import org.junit.Test;

/**
 * 430. 扁平化多级双向链表
 * https://leetcode.cn/problems/flatten-a-multilevel-doubly-linked-list/
 *
 * @author tiankai.me@gmail.com on 2023-08-06 21:41.
 */
public class LC430FlattenMultilevelDoublyLinkedList {
    public Node flatten(Node head) {
        Node curr = head;
        flattenNode(curr);
        return head;
    }

    public Node flattenNode(Node head) {
        Node curr = head;
        while (curr != null && curr.next != null) {
            Node childHead = curr.child;
            while (childHead != null) {
                Node childTail = flattenNode(childHead);
                curr.child = null;
                final Node next = curr.next;
                curr.next = childHead;
                childHead.prev = curr;
                childTail.next = next;
                next.prev = childTail;
                childHead = null;
            }
            curr = curr.next;
        }
        return curr;
    }


    @Test
    public void case01Test() {
        final LC430FlattenMultilevelDoublyLinkedList flattenMultilevelDoublyLinkedList = new LC430FlattenMultilevelDoublyLinkedList();

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
        System.out.println(ans);
    }

    @Test
    public void case02Test() {
        final LC430FlattenMultilevelDoublyLinkedList flattenMultilevelDoublyLinkedList = new LC430FlattenMultilevelDoublyLinkedList();

        final Node node3 = new Node(3);
        final Node node2 = new Node(2);
        final Node node1 = new Node(1);
        node1.child = node2;
        node2.child = node3;

        final Node ans = flattenMultilevelDoublyLinkedList.flatten(node1);
        System.out.println(ans);
    }
}

class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;

    public Node(int val) {
        this.val = val;
    }

    public Node(int val, Node next) {
        this.val = val;
        this.next = next;
    }
}