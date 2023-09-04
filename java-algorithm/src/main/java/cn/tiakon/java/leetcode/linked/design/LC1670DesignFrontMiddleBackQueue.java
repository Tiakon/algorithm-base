package cn.tiakon.java.leetcode.linked.design;

import cn.tiakon.java.leetcode.datastructure.ListNode;
import org.junit.Assert;
import org.junit.Test;

/**
 * 1670. 设计前中后队列
 * https://leetcode.cn/problems/design-front-middle-back-queue/
 * <p>
 * 注意：
 * 1. 前中后函数的添加与删除都会首先被调用,注意边界条件的处理。
 * 2. 删除函数被调用后，要注意链表是否为空，为空时要及时更新头尾指针。
 *
 * @author tiankai.me@gmail.com on 2023-09-03 11:54.
 */
public class LC1670DesignFrontMiddleBackQueue {
    ListNode head;
    ListNode tail;
    public int size = 0;

    public LC1670DesignFrontMiddleBackQueue() {
    }

    public void pushFront(int val) {
        ListNode node = new ListNode(val);
        if (head != null) {
            node.next = head;
            head.prev = node;
        } else tail = node;
        head = node;
        ++size;
    }

    public void pushMiddle(int val) {
        int mid = size / 2;
        ListNode middle = head;
        for (int i = 0; i < mid; i++) {
            middle = middle.next;
        }
        if (middle != null && middle.prev != null) {
            ListNode node = new ListNode(val);
            ListNode prevNode = middle.prev;
            prevNode.next = node;
            node.prev = prevNode;
            node.next = middle;
            middle.prev = node;
            ++size;
        } else pushFront(val);
    }

    public void pushBack(int val) {
        ListNode node = new ListNode(val);
        if (tail != null) {
            node.prev = tail;
            tail.next = node;
        } else head = node;
        tail = node;
        ++size;
    }

    public int popFront() {
        if (head == null) return -1;
        int ans = (int) head.val;
        head = head.next;
        if (head != null) head.prev = null;
        else tail = null;
        --size;
        return ans;
    }

    public int popMiddle() {
        if (head == null) return -1;
        int mid = (size % 2 == 0 ? size / 2 - 1 : size / 2);
        ListNode curr = head;
        for (int i = 0; i < mid; i++) {
            curr = curr.next;
        }
        int ans = (int) curr.val;
        ListNode prevNode = curr.prev, nextNode = curr.next;
        if (prevNode != null) prevNode.next = nextNode;
        else {
            head = curr.next;
            if (head != null) head.prev = null;
        }
        if (nextNode != null) nextNode.prev = prevNode;
        else {
            tail = curr.prev;
            if (tail != null) tail.next = null;
        }
        --size;
        return ans;
    }

    public int popBack() {
        if (tail == null) return -1;
        int ans = (int) tail.val;
        tail = tail.prev;
        if (tail != null) tail.next = null;
        else head = null;
        --size;
        return ans;
    }

}