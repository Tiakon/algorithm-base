package cn.tiakon.java.leetcode.array.binarysearch;

import java.util.Random;

/**
 * 278. 第一个错误的版本
 * https://leetcode.cn/problems/first-bad-version
 * https://leetcode.cn/problems/binary-search/solution/er-fen-cha-zhao-xiang-jie-by-labuladong/
 *
 * @author tiankai.me@gmail.com on 2022/8/8 18:18.
 */
public class LC278FirstBadVersion extends VersionControl {

    public LC278FirstBadVersion(int n) {
        super(n);
    }

    /**
     * 1 <= bad <= n <= 2^31 - 1
     *
     * @author tiankai.me@gmail.com on 2022/8/8 18:24.
     */
    public int firstBadVersion(int n) {
        int left = 1, right = n;
        while (left < right) {
            int middle = left + (right - left) / 2;
            if (isBadVersion(middle)) {
                right = middle;
            } else {
                left = middle + 1;
            }
        }
        return left;
    }

    /**
     * 官方
     * 时间复杂度： O(logn)，其中 n 是给定版本的数量；二分查找使用对数级别时间。
     * 空间复杂度： O(1)，变量left，right使用常数大小空间。
     *
     * @author tiankai.me@gmail.com on 2022/8/8 23:15.
     */
    public int firstBadVersionV2(int n) {
        int left = 1, right = n;
        while (left < right) {
            // 循环直至区间左右端点相同
            // 防止计算时溢出
            int mid = left + (right - left) / 2;
            if (isBadVersion(mid)) {
                // 答案在区间 [left, mid] 中
                right = mid;
            } else {
                // 答案在区间 [mid+1, right] 中
                left = mid + 1;
            }
        }
        // 此时有 left == right，区间缩为一个点，即为答案
        return left;
    }

    // 递归解法 时间复杂度： O(logn) 空间复杂度： ？
    public int firstBadVersionV3(int n) {
        return helper(1, n);
    }

    private int helper(int left, int right) {
        if (left > right) {
            return left;
        }
        int mid = left + (right - left) / 2;
        if (isBadVersion(mid)) {
            right = mid - 1;
        } else {
            left = mid + 1;
        }
        return helper(left, right);
    }

}

/**
 * The isBadVersion API is defined in the parent class VersionControl.
 * boolean isBadVersion(int version);
 *
 * @author tiankai.me@gmail.com on 2022/8/8 18:19.
 */
class VersionControl {
    private final Random random = new Random();
    private int badVersion;

    public VersionControl(int n) {
        badVersion = n;
    }

    boolean isBadVersion(int version) {
        return version >= badVersion;
    }
}