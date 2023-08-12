package cn.tiakon.java.leetcode.linked;

import cn.tiakon.java.leetcode.datastructure.ListNode;
import org.junit.Assert;
import org.junit.Test;

public class LC160IntersectionOfTwoLinkedListsTest {
    @Test
    public void case01Test() {
        final LC160IntersectionOfTwoLinkedLists intersectionOfTwoLinkedLists = new LC160IntersectionOfTwoLinkedLists();
        final ListNode node4 = new ListNode(4);
        final ListNode node2 = new ListNode(2, node4);
        final ListNode headB = new ListNode(3, node2);
        final ListNode node1 = new ListNode(1, node2);
        final ListNode node9 = new ListNode(9, node1);
        final ListNode headA = new ListNode(0, node9);
        Assert.assertEquals(node2, intersectionOfTwoLinkedLists.getIntersectionNode(headA, headB));
    }
}
