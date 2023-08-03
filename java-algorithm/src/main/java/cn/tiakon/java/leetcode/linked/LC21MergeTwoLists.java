package cn.tiakon.java.leetcode.linked;

import cn.tiakon.java.leetcode.datastructure.ListNode;

/**
 * 21. 合并两个有序链表
 * https://leetcode.cn/problems/merge-two-sorted-lists/
 * https://leetcode.cn/problems/merge-two-sorted-lists/solution/he-bing-liang-ge-you-xu-lian-biao-by-leetcode-solu/
 *
 * @author tiankai.me@gmail.com on 2022/8/20 10:25.
 */
public class LC21MergeTwoLists {

    // 1. 双指针，原地修改
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) return list2;
        if (list2 == null) return list1;
        // 头结点在小值链表上
        ListNode head = (isAThanB(list1.val, list2.val)) ? list2 : list1;
        ListNode cur = head, left = head.next, right = (isAThanB(list1.val, list2.val)) ? list1 : list2;
        while (left != null && right != null) {
            // 当前节点保持在新链表的最大值上，LR指针不算在内。
            if (isAThanB(right.val, left.val)) {
                cur.next = left;
                cur = left;
                left = left.next;
            } else if (isAEqualsB(right.val, left.val)) {
                cur = cur.next;
                if (cur == right) right = right.next;
                else left = left.next;
            } else {
                cur.next = right;
                cur = right;
                right = right.next;
            }
        }
        cur.next = (left == null ? right : left);
        return head;
    }

    public boolean isAThanB(Object a, Object b) {
        return (int) a > (int) b;
    }

    public boolean isAEqualsB(Object a, Object b) {
        return (int) a == (int) b;
    }

    /**
     * 2. 双指针
     * 复杂度分析
     * 时间复杂度：O(n+m)，其中 n 和 m 分别为两个链表的长度。因为每次循环迭代中，l1 和 l2 只有一个元素会被放进合并链表中， 因此 while 循环的次数不会超过两个链表的长度之和。所有其他操作的时间复杂度都是常数级别的，因此总的时间复杂度为 O(n+m)。
     * 空间复杂度：O(1)。我们只需要常数的空间存放若干变量。
     *
     * @author tiankai.me@gmail.com on 2022/8/21 7:50.
     */
    public ListNode mergeTwoListsV2(ListNode l1, ListNode l2) {
        ListNode preHead = new ListNode(-1);
        ListNode prev = preHead;
        while (l1 != null && l2 != null) {
            if ((int) (l1.val) <= (int) (l2.val)) {
                prev.next = l1;
                l1 = l1.next;
            } else {
                prev.next = l2;
                l2 = l2.next;
            }
            prev = prev.next;
        }
        // 合并后 l1 和 l2 最多只有一个还未被合并完，我们直接将链表末尾指向未合并完的链表即可
        prev.next = l1 == null ? l2 : l1;
        return preHead.next;
    }

    /**
     * 3. 递归
     * 执行用时： 0 ms , 在所有 Java 提交中击败了 100.00% 的用户
     * 内存消耗： 40.8 MB , 在所有 Java 提交中击败了 79.55% 的用户
     *
     * @author tiankai.me@gmail.com on 2022/8/24 10:23.
     */
    public ListNode mergeTwoListsV3(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        } else if ((int) l1.val < (int) l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }

}
