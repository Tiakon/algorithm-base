package cn.tiakon.java.leetcode.array;

import org.junit.Assert;
import org.junit.Test;

/**
 * 724. 寻找数组的中心下标
 * https://leetcode.cn/problems/find-pivot-index/
 *
 * @author tiankai.me@gmail.com on 2022/11/8 上午10:46.
 */
public class LC724FindPivotIndex {
    public int pivotIndex(int[] nums) {
        int lSum = 0, rSum = 0, ans = 0;
        for (int i = 1; i < nums.length; i++) {
            rSum += nums[i];
        }
        while (lSum != rSum && ans < nums.length) {
            lSum += nums[ans++];
            if (ans < nums.length) rSum -= nums[ans];
        }
        return ans < nums.length ? ans : -1;
    }

    @Test
    public void pivotIndexTest() {
        LC724FindPivotIndex lc724FindPivotIndex = new LC724FindPivotIndex();
        int[] nums = new int[]{1, 7, 3, 6, 5, 6};
        int ans = lc724FindPivotIndex.pivotIndex(nums);
        Assert.assertEquals(3, ans);

        nums = new int[]{1, 2, 3};
        ans = lc724FindPivotIndex.pivotIndex(nums);
        Assert.assertEquals(-1, ans);

        nums = new int[]{2, 1, -1};
        ans = lc724FindPivotIndex.pivotIndex(nums);
        Assert.assertEquals(0, ans);

        nums = new int[]{-1, 1, 2};
        ans = lc724FindPivotIndex.pivotIndex(nums);
        Assert.assertEquals(2, ans);

        nums = new int[]{2, 5};
        ans = lc724FindPivotIndex.pivotIndex(nums);
        Assert.assertEquals(-1, ans);

        nums = new int[]{1, 0};
        ans = lc724FindPivotIndex.pivotIndex(nums);
        Assert.assertEquals(0, ans);
    }

}
