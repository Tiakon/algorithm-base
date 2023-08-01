package cn.tiakon.java.leetcode.array.binarysearch;

/**
 * <a href="https://leetcode.cn/problems/maximum-distance-between-a-pair-of-values/">1855. 下标对中的最大距离</a>
 *
 * @author tiankai.me@gmail.com on 2022/12/9 下午5:02.
 */
public class LC1855MaxDistance {
    /**
     * 暴力破解
     * [55,30,5,4,2]
     * [100,20,10,10,5]
     * [2,2,2]
     * [10,10,1]
     * [30,29,19,5]
     * [25,25,25,25,25]
     *
     * @author tiankai.me@gmail.com on 2022/12/9 下午5:12.
     */
    public int maxDistance(int[] nums1, int[] nums2) {
        int ans = 0;
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                if (i <= j && nums1[i] <= nums2[j]) ans = Math.max(ans, j - i);
            }
        }
        return ans;
    }

    // 二分法
    // O(nlogn)
    public int maxDistanceV2(int[] nums1, int[] nums2) {
        int ans = 0;
        for (int i = 0; i < nums1.length; i++) {
            int left = 0, right = nums2.length - 1;
            while (left <= right) {
                int middle = left + (right - left) / 2;
                if (nums1[i] <= nums2[middle]) {
                    if (i <= middle) ans = Math.max(ans, middle - i);
                    left = middle + 1;
                } else right = middle - 1;
            }
        }
        return ans;
    }

    // 双指针
    public int maxDistanceV3(int[] nums1, int[] nums2) {
        int len1 = nums1.length, len2 = nums2.length, left = 0, right = 0;
        while (left < len1 && right < len2) {
            if (nums1[left] > nums2[right]) left++;
            right++;
        }
        return Math.max(right - left - 1, 0);
    }

}
