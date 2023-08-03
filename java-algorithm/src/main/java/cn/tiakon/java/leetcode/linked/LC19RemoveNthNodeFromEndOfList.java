package cn.tiakon.java.leetcode.linked;

import cn.tiakon.java.leetcode.datastructure.ListNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 19. 删除链表的倒数第 N 个结点
 * https://leetcode.cn/problems/remove-nth-node-from-end-of-list/
 *
 * @author tiankai.me@gmail.com on 2022/8/15 18:46.
 */
public class LC19RemoveNthNodeFromEndOfList {

    /**
     * 快慢指针
     * 设想假设设定了双指针p和q的话，当q指向末尾的NULL，p与q之间相隔的元素个数为n时，那么删除掉p的下一个指针就完成了要求。
     * <p>
     * 复杂度分析：
     * 时间复杂度：O(N)
     * 空间复杂度：O(1)
     *
     * @author tiankai.me@gmail.com on 2022/8/16 15:10.
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode tmp = new ListNode(0, head);
        ListNode cur = head;
        ListNode pre = tmp;
        for (int i = 0; i < n; i++) {
            cur = cur.next;
        }
        while (cur != null) {
            cur = cur.next;
            pre = pre.next;
        }
        pre.next = pre.next.next;
        ListNode res = tmp.next;
        return res;
    }

    /**
     * 当访问目标节点时，无法删除节点，只有访问前一个节点才能删除目标节点。
     * 回溯法-后序遍历
     * 复杂度分析：
     * 时间复杂度：O(N)
     * 空间复杂度：O(1)
     *
     * @author tiankai.me@gmail.com on 2022/8/16 15:13.
     */
    public ListNode removeNthFromEndV1(ListNode head, int n) {
        int traverse = traverse(head, n);
        if (traverse == n) return head.next;
        return head;
    }

    private int traverse(ListNode node, int n) {
        if (node == null) return 0;
        int num = traverse(node.next, n);
        if (num == n) node.next = node.next.next;
        return num + 1;
    }

    /**
     * 复杂度分析
     * 时间复杂度：O(n)，其中n 是链表的长度。
     * 空间复杂度：O(n)，其中 n 是链表的长度。主要为栈的开销。
     *
     * @author tiankai.me@gmail.com on 2023-08-03 18:35.
     */
    public ListNode removeNthFromEndStack(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);
        Deque<ListNode> stack = new ArrayDeque<>();
        ListNode cur = dummy;
        while (cur != null) {
            stack.push(cur);
            cur = cur.next;
        }
        for (int i = 0; i < n; ++i) {
            stack.pop();
        }
        ListNode prev = stack.peek();
        prev.next = prev.next.next;
        ListNode ans = dummy.next;
        return ans;
    }

    /**
     * 使用数组
     * <p>
     * 复杂度分析：
     * 时间复杂度：O(N)
     * 空间复杂度：O(N)
     * 执行用时： 0 ms , 在所有 Java 提交中击败了 100.00% 的用户
     * 内存消耗： 39.9 MB , 在所有 Java 提交中击败了 8.99% 的用户
     *
     * @author tiankai.me@gmail.com on 2022/8/15 23:55.
     */
    public ListNode removeNthFromEndArray(ListNode head, int n) {
        ListNode[] list = new ListNode[31];
        ListNode p = head;
        int i = 1;
        while (p != null) {
            list[i] = p;
            p = p.next;
            i++;
        }
        if (i - n == 1) head = head.next;
        else list[i - n - 1].next = list[i - n + 1];
        return head;
    }

}
