package cn.tiakon.java.leetcode.linked;

import cn.tiakon.java.leetcode.datastructure.ListNode;
import cn.tiakon.java.leetcode.linked.merge.LC1669MergeInBetweenLinkedLists;
import org.junit.Test;

public class LC1669MergeInBetweenLinkedListsTest {


    @Test
    public void case01Test() {

        final LC1669MergeInBetweenLinkedLists mergeInBetweenLinkedLists = new LC1669MergeInBetweenLinkedLists();

        ListNode node5 = new ListNode(5);
        ListNode node4 = new ListNode(4, node5);
        ListNode node3 = new ListNode(3, node4);
        ListNode node2 = new ListNode(2, node3);
        ListNode node1 = new ListNode(1, node2);
        ListNode node = new ListNode(0, node1);

        ListNode node102 = new ListNode(102);
        ListNode node101 = new ListNode(101, node102);
        ListNode node100 = new ListNode(100, node101);

        final ListNode ans = mergeInBetweenLinkedLists.mergeInBetween(node, 3, 4, node100);
        System.out.println(ans);
    }

    @Test
    public void case02Test() {

        LC1669MergeInBetweenLinkedLists mergeInBetweenLinkedLists = new LC1669MergeInBetweenLinkedLists();

        ListNode node6 = new ListNode(6);
        ListNode node5 = new ListNode(5, node6);
        ListNode node4 = new ListNode(4, node5);
        ListNode node3 = new ListNode(3, node4);
        ListNode node2 = new ListNode(2, node3);
        ListNode node1 = new ListNode(1, node2);
        ListNode node = new ListNode(0, node1);

        ListNode node104 = new ListNode(104);
        ListNode node103 = new ListNode(103, node104);
        ListNode node102 = new ListNode(102, node103);
        ListNode node101 = new ListNode(101, node102);
        ListNode node100 = new ListNode(100, node101);

        final ListNode ans = mergeInBetweenLinkedLists.mergeInBetween(node, 2, 5, node100);
        System.out.println(ans);
    }

}
