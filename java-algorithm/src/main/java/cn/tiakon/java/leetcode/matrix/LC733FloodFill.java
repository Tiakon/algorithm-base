package cn.tiakon.java.leetcode.matrix;

import cn.tiakon.java.utils.MathRandomUtil;
import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 泛洪填充原理
 * 733. 图像渲染
 * https://leetcode.cn/problems/flood-fill/
 *
 * @author tiankai.me@gmail.com on 2023-08-09 22:31.
 * @author tiankai.me@gmail.com on 2022/8/17 14:50.
 */
public class LC733FloodFill {

    /**
     * 广度优先搜索
     * 复杂度分析
     * 时间复杂度：O(n×m)，其中 n 和 m 分别是二维数组的行数和列数。最坏情况下需要遍历所有的方格一次。
     * 空间复杂度：O(n×m) ，其中 n 和 m 分别是二维数组的行数和列数。主要为队列的开销。
     *
     * @author tiankai.me@gmail.com on 2023-08-10 11:21.
     */
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int sourceColor = image[sr][sc];
        if (sourceColor == color) return image;
        int r = sr, c = sc;
        Deque<int[]> deque = new ArrayDeque<>();
        deque.push(new int[]{r, c});
        while (!deque.isEmpty()) {
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                int[] nums = deque.poll();
                int row = nums[0], col = nums[1];
                if (image[row][col] != color) { // 判断是否已访问过
                    image[row][col] = color;
                    if (checkRowColColor(row + 1, col, image, sourceColor))
                        deque.push(new int[]{row + 1, col});
                    if (checkRowColColor(row - 1, col, image, sourceColor))
                        deque.push(new int[]{row - 1, col});
                    if (checkRowColColor(row, col - 1, image, sourceColor))
                        deque.push(new int[]{row, col - 1});
                    if (checkRowColColor(row, col + 1, image, sourceColor))
                        deque.push(new int[]{row, col + 1});
                }
            }
        }
        return image;
    }

    private boolean checkRowColColor(int newRow, int newCol, int[][] image, int sourceColor) {
        return checkRow(newRow, image) && checkCol(newCol, image) && image[newRow][newCol] == sourceColor;
    }

    private boolean checkRow(int newRow, int[][] image) {
        return 0 <= newRow && newRow < image.length;
    }

    private boolean checkCol(int newCol, int[][] image) {
        return 0 <= newCol && newCol < image[0].length;
    }

    int[] dx = {1, 0, 0, -1};
    int[] dy = {0, 1, -1, 0};

    public int[][] floodFillV2(int[][] image, int sr, int sc, int color) {
        int currColor = image[sr][sc];
        if (currColor == color) return image;
        int n = image.length, m = image[0].length;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{sr, sc});
        image[sr][sc] = color;
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int x = cell[0], y = cell[1];
            for (int i = 0; i < 4; i++) {
                int mx = x + dx[i], my = y + dy[i];
                if (mx >= 0 && mx < n && my >= 0 && my < m && image[mx][my] == currColor) {
                    queue.offer(new int[]{mx, my});
                    image[mx][my] = color;
                }
            }
        }
        return image;
    }


    /**
     * 深度优先搜索
     * 复杂度分析:
     * 时间复杂度：O(n×m)，其中 n 和 m 分别是二维数组的行数和列数。最坏情况下需要遍历所有的方格一次。
     * 空间复杂度：O(1)，其中 n 和 m 分别是二维数组的行数和列数。主要为栈空间的开销。
     * @author tiankai.me@gmail.com on 2023-08-10 11:27.
     */
    public int[][] floodFillV3(int[][] image, int sr, int sc, int color) {
        if(image[sr][sc] == color) return image;
        int m = image[sr][sc];
        image[sr][sc] = color;
        // 如果不在最上一行
        if (sr != 0 && m == image[sr - 1][sc]) floodFillV3(image, sr - 1, sc, color);
        // 如果不在最下一行
        if (sr != image.length - 1 && m == image[sr + 1][sc]) floodFillV3(image, sr + 1, sc, color);
        // 如果不在最左一列
        if (sc != 0 && m == image[sr][sc - 1]) floodFillV3(image, sr, sc - 1, color);
        // 如果不在最右一列
        if (sc != image[0].length - 1 && m == image[sr][sc + 1]) floodFillV3(image, sr, sc + 1, color);
        return image;

    }

    @Test
    public void case01Test() {
        final LC733FloodFill floodFill = new LC733FloodFill();
        final int[] col1 = new int[]{1, 1, 1};
        final int[] col2 = new int[]{1, 1, 0};
        final int[] col3 = new int[]{1, 0, 1};
        final int[][] image = new int[][]{col1, col2, col3};
        final int[][] ans = floodFill.floodFill(image, 1, 1, 2);
        MathRandomUtil.print2DArray(ans);
    }

    @Test
    public void case02Test() {
        final LC733FloodFill floodFill = new LC733FloodFill();
        final int[] col1 = new int[]{0, 0, 0};
        final int[] col2 = new int[]{0, 0, 0};
        final int[][] image = new int[][]{col1, col2};
        final int[][] ans = floodFill.floodFill(image, 0, 0, 0);
        MathRandomUtil.print2DArray(ans);
    }
}
