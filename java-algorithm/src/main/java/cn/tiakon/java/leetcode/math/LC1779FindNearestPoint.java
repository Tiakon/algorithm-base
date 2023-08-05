package cn.tiakon.java.leetcode.math;

import org.junit.Assert;
import org.junit.Test;

/**
 * 1779. 找到最近的有相同 X 或 Y 坐标的点
 * https://leetcode.cn/problems/find-nearest-point-that-has-the-same-x-or-y-coordinate/
 *
 * @author tiankai.me@gmail.com on 2022/11/9 下午2:10.
 */
public class LC1779FindNearestPoint {
    public int nearestValidPoint(int x, int y, int[][] points) {
        int distanceMin = Integer.MAX_VALUE;
        int ans = -1;
        for (int i = 0; i < points.length; i++) {
            int temp = Math.abs(points[i][0] - x) + Math.abs(points[i][1] - y);
            if (temp < distanceMin && (points[i][0] == x || points[i][1] == y)) {
                distanceMin = temp;
                ans = i;
            }
        }
        return ans;
    }

    public int nearestValidPointV2(int x, int y, int[][] points) {
        int distance = Integer.MAX_VALUE;
        int tmpX = 10001;
        int tmpY = 10001;
        int idx = -1;
        int cnt = 0;
        for (int[] point : points) {
            if (x == point[0] || y == point[1]) {
                int tmp = Math.abs(point[0] - x) + Math.abs(point[1] - y);
                if (tmp < distance) {
                    distance = tmp;
                    tmpX = point[0];
                    tmpY = point[1];
                    idx = cnt;
                } else if (tmp == distance) {
                    if (point[0] + point[1] < tmpX + tmpY) {
                        tmpX = point[0];
                        tmpY = point[1];
                        idx = cnt;
                    }
                }
            }
            cnt++;
        }
        return idx;
    }

    @Test
    public void nearestValidPointTest() {
        LC1779FindNearestPoint findNearestPoint = new LC1779FindNearestPoint();
        int[][] nums = new int[][]{{1, 2}, {3, 1}, {2, 4}, {2, 3}, {4, 4}};
        int ans = findNearestPoint.nearestValidPoint(3, 4, nums);
        Assert.assertEquals(2, ans);

        nums = new int[][]{{3, 4}};
        ans = findNearestPoint.nearestValidPoint(3, 4, nums);
        Assert.assertEquals(0, ans);

        nums = new int[][]{{2, 3}};
        ans = findNearestPoint.nearestValidPoint(3, 4, nums);
        Assert.assertEquals(-1, ans);

        nums = new int[][]{{1, 2}, {3, 3}, {3, 3}};
        ans = findNearestPoint.nearestValidPoint(1, 1, nums);
        Assert.assertEquals(0, ans);
    }
}
