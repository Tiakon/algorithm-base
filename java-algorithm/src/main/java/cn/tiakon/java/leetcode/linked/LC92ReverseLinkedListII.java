package cn.tiakon.java.leetcode.linked;

import cn.tiakon.java.leetcode.datastructure.ListNode;
import org.junit.Test;

/**
 * 92. 反转链表 II
 * https://leetcode.cn/problems/reverse-linked-list-ii/
 *
 * @author tiankai.me@gmail.com on 2023-08-11 18:21.
 */
public class LC92ReverseLinkedListII {
    /**
     *
     * 思路指定范围内的链表逆序。
     * 只更新左边界前一个节点与跟踪节点的指向。
     * 复杂度分析：
     * 时间复杂度：O(N)，其中 NNN 是链表总节点数。最多只遍历了链表一次，就完成了反转。
     * 空间复杂度：O(1) 。只使用到常数个变量。
     *
     * @author tiankai.me@gmail.com on 2023-08-12 10:57.
     */
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || head.next == null) return head;
        ListNode temp = new ListNode(-1, head);
        ListNode node = temp, leftHeadPrev = null;
        for (int i = 0; i < right; i++) {
            while (i >= left && i < right) {
                ListNode next = node.next;
                node.next = next.next;
                next.next = leftHeadPrev.next;
                leftHeadPrev.next = next;
                ++i;
            }
            leftHeadPrev = node;
            node = node.next;
        }
        return temp.next;
    }
}
