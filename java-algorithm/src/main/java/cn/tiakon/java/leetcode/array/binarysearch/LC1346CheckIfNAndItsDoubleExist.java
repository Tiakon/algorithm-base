package cn.tiakon.java.leetcode.array.binarysearch;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.cn/problems/check-if-n-and-its-double-exist/">1346. 检查整数及其两倍数是否存在</a>
 *
 * @author tiankai.me@gmail.com on 2022/12/8 下午6:52.
 */
public class LC1346CheckIfNAndItsDoubleExist {

    /**
     * [10,2,5,3]
     * [7,1,14,11]
     * [3,1,7,11]
     * [-20,8,-6,-14,0,-19,14,4]
     * [-2,0,10,-19,4,6,-8]
     * [0,0]
     * [-10,12,-20,-8,15]
     *
     * @author tiankai.me@gmail.com on 2022/12/8 下午7:14.
     */
    public boolean checkIfExist(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (i != j && (2 * arr[i] == arr[j] || 2 * arr[j] == arr[i])) return true;
            }
        }
        return false;
    }

    // n log(n) + n log(n)
    public boolean checkIfExistV2(int[] arr) {
        Arrays.sort(arr);
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] % 2 != 0) continue;
            int left = 0, right = arr.length - 1;
            while (left <= right) {
                int middle = left + (right - left) / 2;
                if (middle == i && arr[i] == 0) break; // 下标相等或值等于0时,跳过本次查找
                if (arr[middle] < arr[i] / 2) left = middle + 1;
                else if (arr[middle] > arr[i] / 2) right = middle - 1;
                else return true;
            }
        }
        return false;
    }

    // 数组计数
    public boolean checkIfExistV3(int[] arr) {
        int count[] = new int[2005];
        for (int i = 0; i < arr.length; i++) {
            count[arr[i] + 1000]++;
        }
        if (count[1000] > 1) return true;
        for (int i = -500; i <= 500; i++) {
            if (i != 0 && count[i + 1000] > 0 && count[2 * i + 1000] > 0) return true;
        }
        return false;
    }

    // 哈希表
    public boolean checkIfExistV4(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            Integer index = map.getOrDefault(arr[i] * 2, -1);
            if (index == -1 && arr[i] % 2 == 0) index = map.getOrDefault(arr[i] / 2, -1);
            if (index == -1) map.put(arr[i], i);
            else return true;
        }
        return false;
    }

    @Test
    public void checkIfExistV2Test() {
        LC1346CheckIfNAndItsDoubleExist checkIfNAndItsDoubleExist = new LC1346CheckIfNAndItsDoubleExist();
        int[] arr = new int[]{10, 2, 5, 3};
        boolean ans = checkIfNAndItsDoubleExist.checkIfExistV2(arr);
        Assert.assertTrue(ans);

        arr = new int[]{-10, 12, -20, -8, 15};
        ans = checkIfNAndItsDoubleExist.checkIfExistV2(arr);
        Assert.assertTrue(ans);

        arr = new int[]{-2, 0, 10, -19, 4, 6, -8};
        ans = checkIfNAndItsDoubleExist.checkIfExistV2(arr);
        Assert.assertFalse(ans);

        arr = new int[]{3, 1, 7, 11};
        ans = checkIfNAndItsDoubleExist.checkIfExistV2(arr);
        Assert.assertFalse(ans);
    }

    @Test
    public void checkIfExistV4Test() {
        LC1346CheckIfNAndItsDoubleExist checkIfNAndItsDoubleExist = new LC1346CheckIfNAndItsDoubleExist();
        int[] arr = new int[]{10, 2, 5, 3};
        boolean ans = checkIfNAndItsDoubleExist.checkIfExistV4(arr);
        Assert.assertTrue(ans);

        arr = new int[]{-10, 12, -20, -8, 15};
        ans = checkIfNAndItsDoubleExist.checkIfExistV4(arr);
        Assert.assertTrue(ans);

        arr = new int[]{-2, 0, 10, -19, 4, 6, -8};
        ans = checkIfNAndItsDoubleExist.checkIfExistV4(arr);
        Assert.assertFalse(ans);

        arr = new int[]{3, 1, 7, 11};
        ans = checkIfNAndItsDoubleExist.checkIfExistV4(arr);
        Assert.assertFalse(ans);

        arr = new int[]{0, 0};
        ans = checkIfNAndItsDoubleExist.checkIfExistV4(arr);
        Assert.assertTrue(ans);

        arr = new int[]{-20, 8, -6, -14, 0, -19, 14, 4};
        ans = checkIfNAndItsDoubleExist.checkIfExistV4(arr);
        Assert.assertTrue(ans);
    }
}
