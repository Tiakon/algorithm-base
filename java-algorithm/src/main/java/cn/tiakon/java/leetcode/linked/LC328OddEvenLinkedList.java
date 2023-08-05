package cn.tiakon.java.leetcode.linked;

import cn.tiakon.java.leetcode.datastructure.ListNode;
import org.junit.Test;

/**
 * 328. 奇偶链表
 * https://leetcode.cn/problems/odd-even-linked-list/
 *
 * @author tiankai.me@gmail.com on 2023-08-05 14:29.
 */
public class LC328OddEvenLinkedList {
    /**
     * 快慢指针解法
     * 复杂度分析
     * 时间复杂度： O(n)，其中 n 是链表的节点数。需要遍历链表中的每个节点，并更新指针。
     * 空间复杂度： O(1)。只需要维护有限的指针。
     *
     * @author tiankai.me@gmail.com on 2023-08-05 15:42.
     */
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode head2 = head.next;
        ListNode node = head, node2 = null;
        while (node.next != null) {
            final ListNode nextNode = node.next;
            if (node2 == null) node2 = nextNode;
            else {
                node2.next = nextNode;
                node2 = node2.next;
            }
            if (nextNode.next == null) break;
            node.next = nextNode.next;
            node = node.next;
            node2.next = null;
        }
        node.next = head2;
        return head;
    }

    public ListNode oddEvenListV2(ListNode head) {
        if (head == null) return head;
        ListNode evenHead = head.next;
        ListNode odd = head, even = evenHead;
        while (even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;
    }


    @Test
    public void case01Test() {
        final LC328OddEvenLinkedList oddEvenLinkedList = new LC328OddEvenLinkedList();
        final ListNode<Integer> node5 = new ListNode<>(5);
        final ListNode<Integer> node4 = new ListNode<>(4, node5);
        final ListNode<Integer> node3 = new ListNode<>(3, node4);
        final ListNode<Integer> node2 = new ListNode<>(2, node3);
        final ListNode<Integer> node = new ListNode<>(1, node2);
        System.out.println(oddEvenLinkedList.oddEvenList(node));
    }

    @Test
    public void case02Test() {
        final LC328OddEvenLinkedList oddEvenLinkedList = new LC328OddEvenLinkedList();
        final ListNode<Integer> node6 = new ListNode<>(6);
        final ListNode<Integer> node5 = new ListNode<>(5, node6);
        final ListNode<Integer> node4 = new ListNode<>(4, node5);
        final ListNode<Integer> node3 = new ListNode<>(3, node4);
        final ListNode<Integer> node2 = new ListNode<>(2, node3);
        final ListNode<Integer> node = new ListNode<>(1, node2);
        System.out.println(oddEvenLinkedList.oddEvenList(node));
    }
}
