package cn.tiakon.java.leetcode.linked.remove;

import cn.tiakon.java.leetcode.datastructure.ListNode;
import cn.tiakon.java.utils.MathRandomUtil;
import org.junit.Test;

/**
 * 2181. 合并零之间的节点
 * https://leetcode.cn/problems/merge-nodes-in-between-zeros/
 *
 * @author tiankai.me@gmail.com on 2023-08-29 16:44.
 */
public class LC2181MergeNodesInBetweenZeros {

    /**
     * 返回新的链表（添加虚拟节点方便操作）
     * 复杂度分析：
     * 时间复杂度：O(n)，其中 n 是给定链表的长度。
     * 空间复杂度：O(m)，其中 m 是新链表的长度。
     *
     * @author tiankai.me@gmail.com on 2023-08-29 17:54.
     */
    public ListNode mergeNodes(ListNode head) {
        ListNode dummy = new ListNode<>(-1);
        ListNode node = dummy, curr = head, prev = dummy;
        while (curr != null) {
            int val = (int) curr.val;
            if (val == 0) {
                ListNode<Integer> newNode = new ListNode<>(0);
                node.next = newNode;
                prev = node;
                node = newNode;
            } else node.val = (int) node.val + val;
            curr = curr.next;
        }
        prev.next = null;
        return dummy.next;
    }

    /**
     * 原链表修改（添加虚拟节点方便操作）
     * 复杂度分析：
     * 时间复杂度：O(n) ，其中 n 是给定链表的长度。
     * 空间复杂度：O(1)
     *
     * @author tiankai.me@gmail.com on 2023-08-29 17:54.
     */
    public ListNode mergeNodesV2(ListNode head) {
        ListNode dummy = new ListNode<>(0, head);
        ListNode curr = dummy, prev = null;
        while (curr.next != null) {
            int val2 = (int) curr.next.val;
            if (val2 == 0) {
                prev = curr;
                curr = curr.next;
            } else {
                curr.val = (int) curr.val + val2;
                curr.next = curr.next.next;
            }
        }
        prev.next = null;
        return dummy.next;
    }

    /**
     * 递归解法
     *
     * @author tiankai.me@gmail.com on 2023-08-29 18:00.
     */
    public ListNode mergeNodesV3(ListNode head) {
        if (head.next == null) {
            head = null;
            return head;
        }
        ListNode l = head.next;
        while ((int) l.val != 0) {
            head.val = (int) head.val + (int) l.val;
            l = l.next;
        }
        head.next = mergeNodesV3(l);
        return head;
    }

}