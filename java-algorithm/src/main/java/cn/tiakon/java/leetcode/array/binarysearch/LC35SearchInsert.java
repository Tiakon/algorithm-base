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
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int middle = left + (right - left) / 2;
            if (target == nums[middle]) {
                return middle;
            } else if (target > nums[middle]) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }
        return left;
    }

    /**
     * 作者：guanpengchn
     * 链接：https://leetcode.cn/problems/search-insert-position/solution/hua-jie-suan-fa-35-sou-suo-cha-ru-wei-zhi-by-guanp/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     *
     * @author tiankai.me@gmail.com on 2022/8/9 16:15.
     */
    public int searchInsertV2(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (target == nums[mid]) {
                return mid;
            } else if (target < nums[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        //此时left = right
        return target <= nums[left] ? left : left + 1;
    }

}
