package cn.tiakon.java.leetcode.stack.monotone;


/**
 * <a href="https://leetcode.cn/problems/monotonic-array/">896. 单调数列</a>
 * @author tiankai.me@gmail.com on 2022/11/28 下午10:16.
 */
public class LC896MonotonicArray {
    public boolean isMonotonic(int[] nums) {
        int ans = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] >= nums[i]) ++ans;
        }
        if (ans == (nums.length-1)) return true;
        ans = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] <= nums[i]) ++ans;
        }
        return ans == (nums.length-1);
    }
}
