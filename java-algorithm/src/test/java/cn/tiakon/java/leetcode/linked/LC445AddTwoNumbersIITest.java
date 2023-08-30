package cn.tiakon.java.leetcode.linked;

import cn.tiakon.java.leetcode.datastructure.ListNode;
import cn.tiakon.java.utils.MathRandomUtil;
import org.junit.Test;

public class LC445AddTwoNumbersIITest {
    @Test
    public void case01Test() {
        ListNode node4 = new ListNode(4);
        ListNode node3 = new ListNode(3, node4);
        ListNode node2 = new ListNode(2, node3);
        ListNode node1 = new ListNode(1, node2);
        ListNode node = new ListNode(0, node1);

        final LC445AddTwoNumbersII addTwoNumbersII = new LC445AddTwoNumbersII();
        final ListNode ans = addTwoNumbersII.reverseList(node);
        MathRandomUtil.printListNode(ans);
    }

    @Test
    public void case02Test() {
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4, node3);
        ListNode node2 = new ListNode(2, node4);
        ListNode node7 = new ListNode(7, node2);

        ListNode node_4 = new ListNode(4);
        ListNode node6 = new ListNode(6, node_4);
        ListNode node5 = new ListNode(5, node6);

        final LC445AddTwoNumbersII addTwoNumbersII = new LC445AddTwoNumbersII();
        final ListNode ans = addTwoNumbersII.addTwoNumbers(node7, node5);
        //  7 8 0 7
        MathRandomUtil.printListNode(ans);
    }

    @Test
    public void case03Test() {
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4, node3);
        ListNode node2 = new ListNode(2, node4);
        ListNode node7 = new ListNode(7, node2);

        ListNode node_4 = new ListNode(4);
        ListNode node6 = new ListNode(6, node_4);
        ListNode node5 = new ListNode(5, node6);

        final LC445AddTwoNumbersII addTwoNumbersII = new LC445AddTwoNumbersII();
        final ListNode ans = addTwoNumbersII.addTwoNumbersV2(node7, node5);
        //  7 8 0 7
        MathRandomUtil.printListNode(ans);
    }
}
