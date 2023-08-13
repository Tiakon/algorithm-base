package cn.tiakon.java.leetcode.linked;

import cn.tiakon.java.leetcode.datastructure.ListNode;
import cn.tiakon.java.leetcode.linked.remove.LC203RemoveLinkedElements;
import cn.tiakon.java.utils.ListUtils;
import cn.tiakon.java.utils.MathRandomUtil;
import org.junit.Test;

public class LC203RemoveLinkedElementsTest {
    @Test
    public void removeElementsTest() {
        LC203RemoveLinkedElements removeLinkedElements = new LC203RemoveLinkedElements();
        ListNode randomListNode = MathRandomUtil.createRandomListNode(10, 5);
        System.out.println(ListUtils.printListNode(randomListNode));
        int val = 2;
        ListNode listNode = removeLinkedElements.removeElements(randomListNode, val);
        System.out.println(ListUtils.printListNode(listNode));
    }
}
