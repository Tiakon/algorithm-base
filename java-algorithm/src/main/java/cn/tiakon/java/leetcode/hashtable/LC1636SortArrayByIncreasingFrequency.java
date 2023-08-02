package cn.tiakon.java.leetcode.hashtable;

import cn.tiakon.java.utils.MathRandomUtil;
import org.junit.Assert;
import org.junit.Test;

import java.util.*;

/**
 * 1636. 按照频率将数组升序排序
 * https://leetcode.cn/problems/sort-array-by-increasing-frequency/
 *
 * @author tiankai.me@gmail.com on 2022/9/19 11:25.
 */
public class LC1636SortArrayByIncreasingFrequency {

    /**
     * 模拟流程：主要考察哈希表
     * <p>
     * 1. 先统计字母出现的频次
     * 2. 再将字母与频次反转，值使用set集合
     * 3. 最后在原地排序，先根据频次升序排，同频再按逆序排
     * <p>
     * 执行用时： 4 ms , 在所有 Java 提交中击败了 73.41% 的用户
     * 内存消耗： 41.8 MB , 在所有 Java 提交中击败了 45.67% 的用户
     *
     * @author tiankai.me@gmail.com on 2022/9/19 17:31.
     */
    public int[] frequencySort(int[] nums) {
        final Map<Integer, Integer> map = new HashMap<>();
        // 统计字母出现的频次
        for (int i = 0; i < nums.length; i++) map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        // 将字母与频次反转，值使用set集合
        Map<Integer, Set<Integer>> hashMap = new HashMap<>();
        for (Integer realValue : map.keySet()) {
            final Integer countValue = map.get(realValue);
            Set<Integer> hashSet;
            if (!hashMap.containsKey(countValue)) {
                hashSet = new HashSet<>();
                hashSet.add(realValue);
            } else {
                hashSet = hashMap.get(countValue);
                hashSet.add(realValue);
            }
            hashMap.put(countValue, hashSet);
        }
        int left = 0;
        // 在原地排序，先根据频次升序排，同频再按逆序排
        final Integer[] keyArr = hashMap.keySet().toArray(new Integer[0]);
        Arrays.sort(keyArr);
        for (Integer count : keyArr) {
            final Set<Integer> set = hashMap.get(count);
            final Integer[] array = set.toArray(new Integer[0]);
            Arrays.sort(array);
            for (int k = array.length - 1; k >= 0; k--) {
                int temp = count;
                while (temp-- > 0) {
                    nums[left++] = array[k];
                }
            }
        }
        return nums;
    }

    /**
     * @author tiankai.me@gmail.com on 2022/9/19 17:36.
     */
    public int[] frequencySortV2(int[] nums) {
        Map<Integer, Integer> cnt = new HashMap<Integer, Integer>();
        for (int num : nums) {
            cnt.put(num, cnt.getOrDefault(num, 0) + 1);
        }
        List<Integer> list = new ArrayList<Integer>();
        for (int num : nums) {
            list.add(num);
        }
        Collections.sort(list, (a, b) -> {
            int cnt1 = cnt.get(a), cnt2 = cnt.get(b);
            return cnt1 != cnt2 ? cnt1 - cnt2 : b - a;
        });
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            nums[i] = list.get(i);
        }
        return nums;
    }

    /**
     * @author tiankai.me@gmail.com on 2022/9/19 17:36.
     */
    public int[] frequencySortV3(int[] nums) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        List<int[]> list = new ArrayList<>();
        for (int key : map.keySet()) list.add(new int[]{key, map.get(key)});
        Collections.sort(list, (a, b) -> {
            return a[1] != b[1] ? a[1] - b[1] : b[0] - a[0];
        });
        int[] ans = new int[n];
        int idx = 0;
        for (int[] info : list) {
            while (info[1]-- > 0) ans[idx++] = info[0];
        }
        return ans;
    }

}
