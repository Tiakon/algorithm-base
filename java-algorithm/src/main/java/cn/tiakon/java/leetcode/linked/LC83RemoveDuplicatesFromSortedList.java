package cn.tiakon.java.leetcode.linked;

import cn.tiakon.java.leetcode.datastructure.ListNode;

/**
 * 83. 删除排序链表中的重复元素
 * https://leetcode.cn/problems/remove-duplicates-from-sorted-list/
 *
 * @author tiankai.me@gmail.com on 2022/10/31 下午1:19.
 */
public class LC83RemoveDuplicatesFromSortedList {
    /**
     * 迭代
     * ### 实测
     * 执行用时： 0 ms , 在所有 Java 提交中击败了 100.00% 的用户
     * 内存消耗： 41 MB , 在所有 Java 提交中击败了 62.04% 的用户
     *
     * @author tiankai.me@gmail.com on 2022/10/31 下午1:29.
     */
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return null;
        ListNode node = head;
        while (node.next != null) {
            if (node.val == node.next.val) node.next = node.next.next;
            else node = node.next;
        }
        return head;
    }

    /**
     * 迭代:从上至下
     * ### 实测
     * 执行用时： 0 ms , 在所有 Java 提交中击败了 100.00% 的用户
     * 内存消耗： 41.2 MB , 在所有 Java 提交中击败了 37.07% 的用户
     *
     * @author tiankai.me@gmail.com on 2022/10/31 下午1:37.
     */
    public ListNode deleteDuplicatesV2(ListNode head) {
        ListNode node = head;
        dfs(node);
        return head;
    }

    public void dfs(ListNode node) {
        if (node == null || node.next == null) return;
        if (node.val == node.next.val) node.next = node.next.next;
        else node = node.next;
        dfs(node);
    }

}
