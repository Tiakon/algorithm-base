package cn.tiakon.java.leetcode.linked;

import cn.tiakon.java.leetcode.datastructure.ListNode;
import cn.tiakon.java.utils.MathRandomUtil;
import org.junit.Assert;
import org.junit.Test;

import java.util.Random;

public class LC19RemoveNthNodeFromEndOfListTest {
    @Test
    public void removeNthFromEndTest() {
        final LC19RemoveNthNodeFromEndOfList lc19RemoveNthNodeFromEndOfList = new LC19RemoveNthNodeFromEndOfList();

        ListNode head = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        head.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        ListNode removeNthFromEnd = lc19RemoveNthNodeFromEndOfList.removeNthFromEnd(head, 2);

        Assert.assertEquals(1, removeNthFromEnd.val);
        Assert.assertEquals(2, removeNthFromEnd.next.val);
        Assert.assertEquals(3, removeNthFromEnd.next.next.val);
        Assert.assertEquals(5, removeNthFromEnd.next.next.next.val);
        Assert.assertEquals(null, removeNthFromEnd.next.next.next.next);

        head = new ListNode(1);
        node2 = new ListNode(2);
        head.next = node2;
        removeNthFromEnd = lc19RemoveNthNodeFromEndOfList.removeNthFromEnd(head, 1);
        Assert.assertEquals(1, removeNthFromEnd.val);
        Assert.assertEquals(null, removeNthFromEnd.next);

        head = new ListNode(1);
        removeNthFromEnd = lc19RemoveNthNodeFromEndOfList.removeNthFromEnd(head, 1);
        Assert.assertEquals(null, removeNthFromEnd);

        head = new ListNode(1);
        node2 = new ListNode(2);
        node3 = new ListNode(3);
        node4 = new ListNode(4);
        node5 = new ListNode(5);
        head.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        removeNthFromEnd = lc19RemoveNthNodeFromEndOfList.removeNthFromEnd(head, 5);

        Assert.assertEquals(2, removeNthFromEnd.val);
        Assert.assertEquals(3, removeNthFromEnd.next.val);
        Assert.assertEquals(4, removeNthFromEnd.next.next.val);
        Assert.assertEquals(5, removeNthFromEnd.next.next.next.val);
        Assert.assertEquals(null, removeNthFromEnd.next.next.next.next);
    }

    @Test
    public void removeNthFromEndV1Test() {
        final LC19RemoveNthNodeFromEndOfList lc19RemoveNthNodeFromEndOfList = new LC19RemoveNthNodeFromEndOfList();

        ListNode head = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        head.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        ListNode removeNthFromEnd = lc19RemoveNthNodeFromEndOfList.removeNthFromEndV1(head, 2);

        Assert.assertEquals(1, removeNthFromEnd.val);
        Assert.assertEquals(2, removeNthFromEnd.next.val);
        Assert.assertEquals(3, removeNthFromEnd.next.next.val);
        Assert.assertEquals(5, removeNthFromEnd.next.next.next.val);
        Assert.assertEquals(null, removeNthFromEnd.next.next.next.next);

        head = new ListNode(1);
        node2 = new ListNode(2);
        head.next = node2;
        removeNthFromEnd = lc19RemoveNthNodeFromEndOfList.removeNthFromEndV1(head, 1);
        Assert.assertEquals(1, removeNthFromEnd.val);
        Assert.assertEquals(null, removeNthFromEnd.next);

        head = new ListNode(1);
        removeNthFromEnd = lc19RemoveNthNodeFromEndOfList.removeNthFromEndV1(head, 1);
        Assert.assertEquals(null, removeNthFromEnd);

        head = new ListNode(1);
        node2 = new ListNode(2);
        node3 = new ListNode(3);
        node4 = new ListNode(4);
        node5 = new ListNode(5);
        head.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        removeNthFromEnd = lc19RemoveNthNodeFromEndOfList.removeNthFromEndV1(head, 5);

        Assert.assertEquals(2, removeNthFromEnd.val);
        Assert.assertEquals(3, removeNthFromEnd.next.val);
        Assert.assertEquals(4, removeNthFromEnd.next.next.val);
        Assert.assertEquals(5, removeNthFromEnd.next.next.next.val);
        Assert.assertEquals(null, removeNthFromEnd.next.next.next.next);
    }

    @Test
    public void removeNthFromEndArrayTest() {
        final LC19RemoveNthNodeFromEndOfList lc19RemoveNthNodeFromEndOfList = new LC19RemoveNthNodeFromEndOfList();

        ListNode head = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        head.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        ListNode removeNthFromEnd = lc19RemoveNthNodeFromEndOfList.removeNthFromEndArray(head, 2);

        Assert.assertEquals(1, removeNthFromEnd.val);
        Assert.assertEquals(2, removeNthFromEnd.next.val);
        Assert.assertEquals(3, removeNthFromEnd.next.next.val);
        Assert.assertEquals(5, removeNthFromEnd.next.next.next.val);
        Assert.assertEquals(null, removeNthFromEnd.next.next.next.next);

        head = new ListNode(1);
        node2 = new ListNode(2);
        head.next = node2;
        removeNthFromEnd = lc19RemoveNthNodeFromEndOfList.removeNthFromEndArray(head, 1);
        Assert.assertEquals(1, removeNthFromEnd.val);
        Assert.assertEquals(null, removeNthFromEnd.next);

        head = new ListNode(1);
        removeNthFromEnd = lc19RemoveNthNodeFromEndOfList.removeNthFromEndArray(head, 1);
        Assert.assertEquals(null, removeNthFromEnd);

        head = new ListNode(1);
        node2 = new ListNode(2);
        node3 = new ListNode(3);
        node4 = new ListNode(4);
        node5 = new ListNode(5);
        head.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        removeNthFromEnd = lc19RemoveNthNodeFromEndOfList.removeNthFromEndArray(head, 4);

        Assert.assertEquals(1, removeNthFromEnd.val);
        Assert.assertEquals(3, removeNthFromEnd.next.val);
        Assert.assertEquals(4, removeNthFromEnd.next.next.val);
        Assert.assertEquals(5, removeNthFromEnd.next.next.next.val);
        Assert.assertEquals(null, removeNthFromEnd.next.next.next.next);
    }

    @Test
    public void removeNthFromEndV3Test() {
        final LC19RemoveNthNodeFromEndOfList lc19RemoveNthNodeFromEndOfList = new LC19RemoveNthNodeFromEndOfList();

        ListNode head = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        head.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        ListNode removeNthFromEnd = lc19RemoveNthNodeFromEndOfList.removeNthFromEndStack(head, 2);

        Assert.assertEquals(1, removeNthFromEnd.val);
        Assert.assertEquals(2, removeNthFromEnd.next.val);
        Assert.assertEquals(3, removeNthFromEnd.next.next.val);
        Assert.assertEquals(5, removeNthFromEnd.next.next.next.val);
        Assert.assertEquals(null, removeNthFromEnd.next.next.next.next);

        head = new ListNode(1);
        node2 = new ListNode(2);
        head.next = node2;
        removeNthFromEnd = lc19RemoveNthNodeFromEndOfList.removeNthFromEndStack(head, 1);
        Assert.assertEquals(1, removeNthFromEnd.val);
        Assert.assertEquals(null, removeNthFromEnd.next);

        head = new ListNode(1);
        removeNthFromEnd = lc19RemoveNthNodeFromEndOfList.removeNthFromEndStack(head, 1);
        Assert.assertEquals(null, removeNthFromEnd);

        head = new ListNode(1);
        node2 = new ListNode(2);
        node3 = new ListNode(3);
        node4 = new ListNode(4);
        node5 = new ListNode(5);
        head.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        removeNthFromEnd = lc19RemoveNthNodeFromEndOfList.removeNthFromEndStack(head, 5);

        Assert.assertEquals(2, removeNthFromEnd.val);
        Assert.assertEquals(3, removeNthFromEnd.next.val);
        Assert.assertEquals(4, removeNthFromEnd.next.next.val);
        Assert.assertEquals(5, removeNthFromEnd.next.next.next.val);
        Assert.assertEquals(null, removeNthFromEnd.next.next.next.next);
    }


    /**
     * 该测试用例还存在着以下问题：
     * 由于v1方法会修改链表的内容，所以v2使用的是，v1修改后的结果。
     * 由于ListNode对象 equals方法只判断前后两对象的引用是否发生变化，所以当引用发现变化时断言报错。
     * 解决：
     * 1.将head对象拷贝一份，分别给v1、v2使用
     * 2.再修改ListNode对象 equals 方法，根据对应层级节点值是否相同来判断，二者是否相同。
     *
     * @author tiankai.me@gmail.com on 2022/8/16 14:58.
     */
    @Test
    public void removeNthFromEndBenchmarkTest() {
        final LC19RemoveNthNodeFromEndOfList lc19RemoveNthNodeFromEndOfList = new LC19RemoveNthNodeFromEndOfList();
        final Random random = new Random();
        for (int i = 0; i < 1000; i++) {
            final int length = random.nextInt(30) + 1;
            final int n = random.nextInt(length) + 1;
            System.out.println("n: " + n);
            final ListNode head = MathRandomUtil.createRandomListNode(length, 100);
            final ListNode headClone = head.clone();
            System.out.println("head: " + head);
            final ListNode removeNthFromEnd = lc19RemoveNthNodeFromEndOfList.removeNthFromEnd(head, n);
            System.out.println("v1: " + removeNthFromEnd);
            final ListNode removeNthFromEndArray = lc19RemoveNthNodeFromEndOfList.removeNthFromEndV1(headClone, n);
            System.out.println("v2: " + removeNthFromEndArray);
            if (removeNthFromEnd != null && removeNthFromEndArray != null) {
                Assert.assertEquals(removeNthFromEnd.toString() , removeNthFromEndArray.toString());
            } else {
                Assert.assertNull(removeNthFromEnd);
                Assert.assertNull(removeNthFromEndArray);
            }
        }
    }

}