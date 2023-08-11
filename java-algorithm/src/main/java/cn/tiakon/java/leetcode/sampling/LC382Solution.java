package cn.tiakon.java.leetcode.sampling;

import cn.tiakon.java.leetcode.datastructure.ListNode;

import java.util.Random;

/**
 * 382. 链表随机节点
 * https://leetcode.cn/problems/linked-list-random-node/
 *
 * @author tiankai.me@gmail.com on 2023-08-10 18:02.
 */
class LC382Solution {
    ListNode head;
    Random random = new Random(20230810);

    public LC382Solution(ListNode head) {
        this.head = head;
    }

    /**
     * 蓄水池抽样
     * 在 [0,k) 范围内进行随机，若随机到结果为 0（发生概率为 1/k），则将节点 k 的值存入答案，最后一次覆盖答案的节点即为本次抽样结果。
     * https://leetcode.cn/problems/linked-list-random-node/solutions/1213605/gong-shui-san-xie-xu-shui-chi-chou-yang-1lp9d/
     *
     * @author tiankai.me@gmail.com on 2023-08-10 18:21.
     */
    public int getRandom() {
        int ans = 0, idx = 0;
        ListNode t = head;
        while (t != null && ++idx >= 0) {
            if (random.nextInt(idx) == 0) ans = (int) t.val;
            t = t.next;
        }
        return ans;
    }
}

