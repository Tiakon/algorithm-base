package cn.tiakon.java.leetcode.array.sort;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * 976. 三角形的最大周长
 * https://leetcode.cn/problems/largest-perimeter-triangle/
 *
 * @author tiankai.me@gmail.com on 2022/11/9 上午11:07.
 */
public class LC976LargestPerimeterTriangle {
    public int largestPerimeter(int[] nums) {
        Arrays.sort(nums);
        for (int i = nums.length - 1; i - 2 >= 0; i--) {
            int a = i, b = i - 1, c = i - 2;
            if (nums[b] + nums[c] > nums[a]) return nums[a] + nums[b] + nums[c];
        }
        return 0;
    }

    // 当a>=b>=c时,只需验证b+c>a即可.
    public boolean check(int a, int b, int c) {
        return a + b > c && a + c > b && b + c > a;
    }

    // 选择排序
    public void sort(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] < nums[i]) {
                    int temp = nums[j];
                    nums[j] = nums[i];
                    nums[i] = temp;
                }
            }
        }
    }

    @Test
    public void sortTest() {
        LC976LargestPerimeterTriangle largestPerimeterTriangle = new LC976LargestPerimeterTriangle();
        int[] nums = new int[]{5, 2, 6, 9, 7, 3, 4, 1};
        largestPerimeterTriangle.sort(nums);
        Assert.assertArrayEquals(new int[]{1, 2, 3, 4, 5, 6, 7, 9}, nums);

        nums = new int[]{7, 3, 4, 1, 8, 5, 2, 6, 9};
        largestPerimeterTriangle.sort(nums);
        Assert.assertArrayEquals(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9}, nums);
    }

}
