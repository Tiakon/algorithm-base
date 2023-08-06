package cn.tiakon.java.leetcode.linked;

import cn.tiakon.java.leetcode.datastructure.ListNode;
import cn.tiakon.java.utils.MathRandomUtil;
import org.junit.Test;

/**
 * 61. 旋转链表
 * https://leetcode.cn/problems/rotate-list/
 *
 * @author tiankai.me@gmail.com on 2023-08-06 12:11.
 */
public class LC61RotateList {
    /**
     * 可以借鉴删除倒数第N个节点的思路，使用双指针解决
     * 复杂度分析
     * 时间复杂度：O(2n),第一次遍历链表长度，第二次快指针先移k-1次，然后在于慢指针同步移动。
     * 空间复杂度：O(1)
     * @author tiankai.me@gmail.com on 2023-08-06 12:48.
     */
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || k == 0) return head;
        ListNode curr = head;
        int size = 0;
        while (curr != null) {
            curr = curr.next;
            ++size;
        }
        k = k % size;
        ListNode low = head, fast = head;
        for (int i = 0; i < k && fast != null; i++) {
            fast = fast.next;
        }
        while (fast != null && fast.next != null) {
            low = low.next;
            fast = fast.next;
        }
        fast.next = head;
        head = low.next;
        low.next = null;
        return head;
    }

    @Test
    public void case01Test() {
        final LC61RotateList rotateList = new LC61RotateList();
        final ListNode node5 = new ListNode(5);
        final ListNode node4 = new ListNode(4, node5);
        final ListNode node3 = new ListNode(3, node4);
        final ListNode node2 = new ListNode(2, node3);
        final ListNode node1 = new ListNode(1, node2);
        final ListNode node = rotateList.rotateRight(node1, 2);
        MathRandomUtil.printListNode(node);
    }

    @Test
    public void case02Test() {
        final LC61RotateList rotateList = new LC61RotateList();
        final ListNode node3 = new ListNode(2);
        final ListNode node2 = new ListNode(1, node3);
        final ListNode node1 = new ListNode(0, node2);
        final ListNode node = rotateList.rotateRight(node1, 4);
        MathRandomUtil.printListNode(node);
    }

}
