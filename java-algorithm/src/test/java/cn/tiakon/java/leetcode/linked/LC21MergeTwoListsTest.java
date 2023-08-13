package cn.tiakon.java.leetcode.linked;

import cn.tiakon.java.leetcode.datastructure.ListNode;
import cn.tiakon.java.leetcode.linked.merge.LC21MergeTwoLists;
import cn.tiakon.java.utils.MathRandomUtil;
import org.junit.Assert;
import org.junit.Test;

public class LC21MergeTwoListsTest {

    @Test
    public void mergeTwoListsTest() {
        LC21MergeTwoLists lc21MergeTwoLists = new LC21MergeTwoLists();

        ListNode node5 = new ListNode(5, null);
        ListNode node4 = new ListNode(4, node5);
        ListNode node3 = new ListNode(3, node4);
        ListNode node2 = new ListNode(2, node3);
        ListNode head = new ListNode(1, node2);

        ListNode node24 = new ListNode(7, null);
        ListNode node23 = new ListNode(5, node24);
        ListNode node22 = new ListNode(3, node23);
        ListNode head2 = new ListNode(2, node22);

        ListNode newHead = lc21MergeTwoLists.mergeTwoLists(head, head2);
        String listNodeToString = MathRandomUtil.listNodeToString(newHead);
        Assert.assertEquals("122334557", listNodeToString);

        node3 = new ListNode(4, null);
        node2 = new ListNode(2, node3);
        head = new ListNode(1, node2);
        node23 = new ListNode(4, null);
        node22 = new ListNode(3, node23);
        head2 = new ListNode(1, node22);

        newHead = lc21MergeTwoLists.mergeTwoLists(head, head2);
        listNodeToString = MathRandomUtil.listNodeToString(newHead);
        Assert.assertEquals("112344", listNodeToString);

        head = new ListNode(1, null);
        head2 = new ListNode(2, null);

        newHead = lc21MergeTwoLists.mergeTwoLists(head2, head);
        listNodeToString = MathRandomUtil.listNodeToString(newHead);
        Assert.assertEquals("12", listNodeToString);
    }

    @Test
    public void mergeTwoListsV2Test() {
        LC21MergeTwoLists lc21MergeTwoLists = new LC21MergeTwoLists();

        ListNode node5 = new ListNode(5, null);
        ListNode node4 = new ListNode(4, node5);
        ListNode node3 = new ListNode(3, node4);
        ListNode node2 = new ListNode(2, node3);
        ListNode head = new ListNode(1, node2);

        ListNode node24 = new ListNode(7, null);
        ListNode node23 = new ListNode(5, node24);
        ListNode node22 = new ListNode(3, node23);
        ListNode head2 = new ListNode(2, node22);

        ListNode newHead = lc21MergeTwoLists.mergeTwoListsV2(head, head2);
        String listNodeToString = MathRandomUtil.listNodeToString(newHead);
        Assert.assertEquals("122334557", listNodeToString);

        node3 = new ListNode(4, null);
        node2 = new ListNode(2, node3);
        head = new ListNode(1, node2);
        node23 = new ListNode(4, null);
        node22 = new ListNode(3, node23);
        head2 = new ListNode(1, node22);

        newHead = lc21MergeTwoLists.mergeTwoListsV2(head, head2);
        listNodeToString = MathRandomUtil.listNodeToString(newHead);
        Assert.assertEquals("112344", listNodeToString);

        head = new ListNode(1, null);
        head2 = new ListNode(2, null);

        newHead = lc21MergeTwoLists.mergeTwoListsV2(head2, head);
        listNodeToString = MathRandomUtil.listNodeToString(newHead);
        Assert.assertEquals("12", listNodeToString);
    }

    @Test
    public void mergeTwoListsV3Test() {
        LC21MergeTwoLists lc21MergeTwoLists = new LC21MergeTwoLists();

        ListNode node5 = new ListNode(5, null);
        ListNode node4 = new ListNode(4, node5);
        ListNode node3 = new ListNode(3, node4);
        ListNode node2 = new ListNode(2, node3);
        ListNode head = new ListNode(1, node2);

        ListNode node24 = new ListNode(7, null);
        ListNode node23 = new ListNode(5, node24);
        ListNode node22 = new ListNode(3, node23);
        ListNode head2 = new ListNode(2, node22);

        ListNode newHead = lc21MergeTwoLists.mergeTwoListsV3(head, head2);
        String listNodeToString = MathRandomUtil.listNodeToString(newHead);
        Assert.assertEquals("122334557", listNodeToString);

        node3 = new ListNode(4, null);
        node2 = new ListNode(2, node3);
        head = new ListNode(1, node2);
        node23 = new ListNode(4, null);
        node22 = new ListNode(3, node23);
        head2 = new ListNode(1, node22);

        newHead = lc21MergeTwoLists.mergeTwoListsV3(head, head2);
        listNodeToString = MathRandomUtil.listNodeToString(newHead);
        Assert.assertEquals("112344", listNodeToString);

        head = new ListNode(1, null);
        head2 = new ListNode(2, null);

        newHead = lc21MergeTwoLists.mergeTwoListsV3(head2, head);
        listNodeToString = MathRandomUtil.listNodeToString(newHead);
        Assert.assertEquals("12", listNodeToString);
    }

}
