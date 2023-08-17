package cn.tiakon.java.leetcode.array;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * <a href="https://leetcode.cn/problems/intersection-of-two-arrays/">349. 两个数组的交集</a>
 *
 * @author tiankai.me@gmail.com on 2022/12/8 下午6:40.
 */
public class LC349IntersectionOfTwoArrays {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        for (int i : nums1) set1.add(i);
        Set<Integer> set2 = new HashSet<>();
        for (int i : nums2) if (set1.contains(i)) set2.add(i);
        return set2.stream().mapToInt(i -> i).toArray();
    }

    public int[] intersectionV2(int[] nums1, int[] nums2) {
        Set<Integer> set = Arrays.stream(nums1).boxed().collect(Collectors.toSet());
        return Arrays.stream(nums2).distinct().filter(set::contains).toArray();
    }

    @Test
    public void intersectionTest() {
        LC349IntersectionOfTwoArrays intersectionOfTwoArrays = new LC349IntersectionOfTwoArrays();
        int[] num1 = new int[]{1, 2, 2, 1};
        int[] num2 = new int[]{2, 2};
        int[] ans = intersectionOfTwoArrays.intersection(num1, num2);
        Arrays.sort(ans);
        Assert.assertArrayEquals(new int[]{2}, ans);

        num1 = new int[]{4, 9, 5};
        num2 = new int[]{9, 4, 9, 8, 4};
        ans = intersectionOfTwoArrays.intersection(num1, num2);
        Arrays.sort(ans);
        Assert.assertArrayEquals(new int[]{4, 9}, ans);
    }

}
