package cn.tiakon.java.leetcode.linked;

import cn.tiakon.java.leetcode.datastructure.ListNode;
import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 143. 重排链表
 * https://leetcode.cn/problems/reorder-list/
 *
 * @author tiankai.me@gmail.com on 2023-08-02 14:27.
 */
public class LC143ReorderList {

    /**
     * 双指针解法
     *
     * @author tiankai.me@gmail.com on 2023-08-04 0:47.
     */
    public void reorderList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) return;
        ListNode low = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            while (fast.next.next != null) {
                fast = fast.next;
            }
            final ListNode tailNode = fast.next;
            fast.next = null;
            fast = tailNode;
            if (low.next == fast) break;
            ListNode nextNode = low.next;
            low.next = fast;
            fast.next = nextNode;
            low = nextNode;
            fast = nextNode.next;
        }
    }

    /**
     * 双端队列解法
     *
     * @author tiankai.me@gmail.com on 2023-08-04 0:47.
     */
    public void reorderListDeque(ListNode head) {
        Deque<ListNode> deque = new ArrayDeque<>();
        ListNode node = head;
        while (node != null) {
            deque.push(node);
            node = node.next;
        }
        ListNode tail = deque.pollLast();
        final int size = deque.size();
        for (int i = 0; i < size; i++) {
            if (i % 2 == 0) node = deque.pollFirst();
            else node = deque.pollLast();
            node.next = null;
            tail.next = node;
            tail = tail.next;
        }
    }

    /**
     * 寻找链表中点 + 链表逆序 + 合并链表
     * 注意到目标链表即为将原链表的左半端和反转后的右半端合并后的结果。
     * 复杂度分析
     * 时间复杂度： O(N)，其中 N 是链表中的节点数。
     * 空间复杂度： O(1)。
     *
     * @author tiankai.me@gmail.com on 2023-08-04 0:48.
     */
    public void reorderListMiddleAndReverseAndMerge(ListNode head) {
        if (head == null) return;
        ListNode mid = middleNode(head);
        ListNode l1 = head;
        ListNode l2 = mid.next;
        mid.next = null;
        l2 = reverseList(l2);
        mergeList(l1, l2);
    }

    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }

    public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public void mergeList(ListNode l1, ListNode l2) {
        ListNode l1_tmp;
        ListNode l2_tmp;
        while (l1 != null && l2 != null) {
            l1_tmp = l1.next;
            l2_tmp = l2.next;

            l1.next = l2;
            l1 = l1_tmp;

            l2.next = l1;
            l2 = l2_tmp;
        }
    }

}
