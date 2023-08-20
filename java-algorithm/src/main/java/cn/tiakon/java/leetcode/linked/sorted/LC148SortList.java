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
     * 自顶向下归并排序（递归法）
     * 使用自底向上的方法实现归并排序，则可以达到 O(1)的空间复杂度。
     * 首先求得链表的长度 length ，然后将链表拆分成子链表进行合并。
     * <p>
     * 时间复杂度 : O(nlogn)，n为链表的长度。
     * 空间复杂度 : O(logn),递归调用函数将带来 O(logn) 的空间复杂度。
     * <p>
     * https://leetcode.cn/problems/sort-list/solutions/13728/sort-list-gui-bing-pai-xu-lian-biao-by-jyd/
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
        ListNode left = sortList(head);
        ListNode right = sortList(tmp);
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
     * 自底向上归并排序
     * 时间复杂度: O(nlogn)，其中 n 是链表的长度。
     * 空间复杂度:O(1)
     *
     * @author tiankai.me@gmail.com on 2023-08-07 22:44.
     */
    public ListNode sortListV2(ListNode head) {
        if (head == null) return head;
        int length = 0;
        ListNode node = head;
        while (node != null) {
            length++;
            node = node.next;
        }
        ListNode dummyHead = new ListNode(0, head);
        for (int subLength = 1; subLength < length; subLength <<= 1) {
            ListNode prev = dummyHead, curr = dummyHead.next;
            while (curr != null) {
                ListNode head1 = curr;
                for (int i = 1; i < subLength && curr.next != null; i++) {
                    curr = curr.next;
                }
                ListNode head2 = curr.next;
                curr.next = null;
                curr = head2;
                for (int i = 1; i < subLength && curr != null && curr.next != null; i++) {
                    curr = curr.next;
                }
                ListNode next = null;
                if (curr != null) {
                    next = curr.next;
                    curr.next = null;
                }
                ListNode merged = merge(head1, head2);
                prev.next = merged;
                while (prev.next != null) {
                    prev = prev.next;
                }
                curr = next;
            }
        }
        return dummyHead.next;
    }

    public ListNode merge(ListNode head1, ListNode head2) {
        ListNode dummyHead = new ListNode(0);
        ListNode temp = dummyHead, temp1 = head1, temp2 = head2;
        while (temp1 != null && temp2 != null) {
            if ((int) temp1.val <= (int) temp2.val) {
                temp.next = temp1;
                temp1 = temp1.next;
            } else {
                temp.next = temp2;
                temp2 = temp2.next;
            }
            temp = temp.next;
        }
        if (temp1 != null) temp.next = temp1;
        else if (temp2 != null) temp.next = temp2;
        return dummyHead.next;
    }

}
