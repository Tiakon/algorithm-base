package cn.tiakon.java.leetcode.linked;

import cn.tiakon.java.leetcode.datastructure.ListNode;
import cn.tiakon.java.utils.MathRandomUtil;
import org.junit.Test;

public class LC24SwapNodesInPairsTest {

    @Test
    public void case01Test() {
        final LC24SwapNodesInPairs swapNodesInPairs = new LC24SwapNodesInPairs();
        final ListNode node4 = new ListNode(4);
        final ListNode node3 = new ListNode(3, node4);
        final ListNode node2 = new ListNode(2, node3);
        final ListNode head = new ListNode(1, node2);
        final ListNode ans = swapNodesInPairs.swapPairs(head);
        MathRandomUtil.printListNode(ans);
    }

    @Test
    public void case02Test() {
        final LC24SwapNodesInPairs swapNodesInPairs = new LC24SwapNodesInPairs();
        final ListNode node6 = new ListNode(6);
        final ListNode node5 = new ListNode(5,node6);
        final ListNode node4 = new ListNode(4,node5);
        final ListNode node3 = new ListNode(3, node4);
        final ListNode node2 = new ListNode(2, node3);
        final ListNode head = new ListNode(1, node2);
        final ListNode ans = swapNodesInPairs.swapPairs(head);
        MathRandomUtil.printListNode(ans);
    }

}
