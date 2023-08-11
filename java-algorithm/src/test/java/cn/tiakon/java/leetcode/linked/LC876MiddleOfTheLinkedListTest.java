package cn.tiakon.java.leetcode.linked;

import cn.tiakon.java.leetcode.datastructure.ListNode;
import cn.tiakon.java.utils.MathRandomUtil;
import org.junit.Assert;
import org.junit.Test;

public class LC876MiddleOfTheLinkedListTest {

    @Test
    public void middleNodeTest() {
        final LC876MiddleOfTheLinkedList lc876MiddleOfTheLinkedList = new LC876MiddleOfTheLinkedList();
        final ListNode head = new ListNode(1);
        final ListNode node2 = new ListNode(2);
        final ListNode node3 = new ListNode(3);
        final ListNode node4 = new ListNode(4);
        final ListNode node5 = new ListNode(5);
        head.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        final ListNode middleNode = lc876MiddleOfTheLinkedList.middleNode(head);

        Assert.assertEquals(3, middleNode.val);
        Assert.assertEquals(4, middleNode.next.val);
        Assert.assertEquals(5, middleNode.next.next.val);
    }

    @Test
    public void middleNodeV2Test() {
        final LC876MiddleOfTheLinkedList lc876MiddleOfTheLinkedList = new LC876MiddleOfTheLinkedList();
        final ListNode head = new ListNode(1);
        final ListNode node2 = new ListNode(2);
        final ListNode node3 = new ListNode(3);
        final ListNode node4 = new ListNode(4);
        final ListNode node5 = new ListNode(5);
        head.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        final ListNode middleNode = lc876MiddleOfTheLinkedList.middleNodeV2(head);

        Assert.assertEquals(3, middleNode.val);
        Assert.assertEquals(4, middleNode.next.val);
        Assert.assertEquals(5, middleNode.next.next.val);
    }

    @Test
    public void middleNodeV3Test() {
        final LC876MiddleOfTheLinkedList lc876MiddleOfTheLinkedList = new LC876MiddleOfTheLinkedList();
        ListNode head = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        head.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        ListNode middleNode = lc876MiddleOfTheLinkedList.middleNodeV3(head);

        Assert.assertEquals(3, middleNode.val);
        Assert.assertEquals(4, middleNode.next.val);
        Assert.assertEquals(5, middleNode.next.next.val);

        head = new ListNode(1);
        node2 = new ListNode(2);
        head.next = node2;
        middleNode = lc876MiddleOfTheLinkedList.middleNodeV3(head);
        Assert.assertEquals(2, middleNode.val);
    }

    @Test
    public void middleNodeBenchmarkTest() {
        final LC876MiddleOfTheLinkedList lc876MiddleOfTheLinkedList = new LC876MiddleOfTheLinkedList();
        for (int i = 0; i < 1000; i++) {
            final ListNode randomListNode = MathRandomUtil.createRandomListNode(10, 100);
            final ListNode middleNode = lc876MiddleOfTheLinkedList.middleNode(randomListNode);
            final ListNode middleNodeV2 = lc876MiddleOfTheLinkedList.middleNodeV2(randomListNode);
            final ListNode middleNodeV3 = lc876MiddleOfTheLinkedList.middleNodeV3(randomListNode);
            Assert.assertEquals(middleNode, middleNodeV2);
            Assert.assertEquals(middleNode, middleNodeV3);
        }
    }
}
