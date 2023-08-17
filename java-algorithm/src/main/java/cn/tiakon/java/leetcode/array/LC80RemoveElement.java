package cn.tiakon.java.leetcode.array;

import org.junit.Assert;
import org.junit.Test;

/**
 * 80. 删除有序数组中的重复项 II
 * https://leetcode.cn/problems/remove-duplicates-from-sorted-array-ii/
 *
 * @author tiankai.me@gmail.com on 2022/10/28 下午11:02.
 */
public class LC80RemoveElement {
    /**
     * 1. 重复超过或等于2个,直接移动到两个索引之后
     * 2. 重复小于2个的,遇到大于自己的,则赋值到下一个位置.
     *
     * 复杂度分析:
     * 时间复杂度: O(n)
     * 空间复杂度: O(1)
     * <p>
     * 执行用时： 0 ms , 在所有 Java 提交中击败了 100.00% 的用户
     * 内存消耗： 41.6 MB , 在所有 Java 提交中击败了 50.30% 的用户
     * 通过测试用例： 164 / 164
     *
     * @author tiankai.me@gmail.com on 2022/10/29 上午11:10.
     */
    public int removeDuplicates(int[] nums) {
        int left = 0;
        int count = 0;
        for (int right = 0; right < nums.length; right++) {
            if (nums[right] == nums[left] && count == 1) {
                if (right - left == 1) left++;
                else nums[++left] = nums[right];
                count = 2;
            } else if (nums[right] != nums[left]) {
                nums[++left] = nums[right];
                count = 1;
            } else count++;
        }
        return left + 1;
    }

    public int removeDuplicatesV2(int[] nums) {
        if(nums.length <= 2) return nums.length;
        int j = 2;
        for(int i = 2; i < nums.length; i++){
            if(nums[i] != nums[j-2]) nums[j++] = nums[i];
        }
        return j;
    }

    @Test
    public void removeDuplicatesTest() {
        LC80RemoveElement removeElement = new LC80RemoveElement();
        int[] nums = new int[]{1, 1, 1, 2, 2, 3};
        int[] arr = {1, 1, 2, 2, 3};
        int ans = removeElement.removeDuplicates(nums);
        Assert.assertEquals(arr.length, ans);
        for (int i = 0; i < arr.length; i++) {
            Assert.assertEquals(arr[i], nums[i]);
        }

        nums = new int[]{0, 0, 1, 1, 1, 1, 2, 3, 3};
        arr = new int[]{0, 0, 1, 1, 2, 3, 3};
        ans = removeElement.removeDuplicates(nums);
        Assert.assertEquals(arr.length, ans);
        for (int i = 0; i < arr.length; i++) {
            Assert.assertEquals(arr[i], nums[i]);
        }

        nums = new int[]{1, 1, 1, 2, 2, 2, 3, 3};
        arr = new int[]{1, 1, 2, 2, 3, 3};
        ans = removeElement.removeDuplicates(nums);
        Assert.assertEquals(arr.length, ans);
        for (int i = 0; i < arr.length; i++) {
            Assert.assertEquals(arr[i], nums[i]);
        }
    }
}
