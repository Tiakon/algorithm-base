package cn.tiakon.java.leetcode.linked;

import cn.tiakon.java.leetcode.datastructure.ListNode;
import cn.tiakon.java.leetcode.linked.merge.LC23MergeKSortedLists;
import org.junit.Test;

public class LC23MergeKSortedListsTest {

    @Test
    public void case01Test() {
        final LC23MergeKSortedLists mergeKSortedLists = new LC23MergeKSortedLists();

        final ListNode node31 = new ListNode(31);
        final ListNode node21 = new ListNode(21, node31);
        final ListNode node11 = new ListNode(11, node21);

        final ListNode node3 = new ListNode(3);
        final ListNode node2 = new ListNode(2, node3);
        final ListNode node1 = new ListNode(1, node2);

        final ListNode node7 = new ListNode(7);
        final ListNode node6 = new ListNode(6, node7);
        final ListNode node5 = new ListNode(5, node6);
        final ListNode node4 = new ListNode(4, node5);

        final ListNode node = mergeKSortedLists.mergeKLists(new ListNode[]{node11, node1, node4});
        System.out.println(node);
    }

    @Test
    public void case02Test() {
        final LC23MergeKSortedLists mergeKSortedLists = new LC23MergeKSortedLists();

        final ListNode node5 = new ListNode(5);
        final ListNode node4 = new ListNode(4, node5);
        final ListNode node1 = new ListNode(1, node4);


        final ListNode node44 = new ListNode(4);
        final ListNode node3 = new ListNode(3, node44);
        final ListNode node12 = new ListNode(1, node3);

        final ListNode node6 = new ListNode(6);
        final ListNode node2 = new ListNode(2, node6);

        final ListNode node = mergeKSortedLists.mergeKLists(new ListNode[]{node1, node12, node2});
        System.out.println(node);
    }

    @Test
    public void case03Test() {
        final LC23MergeKSortedLists mergeKSortedLists = new LC23MergeKSortedLists();
        final ListNode node1 = new ListNode(1);
        final ListNode node = mergeKSortedLists.mergeKLists(new ListNode[]{null, node1});
        System.out.println(node);
    }

    @Test
    public void case04Test() {
        LC23MergeKSortedLists mergeKSortedLists = new LC23MergeKSortedLists();
        ListNode node5 = new ListNode(5);
        ListNode node4 = new ListNode(4, node5);
        ListNode node1 = new ListNode(1, node4);
        ListNode node44 = new ListNode(4);
        ListNode node3 = new ListNode(3, node44);
        ListNode node12 = new ListNode(1, node3);
        ListNode node6 = new ListNode(6);
        ListNode node2 = new ListNode(2, node6);

        ListNode[] lists = {node1, node12, node2};

        ListNode node = mergeKSortedLists.mergeKListsPriorityQueue(lists);
        System.out.println(node);
    }
}
