package cn.tiakon.java.leetcode.linked.sorted;

import cn.tiakon.java.leetcode.datastructure.ListNode;
import cn.tiakon.java.utils.MathRandomUtil;
import org.junit.Test;

/**
 * 147. 对链表进行插入排序
 * https://leetcode.cn/problems/insertion-sort-list/
 *
 * @author tiankai.me@gmail.com on 2023-09-04 14:48.
 */
public class LC147InsertionSortList {
    /**
     * 在新链表上插入。
     * 复杂度分析
     * 时间复杂度： O(n^2)，其中 n 是链表的长度。
     * 空间复杂度： O(1)
     *
     * @author tiankai.me@gmail.com on 2023-09-05 21:22.
     */
    public ListNode insertionSortList(ListNode head) {
        ListNode dummy = new ListNode(Integer.MIN_VALUE);
        ListNode curr = head;
        while (curr != null) {
            ListNode currNext = curr.next;
            ListNode node = dummy.next, prev = dummy;
            while (node != null) {
                if ((int) curr.val < (int) node.val) {
                    ListNode next = prev.next;
                    prev.next = curr;
                    curr.next = next;
                    break;
                }
                prev = node;
                node = node.next;
            }
            if (prev.next == null) {
                prev.next = curr;
                curr.next = null;
            }
            curr = currNext;
        }
        return dummy.next;
    }

    /**
     * 在原链表上插入。
     * 复杂度分析
     * 时间复杂度： O(n^2)，其中 n 是链表的长度。
     * 空间复杂度： O(1)
     *
     * @author tiankai.me@gmail.com on 2023-09-05 21:22.
     */
    public ListNode insertionSortListV2(ListNode head) {
        if (head == null) return head;
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode lastSorted = head, curr = head.next;
        while (curr != null) {
            if ((int) lastSorted.val <= (int) curr.val) lastSorted = lastSorted.next;
            else {
                ListNode prev = dummyHead;
                while ((int) prev.next.val <= (int) curr.val) {
                    prev = prev.next;
                }
                lastSorted.next = curr.next;
                curr.next = prev.next;
                prev.next = curr;
            }
            curr = lastSorted.next;
        }
        return dummyHead.next;
    }

}