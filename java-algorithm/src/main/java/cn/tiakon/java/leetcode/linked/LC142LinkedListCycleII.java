package cn.tiakon.java.leetcode.linked;

import cn.tiakon.java.leetcode.datastructure.ListNode;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * 142. 环形链表 II
 * https://leetcode.cn/problems/linked-list-cycle-ii/
 *
 * @author tiankai.me@gmail.com on 2023-08-02 14:28.
 */
public class LC142LinkedListCycleII {

    public ListNode detectCycle(ListNode head) {
        final Set<ListNode> hashSet = new HashSet<>();
        ListNode node = head;
        while (node != null) {
            if (!hashSet.add(node)) return node;
            node = node.next;
        }
        return null;
    }

    /**
     * 时间复杂度：O(N )
     * 空间复杂度：O(1)
     * https://leetcode.cn/leetbook/read/linked-list/jjhf6/
     * @author tiankai.me@gmail.com on 2023-08-02 22:40.
     */
    public ListNode detectCycleV2(ListNode head) {
        ListNode slow = head, fast = head;
        //快慢指针相遇
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            //第一次相遇退出循环
            if (slow == fast) break;
        }
        //判断是否有环
        if (fast == null || fast.next == null) return null;
        //有环则将fast移动至head并移动S2距离
        fast = head;
        while (fast != slow) {
            slow = slow.next;
            fast = fast.next;
        }
        return fast;
    }

    public boolean hasCycle(ListNode head) {
        if (head == null) return false;
        ListNode low = head;
        ListNode fast = head;
        int l = 0, f = 0;
        while (fast.next != null && fast.next.next != null) {
            low = low.next;
            fast = fast.next.next;
            l++;
            f += 2;
            if (low.val == fast.val) {
                System.out.printf("l: %d  f: %d %n", l, f);
                return true;
            }
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
        final LC142LinkedListCycleII lc142LinkedListCycleII = new LC142LinkedListCycleII();
        Assert.assertEquals(node2, lc142LinkedListCycleII.detectCycle(node3));
    }


}
