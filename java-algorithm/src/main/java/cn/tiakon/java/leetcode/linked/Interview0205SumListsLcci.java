package cn.tiakon.java.leetcode.linked;

import cn.tiakon.java.leetcode.datastructure.ListNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 面试题 02.05. 链表求和
 * https://leetcode.cn/problems/sum-lists-lcci/
 *
 * @author tiankai.me@gmail.com on 2023-08-08 22:46.
 */
public class Interview0205SumListsLcci {
    /**
     * 模拟流程
     * 复杂度分析
     * <p>
     * 时间复杂度： O(max(m,n))，其中 m 和 n 分别为两个链表的长度。我们需要遍历两个链表的全部位置，而处理每个位置只需要  O(1) 的时间。
     * <p>
     * 空间复杂度： O(1)。注意返回值不计入空间复杂度。
     *
     * @author tiankai.me@gmail.com on 2023-08-08 23:40.
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        ListNode head = null, prev = null;
        int num = 0;
        while (l1 != null || l2 != null) {
            int i1 = (l1 != null) ? (int) l1.val : 0;
            int i2 = (l2 != null) ? (int) l2.val : 0;
            int i = i1 + i2 + num;
            num = i / 10;
            ListNode node = new ListNode(i % 10);
            if (prev != null) {
                prev.next = node;
                prev = prev.next;
            } else {
                head = node;
                prev = head;
            }
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
        if (num == 1) prev.next = new ListNode(1);
        return head;
    }


    /**
     * 使用栈：把所有数字压入栈中，再依次取出相加。
     * 复杂度分析
     * <p>
     * 时间复杂度：O(max(m,n))，其中 m 和 n 分别为两个链表的长度。我们需要遍历两个链表的全部位置，而处理每个位置只需要 O(1) 的时间。
     * 空间复杂度：O(m+n)，其中 m 和 n 分别为两个链表的长度。空间复杂度主要取决于我们把链表内容放入栈中所用的空间。
     *
     * @author tiankai.me@gmail.com on 2023-08-09 6:59.
     */
    public ListNode addTwoNumbersV2(ListNode l1, ListNode l2) {
        Deque<Integer> stack1 = new ArrayDeque<Integer>();
        Deque<Integer> stack2 = new ArrayDeque<Integer>();
        while (l1 != null) {
            stack1.push((int) l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            stack2.push((int) l2.val);
            l2 = l2.next;
        }
        int carry = 0;
        ListNode ans = null;
        while (!stack1.isEmpty() || !stack2.isEmpty() || carry != 0) {
            int a = stack1.isEmpty() ? 0 : stack1.pop();
            int b = stack2.isEmpty() ? 0 : stack2.pop();
            int cur = a + b + carry;
            carry = cur / 10;
            cur %= 10;
            ListNode curnode = new ListNode(cur);
            curnode.next = ans;
            ans = curnode;
        }
        return ans;
    }

}