package cn.tiakon.java.leetcode.array.binarysearch;

import java.util.HashMap;

/**
 * 704. 二分查找
 * https://leetcode.cn/problems/binary-search
 * 3 74. 猜数字大小
 * https://leetcode.cn/problems/guess-number-higher-or-lower/
 *
 * @author tiankai.me@gmail.com on 2022/8/8 14:58.
 */
public class LC704BinarySearch {

    // 对数器
    public int binarySearch(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;
        final HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            hashMap.put(nums[i], i);
        }
        return hashMap.getOrDefault(target, -1);
    }

    /**
     * 官方解法
     * 复杂度分析
     * 时间复杂度 O(logN) ： 其中 N 为数组的长度。二分查找使用对数级别时间。
     * 空间复杂度 O(1)    ： 变量 i,j使用常数大小空间。
     *
     * @author tiankai.me@gmail.com on 2022/8/8 18:00.
     */
    public int binarySearchV1(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        // 搜索区间为 [left, right]
        while (left <= right) {                     // 允许相等，代表中间值可以来到0或length-1位置
            int mid = left + (right - left) / 2;    // 防止溢出
            if (nums[mid] < target) left = mid + 1; // 收缩左侧边界
            else if (nums[mid] > target) right = mid - 1; // 收缩右侧边界
            else if (nums[mid] == target) return mid; // 直接返回
        }
        return -1;
    }

    // 递归法
    public int binarySearchV2(int[] nums, int target) {
        return search(nums, 0, nums.length - 1, target);
    }

    private int search(int[] nums, int left, int right, int target) {
        if (right < left) return -1;
        int mid = left + (right - left) / 2;
        if (nums[mid] == target) return mid;
        if (nums[mid] < target) return search(nums, mid + 1, right, target);
        else return search(nums, left, mid - 1, target);
    }

    // 搜索左侧边界
    public int searchLeftBound(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        // 搜索区间为 [left, right]
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                // 搜索区间变为 [mid+1, right]
                left = mid + 1;
            } else if (nums[mid] > target) {
                // 搜索区间变为 [left, mid-1]
                right = mid - 1;
            } else if (nums[mid] == target) {
                // 收缩右侧边界
                right = mid - 1;
            }
        }
        // 检查出界情况
        if (left >= nums.length || nums[left] != target) {
            return -1;
        }
        return left;
    }

    // 搜索右侧边界
    public int searchRightBound(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        // 搜索区间为 [left, right]
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] == target) {
                left = mid + 1;
            }
        }
        // 检查 right 越界的情况
        if (right < 0 || nums[right] != target) {
            return -1;
        }
        return right;
    }

    public int guessNumber(int n) {
        int left=1,right=n;
        while(left<=right){
            int middle=left+(right-left)/2;
            if(guess(middle)==-1) right=middle-1;
            else if(guess(middle)==1) left=middle+1;
            else return middle;
        }
        return -1;
    }

    /**
     * Forward declaration of guess API.
     *
     * @param num your guess
     * @return -1 if num is higher than the picked number
     * 1 if num is lower than the picked number
     * otherwise return 0
     */
    public int guess(int num) {
        return -1;
    }
}
