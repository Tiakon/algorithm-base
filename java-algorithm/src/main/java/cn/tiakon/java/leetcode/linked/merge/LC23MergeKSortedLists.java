package cn.tiakon.java.leetcode.linked.merge;

import cn.tiakon.java.leetcode.datastructure.ListNode;
import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;
import java.util.PriorityQueue;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 23. 合并 K 个升序链表
 * https://leetcode.cn/problems/merge-k-sorted-lists/description/
 *
 * @author tiankai.me@gmail.com on 2023-08-12 11:25.
 */
public class LC23MergeKSortedLists {
    /**
     * 模拟
     *
     * @author tiankai.me@gmail.com on 2023-08-13 10:17.
     */
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null) return null;
        lists = Arrays.stream(lists).filter(Objects::nonNull).toArray(ListNode[]::new);
        if (lists.length == 1) return lists[0];
        ListNode temp = new ListNode(Integer.MIN_VALUE, null);
        for (int i = 1; i < lists.length; i++) {
            ListNode node = temp;
            ListNode left = lists[i - 1];
            ListNode right = lists[i];
            while (left != null && right != null) {
                if ((int) left.val <= (int) right.val) {
                    ListNode next = left.next;
                    node.next = left;
                    left = next;
                } else {
                    ListNode next = right.next;
                    node.next = right;
                    right = next;
                }
                node = node.next;
                if (left == null) node.next = right;
                if (right == null) node.next = left;
            }
            lists[i] = temp;
        }
        return temp.next;
    }

    /**
     * 使用优先队列
     * 复杂度分析
     * 时间复杂度：O(nlogk)，其中 k 为 lists 的长度，n 为所有链表的节点数之和。
     * 空间复杂度：O(k)。堆中至多有 k 个元素。
     *
     * @author tiankai.me@gmail.com on 2023-08-13 10:17.
     */
    public ListNode mergeKListsPriorityQueue(ListNode[] lists) {
        PriorityQueue<ListNode> queue = Stream.of(lists).filter(Objects::nonNull).collect(Collectors.toCollection(() -> new PriorityQueue<>(Comparator.comparingInt(a -> (int) a.val))));
        ListNode temp = new ListNode(), node = temp;
        while (!queue.isEmpty()) {
            ListNode min = queue.poll();
            node.next = min;
            node = node.next;
            if (min.next != null) queue.add(min.next);
        }
        return temp.next;
    }

    /**
     * 分治
     * 时间复杂度： O(nlogk)，其中 k 为 lists  的长度，n 为所有链表的节点数之和。每个节点参与链表合并的次数为 O(logk) 次，一共有  n 个节点，所以总的时间复杂度为 O(nlogk)。
     * 空间复杂度： O(logk)。递归深度为  O(logk)，需要用到 O(logk) 的栈空间。Python 忽略切片产生的额外空间。
     *
     * @author tiankai.me@gmail.com on 2023-08-13 10:59.
     */
    public ListNode mergeKListsV2(ListNode[] lists) {
        return mergeKListsV2(lists, 0, lists.length);
    }

    // 合并从 lists[i] 到 lists[j-1] 的链表
    private ListNode mergeKListsV2(ListNode[] lists, int i, int j) {
        int m = j - i;
        if (m == 0) return null; // 注意输入的 lists 可能是空的
        if (m == 1) return lists[i]; // 无需合并，直接返回
        ListNode left = mergeKListsV2(lists, i, i + m / 2); // 合并左半部分
        ListNode right = mergeKListsV2(lists, i + m / 2, j); // 合并右半部分
        return mergeTwoLists(left, right); // 最后把左半和右半合并
    }

    // 21. 合并两个有序链表
    private ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(); // 用哨兵节点简化代码逻辑
        ListNode cur = dummy; // cur 指向新链表的末尾
        while (list1 != null && list2 != null) {
            if ((int) list1.val < (int) list2.val) {
                cur.next = list1; // 把 list1 加到新链表中
                list1 = list1.next;
            } else { // 注：相等的情况加哪个节点都是可以的
                cur.next = list2; // 把 list2 加到新链表中
                list2 = list2.next;
            }
            cur = cur.next;
        }
        cur.next = list1 != null ? list1 : list2; // 拼接剩余链表
        return dummy.next;
    }


    /**
     * 最小堆
     * 复杂度分析
     * 时间复杂度：O(nlogk)，其中 k 为 lists 的长度，n 为所有链表的节点数之和。
     * 空间复杂度：O(k)。堆中至多有 k 个元素。
     *
     * @author tiankai.me@gmail.com on 2023-08-13 10:17.
     */
    public ListNode mergeKListsHeap(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>(Comparator.comparingInt(a -> (int) a.val));
        for (ListNode head : lists)
            if (head != null) pq.offer(head);
        ListNode dummy = new ListNode(); // 哨兵节点，作为合并后链表头节点的前一个节点
        ListNode cur = dummy;
        while (!pq.isEmpty()) { // 循环直到堆为空
            ListNode node = pq.poll(); // 剩余节点中的最小节点
            if (node.next != null) // 下一个节点不为空
                pq.offer(node.next); // 下一个节点有可能是最小节点，入堆
            cur.next = node; // 合并到新链表中
            cur = cur.next; // 准备合并下一个节点
        }
        return dummy.next; // 哨兵节点的下一个节点就是新链表的头节点
    }
}
