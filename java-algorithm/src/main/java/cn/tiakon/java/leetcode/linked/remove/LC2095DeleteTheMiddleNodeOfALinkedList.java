package cn.tiakon.java.leetcode.linked.remove;

import cn.tiakon.java.leetcode.datastructure.ListNode;

/**
 * 2095. 删除链表的中间节点
 * https://leetcode.cn/problems/delete-the-middle-node-of-a-linked-list/
 *
 * @author tiankai.me@gmail.com on 2023-09-01 23:15.
 */
public class LC2095DeleteTheMiddleNodeOfALinkedList {
    /**
     * 查找中间节点，做值交换。
     *
     * @author tiankai.me@gmail.com on 2023-09-01 23:31.
     */
    public ListNode deleteMiddle(ListNode head) {
        if (head.next == null) return null;
        if (head.next.next == null) {
            head.next = null;
            return head;
        }
        ListNode left = head, right = head;
        while (right != null && right.next != null) {
            left = left.next;
            right = right.next.next;
        }
        int temp = (int) left.next.val;
        left.val = temp;
        left.next = left.next.next;
        return head;
    }
}
