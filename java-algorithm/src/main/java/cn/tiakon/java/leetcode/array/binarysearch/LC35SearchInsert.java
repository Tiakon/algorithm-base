package cn.tiakon.java.leetcode.array.binarysearch;

/**
 * 35. 搜索插入位置
 * https://leetcode.cn/problems/search-insert-position
 *
 * @author tiankai.me@gmail.com on 2022/8/8 23:59.
 */
public class LC35SearchInsert {

    /**
     * 二分法
     * <p>
     * 复杂度分析
     * 时间复杂度：O(logn)
     * 空间复杂度：O(1)
     * <p>
     * 执行用时： 0 ms , 在所有 Java 提交中击败了 100.00% 的用户
     * 内存消耗： 41 MB , 在所有 Java 提交中击败了 53.30% 的用户
     *
     * @author tiankai.me@gmail.com on 2022/8/22 14:41.
     */
    public int searchInsert(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int middle = left + (right - left) / 2;
            if (nums[middle] > target) right = middle - 1;
            else if (nums[middle] < target) left = middle + 1;
            else return middle;
        }
        return left;
    }

    // 对数器
    public int searchInsertV2(int[] nums, int target) {
        int n = nums.length;
        int left = 0, right = n - 1, ans = n;
        while (left <= right) {
            int mid = ((right - left) >> 1) + left;
            if (target <= nums[mid]) {
                ans = mid;
                right = mid - 1;
            } else left = mid + 1;
        }
        return ans;
    }

}
