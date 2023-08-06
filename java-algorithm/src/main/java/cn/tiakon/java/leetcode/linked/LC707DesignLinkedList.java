package cn.tiakon.java.leetcode.linked;

import cn.tiakon.java.leetcode.datastructure.ListNode;

/**
 * 707. 设计链表
 * https://leetcode.cn/problems/design-linked-list/
 * 基于单链表设计
 * 这种设计不好，属性太过于封闭，不方便对外使用。
 * @author tiankai.me@gmail.com on 2023/7/29 下午9:52.
 */
public class LC707DesignLinkedList {
    int size = 0;
    ListNode head;

    public LC707DesignLinkedList() {
        head = new ListNode();
    }

    public int get(int index) {
        if (index < 0 || index >= size) return -1;
        ListNode cur = head;
        for (int i = 0; i <= index; i++) {
            cur = cur.next;
        }
        return (int) cur.val;
    }

    public void addAtHead(int val) {
        addAtIndex(0, val);
    }

    public void addAtTail(int val) {
        addAtIndex(size, val);
    }

    public void addAtIndex(int index, int val) {
        if (index < 0 || index > size) return;
        size++;
        ListNode pred = head;
        for (int i = 0; i < index; i++) {
            pred = pred.next;
        }
        ListNode toAdd = new ListNode(val);
        toAdd.next = pred.next;
        pred.next = toAdd;
    }

    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) return;
        size--;
        ListNode pred = head;
        for (int i = 0; i < index; i++) {
            pred = pred.next;
        }
        pred.next = pred.next.next;
    }

}
