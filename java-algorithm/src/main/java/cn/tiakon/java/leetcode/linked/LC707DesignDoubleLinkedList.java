package cn.tiakon.java.leetcode.linked;

import cn.tiakon.java.leetcode.datastructure.ListNode;
import org.junit.Assert;
import org.junit.Test;

/**
 * 707. 设计链表
 * https://leetcode.cn/problems/design-linked-list/
 * 基于双链表设计,需要同时跟踪目标节点的前一个节点和下一个节点。
 * 注意，头尾节点都为虚节点，没有具体的值。
 *
 * @author tiankai.me@gmail.com on 2023-08-06 7:49.
 */
public class LC707DesignDoubleLinkedList {
    int size;
    ListNode head;
    ListNode tail;

    public LC707DesignDoubleLinkedList() {
        size = 0;
        head = new ListNode(0);
        tail = new ListNode(0);
        head.next = tail;
        tail.prev = head;
    }

    public int get(int index) {
        if (index < 0 || index > size - 1) return -1;
        ListNode curr;
        if (index <= (size << 1)) {
            curr = head;
            for (int i = 0; i <= index; i++) {
                curr = curr.next;
            }
        } else {
            curr = tail;
            for (int i = size - 1; i >= index; i--) {
                curr = curr.prev;
            }
        }
        return (int) curr.val;
    }

    public void addAtHead(int val) {
        addAtIndex(0, val);
    }

    public void addAtTail(int val) {
        addAtIndex(size, val);
    }

    public void addAtIndex(int index, int val) {
        if (index < 0 || index > size) return;
        ListNode addNode = new ListNode(val);
        ListNode prev,next;
        if (index <= (size << 1)) {
            prev = head;
            for (int i = 0; i < index; i++) {
                prev = prev.next;
            }
            next = prev.next;
        } else {
            next = tail;
            for (int i = size - 1; i > index; i--) {
                next = next.prev;
            }
            prev = next.prev;
        }
        prev.next=addNode;
        next.prev=addNode;
        addNode.prev=prev;
        addNode.next=next;
        ++size;
    }

    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) return;
        ListNode prev, next;
        if (index <= (size << 1)) {
            prev = head;
            for (int i = 0; i < index; i++) {
                prev = prev.next;
            }
            next = prev.next.next;
        } else {
            next = tail;
            for (int i = size - 1; i > index; i--) {
                next = next.prev;
            }
            prev = next.prev.prev;
        }
        prev.next = next;
        next.prev = prev;
        --size;
    }

    @Test
    public void case01Test() {
        // ["MyLinkedList","addAtHead","addAtTail","addAtIndex","get","deleteAtIndex","get"]
        // [[],[1],[3],[1,2],[1],[1],[1]]
        final LC707DesignDoubleLinkedList designDoubleLinkedList = new LC707DesignDoubleLinkedList();
        designDoubleLinkedList.addAtHead(1);
        designDoubleLinkedList.addAtTail(3);
        designDoubleLinkedList.addAtIndex(1, 2);
        Assert.assertEquals(1, designDoubleLinkedList.get(0));
        Assert.assertEquals(2, designDoubleLinkedList.get(1));
        Assert.assertEquals(3, designDoubleLinkedList.get(2));
        designDoubleLinkedList.deleteAtIndex(1);
        Assert.assertEquals(3, designDoubleLinkedList.get(1));
        designDoubleLinkedList.deleteAtIndex(0);
        Assert.assertEquals(3, designDoubleLinkedList.get(0));
    }


}