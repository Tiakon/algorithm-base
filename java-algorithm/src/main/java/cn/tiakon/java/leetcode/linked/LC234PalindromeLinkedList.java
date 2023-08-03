package cn.tiakon.java.leetcode.linked;

import cn.tiakon.java.leetcode.datastructure.ListNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 234. 回文链表
 * https://leetcode.cn/problems/palindrome-linked-list/
 *
 * @author tiankai.me@gmail.com on 2022/10/24 下午3:34.
 */
public class LC234PalindromeLinkedList {
    /**
     * 利用双端队列,先遍历一遍单链表,将值保存在双端队列中.再通过首尾对比判断,即可得出答案.
     * 执行用时： 11 ms , 在所有 Java 提交中击败了 24.55% 的用户
     * 内存消耗： 53.6 MB , 在所有 Java 提交中击败了 76.64% 的用户
     * 通过测试用例： 88 / 88
     * <p>
     * 算法复杂度
     * 空间复杂度:O(n)
     * 空间复杂度:O(n)
     *
     * @author tiankai.me@gmail.com on 2022/10/24 下午3:58.
     */
    public boolean isPalindrome(ListNode head) {
        Deque deque = new ArrayDeque<>();
        while (head != null) {
            deque.push(head.val);
            head = head.next;
        }
        while (!deque.isEmpty()) {
            if (deque.peekLast() != deque.peekFirst()) return false;
            deque.pollFirst();
            if (!deque.isEmpty()) deque.pollLast();
        }
        return true;
    }

    /**
     * 快慢指针解法(有图LC234)
     * 快指针走到末尾，慢指针刚好到中间。其中慢指针将前半部分反转。然后比较反转后的前半部分与后半部分是否相等。
     * 复杂度分析
     * 时间复杂度:
     * 空间复杂度: O(1)
     *
     * @author tiankai.me@gmail.com on 2022/10/24 下午5:03.
     */
    public boolean isPalindromeWithFastAndLowPointer(ListNode head) {
        if (head == null || head.next == null) return true;
        ListNode slow = head, fast = head;
        ListNode pre = head, prepre = null;
        while (fast != null && fast.next != null) {
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
            // 反转节点
            pre.next = prepre;
            prepre = pre;
        }
        // 当链表节点个数为奇数时,慢指针刚好来到中间节点需要移动到下一个节点.
        if (fast != null) slow = slow.next;
        while (pre != null && slow != null) {
            if (pre.val != slow.val) return false;
            pre = pre.next;
            slow = slow.next;
        }
        return true;
    }


    ListNode temp;

    // 使用递归的方式判断是否是回文链表
    public boolean isPalindromeV2(ListNode head) {
        temp = head;
        return check(head);
    }

    private boolean check(ListNode head) {
        if (head == null) return true;
        boolean res = check(head.next) && (temp.val == head.val);
        temp = temp.next;
        return res;
    }

}
