package cn.tiakon.java.leetcode.matrix;

/**
 * 1572. 矩阵对角线元素的和
 * https://leetcode.cn/problems/matrix-diagonal-sum/
 *
 * @author tiankai.me@gmail.com on 2022/11/15 下午3:12.
 */
public class LC1572MatrixDiagonalSum {

    /**
     * 求正矩阵正副对角线之和
     * 逐行遍历，记当前的行号为 i，对于一行我们把 (i,i) 位置和(i,n−i−1) 加入答案。
     * 这样如果 n 是奇数的话，最中间的格子会被加入两次。
     * 所以 n 为奇数的时候，我们需要减掉矩阵最中心的那个值。
     *
     * @author tiankai.me@gmail.com on 2022/11/15 下午3:40.
     */
    public int diagonalSum(int[][] mat) {
        int n = mat.length, sum = 0, mid = n / 2;
        for (int i = 0; i < n; ++i) {
            sum += mat[i][i] + mat[i][n - 1 - i];
        }
        return sum - mat[mid][mid] * (n & 1); // n&1 == n % 2 (判断奇偶性)
    }
}
