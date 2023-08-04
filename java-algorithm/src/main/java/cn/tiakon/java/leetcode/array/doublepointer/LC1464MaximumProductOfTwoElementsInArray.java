package cn.tiakon.java.leetcode.array.doublepointer;

/**
 * 1464. 数组中两元素的最大乘积
 * https://leetcode.cn/problems/maximum-product-of-two-elements-in-an-array/
 *
 * @author tiankai.me@gmail.com on 2022/8/29 9:56.
 */
public class LC1464MaximumProductOfTwoElementsInArray {
    /**
     * 双指针
     * 执行用时： 4 ms , 在所有 Java 提交中击败了 9.24% 的用户
     * 内存消耗： 40.8 MB , 在所有 Java 提交中击败了 86.19% 的用户
     *
     * @author tiankai.me@gmail.com on 2022/8/29 10:35.
     */
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                ans = Math.max(ans, (nums[i] - 1) * (nums[j] - 1));
            }
        }
        return ans;
    }

    /**
     * 找最大值和次大值，即可满足要求。
     * 复杂度分析
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     *
     * @author tiankai.me@gmail.com on 2022/8/29 11:01.
     */
    public int maxProductV2(int[] nums) {
        int a = -1, b = -1;
        for (int x : nums) {
            if (x > a) {
                b = a;
                a = x;
            } else if (x > b) {
                // 更新次大值
                b = x;
            }
        }
        return (a - 1) * (b - 1);
    }

}
