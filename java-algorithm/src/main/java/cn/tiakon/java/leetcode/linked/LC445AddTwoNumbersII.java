package cn.tiakon.java.leetcode.linked;

import cn.tiakon.java.leetcode.datastructure.ListNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 445. 两数相加 II
 * https://leetcode.cn/problems/add-two-numbers-ii/
 *
 * @author tiankai.me@gmail.com on 2023-08-29 18:18.
 */
public class LC445AddTwoNumbersII {

    /**
     * 反转链表
     * @author tiankai.me@gmail.com on 2023-08-29 23:41.
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head1 = reverseList(l1);
        ListNode head2 = reverseList(l2);
        final ListNode head = new ListNode();
        ListNode curr = head;
        int carry = 0;
        while (head1 != null || head2 != null) {
            int sum;
            if (head1 == null) sum = (int) head2.val;
            else if (head2 == null) sum = (int) head1.val;
            else sum = (int) head1.val + (int) head2.val;
            curr.next = new ListNode<>((carry + sum) % 10);
            carry = (carry + sum) >= 10 ? 1 : 0;
            curr = curr.next;
            if (head1 != null) head1 = head1.next;
            if (head2 != null) head2 = head2.next;
        }
        curr.next = carry == 1 ? new ListNode(1) : null;
        return reverseList(head.next);
    }

    // 链表反转
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
     * 使用栈，即可避免链表翻转.
     * 复杂度分析：
     * 时间复杂度： O(max(m,n))，其中 m 和 n 分别为两个链表的长度。我们需要遍历两个链表的全部位置，而处理每个位置只需要 O(1) 的时间。
     * 空间复杂度： O(m+n)，其中 m 和 n 分别为两个链表的长度。空间复杂度主要取决于我们把链表内容放入栈中所用的空间。
     *
     * @author tiankai.me@gmail.com on 2023-08-29 23:08.
     */
    public ListNode addTwoNumbersV2(ListNode l1, ListNode l2) {
        Deque<Integer> stack1 = new ArrayDeque<>();
        Deque<Integer> stack2 = new ArrayDeque<>();
        while (l1 != null) {
            stack1.push((int) l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            stack2.push((int) l2.val);
            l2 = l2.next;
        }
        ListNode dummy = new ListNode();
        ListNode curr = dummy;
        int carry = 0;
        while (!stack1.isEmpty() || !stack2.isEmpty()) {
            int sum;
            if (stack1.isEmpty()) sum = stack2.pop() + carry;
            else if (stack2.isEmpty()) sum = stack1.pop() + carry;
            else sum = stack2.pop() + stack1.pop() + carry;
            // 使用头插入的方式插入链表。
            ListNode next = curr.next;
            curr.next = new ListNode(sum % 10, next);
            carry = sum >= 10 ? 1 : 0;
        }
        if (carry == 1) {
            ListNode next = curr.next;
            curr.next = new ListNode(1, next);
        }
        return dummy.next;
    }

}
