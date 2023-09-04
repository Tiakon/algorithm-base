package cn.tiakon.java.leetcode.linked;

import cn.tiakon.java.leetcode.datastructure.ListNode;
import cn.tiakon.java.leetcode.linked.sorted.LC147InsertionSortList;
import cn.tiakon.java.utils.MathRandomUtil;
import org.junit.Test;

public class LC147InsertionSortListTest {

    @Test
    public void case01Test() {
        LC147InsertionSortList insertionSortList = new LC147InsertionSortList();

        ListNode node3 = new ListNode(3);
        ListNode node1 = new ListNode(1, node3);
        ListNode node2 = new ListNode(2, node1);
        ListNode node4 = new ListNode(4, node2);

        ListNode ans = insertionSortList.insertionSortList(node4);

        MathRandomUtil.printListNode(ans);
    }

    @Test
    public void case02Test() {
        LC147InsertionSortList insertionSortList = new LC147InsertionSortList();

        ListNode node5 = new ListNode(5);
        ListNode node4 = new ListNode(4, node5);
        ListNode node3 = new ListNode(3, node4);
        ListNode node = new ListNode(0, node3);
        ListNode node1 = new ListNode(-1, node);

        ListNode ans = insertionSortList.insertionSortList(node1);

        MathRandomUtil.printListNode(ans);
    }
}
