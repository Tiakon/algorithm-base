package cn.tiakon.java.leetcode.array.binarysearch;

import cn.tiakon.java.utils.ListUtils;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 658. 找到 K 个最接近的元素
 * https://leetcode.cn/problems/find-k-closest-elements/
 *
 * @author tiankai.me@gmail.com on 2022/8/25 22:09.
 */
public class LC658FindKClosestElements {

    // 1. 二分法+双指针
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> ans = new ArrayList<>();
        if (arr.length == k || x <= arr[0]) {
            for (int i = 0; i < k; i++) {
                ans.add(arr[i]);
            }
            return ans;
        }
        if (x >= arr[arr.length - 1]) {
            for (int i = arr.length - k; i < arr.length; i++) {
                ans.add(arr[i]);
            }
            return ans;
        }
        // x -> index [1,len-2]
        int searchForLeft = binarySearchForLeft(arr, x);
        int left = searchForLeft, right = searchForLeft;
        if (k == 1) {
            if ((Math.abs(arr[left] - x) < Math.abs(arr[right + 1] - x) || Math.abs(arr[left] - x) == Math.abs(arr[right + 1] - x) && arr[left] <= arr[right + 1]))
                ans.add(arr[left]);
            else ans.add(arr[right + 1]);
            return ans;
        }
        do {
            if (left > 0 && (Math.abs(arr[left] - x) < Math.abs(arr[right] - x) ||
                    Math.abs(arr[left] - x) == Math.abs(arr[right] - x) && arr[left] <= arr[right]))
                left--;
            else right++;
            if (right == arr.length) {
                right--;
                left--;
            }
        } while (right - left - 1 < k);
        for (int i = (left == -1 ? 0 : left); i < right; i++) {
            ans.add(arr[i]);
        }
        return ans;
    }

    public List<Integer> findClosestElementsV2(int[] arr, int k, int x) {
        int right = binarySearch(arr, x);
        int left = right - 1;
        while (k-- > 0) {
            if (left < 0) {
                right++;
            } else if (right >= arr.length) {
                left--;
            } else if (x - arr[left] <= arr[right] - x) {
                left--;
            } else {
                right++;
            }
        }
        List<Integer> ans = new ArrayList<Integer>();
        for (int i = left + 1; i < right; i++) {
            ans.add(arr[i]);
        }
        return ans;
    }

    public int binarySearch(int[] arr, int x) {
        int low = 0, high = arr.length - 1;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] >= x) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    /**
     * 二分查找最优区间的左边界
     * 最优区间的左边界的下标的搜索区间为 [0, size - k]。
     *
     * @author tiankai.me@gmail.com on 2022/8/29 16:53.
     */
    public List<Integer> findClosestElementsV3(int[] arr, int k, int x) {
        int size = arr.length;
        int left = 0;
        int right = size - k;
        while (left < right) {
            int mid = left + (right - left) / 2;
            // 尝试从长度为 k + 1 的连续子区间删除一个元素
            // 从而定位左区间端点的边界值
            if (x - arr[mid] > arr[mid + k] - x) {
                // 下一轮搜索区间是 [mid + 1..right]
                left = mid + 1;
            } else {
                // 下一轮搜索区间是 [left..mid]
                right = mid;
            }
        }
        List<Integer> res = new ArrayList<>();
        for (int i = left; i < left + k; i++) {
            res.add(arr[i]);
        }
        return res;
    }

    /**
     * 二分法
     *
     * @author tiankai.me@gmail.com on 2022/8/29 18:14.
     */
    public List<Integer> findClosestElementsV4(int[] arr, int k, int x) {
        List<Integer> list = new ArrayList<>();
        int n = arr.length;
        int left = 0;
        int right = n - k;
        while (left <= right) {
            int mid = (left + right) >>> 1;
            if (mid + k < n && x - arr[mid] > arr[mid + k] - x) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        for (int i = left; i < left + k; i++) {
            list.add(arr[i]);
        }
        return list;
    }

    /**
     * 双指针
     *
     * @author tiankai.me@gmail.com on 2022/8/29 18:14.
     */
    public List<Integer> findClosestElementsV5(int[] arr, int k, int x) {
        List<Integer> list = new ArrayList<>();
        int n = arr.length;
        int left = 0;
        int right = n - 1;
        while (right - left + 1 != k) {
            if (Math.abs(arr[left] - x) <= Math.abs(arr[right] - x)) {
                right--;
            } else {
                left++;
            }
        }
        for (int i = left; i <= right; i++) {
            list.add(arr[i]);
        }
        return list;
    }

    /**
     * 滑动窗口
     *
     * @author tiankai.me@gmail.com on 2022/8/29 18:15.
     */
    public List<Integer> findClosestElementsV6(int[] arr, int k, int x) {
        List<Integer> list = new ArrayList<>();
        int n = arr.length;
        int left = 0;
        int right = 0;
        int sum = 0;
        int res = Integer.MAX_VALUE;
        int idx = 0;
        while (right < n) {
            sum += Math.abs(arr[right] - x);
            if (right - left + 1 == k) {
                if (sum < res) {
                    res = sum;
                    idx = left;
                }
                sum -= Math.abs(arr[left] - x);
                left++;
            }
            right++;
        }

        for (int i = idx; i < idx + k; i++) {
            list.add(arr[i]);
        }
        return list;
    }

    // 存在就返回x的位置，不存在返回x最左边的第一个位置
    public int binarySearchForLeft(int[] arr, int x) {
        int left = 0, right = arr.length - 1;
        // 搜索左边界
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == x) return mid;
            else if (arr[mid] < x) left = mid + 1;
            else right = mid - 1; // x < arr[mid]
        }
        return right;
    }

    @Test
    public void binarySearchForLeftTest() {
        final LC658FindKClosestElements lc658FindKClosestElements = new LC658FindKClosestElements();

        int[] arr = new int[]{1, 2, 3, 4, 5};
        int x = 6;
        int forLeft = lc658FindKClosestElements.binarySearchForLeft(arr, x);
        Assert.assertEquals(4, forLeft);

        x = 3;
        forLeft = lc658FindKClosestElements.binarySearchForLeft(arr, x);
        // Assert.assertEquals(1, forLeft);
        Assert.assertEquals(2, forLeft);

        x = 0;
        forLeft = lc658FindKClosestElements.binarySearchForLeft(arr, x);
        Assert.assertEquals(-1, forLeft);
    }

    @Test
    public void findClosestElementsTest() {
        final LC658FindKClosestElements lc658FindKClosestElements = new LC658FindKClosestElements();
        int[] arr = new int[]{1, 2, 3, 4, 5};
        int k = 4;
        int x = 3;
        List<Integer> elements = lc658FindKClosestElements.findClosestElements(arr, k, x);
        String ans = ListUtils.listToString(elements);
        Assert.assertEquals("1,2,3,4", ans);

        k = 4;
        x = -1;
        elements = lc658FindKClosestElements.findClosestElements(arr, k, x);
        ans = ListUtils.listToString(elements);
        Assert.assertEquals("1,2,3,4", ans);

        arr = new int[]{-2, -1, 1, 2, 3, 4, 5};
        k = 7;
        x = 3;
        elements = lc658FindKClosestElements.findClosestElements(arr, k, x);
        ans = ListUtils.listToString(elements);
        Assert.assertEquals("-2,-1,1,2,3,4,5", ans);

        arr = new int[]{0, 1, 1, 1, 2, 3, 6, 7, 8, 9};
        k = 9;
        x = 4;
        elements = lc658FindKClosestElements.findClosestElements(arr, k, x);
        ans = ListUtils.listToString(elements);
        Assert.assertEquals("0,1,1,1,2,3,6,7,8", ans);

        arr = new int[]{1, 1, 1, 10, 10, 10};
        k = 1;
        x = 9;
        elements = lc658FindKClosestElements.findClosestElements(arr, k, x);
        ans = ListUtils.listToString(elements);
        Assert.assertEquals("10", ans);

        arr = new int[]{0, 0, 1, 2, 3, 3, 4, 7, 7, 8};
        k = 3;
        x = 5;
        elements = lc658FindKClosestElements.findClosestElements(arr, k, x);
        ans = ListUtils.listToString(elements);
        Assert.assertEquals("3,3,4", ans);

        arr = new int[]{0, 1, 2, 2, 2, 3, 6, 8, 8, 9};
        k = 5;
        x = 9;
        elements = lc658FindKClosestElements.findClosestElements(arr, k, x);
        ans = ListUtils.listToString(elements);
        Assert.assertEquals("3,6,8,8,9", ans);

        arr = new int[]{1, 2, 3, 3, 6, 6, 7, 7, 9, 9};
        k = 8;
        x = 8;
        elements = lc658FindKClosestElements.findClosestElements(arr, k, x);
        ans = ListUtils.listToString(elements);
        Assert.assertEquals("3,3,6,6,7,7,9,9", ans);
    }

}
