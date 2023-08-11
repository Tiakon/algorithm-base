package cn.tiakon.java.leetcode.linked;

import cn.tiakon.java.leetcode.datastructure.ListNode;
import cn.tiakon.java.utils.MathRandomUtil;
import org.junit.Assert;
import org.junit.Test;

import java.util.Random;

public class LC206ReverseListTest {


    @Test
    public void reverseListTest() {
        LC206ReverseList lc206ReverseList = new LC206ReverseList();
        ListNode<Integer> node5 = new ListNode<>(5);
        ListNode<Integer> node4 = new ListNode<>(4, node5);
        ListNode<Integer> node3 = new ListNode<>(3, node4);
        ListNode<Integer> node2 = new ListNode<>(2, node3);
        ListNode<Integer> head = new ListNode<>(1, node2);
        ListNode listNode = lc206ReverseList.reverseList(head);
        Assert.assertEquals("54321", MathRandomUtil.listNodeToString(listNode));

        node2 = new ListNode<>(2, null);
        head = new ListNode<>(1, node2);
        listNode = lc206ReverseList.reverseList(head);
        // MathRandomUtil.printListNode(listNode);
        Assert.assertEquals("21", MathRandomUtil.listNodeToString(listNode));

        head = new ListNode<>(1, null);
        listNode = lc206ReverseList.reverseList(head);
        // MathRandomUtil.printListNode(listNode);
        Assert.assertEquals("1", MathRandomUtil.listNodeToString(listNode));
    }

    @Test
    public void reverseListV2Test() {
        LC206ReverseList lc206ReverseList = new LC206ReverseList();
        ListNode<Integer> node5 = new ListNode<>(5);
        ListNode<Integer> node4 = new ListNode<>(4, node5);
        ListNode<Integer> node3 = new ListNode<>(3, node4);
        ListNode<Integer> node2 = new ListNode<>(2, node3);
        ListNode<Integer> head = new ListNode<>(1, node2);
        ListNode listNode = lc206ReverseList.reverseListV2(head);
        Assert.assertEquals("54321", MathRandomUtil.listNodeToString(listNode));

        node2 = new ListNode<>(2, null);
        head = new ListNode<>(1, node2);
        listNode = lc206ReverseList.reverseListV2(head);
        // MathRandomUtil.printListNode(listNode);
        Assert.assertEquals("21", MathRandomUtil.listNodeToString(listNode));

        head = new ListNode<>(1, null);
        listNode = lc206ReverseList.reverseListV2(head);
        // MathRandomUtil.printListNode(listNode);
        Assert.assertEquals("1", MathRandomUtil.listNodeToString(listNode));
    }

    @Test
    public void reverseListBenchmarkTest() {
        LC206ReverseList lc206ReverseList = new LC206ReverseList();
        final Random random = new Random();
        for (int i = 0; i < 10000; i++) {
            final int length = random.nextInt(501);
            final ListNode head = MathRandomUtil.createRandomListNode(length, 5000);
            final String listNodeToString = MathRandomUtil.listNodeToString(lc206ReverseList.reverseList(head.clone()));
            final String listNodeToStringV2 = MathRandomUtil.listNodeToString(lc206ReverseList.reverseListV2(head.clone()));
            if (!listNodeToString.equals(listNodeToStringV2)) {
                System.out.println(MathRandomUtil.listNodeToString(head));
            }
            Assert.assertEquals(listNodeToString, listNodeToStringV2);
        }
    }


}
