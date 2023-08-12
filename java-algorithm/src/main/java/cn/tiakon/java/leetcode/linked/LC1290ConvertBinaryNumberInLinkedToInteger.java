package cn.tiakon.java.leetcode.linked;

import cn.tiakon.java.leetcode.datastructure.ListNode;

/**
 * 1290. 二进制链表转整数
 * https://leetcode.cn/problems/convert-binary-number-in-a-linked-list-to-integer/
 *
 * @author tiankai.me@gmail.com on 2022/11/19 下午9:38.
 */
public class LC1290ConvertBinaryNumberInLinkedToInteger {

    /**
     * 执行用时： 0 ms , 在所有 Java 提交中击败了 100.00% 的用户
     * 内存消耗： 39 MB , 在所有 Java 提交中击败了 52.44% 的用户
     * 通过测试用例： 102 / 102
     *
     * @author tiankai.me@gmail.com on 2022/11/19 下午11:01.
     */
    public int getDecimalValue(ListNode head) {
        int ans = 0, i = 0;
        int[] ints = new int[30];
        ListNode<Integer> node = head;
        while (node != null) {
            ints[i++] = node.val;
            node = node.next;
        }
        for (int j = 0; j < i; j++) {
            ans += (ints[j]) * (1 << i - 1 - j);
        }
        return ans;
    }

    /**
     * 执行用时： 0 ms , 在所有 Java 提交中击败了 100.00% 的用户
     * 内存消耗： 39.4 MB , 在所有 Java 提交中击败了 10.69% 的用户
     * 通过测试用例： 102 / 102
     * <p>
     * 5÷2=2余1
     * 2÷2=1余0
     * 1÷2=0余1
     * ===> 得出二进制 101 .
     * 反推回去 商 x 除数 + 余数
     * => 0 x 2 + 1 = 1
     * -> 1 x 2 + 0 = 2
     * -> 2 x 2 +1 = 5
     *
     * @author tiankai.me@gmail.com on 2022/11/19 下午11:02.
     */
    public int getDecimalValueV2(ListNode head) {
        ListNode<Integer> curNode = head;
        int ans = 0;
        while (curNode != null) {
            ans = ans * 2 + curNode.val;
            curNode = curNode.next;
        }
        return ans;
    }

}