package cn.tiakon.java.leetcode.array.binarysearch;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * <a href="https://leetcode.cn/problems/special-array-with-x-elements-greater-than-or-equal-x/">1608. 特殊数组的特征值</a>
 *
 * @author tiankai.me@gmail.com on 2022/12/8 上午11:35.
 */
public class LC1608SpecialArray {
    /**
     * 排序+二分法
     * <p>
     * 1. 先对数组进行升序排序.
     * 2. 根据二分法,可以找到特殊数组中的答案,但无法区分非特殊数组.
     * 3. 所以还需要通过遍历数组根据大于等于条件来验证答案.
     *
     * 复杂度分析:
     * 排序时间复杂度: O(nlog(n))
     * 二分时间复杂度: O(log(n))
     * 时间复杂度: O(nlog(n)+log(n))
     * 空间复杂度: O(1)
     * <p>
     * 执行用时： 1 ms , 在所有 Java 提交中击败了 95.27% 的用户
     * 内存消耗： 39.4 MB , 在所有 Java 提交中击败了 35.20% 的用户
     * 通过测试用例： 98 / 98
     *
     * @author tiankai.me@gmail.com on 2022/12/8 下午3:21.
     */
    public int specialArray(int[] nums) {
        int left = 0, right = nums.length - 1;
        Arrays.sort(nums);
        while (left < right) {
            int middle = left + (right - left) / 2;
            int size = nums.length - middle;
            if (nums[middle] < size) left = middle + 1;
            else right = middle;
        }
        int ans = nums.length - right, count = 0;
        for (int num : nums) {
            if (num >= ans) ++count;
        }
        return ans != count ? -1 : ans;
    }

    @Test
    public void specialArrayTest() {
        LC1608SpecialArray lc1608SpecialArray = new LC1608SpecialArray();
        int[] nums = new int[]{3, 9, 7, 8, 3, 8, 6, 6};
        int ans = lc1608SpecialArray.specialArray(nums);
        Assert.assertEquals(6, ans);
    }
}