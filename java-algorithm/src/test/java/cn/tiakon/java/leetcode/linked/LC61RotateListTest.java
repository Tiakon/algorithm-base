package cn.tiakon.java.leetcode.linked;

import cn.tiakon.java.leetcode.datastructure.ListNode;
import cn.tiakon.java.utils.MathRandomUtil;
import org.junit.Test;

public class LC61RotateListTest {

    @Test
    public void case01Test() {
        final LC61RotateList rotateList = new LC61RotateList();
        final ListNode node5 = new ListNode(5);
        final ListNode node4 = new ListNode(4, node5);
        final ListNode node3 = new ListNode(3, node4);
        final ListNode node2 = new ListNode(2, node3);
        final ListNode node1 = new ListNode(1, node2);
        final ListNode node = rotateList.rotateRight(node1, 2);
        MathRandomUtil.printListNode(node);
    }

    @Test
    public void case02Test() {
        final LC61RotateList rotateList = new LC61RotateList();
        final ListNode node3 = new ListNode(2);
        final ListNode node2 = new ListNode(1, node3);
        final ListNode node1 = new ListNode(0, node2);
        final ListNode node = rotateList.rotateRight(node1, 4);
        MathRandomUtil.printListNode(node);
    }

}