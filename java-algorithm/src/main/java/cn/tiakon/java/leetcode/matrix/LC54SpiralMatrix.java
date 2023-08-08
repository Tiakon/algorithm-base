package cn.tiakon.java.leetcode.matrix;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 54. 螺旋矩阵
 * https://leetcode.cn/problems/spiral-matrix/
 *
 * @author tiankai.me@gmail.com on 2022/8/1 16:19.
 */
public class LC54SpiralMatrix {

    /**
     * 双指针解法
     * <p>
     * 时间复杂度： O(N)
     *
     * @author tiankai.me@gmail.com on 2022/8/1 16:49.
     */
    public List<Integer> spiralOrder(int[][] matrix) {
        if (matrix == null) {
            throw new NullPointerException("The matrix can't be empty. ");
        }
        final int rows = matrix.length;
        final int columns = matrix[0].length;
        if (rows < 1 || columns > 10) {
            throw new RuntimeException(String.format("The rows less than 1 or columns more than 10. rows:%d columns:%d .", rows, columns));
        }
        final List<Integer> resList = new ArrayList<>();
        boolean isReversed = false;
        int rowStartIndex = 0;
        int rowEndIndex = matrix.length - 1;
        int columnStartIndex = 0;
        int columnEndIndex = matrix[0].length - 1;

        while (resList.size() != rows * columns) {
            if (!isReversed) {
                for (int j = columnStartIndex; j <= columnEndIndex; j++) {
                    resList.add(matrix[rowStartIndex][j]);
                }
                rowStartIndex++;
                for (int i = rowStartIndex; i <= rowEndIndex; i++) {
                    resList.add(matrix[i][columnEndIndex]);
                }
                columnEndIndex--;
            } else {
                for (int j = columnEndIndex; j >= columnStartIndex; j--) {
                    resList.add(matrix[rowEndIndex][j]);
                }
                rowEndIndex--;
                for (int i = rowEndIndex; i >= rowStartIndex; i--) {
                    resList.add(matrix[i][columnStartIndex]);
                }
                columnStartIndex++;
            }
            isReversed = !isReversed;
        }
        return resList;
    }

    public List<Integer> spiralOrderV2(int[][] matrix) {
        List<Integer> res = new LinkedList<>();
        if (matrix.length == 0) {
            return res;
        }
        int up = 0, down = matrix.length - 1, left = 0, right = matrix[0].length - 1;
        while (true) {
            for (int col = left; col <= right; ++col) {
                res.add(matrix[up][col]);
            }
            if (++up > down) {
                break;
            }
            for (int row = up; row <= down; ++row) {
                res.add(matrix[row][right]);
            }
            if (--right < left) {
                break;
            }
            for (int col = right; col >= left; --col) {
                res.add(matrix[down][col]);
            }
            if (--down < up) {
                break;
            }
            for (int row = down; row >= up; --row) {
                res.add(matrix[row][left]);
            }
            if (++left > right) {
                break;
            }
        }
        return res;
    }

    /**
     * 官方版本
     *
     * @author tiankai.me@gmail.com on 2022/8/8 0:01.
     */
    public List<Integer> spiralOrderV3(int[][] matrix) {
        List<Integer> order = new ArrayList<Integer>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return order;
        }
        int rows = matrix.length, columns = matrix[0].length;
        boolean[][] visited = new boolean[rows][columns];
        int total = rows * columns;
        int row = 0, column = 0;
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int directionIndex = 0;
        for (int i = 0; i < total; i++) {
            order.add(matrix[row][column]);
            visited[row][column] = true;
            int nextRow = row + directions[directionIndex][0], nextColumn = column + directions[directionIndex][1];
            if (nextRow < 0 || nextRow >= rows || nextColumn < 0 || nextColumn >= columns || visited[nextRow][nextColumn]) {
                directionIndex = (directionIndex + 1) % 4;
            }
            row += directions[directionIndex][0];
            column += directions[directionIndex][1];
        }
        return order;
    }

    public List<Integer> spiralOrderV4(int[][] matrix) {
        //定义四个角
        // top --> bottom 是从上往下遍历
        // left --> right 是从左往右遍历
        int top = 0;    //top指明哪一行的行首
        int bottom = matrix.length - 1; //bottom 指明哪一行的数目
        int left = 0;   //left指明哪一列的列首
        int right = matrix[0].length - 1; //right指明哪一列

        //特例(无,)因为题目给了:     1 <= matrix.length <= 10
        //
        //结果集合
        List<Integer> list = new ArrayList<>();

        while (top < bottom && left < right) {
            //从左到右遍历, 放入list
            for (int i = left; i < right; i++) {
                list.add(matrix[top][i]);
            } //当前top行的每一列
            for (int i = top; i < bottom; i++) {
                list.add(matrix[i][right]);
            } //当前right列的每一行
            for (int i = right; i > left; i--) {
                list.add(matrix[bottom][i]);
            } //当前bottom行的每一列
            for (int i = bottom; i > top; i--) {
                list.add(matrix[i][left]);
            } //当前left列的每一行

            ++left;
            --right;
            ++top;
            --bottom;
        }

        //边缘判断(当只剩下了一行. 或者一列, 或者一个数, 直接一次遍历加入集合即可)
        //只剩下顺序一行
        if (bottom == top) {
            for (int i = left; i <= right; i++) {
                list.add(matrix[top][i]);
            }
        } else if (left == right) {
            for (int i = top; i <= bottom; i++) {
                list.add(matrix[i][top]);
            }
        }

        return list;
    }

}
