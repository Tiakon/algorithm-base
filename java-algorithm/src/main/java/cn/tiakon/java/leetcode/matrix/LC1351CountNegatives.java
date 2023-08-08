package cn.tiakon.java.leetcode.matrix;

/**
 * <a href="https://leetcode.cn/problems/count-negative-numbers-in-a-sorted-matrix/">1351. 统计有序矩阵中的负数</a>
 *
 * @author tiankai.me@gmail.com on 2022/12/8 下午3:50.
 */
public class LC1351CountNegatives {
    // 时间复杂度最好: O(n+m)
    // 时间复杂度最坏: O(n*m)
    // 暴力破解
    public int countNegatives(int[][] grid) {
        int ans = 0;
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[r].length; c++) {
                if (grid[r][c] < 0) {
                    ans += grid[r].length - c;
                    break;
                }
            }
        }
        return ans;
    }

    // 充分利用题中条件:矩阵中的元素无论是按行还是按列，都以非递增顺序排列
    // 从最右上角开始遍历 : O(m+n)
    public int countNegativesV2(int[][] grid) {
        int ans = 0, row = 0, col = grid[0].length - 1;
        while (row < grid.length && col >= 0) {
            if (grid[row][col] < 0) {
                ans += grid.length - row;
                col--;// 向左移动
            } else row++;// 向下移动
        }
        return ans;
    }

    // 二分O(mlogn)
    public int countNegativesV3(int[][] grid) {
        int ans = 0;
        for (int[] cols : grid) {
            int left = 0, right = grid[0].length - 1;
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (cols[mid] >= 0) left = mid + 1; // 向右找
                else right = mid; // 找到最左边的负数
            }
            if (cols[left] < 0) ans += grid[0].length - left;
        }
        return ans;
    }

}
