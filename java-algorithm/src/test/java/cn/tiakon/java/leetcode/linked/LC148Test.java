package cn.tiakon.java.leetcode.linked;

import cn.tiakon.java.leetcode.datastructure.ListNode;
import cn.tiakon.java.leetcode.linked.sorted.LC148SortList;
import org.junit.Test;

public class LC148Test {

    @Test
    public void case01Test() {
        final LC148SortList lc148SortList = new LC148SortList();
        final ListNode<Integer> node6 = new ListNode<>(1);
        final ListNode<Integer> node5 = new ListNode<>(2, node6);
        final ListNode<Integer> node4 = new ListNode<>(3, node5);
        final ListNode<Integer> node3 = new ListNode<>(4, node4);
        final ListNode<Integer> node2 = new ListNode<>(5, node3);
        final ListNode<Integer> node = new ListNode<>(6, node2);
        final ListNode ans = lc148SortList.sortList(node);
        System.out.println(ans);
    }

    @Test
    public void case02Test() {
        final LC148SortList lc148SortList = new LC148SortList();
        final ListNode<Integer> node6 = new ListNode<>(1);
        final ListNode<Integer> node5 = new ListNode<>(2, node6);
        final ListNode<Integer> node4 = new ListNode<>(3, node5);
        final ListNode<Integer> node3 = new ListNode<>(4, node4);
        final ListNode<Integer> node2 = new ListNode<>(5, node3);
        final ListNode<Integer> node = new ListNode<>(6, node2);
        final ListNode ans = lc148SortList.sortListV2(node);
        System.out.println(ans);
    }

}
