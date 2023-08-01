package cn.tiakon.java.leetcode.array.binarysearch;

/**
 * 34. 在排序数组中查找元素的第一个和最后一个位置
 * https://leetcode.cn/problems/find-first-and-last-position-of-element-in-sorted-array/
 *
 * @author tiankai.me@gmail.com on 2022/11/28 下午5:17.
 */
public class LC34FindFirstAndLastPosition {
    public int[] searchRange(int[] nums, int target) {
        return new int[]{searchLeft(nums, target), searchRight(nums, target)};
    }

    // 搜索目标值的右边界
    public int searchRight(int[] nums, int target) {
        int ans = -1, left = 0, right = nums.length - 1;
        while (left <= right) {
            int middle = left + (right - left) / 2;
            if (nums[middle] > target) right = middle - 1;
            else if (nums[middle] < target) left = middle + 1;
            else {
                ans = middle;
                left = middle + 1;
            }
        }
        return ans;
    }

    // 搜索目标值的左边界
    public int searchLeft(int[] nums, int target) {
        int ans = -1, left = 0, right = nums.length - 1;
        while (left <= right) {
            int middle = left + (right - left) / 2;
            if (nums[middle] > target) right = middle - 1;
            else if (nums[middle] < target) left = middle + 1;
            else {
                ans = middle;
                right = middle - 1;
            }
        }
        return ans;
    }
}
