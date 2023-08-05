package cn.tiakon.java.leetcode.stack.monotone;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 503. 下一个更大元素 II
 * https://leetcode.cn/problems/next-greater-element-ii/
 *
 * @author tiankai.me@gmail.com on 2022/11/20 下午10:47.
 */
public class LC503NextGreaterElementII {
    /**
     * 1. 先实现非循环的搜索.
     * 2. 再将数组基于长度取模.
     * 复杂度分析
     * 时间复杂度：O(N)，遍历了两次数组；
     * 空间复杂度：O(N)，使用了额外空间「单调栈」，最坏情况下，栈内会保存数组的所有元素。
     * 实测:
     * 执行用时： 3 ms , 在所有 Java 提交中击败了 98.44% 的用户
     * 内存消耗： 42.1 MB , 在所有 Java 提交中击败了 97.08% 的用户
     * 通过测试用例： 223 / 223
     *
     * @author tiankai.me@gmail.com on 2022/11/20 下午10:49.
     */
    public int[] nextGreaterElements(int[] nums) {
        int[] ans = new int[nums.length];
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < nums.length * 2 - 1; i++) {
            int index = i % nums.length;
            while (!stack.isEmpty() && nums[index] > nums[stack.peek()]) {
                ans[stack.pop()] = nums[index];
            }
            if (i < nums.length) stack.push(index);
        }
        while (!stack.isEmpty()) ans[stack.pop()] = -1;
        return ans;
    }

    @Test
    public void nextGreaterElementsTest() {
        LC503NextGreaterElementII nextGreaterElementII = new LC503NextGreaterElementII();

        int[] nums = new int[]{1, 2, 3, 4, 5};
        int[] ans = nextGreaterElementII.nextGreaterElements(nums);
        Assert.assertArrayEquals(new int[]{2, 3, 4, 5, -1}, ans);

        // [100,1,11,1,120,111,123,1,-1,-100]
        nums = new int[]{100, 1, 11, 1, 120, 111, 123, 1, -1, -100};
        ans = nextGreaterElementII.nextGreaterElements(nums);
        Assert.assertArrayEquals(new int[]{120, 11, 120, 120, 123, 123, -1, 100, 100, 100}, ans);
    }
}
