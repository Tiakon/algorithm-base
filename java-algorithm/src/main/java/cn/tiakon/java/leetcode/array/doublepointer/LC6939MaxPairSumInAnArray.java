package cn.tiakon.java.leetcode.array.doublepointer;

/**
 * 6939. 数组中的最大数对和
 * https://leetcode.cn/problems/max-pair-sum-in-an-array/
 *
 * @author tiankai.me@gmail.com on 2023-08-13 14:39.
 */
public class LC6939MaxPairSumInAnArray {
    /**
     *
     * @author tiankai.me@gmail.com on 2023-08-13 16:35.
     */
    public int maxSum(int[] nums) {
        int ans = -1;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int a = nums[i], b = nums[j], aMax = 0, bMax = 0, tempSum = nums[i] + nums[j];
                if (a == b) ans = Math.max(ans, tempSum);
                else {
                    while (a != 0 || b != 0) {
                        if (a != 0) {
                            aMax = Math.max(aMax, a % 10);
                            a /= 10;
                        }
                        if (b != 0) {
                            bMax = Math.max(bMax, b % 10);
                            b /= 10;
                        }
                    }
                    if (aMax == bMax) ans = Math.max(ans, tempSum);
                }
            }
        }
        return ans;
    }
}
