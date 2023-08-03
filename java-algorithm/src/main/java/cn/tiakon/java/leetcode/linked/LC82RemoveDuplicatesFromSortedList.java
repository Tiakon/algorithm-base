package cn.tiakon.java.leetcode.linked;

import cn.tiakon.java.leetcode.datastructure.ListNode;

/**
 * 82. 删除排序链表中的重复元素 II
 * https://leetcode.cn/problems/remove-duplicates-from-sorted-list-ii/
 *
 * @author tiankai.me@gmail.com on 2022/10/31 下午1:48.
 */
public class LC82RemoveDuplicatesFromSortedList {
    /**
     * 迭代法深度优先遍历
     * 1. 先添加虚拟节点头结点减少边界判断
     * 2. 通过标记重复值,删除最后遗留的单个节点.
     * ### 复杂度分析
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     * 执行用时： 0 ms , 在所有 Java 提交中击败了 100.00% 的用户
     * 内存消耗： 41.1 MB , 在所有 Java 提交中击败了 41.23% 的用户
     *
     * @author tiankai.me@gmail.com on 2022/10/31 下午2:27.
     */
    public ListNode deleteDuplicates(ListNode head) {
        ListNode temp = new ListNode();
        temp.next = head;
        ListNode node = temp;
        ListNode pre = temp;
        int val = -101;
        while (node != null) {
            if (node.next != null && node.val == node.next.val) {
                val = (int) node.val;
                pre.next = node.next.next;
                node = node.next.next;
            } else if ((int) node.val == val) {
                pre.next = node.next;
                node = node.next;
            } else {
                pre = node;
                node = node.next;
            }
        }
        return temp.next;
    }

    public ListNode deleteDuplicatesV2(ListNode head) {
        ListNode dummy = new ListNode();
        ListNode tail = dummy;
        while (head != null) {
            // 进入循环时，确保了 head 不会与上一节点相同
            if (head.next == null || head.val != head.next.val) {
                tail.next = head;
                tail = head;
            }
            // 如果 head 与下一节点相同，跳过相同节点,[设计巧妙哦!!!]
            while (head.next != null && head.val == head.next.val) head = head.next;
            head = head.next;
        }
        tail.next = null;
        return dummy.next;
    }

}
