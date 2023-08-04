package cn.tiakon.java.zbook.chapter01.example10;

import cn.tiakon.java.utils.MathRandomUtil;
import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * 求最大子矩阵的面积
 * 给定一个整数矩阵map，其中的值只有0个1两种，求其中全是1的所有矩形区域中，最大的矩形区域为1的数量。
 * <p>
 * 例如：
 * 1 1 1 0
 * 其中，最大的矩形区域有 3 个 1 ，所以返回 3.
 * 再如：
 * 1 0 1 1
 * 1 1 1 1
 * 1 1 1 0
 * 其中，最大的矩形区域有 6 个 1 ，所以返回 6
 *
 * @author tiankai.me@gmail.com on 2022/7/24 6:18.
 */
public class MaximumSubMatrix {

    public int getMaximumForSubMatrix(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return 0;
        }
        final Stack<LinkedList<Integer>> stack = new Stack<>();
        final List<Integer> list = new ArrayList<>();
        int res = 0;
        for (int i = 0; i < matrix.length; i++) {
            final LinkedList<Integer> linkedList = new LinkedList<>();
            for (int j = 0; j < matrix[i].length - 1; j++) {
                if (matrix[i][j] == 1) {
                    linkedList.add(j);
                }
                if (!stack.isEmpty()) {
                    final LinkedList<Integer> preLinked = stack.peek();
                    final Integer peekFirstIndex = preLinked.peekFirst();
                    if (matrix[i][j] == matrix[i - 1][peekFirstIndex] && j == peekFirstIndex) {
                        res += 2;
                        preLinked.pollFirst();
                    } else {
                        list.add(res);
                        res = 0;
                    }
                    if (j != 0 && matrix[i][j - 1] != matrix[i - 1][peekFirstIndex - 1]) {
                        list.add(res);
                        res = 0;
                    }
                    if (preLinked.isEmpty()) {
                        stack.pop();
                    }
                }
            }
            stack.push(linkedList);
        }

        return res;
    }

    // 1 0 0 1
    // 1 0 1 1
    // 0 0 1 1
    public int maxRecSize(int[][] map) {
        if (map == null || map.length == 0 || map[0].length == 0) {
            return 0;
        }
        int maxArea = 0;
        int[] height = new int[map[0].length];
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                height[j] = map[i][j] == 0 ? 0 : height[j] + 1;
            }
            maxArea = Math.max(maxRecFromBottom(height), maxArea);
        }
        return maxArea;
    }

    /**
     * 求直方图中的最大矩形面积
     *
     * @author tiankai.me@gmail.com on 2022/7/24 17:23.
     */
    private int maxRecFromBottom(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        int maxArea = 0;
        final Stack<Integer> stack = new Stack<Integer>();
        for (int i = 0; i < height.length; i++) {
            while (!stack.isEmpty() && height[i] <= height[stack.peek()]) {
                int j = stack.pop();
                int k = stack.isEmpty() ? -1 : stack.peek();
                int curArea = (i - k - 1) * height[j];
                maxArea = Math.max(maxArea, curArea);
            }
            stack.push(i);
        }
        while (!stack.isEmpty()) {
            int j = stack.pop();
            int k = stack.isEmpty() ? -1 : stack.peek();
            int curArea = (height.length - k - 1) * height[j];
            maxArea = Math.max(maxArea, curArea);
        }
        return maxArea;
    }

    @Test
    public void matrixTest() {
        // 5行3列
        final int[][] matrix = new int[5][3];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println("");
        }
    }

    public static void main(String[] args) {
        final MaximumSubMatrix maximumSubMatrix = new MaximumSubMatrix();
        final int[][] array2d = MathRandomUtil.create2DRandomArrayWithZeroAndOne(3, 4);
        MathRandomUtil.print2DArray(array2d);
        final int maxRecSize = maximumSubMatrix.maxRecSize(array2d);
        System.out.println(maxRecSize);
    }
}
