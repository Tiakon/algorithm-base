package cn.tiakon.java.leetcode.linked.sorted;

import cn.tiakon.java.leetcode.datastructure.ListNode;

/**
 * 148. 排序链表
 * https://leetcode.cn/problems/sort-list/
 *
 * @author tiankai.me@gmail.com on 2023-08-07 21:37.
 */
public class LC148SortList {

    /**
     * 归并排序（递归法）
     * <p>
     * 时间复杂度 :
     * 空间复杂度 : O(logn),递归调用函数将带来 O(logn) 的空间复杂度。
     *
     * @author tiankai.me@gmail.com on 2023-08-07 23:08.
     */
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode fast = head.next, slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode tmp = slow.next;
        slow.next = null;
        ListNode left = sortListV2(head);
        ListNode right = sortListV2(tmp);
        ListNode h = new ListNode(0);
        ListNode res = h;
        while (left != null && right != null) {
            if ((int) left.val < (int) right.val) {
                h.next = left;
                left = left.next;
            } else {
                h.next = right;
                right = right.next;
            }
            h = h.next;
        }
        h.next = left != null ? left : right;
        return res.next;
    }

    /**
     * 找中间位置 + 递归 + 合并链表
     * 时间复杂度: O(nlogn)
     * 空间复杂度:O(1)
     *
     * @author tiankai.me@gmail.com on 2023-08-07 22:44.
     */
    public ListNode sortListV2(ListNode head) {
        // 1、递归结束条件
        if (head == null || head.next == null) return head;
        // 2、找到链表中间节点并断开链表 & 递归下探
        ListNode midNode = middleNode(head);
        ListNode rightHead = midNode.next;
        midNode.next = null;
        ListNode left = sortListV2(head);
        ListNode right = sortListV2(rightHead);
        // 3、当前层业务操作（合并有序链表）
        return mergeTwoLists(left, right);
    }

    //  找到链表中间节点（876. 链表的中间结点）
    private ListNode middleNode(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode slow = head;
        ListNode fast = head.next.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    // 合并两个有序链表（21. 合并两个有序链表）
    private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode sentry = new ListNode(-1);
        ListNode curr = sentry;
        while (l1 != null && l2 != null) {
            if ((int) l1.val < (int) l2.val) {
                curr.next = l1;
                l1 = l1.next;
            } else {
                curr.next = l2;
                l2 = l2.next;
            }
            curr = curr.next;
        }
        curr.next = l1 != null ? l1 : l2;
        return sentry.next;
    }
}
