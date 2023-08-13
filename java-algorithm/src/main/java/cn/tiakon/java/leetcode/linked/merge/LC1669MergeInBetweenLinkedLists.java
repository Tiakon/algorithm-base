package cn.tiakon.java.leetcode.linked.merge;

import cn.tiakon.java.leetcode.datastructure.ListNode;

/**
 * 1669. 合并两个链表
 * https://leetcode.cn/problems/merge-in-between-linked-lists/
 *
 * @author tiankai.me@gmail.com on 2023-08-10 7:21.
 */
public class LC1669MergeInBetweenLinkedLists {
    /**
     * 复杂度分析
     * 时间复杂度：O(n+m)，其中 n 是 list1 的长度，m 是 list2 的长度。
     * 空间复杂度：O(1)
     *
     * @author tiankai.me@gmail.com on 2023-08-13 14:16.
     */
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode node = list1, h1 = null, h2 = null;
        for (int i = 0; i <= b; i++) {
            if (i == a - 1) h1 = node;
            if (i == b) h2 = node.next;
            node = node.next;
        }
        h1.next = list2;
        node = list2;
        while (node != null && node.next != null) {
            node = node.next;
        }
        node.next = h2;
        return list1;
    }
}
