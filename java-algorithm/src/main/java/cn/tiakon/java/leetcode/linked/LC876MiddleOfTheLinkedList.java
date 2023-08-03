package cn.tiakon.java.leetcode.linked;

import cn.tiakon.java.leetcode.datastructure.ListNode;

/**
 * 876. 链表的中间结点
 * https://leetcode.cn/problems/middle-of-the-linked-list/
 *
 * @author tiankai.me@gmail.com on 2022/8/15 18:45.
 */
public class LC876MiddleOfTheLinkedList {

    /**
     * 1. 数组索引
     * 根据题意得知链表最大长度为 100
     * 1. 遍历链表将每个节点放到对应数组中。
     * 2. 通过累加的索引值求中间结果。
     * 复杂度分析：
     * 时间复杂度： O(N)
     * 空间复杂度： O(N)
     * 执行用时： 0 ms , 在所有 Java 提交中击败了 100.00% 的用户
     * 内存消耗： 38.9 MB , 在所有 Java 提交中击败了 61.14% 的用户
     *
     * @author tiankai.me@gmail.com on 2022/8/15 20:38.
     */
    public ListNode middleNode(ListNode head) {
        final ListNode[] nums = new ListNode[100];
        int i = 0;
        while (head != null) {
            nums[i++] = head;
            head = head.next;
        }
        return nums[i / 2];
    }

    /**
     * 2. 两次遍历
     * 1. 复制一份head成temp，第一次遍历后得知链表长度 size。
     * 2. 第二次直接遍历head到size/2位置返回中间节点即可。
     * <p>
     * 复杂度分析：
     * 时间复杂度： O(N)
     * 空间复杂度： O(1)
     * 执行用时： 0 ms , 在所有 Java 提交中击败了 100.00% 的用户
     * 内存消耗： 39.2 MB , 在所有 Java 提交中击败了 15.23% 的用户
     *
     * @author tiankai.me@gmail.com on 2022/8/15 21:12.
     */
    public ListNode middleNodeV2(ListNode head) {
        int size = 0, i = 0;
        ListNode temp = head;
        while (temp != null) {
            temp = temp.next;
            size++;
        }
        while (i != size / 2) {
            head = head.next;
            i++;
        }
        return head;
    }

    /**
     * 3. 快慢指针
     * 1. 声明slow,fast两个指针，slow的步长是1，fast的步长是2。
     * 2. 当 fast 到达链表尾部时，slow就停在了中间位置。
     * 3. 注意检查 fast与fast.next 的空指针异常。
     * 复杂度分析：
     * 时间复杂度： O(N)
     * 空间复杂度： O(1)
     * 执行用时： 0 ms , 在所有 Java 提交中击败了 100.00% 的用户
     * 内存消耗： 39.5 MB , 在所有 Java 提交中击败了 5.12% 的用户
     *
     * @author tiankai.me@gmail.com on 2022/8/15 21:12.
     */
    public ListNode middleNodeV3(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }


    /**
     * 第二遍
     * @author tiankai.me@gmail.com on 2022/11/19 下午11:10.
     */
    public ListNode middleNodeV4(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }
}
