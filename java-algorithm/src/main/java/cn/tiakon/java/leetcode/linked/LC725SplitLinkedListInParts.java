package cn.tiakon.java.leetcode.linked;

import cn.tiakon.java.leetcode.datastructure.ListNode;
import org.junit.Test;

/**
 * 725. 分隔链表
 * https://leetcode.cn/problems/split-linked-list-in-parts/
 *
 * @author tiankai.me@gmail.com on 2023-08-11 7:20.
 */
public class LC725SplitLinkedListInParts {

    /**
     * 链表分成k组，尽可能均分。且前面组的长度要大于后面组的长度。
     * 根据链表长度取模，模不为0时，在均分k个组时就多分一个节点，模随每组递减，直到为0；
     * <p>
     * 复杂度分析：
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     *
     * @author tiankai.me@gmail.com on 2023-08-11 11:50.
     */
    public ListNode[] splitListToParts(ListNode head, int k) {
        int size = 0;
        ListNode temp = head, node = head;
        while (temp != null && ++size > 0) temp = temp.next;
        ListNode[] ans;
        int num = size / k, i = size % k;
        ans = new ListNode[k];
        for (int j = 0; j < k && node != null; j++) {
            ans[j] = node;
            for (int l = 1; l < num; l++) node = node.next;
            if (num != 0 && i-- > 0) node = node.next;
            if (node != null) {
                ListNode currLast = node;
                node = node.next;
                currLast.next = null;
            }
        }
        return ans;
    }

    @Test
    public void case01Test() {
        final LC725SplitLinkedListInParts splitLinkedListInParts = new LC725SplitLinkedListInParts();
        int k = 3;
        final ListNode node10 = new ListNode<>(10);
        final ListNode node9 = new ListNode<>(9, node10);
        final ListNode node8 = new ListNode<>(8, node9);
        final ListNode node7 = new ListNode<>(7, node8);
        final ListNode node6 = new ListNode<>(6, node7);
        final ListNode node5 = new ListNode<>(5, node6);
        final ListNode node4 = new ListNode<>(4, node5);
        final ListNode node3 = new ListNode<>(3, node4);
        final ListNode node2 = new ListNode<>(2, node3);
        final ListNode node1 = new ListNode<>(1, node2);

        final ListNode[] listNodes = splitLinkedListInParts.splitListToParts(node1, k);

        for (int i = 0; i < listNodes.length; i++) {
            System.out.println(listNodes[i]);
        }
    }

    @Test
    public void case02Test() {
        final LC725SplitLinkedListInParts splitLinkedListInParts = new LC725SplitLinkedListInParts();
        int k = 3;
        final ListNode node7 = new ListNode<>(7);
        final ListNode node6 = new ListNode<>(6, node7);
        final ListNode node5 = new ListNode<>(5, node6);
        final ListNode node4 = new ListNode<>(4, node5);
        final ListNode node3 = new ListNode<>(3, node4);
        final ListNode node2 = new ListNode<>(2, node3);
        final ListNode node1 = new ListNode<>(1, node2);

        final ListNode[] listNodes = splitLinkedListInParts.splitListToParts(node1, k);

        for (int i = 0; i < listNodes.length; i++) {
            System.out.println(listNodes[i]);
        }
    }

    @Test
    public void case03Test() {
        final LC725SplitLinkedListInParts splitLinkedListInParts = new LC725SplitLinkedListInParts();
        int k = 3;
        final ListNode node8 = new ListNode<>(8);
        final ListNode node7 = new ListNode<>(7, node8);
        final ListNode node6 = new ListNode<>(6, node7);
        final ListNode node5 = new ListNode<>(5, node6);
        final ListNode node4 = new ListNode<>(4, node5);
        final ListNode node3 = new ListNode<>(3, node4);
        final ListNode node2 = new ListNode<>(2, node3);
        final ListNode node1 = new ListNode<>(1, node2);

        final ListNode[] listNodes = splitLinkedListInParts.splitListToParts(node1, k);

        for (int i = 0; i < listNodes.length; i++) {
            System.out.println(listNodes[i]);
        }
    }

    @Test
    public void case04Test() {
        final LC725SplitLinkedListInParts splitLinkedListInParts = new LC725SplitLinkedListInParts();
        int k = 5;
        final ListNode node3 = new ListNode<>(3);
        final ListNode node2 = new ListNode<>(2, node3);
        final ListNode node1 = new ListNode<>(1, node2);
        final ListNode[] listNodes = splitLinkedListInParts.splitListToParts(node1, k);
        for (int i = 0; i < listNodes.length; i++) {
            System.out.println(listNodes[i]);
        }
    }

}
