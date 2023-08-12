package cn.tiakon.java.leetcode.linked;

import cn.tiakon.java.leetcode.datastructure.ListNode;
import cn.tiakon.java.utils.MathRandomUtil;
import org.junit.Assert;
import org.junit.Test;

/**
 * 86. 分隔链表
 * https://leetcode.cn/problems/partition-list/
 *
 * @author tiankai.me@gmail.com on 2023-08-05 17:51.
 */
public class LC86PartitionList {
    /**
     * 模拟流程
     * 复杂度分析
     * 时间度分析：O(N)
     * 空间度分析：O(1)
     *
     * @author tiankai.me@gmail.com on 2023-08-06 0:44.
     */
    public ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null) return head;
        final ListNode tempNode = new ListNode(-101);
        tempNode.next = head;
        ListNode node = tempNode;
        ListNode node1 = null, head2 = null, node2 = null;
        while (node.next != null) {
            if ((int) node.val >= x) {
                if (head2 != null) {
                    node2.next = node;
                    node2 = node2.next;
                } else {
                    head2 = node;
                    node2 = head2;
                }
            } else {
                if (node1 == null) node1 = node;
                else {
                    node1.next = node;
                    node1 = node1.next;
                }
            }
            node = node.next;
        }
        if (head2 != null && node2 != null && node1 != null) {
            if ((int) node.val >= x) node2.next = node;
            else {
                node2.next = null;
                node1.next = node;
                node1 = node1.next;
            }
            node1.next = head2;
        }
        return tempNode.next;
    }

    /**
     * 创建两个虚拟头结点，将小于x值的节点和大于等于x值的节点分别拆分链接上即可。
     *
     * @author tiankai.me@gmail.com on 2023-08-06 7:25.
     */
    public ListNode partitionV2(ListNode head, int x) {
        ListNode small = new ListNode(0);
        ListNode smallHead = small;
        ListNode large = new ListNode(0);
        ListNode largeHead = large;
        while (head != null) {
            if ((int) head.val < x) {
                small.next = head;
                small = small.next;
            } else {
                large.next = head;
                large = large.next;
            }
            head = head.next;
        }
        large.next = null;
        small.next = largeHead.next;
        return smallHead.next;
    }
}
