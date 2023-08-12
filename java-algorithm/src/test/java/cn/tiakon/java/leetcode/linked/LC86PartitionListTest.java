package cn.tiakon.java.leetcode.linked;

import cn.tiakon.java.leetcode.datastructure.ListNode;
import cn.tiakon.java.utils.MathRandomUtil;
import org.junit.Assert;
import org.junit.Test;

public class LC86PartitionListTest {

    @Test
    public void case01Test() {
        // [1,4,3,2,5,2]
        // 3
        final LC86PartitionList partitionList = new LC86PartitionList();
        final ListNode node2 = new ListNode(2);
        final ListNode node5 = new ListNode(5, node2);
        final ListNode node_2 = new ListNode(2, node5);
        final ListNode node3 = new ListNode(3, node_2);
        final ListNode node4 = new ListNode(4, node3);
        final ListNode node1 = new ListNode(1, node4);
        final ListNode node = partitionList.partition(node1, 3);
        MathRandomUtil.printListNode(node);
    }

    @Test
    public void case02Test() {
        // [1,1]
        // 2
        final LC86PartitionList partitionList = new LC86PartitionList();
        final ListNode node_1 = new ListNode(1);
        final ListNode node1 = new ListNode(1, node_1);
        partitionList.partition(node1, 2);
        MathRandomUtil.printListNode(node1);
    }

    @Test
    public void case03Test() {
        // [1,2]
        // 2
        final LC86PartitionList partitionList = new LC86PartitionList();
        final ListNode node2 = new ListNode(2);
        final ListNode node1 = new ListNode(1, node2);
        final ListNode node = partitionList.partition(node1, 2);
        MathRandomUtil.printListNode(node);
    }

    @Test
    public void case04Test() {
        // []
        // 0
        final LC86PartitionList partitionList = new LC86PartitionList();
        final ListNode node = partitionList.partition(null, 0);
        Assert.assertNull(node);
    }

}
