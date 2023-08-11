package cn.tiakon.java.leetcode.sampling;

import java.util.*;

/**
 * 398. 随机数索引
 * https://leetcode.cn/problems/random-pick-index/description/
 *
 * @author tiankai.me@gmail.com on 2023-08-10 18:29.
 */
public class LC398RandomPickIndex {
    Map<Integer, List<Integer>> map;
    int[] nums;
    final Random random = new Random(20230810);

    public LC398RandomPickIndex(int[] nums) {
        map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            final int target = nums[i];
            if (map.containsKey(target)) map.get(target).add(i);
            else {
                List list = new ArrayList();
                list.add(i);
                map.put(target, list);
            }
        }
    }

    public int pick(int target) {
        final List list = map.get(target);
        return (int) list.get(random.nextInt(list.size()));
    }
}
