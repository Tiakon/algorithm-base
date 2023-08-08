package cn.tiakon.java.leetcode.matrix;

import org.junit.Assert;
import org.junit.Test;

/**
 * 566. 重塑矩阵
 * https://leetcode.cn/problems/reshape-the-matrix/
 *
 * @author tiankai.me@gmail.com on 2022/11/14 上午11:38.
 */
public class LC566ReshapeTheMatrix {
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        int matRow = mat.length, matCol = mat[0].length;
        if (matRow * matCol != r * c) return mat;
        int[][] ans = new int[r][c];
        int i = 0, j = 0, row = 0, col = 0;
        while (i < matRow && row < r) {
            ans[row][col++] = mat[i][j++];
            if (col == c) {
                ++row;
                col = 0;
            }
            if (j == matCol) {
                ++i;
                j = 0;
            }
        }
        return ans;
    }

    /**
     * 复杂度分析
     * 时间复杂度：O(rc) 。这里的时间复杂度是在重塑矩阵成功的前提下的时间复杂度，否则当 mn!=rc 时， 需要的时间复杂度仅为 O(1) 。
     * 空间复杂度：O(1)。这里的空间复杂度不包含返回的重塑矩阵需要的空间。
     *
     * @author tiankai.me@gmail.com on 2022/11/14 下午12:32.
     */
    public int[][] matrixReshapeV2(int[][] nums, int r, int c) {
        int m = nums.length,n = nums[0].length;
        if (m * n != r * c) return nums;
        int[][] ans = new int[r][c];
        for (int x = 0; x < m * n; ++x) {
            // 相除得到行下标,取余得到列下标
            ans[x / c][x % c] = nums[x / n][x % n];
        }
        return ans;
    }

    @Test
    public void matrixReshapeTest() {
        LC566ReshapeTheMatrix reshapeTheMatrix = new LC566ReshapeTheMatrix();

        int[][] mat = new int[][]{{1, 2}, {3, 4}};
        int r = 1, c = 4;
        int[][] ans = reshapeTheMatrix.matrixReshape(mat, r, c);
        Assert.assertArrayEquals(new int[][]{{1, 2, 3, 4}}, ans);

        mat = new int[][]{{1, 2}, {3, 4}};
        r = 2;c = 4;
        ans = reshapeTheMatrix.matrixReshape(mat, r, c);
        Assert.assertArrayEquals(new int[][]{{1, 2}, {3, 4}}, ans);
    }

}
