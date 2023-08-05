package cn.tiakon.java.leetcode.stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 1475. 商品折扣后的最终价格
 * https://leetcode.cn/problems/final-prices-with-a-special-discount-in-a-shop/
 *
 * @author tiankai.me@gmail.com on 2022/9/1 10:32.
 */
public class LC1475finalPricesWithASpecialDiscountInAShop {

    /**
     * 非最优解
     * 复杂度分析
     * 时间复杂度：O(n^2)，其中 n 为数组的长度。对于每个商品，我们需要遍历一遍数组查找符合题目要求的折扣。
     * 空间复杂度：O(1)。返回值不计入空间复杂度。
     *
     * @author tiankai.me@gmail.com on 2022/9/1 10:34.
     */
    public int[] finalPrices(int[] prices) {
        int[] ans = new int[prices.length];
        for (int i = 0; i < prices.length; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                if (prices[i] >= prices[j]) {
                    ans[i] = prices[i] - prices[j];
                    break;
                } else ans[i] = prices[i];
            }
        }
        ans[prices.length - 1] = prices[prices.length - 1];
        return ans;
    }

    /**
     * 利用栈保存价格数组中的下标，在数组中寻找符合小于等于原价的元素。
     * 单调栈（最优解）
     * <p>
     * 复杂度分析
     * 时间复杂度：O(n)，其中 n 为数组的长度。只需遍历一遍数组即可。
     * 空间复杂度：O(n)。需要栈空间存储中间变量，需要的空间为 O(n)。
     * <p>
     * 执行用时： 3 ms , 在所有 Java 提交中击败了 56.04% 的用户
     * 内存消耗： 41.3 MB , 在所有 Java 提交中击败了 90.10% 的用户
     *
     * @author tiankai.me@gmail.com on 2022/9/1 10:38.
     */
    public int[] finalPricesV2(int[] prices) {
        int[] ans = new int[prices.length];
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < prices.length; i++) {
            deque.push(i);
            while (!deque.isEmpty() && i + 1 < prices.length && prices[deque.peek()] >= prices[i + 1]) {
                Integer index = deque.poll();
                ans[index] = prices[index] - prices[i + 1];
            }
        }
        while (!deque.isEmpty()) {
            Integer index = deque.poll();
            ans[index] = prices[index];
        }
        return ans;
    }

    // 单调栈（最优解）
    public int[] finalPricesV3(int[] prices) {
        int n = prices.length;
        int[] ans = new int[n];
        Deque<Integer> stack = new ArrayDeque<Integer>();
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() > prices[i]) {
                stack.pop();
            }
            ans[i] = stack.isEmpty() ? prices[i] : prices[i] - stack.peek();
            stack.push(prices[i]);
        }
        return ans;
    }

}








