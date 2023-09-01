package cn.tiakon.java.leetcode.linked;

import cn.tiakon.java.leetcode.datastructure.ListNode;

/**
 * 1721. 交换链表中的节点
 * https://leetcode.cn/problems/swapping-nodes-in-a-linked-list/
 *
 * @author tiankai.me@gmail.com on 2023-08-31 22:12.
 */
public class LC1721SwappingNodesInALinkedList {

    /**
     *
     * @author tiankai.me@gmail.com on 2023-09-01 23:01.
     */
    public ListNode swapNodes(ListNode head, int k) {
        ListNode l = head, r = head, swap1, swap2;
        for (int i = 1; i < k; i++) {
            r = r.next;
        }
        swap1 = r;
        while (r != null && r.next != null) {
            l = l.next;
            r = r.next;
        }
        swap2 = l;
        int temp = (int) swap2.val;
        swap2.val = swap1.val;
        swap1.val = temp;
        return head;
    }

}