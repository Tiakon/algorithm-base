package cn.tiakon.java.leetcode.array.binarysearch;

/**
 * 链接：https://leetcode.cn/problems/find-first-and-last-position-of-element-in-sorted-array
 *
 * @author tiankai.me@gmail.com on 2022/8/9 16:38.
 */
public class LC34SearchRange {

    // 时间复杂度为 O(logn)
    // 空间复杂度为 O(1)
    public int[] searchRange(int[] nums, int target) {
        int[] ans = new int[]{-1, -1};
        if (nums == null || nums.length == 0) {
            return ans;
        }
        int left = searchLeftBound(nums, target);
        int right = searchRightBound(nums, target);
        if (nums[left] == nums[right] && nums[left] == target) {
            ans = new int[]{left, right};
        }
        return ans;
    }

    public int searchLeftBound(int[] nums, int target) {
        // [0,nums.length - 1]
        int left = 0, right = nums.length - 1;
        // 缩减左右区间，找到左边界，当右边界小于左边界时循环终止。
        // 3种终止条件：
        // left一直加，right不变，当出现left>right终止，此时left会超出范围。
        // right一直减，left不变，当出现left>right终止，此时right会超出范围。
        // right会减或left会加 ， 当出现left>right终止，都不会超出范围。
        // 最终左右边界回来到一个位置，最后只对一个位置做检查即可
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > target) {
                // 缩减右边界
                right = mid - 1;
            } else if (nums[mid] < target) {
                // 缩减左边界
                left = mid + 1;
            } else if (nums[mid] == target) {
                // 缩减右边界
                right = mid - 1;
            }
        }
        // 左边界可能会超出
        return left > nums.length - 1 ? left - 1 : left;
    }

    public int searchRightBound(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        // 搜索右边界
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > target) {
                // 缩减右边界
                right = mid - 1;
            } else if (nums[mid] < target) {
                // 缩减左边界
                left = mid + 1;
            } else if (nums[mid] == target) {
                // 缩减右边界
                left = mid + 1;
            }
        }
        // 右边界可能会超出
        return Math.max(right, 0);
    }

    /**
     * 作者：lin-shen-shi-jian-lu-k
     * 链接：https://leetcode.cn/problems/find-first-and-last-position-of-element-in-sorted-array/solution/tu-jie-er-fen-zui-qing-xi-yi-dong-de-jia-ddvc/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     *
     * @author tiankai.me@gmail.com on 2022/8/9 19:10.
     */
    public int[] searchRangeV2(int[] nums, int target) {
        if (nums.length == 0) {
            return new int[]{-1, -1};
        }
        int l = 0, r = nums.length - 1; //二分范围
        //查找元素的开始位置
        while (l < r) {
            int mid = (l + r) / 2;
            if (nums[mid] >= target) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        if (nums[r] != target) {
            return new int[]{-1, -1}; //查找失败
        }
        int L = r;
        l = 0;
        r = nums.length - 1;     //二分范围
        //查找元素的结束位置
        while (l < r) {
            int mid = (l + r + 1) / 2;
            if (nums[mid] <= target) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }
        return new int[]{L, r};
    }

}
