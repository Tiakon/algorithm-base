package cn.tiakon.java.leetcode.linked.offer;

import cn.tiakon.java.leetcode.datastructure.ListNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 剑指 Offer 06. 从尾到头打印链表
 * https://leetcode.cn/problems/cong-wei-dao-tou-da-yin-lian-biao-lcof/
 *
 * @author tiankai.me@gmail.com on 2023-08-09 21:56.
 */
public class JZ06 {
    /**
     * 复杂度分析：
     * 时间复杂度 O(N)： 入栈和出栈共使用 O(N)  时间。
     * 空间复杂度 O(N)： 辅助栈 stack 和数组 res 共使用 O(N) 的额外空间。
     *
     * @author tiankai.me@gmail.com on 2023-08-09 22:15.
     */
    public int[] reversePrint(ListNode head) {
        Deque stack = new ArrayDeque();
        while (head != null) {
            stack.push(head.val);
            head = head.next;
        }
        int[] ans = new int[stack.size()];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = (int) stack.pop();
        }
        return ans;
    }

    public int[] reversePrintV2(ListNode head) {
        int[] nums = new int[10000];
        int i = 0;
        while (head != null && i < nums.length) {
            nums[i++] = (int) head.val;
            head = head.next;
        }
        final int[] ans = new int[i];
        for (int j = 0; j < ans.length && i >= 0; j++, i--) {
            ans[j] = nums[i - 1];
        }
        return ans;
    }
}

//

/**
 * 递归法
 * 复杂度分析：
 * 时间复杂度：O(N) 遍历链表，递归 N 次。
 * 空间复杂度：O(N) 系统递归需要使用 O(N)的栈空间。
 *
 * @author tiankai.me@gmail.com on 2023-08-09 22:18.
 */
class Solution {
    List<Integer> tmp = new ArrayList<>();

    public int[] reversePrint(ListNode head) {
        recur(head);
        int[] res = new int[tmp.size()];
        for (int i = 0; i < res.length; i++)
            res[i] = tmp.get(i);
        return res;
    }

    void recur(ListNode head) {
        if (head == null) return;
        recur(head.next);
        tmp.add((int) head.val);
    }
}