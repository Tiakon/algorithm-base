package cn.tiakon.java.leetcode.array;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

/**
 * 698. 划分为k个相等的子集
 * https://leetcode.cn/problems/partition-to-k-equal-sum-subsets/
 *
 * @author tiankai.me@gmail.com on 2022/9/20 17:51.
 */
public class LC698PartitionToKEqualSumSubsets {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        if (nums.length > 16 || k > nums.length || k < 1) return false;
        int sum = Arrays.stream(nums).sum();
        if (sum % k != 0) return false;
        int partitionSum = sum / k, size = 0;
        int i = 0;
        while (i < nums.length) {
            if (nums[i] > partitionSum) return false;
            if (nums[i] == partitionSum) size++;
            else {
                int j = i + 1;
                int windowSum = nums[i];
                while (j < nums.length) {
                    windowSum += nums[j];
                    if (windowSum == partitionSum) {
                        if (j - i > 1) swap(nums, ++i, j++);
                        else i = j;
                        size++;
                        break;
                    } else if (windowSum < partitionSum) {
                        if (j - i > 1) {
                            swap(nums, ++i, j++);
                        } else {
                            i = j;
                            j++;
                        }
                    } else {
                        windowSum -= nums[j];
                        j++;
                    }
                }
            }
            i++;
        }
        return size == k;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[j];
        nums[j] = nums[i];
        nums[i] = temp;
    }

    // public boolean canPartitionKSubsets(int[] nums, int k) {
    //     int sum = Arrays.stream(nums).sum();
    //     if (sum % k != 0) return false;
    //     int partitionSum = sum / k, size = 0;
    //     final Map<Integer, List<Integer>> hashMap = new HashMap<>();
    //     for (int i = 0; i < nums.length; i++) {
    //         int num = nums[i];
    //         if (num > partitionSum) return false;
    //         if (num == partitionSum) size++;
    //         else {
    //             // num < partitionSum
    //             if (!hashMap.containsKey(num)) {
    //                 final List<Integer> arrayList = new ArrayList<>();
    //                 arrayList.add(i);
    //                 hashMap.put(num, arrayList);
    //             } else hashMap.get(num).add(i);
    //         }
    //     }
    //     for (int i = 0; i < nums.length; i++) {
    //         if (nums[i] < partitionSum && hashMap.containsKey(nums[i])) {
    //             final List<Integer> integers = hashMap.get(nums[i]);
    //             int arraySum = 0;
    //             for (int j = 0; j < integers.size(); j++) {
    //                 arraySum += nums[i];
    //                 final int target = partitionSum - arraySum;
    //                 if (hashMap.containsKey(target)) {
    //                     deleteItemInMapOrList(hashMap, nums[i]);
    //                     deleteItemInMapOrList(hashMap, target);
    //                     size++;
    //                 }
    //             }
    //         }
    //     }
    //     return size == k;
    // }
    //
    // private void deleteItemInMapOrList(Map<Integer, List<Integer>> hashMap, int target) {
    //     final List<Integer> integerList = hashMap.get(target);
    //     if (integerList.size() == 1) hashMap.remove(target);
    //     else integerList.remove(integerList.size() - 1);
    // }
    @Test
    public void canPartitionKSubsetsTest() {
        final LC698PartitionToKEqualSumSubsets partitionToKEqualSumSubsets = new LC698PartitionToKEqualSumSubsets();
        int[] nums = new int[]{4, 3, 2, 3, 5, 2, 1};
        int k = 4;
        boolean ans = partitionToKEqualSumSubsets.canPartitionKSubsets(nums, k);
        Assert.assertTrue(ans);

        nums = new int[]{1, 2, 3, 4};
        k = 3;
        ans = partitionToKEqualSumSubsets.canPartitionKSubsets(nums, k);
        Assert.assertFalse(ans);

        nums = new int[]{2, 2, 2, 2, 3, 4, 5};
        k = 4;
        ans = partitionToKEqualSumSubsets.canPartitionKSubsets(nums, k);
        Assert.assertFalse(ans);

        nums = new int[]{1, 1, 1, 1, 2, 2, 2, 2};
        k = 2;
        ans = partitionToKEqualSumSubsets.canPartitionKSubsets(nums, k);
        Assert.assertTrue(ans);

        nums = new int[]{1, 1, 1, 1, 2, 2, 2, 2};
        k = 4;
        ans = partitionToKEqualSumSubsets.canPartitionKSubsets(nums, k);
        Assert.assertTrue(ans);
    }

}
