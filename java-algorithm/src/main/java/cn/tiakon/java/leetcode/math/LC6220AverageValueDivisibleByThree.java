package cn.tiakon.java.leetcode.math;

/**
 * 6220. 可被三整除的偶数的平均值
 * https://leetcode.cn/problems/average-value-of-even-numbers-that-are-divisible-by-three/
 *
 * @author tiankai.me@gmail.com on 2022/10/31 上午11:47.
 */
public class LC6220AverageValueDivisibleByThree {
    // 极简数学
    public int averageValue(int[] nums) {
        int count = 0, ans = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 3 == 0 && nums[i] % 2 == 0) {
                ans += nums[i];
                count++;
            }
        }
        return count != 0 ? ans / count : ans;
    }
}
