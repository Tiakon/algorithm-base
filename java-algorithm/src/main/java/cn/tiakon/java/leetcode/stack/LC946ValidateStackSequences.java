package cn.tiakon.java.leetcode.stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 946. 验证栈序列
 * https://leetcode.cn/problems/validate-stack-sequences/
 *
 * @author tiankai.me@gmail.com on 2022/8/31 22:42.
 */
public class LC946ValidateStackSequences {

    /**
     * 复杂度分析
     * 时间复杂度：O(n),其中 n 是数组 pushed 和  popped 的长度。需要遍历数组 pushed 和 popped 各一次，判断两个数组是否为有效的栈操作序列。
     * 空间复杂度：O(n)，其中 n 是数组 pushed 和 popped 的长度。空间复杂度主要取决于栈空间，栈内元素个数不超过 n。
     *
     * @author tiankai.me@gmail.com on 2022/9/1 13:04.
     */
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        final Deque<Integer> deque = new ArrayDeque<>();
        int right = 0;
        for (int i = 0; i < pushed.length; i++) {
            deque.push(pushed[i]);
            while (!deque.isEmpty() && popped[right] == deque.peek()) {
                deque.poll();
                right++;
            }
        }
        // for (int i = right; i < popped.length; i++) {
        //     while (!deque.isEmpty() && popped[i] == deque.peek()) {
        //         deque.poll();
        //     }
        // }
        return deque.isEmpty();
    }

}
