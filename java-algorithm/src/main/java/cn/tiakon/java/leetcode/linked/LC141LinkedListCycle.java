package cn.tiakon.java.leetcode.linked;

import cn.tiakon.java.leetcode.datastructure.ListNode;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;
/**
 * 141. 环形链表
 * https://leetcode.cn/problems/linked-list-cycle/
 * @author tiankai.me@gmail.com on 2023/7/29 下午9:52.
 */
public class LC141LinkedListCycle {

    /**
     * 复杂度分析
     * 时间复杂度：O(N) ，其中 N 是链表中的节点数。
     * 当链表中不存在环时，快指针将先于慢指针到达链表尾部，链表中每个节点至多被访问两次。
     * 当链表中存在环时，每一轮移动后，快慢指针的距离将减小一。而初始距离为环的长度，因此至多移动 N 轮。
     * 空间复杂度：O(1) 。我们只使用了两个指针的额外空间。
     */
    public boolean hasCycle(ListNode head) {
        boolean ans = false;
        ListNode slow = head;
        ListNode fast = head;
        while (!ans && fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) ans = true;
        }
        return ans;
    }

    public boolean hasCycleV2(ListNode head) {
        Set<ListNode> seen = new HashSet<ListNode>();
        while (head != null) {
            if (!seen.add(head)) {
                return true;
            }
            head = head.next;
        }
        return false;
    }

    @Test
    public void case01Test() {
        final ListNode<Integer> node4 = new ListNode<>(4);
        final ListNode<Integer> node0 = new ListNode<>(0, node4);
        final ListNode<Integer> node2 = new ListNode<>(2, node0);
        final ListNode<Integer> node3 = new ListNode<>(3, node2);
        node4.next = node2;
        final LC141LinkedListCycle linkedListCycle = new LC141LinkedListCycle();
        Assert.assertTrue(linkedListCycle.hasCycle(node3));
    }

}
