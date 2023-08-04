package cn.tiakon.java.leetcode.array.doublepointer;

/**
 * 1539. 第 k 个缺失的正整数<p>
 * https://leetcode.cn/problems/kth-missing-positive-number/
 *
 * @author tiankai.me@gmail.com on 2022/12/7 下午5:55.
 */
public class LC1539KThMissingPositiveNumber {

    /**
     * 枚举法:
     * 记录缺失的值,同时维护第i个位置实际的值,并与当前数组作对比.
     * <p>
     * 复杂度分析 :<p>
     * 时间复杂度 :O(n+k)，其中 n 是数组 arr 的长度，k 是给定的整数。最坏情况下遍历完整个数组都没有缺失正整数，还要再将 current 递增 k 次，才能找到最终的答案。<p>
     * 空间复杂度：O(1)<p>
     * @author tiankai.me@gmail.com on 2022/12/7 下午10:49.
     */
    public int findKthPositive(int[] arr, int k) {
        int i = 0, ans = 0, value = 1;
        while (k > 0) {
            if (i >= arr.length || arr[i] != value) {
                ans = value;
                --k;
            } else ++i;
            ++value;
        }
        return ans;
    }

    // 二分法
    // https://leetcode.cn/problems/kth-missing-positive-number/solution/di-k-ge-que-shi-de-zheng-zheng-shu-by-leetcode-sol/
    // https://leetcode.cn/problems/kth-missing-positive-number/solution/-by-max-lfsznscofe-0qh4/
    public int findKthPositiveV3(int[] arr, int k) {
        if (arr[0] > k) return k;
        int l = 0, r = arr.length;
        while (l < r) {
            int mid = (l + r) >> 1;
            int x = mid < arr.length ? arr[mid] : Integer.MAX_VALUE;
            if (x - mid - 1 >= k) r = mid;
            else l = mid + 1;
        }
        return k - (arr[l - 1] - (l - 1) - 1) + arr[l - 1];
    }
}
