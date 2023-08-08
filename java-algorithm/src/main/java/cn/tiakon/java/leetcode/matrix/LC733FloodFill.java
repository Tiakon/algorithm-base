package cn.tiakon.java.leetcode.matrix;

/**
 * 733. 图像渲染
 * https://leetcode.cn/problems/flood-fill/
 *
 * @author tiankai.me@gmail.com on 2022/8/17 14:50.
 */
public class LC733FloodFill {

    // 1. 递归
    // 2. 双指针
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if (image == null) {
            return new int[0][0];
        }
        if (image.length > 50 || image[0].length > 50) {
            throw new ArrayIndexOutOfBoundsException(51);
        }
        final int initColor = image[sr][sc];
        // 如何实现上下左右搜索，并返回符合填充节点的位置

        return null;
    }

    // 搜索上下左右相同颜色的像素，并返回合法像素的位置
    public void searchSamePixel(){

    }


}
