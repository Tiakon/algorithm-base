package cn.tiakon.java.leetcode.linked;

import cn.tiakon.java.leetcode.datastructure.ListNode;

/**
 * 2807. 在链表中插入最大公约数
 * https://leetcode.cn/problems/insert-greatest-common-divisors-in-linked-list/
 *
 * @author tiankai.me@gmail.com on 2023-08-27 9:20.
 */
public class LC2807 {
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        ListNode curr = head;
        while (curr != null && curr.next != null) {
            final ListNode next = curr.next;
            final int g = gcd((int) curr.val, (int) next.val);
            curr.next = new ListNode(g, next);
            curr = next;
        }
        return head;
    }
    // 递归求最大公约数
    public int gcd(int a, int b) {
        return (b != 0 ? gcd(b, a % b) : a);
    }
    public int getGreatestCommonDivisors(int a, int b) {
        int max = Math.max(a, b);
        int min = Math.min(a, b);
        if (max % min == 0) return min;
        int ans = min;
        while (ans-- > 0) {
            if (a % ans == 0 && b % ans == 0) return ans;
        }
        return 1;
    }

}