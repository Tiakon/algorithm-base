package cn.tiakon.java.leetcode.simulation;

import org.junit.Assert;
import org.junit.Test;

/**
 * 1620. 网络信号最好的坐标
 * 注意:最好信号的坐标可以不在塔上
 * https://leetcode.cn/problems/coordinate-with-maximum-network-quality/
 *
 * @author tiankai.me@gmail.com on 2022/11/2 下午10:38.
 */
public class LC1620CoordinateWithMaximumNetworkQuality {

    public int[] bestCoordinate(int[][] towers, int radius) {
        int xMax = Integer.MIN_VALUE, yMax = Integer.MIN_VALUE;
        for (int[] tower : towers) {
            int x = tower[0], y = tower[1];
            xMax = Math.max(xMax, x);
            yMax = Math.max(yMax, y);
        }
        int cx = 0, cy = 0;
        int maxQuality = 0;
        for (int x = 0; x <= xMax; x++) {
            for (int y = 0; y <= yMax; y++) {
                int[] coordinate = {x, y};
                int quality = 0;
                for (int[] tower : towers) {
                    int squaredDistance = getSquaredDistance(coordinate, tower);
                    if (squaredDistance <= radius * radius) {
                        double distance = Math.sqrt(squaredDistance);
                        quality += (int) Math.floor(tower[2] / (1 + distance));
                    }
                }
                if (quality > maxQuality) {
                    cx = x;
                    cy = y;
                    maxQuality = quality;
                }
            }
        }
        return new int[]{cx, cy};
    }

    public int getSquaredDistance(int[] coordinate, int[] tower) {
        return (tower[0] - coordinate[0]) * (tower[0] - coordinate[0]) + (tower[1] - coordinate[1]) * (tower[1] - coordinate[1]);
    }

    /**
     * for(x){for(y)}  ->  从x=0开始,在y轴上从小到大搜索.  当值相同时,这种方式可满足字典序最小.
     * for(y){for(x)}  ->  从y=0开始,在x轴上从小到大搜索.  此方式 x坐标可能不是最小的.
     * <p>
     * 坐标(x1, y1)字典序比另一个坐标(x2, y2) 小，需满足以下条件之一：
     * 要么x1 < x2，
     * 要么x1 == x2 且y1 < y2。
     *
     * @author tiankai.me@gmail.com on 2022/11/7 下午5:52.
     */
    public int[] bestCoordinateV2(int[][] towers, int radius) {
        int xMax = -1, yMax = -1;
        for (int[] tower : towers) {
            xMax = Math.max(tower[0], xMax);
            yMax = Math.max(tower[1], yMax);
        }
//        debug使用
//        int[][] ints = new int[yMax + 1][xMax + 1];
        int max = 0, x = 0, y = 0;
        for (int x1 = 0; x1 <= xMax; x1++) {
            for (int y1 = 0; y1 <= yMax; y1++) {
                int coordinate = getCoordinate(x1, y1, towers, radius);
//                ints[y1][x1] = coordinate;
                if (coordinate > max) {
                    max = coordinate;
                    x = x1;
                    y = y1;
                }
            }
        }
        return new int[]{x, y};
    }

    // 所有信号塔在(x1,y1)坐标的信号强度
    public int getCoordinate(int x1, int y1, int[][] towers, int radius) {
        int ans = 0;
        for (int[] tower : towers) {
            int x2 = tower[0], y2 = tower[1];
            // 欧几里得公式计算两坐标之间的距离
            double distance = Math.sqrt(Math.pow((x1 - x2), 2) + Math.pow(y1 - y2, 2));
            // 塔i在坐标(x1,y1)的信号强度
            if (radius >= distance) ans += (int) Math.floor(tower[2] / (1 + distance));
        }
        return ans;
    }

    @Test
    public void bestCoordinateTest() {
        Assert.assertEquals(2, Math.sqrt(4), 0);
        LC1620CoordinateWithMaximumNetworkQuality lc1620CoordinateWithMaximumNetworkQuality = new LC1620CoordinateWithMaximumNetworkQuality();
        int[][] towers = {{1, 2, 5}, {2, 1, 7}, {3, 1, 9}};
        int radius = 2;
        int[] ans = lc1620CoordinateWithMaximumNetworkQuality.bestCoordinate(towers, radius);
        Assert.assertArrayEquals(new int[]{2, 1}, ans);

        towers = new int[][]{{23, 11, 21}};
        radius = 9;
        ans = lc1620CoordinateWithMaximumNetworkQuality.bestCoordinate(towers, radius);
        Assert.assertArrayEquals(new int[]{23, 11}, ans);

        towers = new int[][]{{1, 2, 13}, {2, 1, 7}, {0, 1, 9}};
        radius = 2;
        ans = lc1620CoordinateWithMaximumNetworkQuality.bestCoordinate(towers, radius);
        Assert.assertArrayEquals(new int[]{1, 2}, ans);

        towers = new int[][]{{42, 0, 0}};
        radius = 7;
        ans = lc1620CoordinateWithMaximumNetworkQuality.bestCoordinate(towers, radius);
        Assert.assertArrayEquals(new int[]{0, 0}, ans);

        towers = new int[][]{{0, 1, 2}, {2, 1, 2}, {1, 0, 2}, {1, 2, 2}};
        radius = 1;
        ans = lc1620CoordinateWithMaximumNetworkQuality.bestCoordinate(towers, radius);
        Assert.assertArrayEquals(new int[]{1, 1}, ans);

        towers = new int[][]{{33, 24, 12}, {5, 34, 12}, {9, 45, 6}, {28, 12, 12}};
        radius = 2;
        ans = lc1620CoordinateWithMaximumNetworkQuality.bestCoordinate(towers, radius);
        Assert.assertArrayEquals(new int[]{5, 34}, ans);

        towers = new int[][]{{44, 31, 4}, {47, 27, 27}, {7, 13, 0}, {13, 21, 20}, {50, 34, 18}, {47, 44, 28}};
        radius = 13;
        ans = lc1620CoordinateWithMaximumNetworkQuality.bestCoordinate(towers, radius);
        Assert.assertArrayEquals(new int[]{47, 27}, ans);

    }

    @Test
    public void bestCoordinateV2Test() {
        Assert.assertEquals(2, Math.sqrt(4), 0);

        LC1620CoordinateWithMaximumNetworkQuality lc1620CoordinateWithMaximumNetworkQuality = new LC1620CoordinateWithMaximumNetworkQuality();
        int[][] towers = {{1, 2, 5}, {2, 1, 7}, {3, 1, 9}};
        int radius = 2;
        int[] ans = lc1620CoordinateWithMaximumNetworkQuality.bestCoordinateV2(towers, radius);
        Assert.assertArrayEquals(new int[]{2, 1}, ans);

        towers = new int[][]{{23, 11, 21}};
        radius = 9;
        ans = lc1620CoordinateWithMaximumNetworkQuality.bestCoordinateV2(towers, radius);
        Assert.assertArrayEquals(new int[]{23, 11}, ans);

        towers = new int[][]{{1, 2, 13}, {2, 1, 7}, {0, 1, 9}};
        radius = 2;
        ans = lc1620CoordinateWithMaximumNetworkQuality.bestCoordinateV2(towers, radius);
        Assert.assertArrayEquals(new int[]{1, 2}, ans);

        towers = new int[][]{{42, 0, 0}};
        radius = 7;
        ans = lc1620CoordinateWithMaximumNetworkQuality.bestCoordinateV2(towers, radius);
        Assert.assertArrayEquals(new int[]{0, 0}, ans);

        towers = new int[][]{{0, 1, 2}, {2, 1, 2}, {1, 0, 2}, {1, 2, 2}};
        radius = 1;
        ans = lc1620CoordinateWithMaximumNetworkQuality.bestCoordinateV2(towers, radius);
        Assert.assertArrayEquals(new int[]{1, 1}, ans);

        towers = new int[][]{{33, 24, 12}, {5, 34, 12}, {9, 45, 6}, {28, 12, 12}};
        radius = 2;
        ans = lc1620CoordinateWithMaximumNetworkQuality.bestCoordinateV2(towers, radius);
        Assert.assertArrayEquals(new int[]{5, 34}, ans);

        towers = new int[][]{{44, 31, 4}, {47, 27, 27}, {7, 13, 0}, {13, 21, 20}, {50, 34, 18}, {47, 44, 28}};
        radius = 13;
        ans = lc1620CoordinateWithMaximumNetworkQuality.bestCoordinateV2(towers, radius);
        Assert.assertArrayEquals(new int[]{47, 27}, ans);
    }

}
