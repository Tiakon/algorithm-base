package cn.tiakon.java.leetcode.stack.monotone;

import cn.tiakon.java.leetcode.datastructure.ListNode;
import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 6247. 从链表中移除节点
 * https://leetcode.cn/problems/remove-nodes-from-linked-list/
 * @author tiankai.me@gmail.com on 2022/11/27 下午11:47.
 */
public class LC2487RemoveNodesFromLinkedList {
    /**
     * 迭代法:单调栈
     * 执行用时： 23 ms , 在所有 Java 提交中击败了 100.00% 的用户
     * 内存消耗： 60.7 MB , 在所有 Java 提交中击败了 100.00% 的用户
     * 通过测试用例： 32 / 32
     * @author tiankai.me@gmail.com on 2022/11/27 下午11:46.
     */
    public ListNode removeNodes(ListNode<Integer> head) {
        ListNode<Integer> node = head;
        Deque<ListNode<Integer>> deque = new ArrayDeque<>();
        while (node != null) {
            while (!deque.isEmpty() && node.val > deque.peek().val) {
                ListNode<Integer> pop = deque.pop();
                pop.val = node.val;
                pop.next = node.next;
                node=pop;
            }
            deque.push(node);
            node = node.next;
        }
        return head;
    }

    // 递归法
//    public ListNode<Integer> removeNodesV2(ListNode<Integer> head) {
//        return fun(head);
//    }
//    ListNode<Integer> fun(ListNode<Integer> h) {
//        if (h.next == null) return h;
//        h.next = fun(h.next); //更新下一个结点
//        if (h.val < h.next.val) return h.next;
//        return h;
//    }
    @Test
    public void removeNodesTest() {
        LC2487RemoveNodesFromLinkedList removeNodesFromLinkedList = new LC2487RemoveNodesFromLinkedList();
        ListNode<Integer> node119 = new ListNode<>(119);
        ListNode<Integer> node2 = new ListNode<>(2,node119);
        ListNode<Integer> node19 = new ListNode<>(19,node2);
        ListNode<Integer> node7 = new ListNode<>(7,node19);
        ListNode<Integer> node8 = new ListNode<>(8,node7);
        ListNode<Integer> node29 = new ListNode<>(29,node8);
        ListNode<Integer> node6 = new ListNode<>(6,node29);
        ListNode<Integer> node5 = new ListNode<>(5,node6);
        ListNode listNode = removeNodesFromLinkedList.removeNodes(node5);
    }

}
