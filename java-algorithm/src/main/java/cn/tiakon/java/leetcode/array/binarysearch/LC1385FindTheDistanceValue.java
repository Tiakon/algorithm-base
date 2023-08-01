package cn.tiakon.java.leetcode.array.binarysearch;

import java.util.Arrays;

/**
 * 1385. 两个数组间的距离值
 * https://leetcode.cn/problems/find-the-distance-value-between-two-arrays/
 *
 * @author tiankai.me@gmail.com on 2022/12/6 下午3:51.
 */
public class LC1385FindTheDistanceValue {

    /**
     * 暴力破解
     * 复杂度分析:
     * 时间复杂度：O(n^2)。
     * 空间复杂度：O(1)。
     *
     * @author tiankai.me@gmail.com on 2022/12/6 下午4:00.
     */
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        int ans = arr1.length;
        for (int i : arr1) {
            for (int j : arr2) {
                if (Math.abs(i - j) <= d) {
                    --ans;
                    break;
                }
                // isSkip&=(Math.abs(i - j) > d);
            }
        }
        return ans;
    }

    /**
     * 二分法:
     * 在上一种方法中，要知道是否每一个y_j是不是满足|x_i-y_j|>d，我们枚举了所有 y_j.实际上我们只要找到大于等于x_i的第一个y_j和小于x的第一个y_j,看看它们满不满足这个性质就可以了。
     *
     * 假设 arr1 中元素个数为 n，arr2 中元素个数为 m
     * 复杂度分析:
     * 时间复杂度：O((n+m)logm)。
     * 空间复杂度：O(1)。
     *
     * @author tiankai.me@gmail.com on 2022/12/6 下午4:00.
     */
    public int findTheDistanceValueV2(int[] arr1, int[] arr2, int d) {
        Arrays.sort(arr2);
        int cnt = 0;
        for (int x : arr1) {
            int p = binarySearch(arr2, x);
            boolean ok = true;
            if (p < arr2.length) ok &= arr2[p] - x > d;
            if (p - 1 >= 0 && p - 1 <= arr2.length) ok &= x - arr2[p - 1] > d;
            cnt += ok ? 1 : 0;
        }
        return cnt;
    }

    // 在arr2中找与arr[i]最相近的数，如果连最相近的数绝对值差都大于d，那么其他就更不用考虑了
    public int binarySearch(int[] arr, int target) {
        int low = 0, high = arr.length - 1;
        if (arr[high] < target) return high + 1;
        while (low < high) {
            int mid = (high - low) / 2 + low;
            if (arr[mid] < target) low = mid + 1;
            else high = mid;
        }
        return low;
    }


}
