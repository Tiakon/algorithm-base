package cn.tiakon.java.leetcode.array.binarysearch;

/**
 * 852. 山脉数组的峰顶索引
 * https://leetcode.cn/problems/peak-index-in-a-mountain-array/
 *
 * @author tiankai.me@gmail.com on 2022/8/9 23:13.
 */
public class LC852PeakIndexInAMountainArray {

    /**
     * 复杂度分析:
     * 时间复杂度：O(logn)
     * 空间复杂度：O(1)
     *
     * @author tiankai.me@gmail.com on 2022/12/6 下午8:54.
     */
    public int peakIndexInMountainArray(int[] arr) {
        int left = 1, right = arr.length - 2;
        while (left <= right) {
            int middle = left + ((right - left) >> 1);
            if (arr[middle - 1] < arr[middle] && arr[middle] > arr[middle + 1]) return middle;
            else if (arr[middle - 1] < arr[middle]) left = middle + 1;
            else right = middle - 1;
        }
        return -1;
    }

    /**
     * 复杂度分析:
     * 时间复杂度：O(n)。
     * 空间复杂度：O(1)。
     *
     * @author tiankai.me@gmail.com on 2022/12/6 下午8:53.
     */
    public int peakIndexInMountainArrayV2(int[] arr) {
        int n = arr.length;
        int ans = -1;
        for (int i = 1; i < n - 1; ++i) {
            if (arr[i] > arr[i + 1]) {
                ans = i;
                break;
            }
        }
        return ans;
    }

}
