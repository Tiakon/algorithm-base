package cn.tiakon.java.leetcode.simulation;

import org.junit.Assert;
import org.junit.Test;

/**
 * 1603. 设计停车系统
 * https://leetcode.cn/problems/design-parking-system/
 *
 * @author tiankai.me@gmail.com on 2022/11/26 下午9:48.
 */
public class LC1603DesignParkingSystem {
    class ParkingSystem {
        int big;
        int medium;
        int small;

        public ParkingSystem(int big, int medium, int small) {
            this.big = big;
            this.medium = medium;
            this.small = small;
        }

        public boolean addCar(int carType) {
            switch (carType) {
                case 1:
                    if (--big < 0) return false;
                    break;
                case 2:
                    if (--medium < 0) return false;
                    break;
                case 3:
                    if (--small < 0) return false;
                    break;
                default:
                    break;
            }
            return true;
        }
    }

    @Test
    public void parkingSystemTest() {
        ParkingSystem parkingSystem = new ParkingSystem(1, 1, 0);
        Assert.assertTrue(parkingSystem.addCar(1));
        Assert.assertTrue(parkingSystem.addCar(2));
        Assert.assertFalse(parkingSystem.addCar(3));
        Assert.assertFalse(parkingSystem.addCar(1));
    }
}
