package cn.tiakon.java.leetcode.matrix;

/**
 * 1582. 二进制矩阵中的特殊位置
 * https://leetcode.cn/problems/special-positions-in-a-binary-matrix/
 *
 * @author tiankai.me@gmail.com on 2022/9/4 22:38.
 */
public class LC1582SpecialPositionsInABinaryMatrix {

    /**
     * 模拟流程
     * 通过计算每个坐标的行列累加和都是1的位置来统计特殊位置的个数即可。
     * 复杂度分析：
     * 时间复杂度：O(m×n)
     * 空间复杂度：O(m+n)
     *
     * @author tiankai.me@gmail.com on 2022/9/5 12:21.
     */
    public int numSpecial(int[][] mat) {
        int n = mat.length, m = mat[0].length, ans = 0;
        int[] rowSum = new int[n], colSum = new int[m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                rowSum[i] += mat[i][j];
                colSum[j] += mat[i][j];
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == 1 && rowSum[i] == 1 && colSum[j] == 1) {
                    ans++;
                    break;
                }
            }
        }
        return ans;
    }

}
