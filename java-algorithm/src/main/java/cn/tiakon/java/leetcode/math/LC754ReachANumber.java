package cn.tiakon.java.leetcode.math;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 754. 到达终点数字
 * https://leetcode.cn/problems/reach-a-number/
 *
 * @author tiankai.me@gmail.com on 2022/11/4 下午10:10.
 */
public class LC754ReachANumber {

    /**
     * 数学证明题
     * @author tiankai.me@gmail.com on 2022/11/4 下午11:13.
     */
    public int reachNumber(int target) {
        target = Math.abs(target);
        int k = 0;
        while (target > 0) {
            k++;
            target -= k;
        }
        return target % 2 == 0 ? k : k + 1 + k % 2;
    }

    /**
     * 错误解法
     * 构造二叉树,进行广度优先遍历
     * 在0坐标时就可以开始选着方向
     *
     * @author tiankai.me@gmail.com on 2022/11/4 下午10:11.
     */
    public int reachNumberERROR(int target) {
        int i = 0;
        Deque<Integer> deque = new ArrayDeque<>();
        deque.add(0);
        int dequeSize = deque.size();
        while (!deque.isEmpty()) {
            for (int j = 0; j < dequeSize; j++) {
                Integer poll = deque.poll();
                if (poll != target) {
                    deque.add(poll + i + 1);
                    deque.add(poll - i - 1);
                } else return i;
            }
            ++i;
            dequeSize = deque.size();
        }
        return i;
    }
}





