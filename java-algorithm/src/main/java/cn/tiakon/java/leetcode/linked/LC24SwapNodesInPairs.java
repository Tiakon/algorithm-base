package cn.tiakon.java.leetcode.linked;

import cn.tiakon.java.leetcode.datastructure.ListNode;
import cn.tiakon.java.utils.MathRandomUtil;
import org.junit.Test;

/**
 * 24. 两两交换链表中的节点
 * https://leetcode.cn/problems/swap-nodes-in-pairs/
 *
 * @author tiankai.me@gmail.com on 2023-08-06 13:10.
 */
public class LC24SwapNodesInPairs {
    /**
     * 复杂度分析
     * 时间度分析：O(n)
     * 空间度分析：O(1)
     *
     * @author tiankai.me@gmail.com on 2023-08-06 14:26.
     */
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode curr = head, newHead = head.next, prevTail = null;
        while (curr != null && curr.next != null) {
            ListNode next = curr.next;
            curr.next = next.next;
            next.next = curr;
            if (prevTail == null) prevTail = curr;
            else {
                prevTail.next = next;
                prevTail = prevTail.next.next;
            }
            curr = curr.next;
        }
        return newHead;
    }

    public ListNode swapPairsV2(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode newHead = head.next;
        head.next = swapPairsV2(newHead.next);
        newHead.next = head;
        return newHead;
    }
}