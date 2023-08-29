package cn.tiakon.java.leetcode.linked;

import cn.tiakon.java.leetcode.datastructure.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * 817. 链表组件
 * 这里对组件的定义为：链表中一段最长连续结点的值（该值必须在列表 nums 中）所构成的集合。
 * https://leetcode.cn/problems/linked-list-components/
 *
 * @author tiankai.me@gmail.com on 2023-08-28 15:45.
 */
public class LC817LinkedListComponents {
    /**
     * 复杂度分析：
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     *
     * @author tiankai.me@gmail.com on 2023-08-29 14:59.
     */
    public int numComponents(ListNode head, int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int substrSize = 0, ans = 0;
        while (head != null) {
            if (!set.contains((Integer) head.val)) {
                if (substrSize >= 1) {
                    substrSize = 0;
                    ++ans;
                }
            } else ++substrSize;
            head = head.next;
        }
        return substrSize >= 1 ? ++ans : ans;
    }

}