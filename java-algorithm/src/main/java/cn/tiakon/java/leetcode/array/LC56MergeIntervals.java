package cn.tiakon.java.leetcode.array;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 56. 合并区间
 * https://leetcode.cn/problems/merge-intervals/
 *
 * @author tiankai.me@gmail.com on 2022/11/8 下午1:41.
 */
public class LC56MergeIntervals {
    /**
     * 输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
     * 输出：[[1,6],[8,10],[15,18]]
     * <p>
     * 输入：intervals = [[2,6],[1,3],[15,18],[8,10]]
     * 输出：[[1,6],[8,10],[15,18]]
     * <p>
     * 输入：intervals = [[1,4],[4,5]]
     * 输出：[[1,5]]
     * <p>
     * 执行用时： 305 ms , 在所有 Java 提交中击败了 5.00% 的用户
     * 内存消耗： 46.5 MB , 在所有 Java 提交中击败了 35.96% 的用户
     * 通过测试用例： 170 / 170
     *
     * @author tiankai.me@gmail.com on 2022/11/8 下午1:48.
     */
    public int[][] merge(int[][] intervals) {
        sort(intervals);
        List<int[]> ans = new ArrayList<>();
        for (int i = 1; i < intervals.length; i++) {
            int preStart = intervals[i - 1][0], preEnd = intervals[i - 1][1];
            int start = intervals[i][0], end = intervals[i][1];
            if (preStart <= start && start <= preEnd) {
                intervals[i - 1][0] = intervals[i - 1][0] = -1;
                intervals[i][0] = preStart;
                intervals[i][1] = Math.max(preEnd, end);
            }
        }
        for (int[] interval : intervals) {
            if (interval[0] != -1 && interval[1] != -1) ans.add(interval);
        }
        return ans.toArray(new int[0][0]);
    }

    /**
     * 解题思路:
     * 1. 排序后,使用链表收集区间,通过比较两区间的边界进行合并
     * 2. 当区间2的左边界大于区间1的右边界时,说明两区间无交集直接添加即可.
     * 3. 否则就修改区间1的右边界,曲两者的最大值即可.
     * <p>
     * 复杂度分析
     * 时间复杂度：O(nlogn)，其中 n 为区间的数量。除去排序的开销，我们只需要一次线性扫描，所以主要的时间开销是排序的 O(nlogn)。
     * 空间复杂度：O(logn)，其中 n 为区间的数量。这里计算的是存储答案之外，使用的额外空间。O(logn) 即为排序所需要的空间复杂度。
     *
     * @author tiankai.me@gmail.com on 2022/11/8 下午6:50.
     */
    public int[][] mergeV2(int[][] intervals) {
        if (intervals.length == 0) return new int[0][2];
        Arrays.sort(intervals, Comparator.comparingInt(interval -> interval[0]));
        List<int[]> merged = new ArrayList<>();
        for (int[] interval : intervals) {
            int l = interval[0], r = interval[1];
            if (merged.isEmpty() || merged.get(merged.size() - 1)[1] < l) merged.add(new int[]{l, r});
            else merged.get(merged.size() - 1)[1] = Math.max(merged.get(merged.size() - 1)[1], r);
        }
        return merged.toArray(new int[merged.size()][]);
    }

    // 冒泡排序
    public void sort(int[][] intervals) {
        for (int i = 0; i < intervals.length; i++) {
            for (int j = 1; j < intervals.length - i; j++) {
                if (intervals[j - 1][0] > intervals[j][0]) {
                    int[] temp = intervals[j - 1];
                    intervals[j - 1] = intervals[j];
                    intervals[j] = temp;
                }
            }
        }
    }

    @Test
    public void sortTest() {
        LC56MergeIntervals mergeIntervals = new LC56MergeIntervals();
        int[][] nums = new int[][]{{2, 6}, {8, 10}, {1, 3}, {15, 18}};
        mergeIntervals.sort(nums);
        Assert.assertArrayEquals(new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}}, nums);

        nums = new int[][]{{4, 5}, {1, 4}, {0, 1}};
        mergeIntervals.sort(nums);
        Assert.assertArrayEquals(new int[][]{{0, 1}, {1, 4}, {4, 5}}, nums);
    }

    @Test
    public void mergeTest() {
        LC56MergeIntervals mergeIntervals = new LC56MergeIntervals();
        int[][] nums = new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        int[][] ans = mergeIntervals.merge(nums);
        Assert.assertArrayEquals(new int[][]{{1, 6}, {8, 10}, {15, 18}}, ans);

        nums = new int[][]{{1, 4}, {4, 5}};
        ans = mergeIntervals.merge(nums);
        Assert.assertArrayEquals(new int[][]{{1, 5}}, ans);

        nums = new int[][]{{1, 4}, {0, 4}};
        ans = mergeIntervals.merge(nums);
        Assert.assertArrayEquals(new int[][]{{0, 4}}, ans);

        nums = new int[][]{{1, 4}, {4, 5}, {4, 8}, {8, 15}};
        ans = mergeIntervals.merge(nums);
        Assert.assertArrayEquals(new int[][]{{1, 15}}, ans);

        nums = new int[][]{{1, 4}, {0, 0}};
        ans = mergeIntervals.merge(nums);
        Assert.assertArrayEquals(new int[][]{{0, 0}, {1, 4}}, ans);

        nums = new int[][]{{2, 6}, {8, 10}, {1, 3}, {15, 18}};
        ans = mergeIntervals.merge(nums);
        Assert.assertArrayEquals(new int[][]{{1, 6}, {8, 10}, {15, 18}}, ans);

        nums = new int[][]{{4, 5}, {1, 4}, {0, 1}};
        ans = mergeIntervals.merge(nums);
        Assert.assertArrayEquals(new int[][]{{0, 5}}, ans);

    }

    @Test
    public void mergeV2Test() {
        LC56MergeIntervals mergeIntervals = new LC56MergeIntervals();
        int[][] nums = new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        int[][] ans = mergeIntervals.merge(nums);
        Assert.assertArrayEquals(new int[][]{{1, 6}, {8, 10}, {15, 18}}, ans);

        nums = new int[][]{{1, 4}, {4, 5}};
        ans = mergeIntervals.merge(nums);
        Assert.assertArrayEquals(new int[][]{{1, 5}}, ans);

        nums = new int[][]{{1, 4}, {0, 4}};
        ans = mergeIntervals.merge(nums);
        Assert.assertArrayEquals(new int[][]{{0, 4}}, ans);

        nums = new int[][]{{1, 4}, {4, 5}, {4, 8}, {8, 15}};
        ans = mergeIntervals.merge(nums);
        Assert.assertArrayEquals(new int[][]{{1, 15}}, ans);

        nums = new int[][]{{1, 4}, {0, 0}};
        ans = mergeIntervals.merge(nums);
        Assert.assertArrayEquals(new int[][]{{0, 0}, {1, 4}}, ans);

        nums = new int[][]{{2, 6}, {8, 10}, {1, 3}, {15, 18}};
        ans = mergeIntervals.merge(nums);
        Assert.assertArrayEquals(new int[][]{{1, 6}, {8, 10}, {15, 18}}, ans);

        nums = new int[][]{{4, 5}, {1, 4}, {0, 1}};
        ans = mergeIntervals.merge(nums);
        Assert.assertArrayEquals(new int[][]{{0, 5}}, ans);

    }

}
