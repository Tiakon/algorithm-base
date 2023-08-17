package cn.tiakon.java.leetcode.array;

import java.util.*;

/**
 * <a href="https://leetcode.cn/problems/intersection-of-two-arrays-ii/">350. 两个数组的交集 II</a>
 *
 * @author tiankai.me@gmail.com on 2022/12/8 下午6:40.
 */
public class LC350IntersectionOfTwoArraysII {
    /**
     * 哈希表法
     * [1,2,2,1]
     * [2,2]
     * [4,9,5]
     * [9,4,9,8,4]
     * [1,2]
     * [1,1]
     * 如果 nums2 的元素存储在磁盘上，内存是有限的，并且你不能一次加载所有的元素到内存中，你该怎么办？
     * nums2无法全部读进内存,所以无法高效的排序.
     * 因为输出结果还关心交集中相同元素的数量,所以可以使用哈希表,先对num2中的元素进行统计,拿到num2中全部的词频统计后,就可以对nums1中的元素进行判断了.
     * @author tiankai.me@gmail.com on 2022/12/9 下午4:04.
     */
    public int[] intersection(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums1) {
            Integer count = map.getOrDefault(i, 0);
            map.put(i, ++count);
        }
        List<Integer> list2 = new ArrayList<>();
        for (int i : nums2) {
            Integer count = map.getOrDefault(i, 0);
            if (count > 0) {
                list2.add(i);
                map.put(i, --count);
            }
        }
        return list2.stream().mapToInt(i -> i).toArray();
    }

    public int[] intersectionV2(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int length1 = nums1.length, length2 = nums2.length;
        int[] intersection = new int[Math.min(length1, length2)];
        int index1 = 0, index2 = 0, index = 0;
        while (index1 < length1 && index2 < length2) {
            if (nums1[index1] < nums2[index2]) index1++;
            else if (nums1[index1] > nums2[index2]) index2++;
            else {
                intersection[index] = nums1[index1];
                index1++;
                index2++;
                index++;
            }
        }
        return Arrays.copyOfRange(intersection, 0, index);
    }

    public int[] intersectV3(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) return intersectV3(nums2, nums1);
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums1) {
            int count = map.getOrDefault(num, 0);
            map.put(num, ++count);
        }
        int[] intersection = new int[nums1.length];
        int index = 0;
        for (int num : nums2) {
            int count = map.getOrDefault(num, 0);
            if (count > 0) {
                intersection[index++] = num;
                count--;
                if (count > 0) map.put(num, count);
                else map.remove(num);
            }
        }
        return Arrays.copyOfRange(intersection, 0, index);
    }


}
