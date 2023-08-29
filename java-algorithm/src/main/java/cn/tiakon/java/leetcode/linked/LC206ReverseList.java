package cn.tiakon.java.leetcode.linked;

import cn.tiakon.java.leetcode.datastructure.ListNode;

/**
 * 206. 反转链表
 * https://leetcode.cn/problems/reverse-linked-list/
 *
 * @author tiankai.me@gmail.com on 2022/8/19 13:17.
 */
public class LC206ReverseList {

    /**
     * 链表引入虚拟节点方便头插入操作
     * @author tiankai.me@gmail.com on 2023-08-29 22:47.
     */
    public ListNode reverseList(ListNode head) {
        ListNode curr = head, dummy = new ListNode<>();
        while (curr != null) {
            ListNode next = curr.next;
            ListNode node = dummy.next;
            if (node != null) curr.next = node;
            else curr.next = null;  // 注意第一个节点的下一个链接必须置为null，否则会形成环。
            dummy.next = curr;
            curr = next;
        }
        return dummy.next;
    }

    /**
     *
     *  双指针
     * 1. 将左指针指向null，右指针指向head。
     * 2. 当右指针不为空时循环。
     * 3. 将右指针指向左指针所在节点，同时左移左右指针。
     * 4. 最后返回左指针。
     * 时间复杂度：O(n)，其中 nn 是链表的长度。需要遍历链表一次。
     * 空间复杂度：O(1)。
     * 执行用时： 0 ms , 在所有 Java 提交中击败了 100.00% 的用户
     * 内存消耗： 40.7 MB , 在所有 Java 提交中击败了 98.85% 的用户
     *
     * @author tiankai.me@gmail.com on 2022/8/20 8:13.
     */
    public ListNode reverseListV2(ListNode head) {
        ListNode left = null;
        ListNode right = head;
        while (right != null) {
            ListNode temp = right.next;
            right.next = left;
            left = right;
            right = temp;
        }
        return left;
    }

    /**
     * 递归
     * 1. 对于递归先设计终止条件，当头结点或头结点指向空时，返回头结点。
     * 2. 再设计递归逻辑：
     * 2.1 当拿到返回的新头结点后，将当前节点的next节点指向当前节点。
     * 2.2 并将当前节点的next置为空，将当前节点的next留给上一个递归函数处理。
     * <p>
     * 执行用时： 0 ms , 在所有 Java 提交中击败了 100.00% 的用户
     * 内存消耗： 41.2 MB , 在所有 Java 提交中击败了 50.37% 的用户
     *
     * @author tiankai.me@gmail.com on 2022/8/20 9:35.
     */
    public ListNode reverseListV3(ListNode head) {
        if (head == null || head.next == null) return head;
        final ListNode newHead = reverseListV3(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

}
