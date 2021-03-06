package cn.tiakon.java.leetcode.linked;

import cn.tiakon.java.leetcode.datastructure.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * 160. 相交链表
 * https://leetcode.cn/problems/intersection-of-two-linked-lists/
 *
 * @author tiankai.me@gmail.com on 2023-08-03 13:42.
 */
public class LC160IntersectionOfTwoLinkedLists {
    /**
     * 指针到达链表尾部后，交换访问链表的指针可保证与相交节点相遇。
     *
     * @author tiankai.me@gmail.com on 2023-08-03 14:51.
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode nodeA = headA, nodeB = headB;
        while (nodeA != nodeB) {
            nodeA = (nodeA == null) ? headB : nodeA.next;
            nodeB = (nodeB == null) ? headA : nodeB.next;
        }
        return nodeA;
    }

    /**
     * 利用哈希表，当第一次出现重复添加时返回该节点即可。
     * 复杂度分析：
     * 时间度分析：O(n+m),n、m为链表的长度
     * 空间度分析：O(n+m),n、m为链表的长度
     *
     * @author tiankai.me@gmail.com on 2023-08-03 14:03.
     */
    public ListNode getIntersectionNodeHashset(ListNode headA, ListNode headB) {
        ListNode nodeA = headA;
        ListNode nodeB = headB;
        final Set<ListNode> hashSet = new HashSet<>();
        while (nodeA != null || nodeB != null) {
            if (nodeA != null) {
                if (hashSet.add(nodeA)) nodeA = nodeA.next;
                else return nodeA;
            }
            if (nodeB != null) {
                if (hashSet.add(nodeB)) nodeB = nodeB.next;
                else return nodeB;
            }
        }
        return null;
    }

}