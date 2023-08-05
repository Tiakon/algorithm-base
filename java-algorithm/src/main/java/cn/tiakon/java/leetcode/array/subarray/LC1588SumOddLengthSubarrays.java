package cn.tiakon.java.leetcode.array.subarray;

import org.junit.Assert;
import org.junit.Test;

/**
 * 1588. 所有奇数长度子数组的和
 * https://leetcode.cn/problems/sum-of-all-odd-length-subarrays/
 *
 * @author tiankai.me@gmail.com on 2022/11/15 下午2:22.
 */
public class LC1588SumOddLengthSubarrays {
    /**
     * 滑动窗口+前缀和
     * <p>
     * 复杂度分析
     * 时间复杂度:O(n^2)
     * 空间复杂度:O(1)
     *
     * @author tiankai.me@gmail.com on 2022/11/15 下午2:39.
     */
    public int sumOddLengthSubarrays(int[] arr) {
        int ans = 0, left = 0, right = 0, preSum = 0;
        while (left < arr.length) {
            while (right < arr.length) {
                preSum += arr[right++];
                if ((right - left) % 2 == 1) ans += preSum;
            }
            right = ++left;
            preSum = 0;
        }
        return ans;
    }

    /**
     * 数学证明:
     * 数组中的每个元素都会在一个或多个奇数长度的子数组中出现，如果可以计算出每个元素在多少个长度为奇数的子数组中出现，
     * 即可得到所有奇数长度子数组的和。
     * 复杂度分析
     * 时间复杂度:O(n)
     * 空间复杂度:O(1)
     *
     * @author tiankai.me@gmail.com on 2022/11/15 下午2:59.
     */
    public int sumOddLengthSubarraysV2(int[] arr) {
        int sum = 0;
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            int leftCount = i, rightCount = n - i - 1;
            int leftOdd = (leftCount + 1) / 2;
            int rightOdd = (rightCount + 1) / 2;
            int leftEven = leftCount / 2 + 1;
            int rightEven = rightCount / 2 + 1;
            sum += arr[i] * (leftOdd * rightOdd + leftEven * rightEven);
        }
        return sum;
    }

    @Test
    public void sumOddLengthSubArraysTest() {
        LC1588SumOddLengthSubarrays sumOddLengthSubarrays = new LC1588SumOddLengthSubarrays();
        int[] arr = new int[]{1, 4, 2, 5, 3};
        int ans = sumOddLengthSubarrays.sumOddLengthSubarrays(arr);
        Assert.assertEquals(58, ans);

        arr = new int[]{1, 2};
        ans = sumOddLengthSubarrays.sumOddLengthSubarrays(arr);
        Assert.assertEquals(3, ans);

        arr = new int[]{10, 11, 12};
        ans = sumOddLengthSubarrays.sumOddLengthSubarrays(arr);
        Assert.assertEquals(66, ans);
    }

}
