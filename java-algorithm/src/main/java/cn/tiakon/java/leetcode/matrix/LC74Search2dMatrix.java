package cn.tiakon.java.leetcode.matrix;

/**
 * <a href="https://leetcode.cn/problems/search-a-2d-matrix/">74. 搜索二维矩阵</a>
 *
 * @author tiankai.me@gmail.com on 2022/12/7 下午5:39.
 */
public class LC74Search2dMatrix {
    // O(mlogn)
    public boolean searchMatrix(int[][] matrix, int target) {
        for (int[] arr : matrix) {
            int l = 0, r = arr.length - 1;
            if (target <= arr[r]) {
                while (l <= r) {
                    int mid = l + (r - l) / 2;
                    if (target < arr[mid]) r = mid - 1;
                    else if (target > arr[mid]) l = mid + 1;
                    else return true;
                }
            }
        }
        return false;
    }

    // 这道题的关键点在于利用矩阵升序的特性，需要选择合适的切入点与目标值相比较以缩小数据范围，
    // 很明显如果选择左上角或右下角当做切入点并不能起到只能分别排除一个选项，
    // 而如果选择右上角或者左下角进行比较即可起到更明显的效果。
    // 算法复杂度为O(m+n) m 为matrix行数 n 为matrix列数
    public boolean searchMatrixV2(int[][] matrix, int target) {
        int row = 0, col = matrix[0].length - 1;
        while (row < matrix.length && col >= 0) {
            if (matrix[row][col] < target) row++;
            else if (matrix[row][col] > target) col--;
            else return true;
        }
        return false;
    }
}
