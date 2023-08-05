package cn.tiakon.java.leetcode.math;

/**
 * 1232. 缀点成线
 * https://leetcode.cn/problems/check-if-it-is-a-straight-line/
 *
 * @author tiankai.me@gmail.com on 2022/11/11 下午7:48.
 */
public class LC1232CheckIfIsStraightLine {
    /**
     * 以数组第一个节点为原点，重建坐标轴比对两个点之间的斜率
     * 执行用时： 0 ms , 在所有 Java 提交中击败了 100.00% 的用户
     * 内存消耗： 40.9 MB , 在所有 Java 提交中击败了 84.28% 的用户
     * 通过测试用例： 79 / 79
     *
     * @author tiankai.me@gmail.com on 2022/11/11 下午8:52.
     */
    public boolean checkStraightLine(int[][] coordinates) {
        int x = coordinates[0][0];
        int y = coordinates[0][1];
        for (int i = 2; i < coordinates.length; i++) {
            int x1 = coordinates[i - 1][0];
            int y1 = coordinates[i - 1][1];
            int x2 = coordinates[i][0];
            int y2 = coordinates[i][1];
            if ((x1 - x) * (y2 - y) != (y1 - y) * (x2 - x)) return false;
        }
        return true;
    }
}
