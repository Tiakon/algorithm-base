package cn.tiakon.java.leetcode.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 1282. 用户分组
 * https://leetcode.cn/problems/group-the-people-given-the-group-size-they-belong-to/
 *
 * @author tiankai.me@gmail.com on 2022/8/12 10:11.
 */
public class LC1282GroupThePeople {

    /**
     * 复杂度分析：遍历数组
     * 时间复杂度：O(N*k) ,N是数组的长度，k是遍历组的次数。
     * 空间复杂度：O(N)
     *
     * @author tiankai.me@gmail.com on 2022/8/12 17:32.
     */
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        final List<List<Integer>> ans = new ArrayList<>();
        // 主要考虑遍历组时插入元素面临的两种情况：
        // 1. 组已存在，未满员直接插入。
        // 2. 组不存在或存在已满员，创建新组直接插入。
        // 3. 注意隐藏的可用条件，可以利用组中已存下标，去数组中获取组大小。
        for (int i = 0; i < groupSizes.length; i++) {
            boolean isExist = false;
            // 遍历组插入元素面临的几种情况：
            for (int j = 0; j < ans.size(); j++) {
                List<Integer> cur = ans.get(j);
                //1. 组已存在，未满直接插入
                if (groupSizes[i] == groupSizes[cur.get(0)] && cur.size() < groupSizes[cur.get(0)]) {
                    isExist = true;
                    cur.add(i);
                    break;
                }
            }
            //2. 组不存在或存在已满，创建新组直接插入
            if (!isExist) {
                List<Integer> list = new ArrayList<>();
                list.add(i);
                ans.add(list);
            }
        }
        return ans;
    }

    /**
     * 哈希表解法
     * 1. 使用哈希表遍历数组保存成组，键作为groupSize，值作下标。
     * 2. 对已存在的组未满，则插入。
     * 3. 对已存在但满员的组，先移除组放入链表后再创建新组插入。
     * 4. 对不存在的组,创建新组直接插入。
     *
     * @author tiankai.me@gmail.com on 2022/8/12 17:33.
     */
    public List<List<Integer>> groupThePeopleV2(int[] groupSizes) {
        // 1. 使用哈希表遍历数组保存成组，键作为groupSize，值作下标。
        Map<Integer, List<Integer>> hashMap = new HashMap<>();
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < groupSizes.length; i++) {
            final int curGS = groupSizes[i];
            // 2. 对已存在的组未满，则插入。
            if (hashMap.containsKey(curGS) && hashMap.get(curGS).size() < curGS) {
                hashMap.get(curGS).add(i);
            } else {
                // 3. 对已存在但满员的组，先移除组放入链表后再创建新组插入。
                if (hashMap.containsKey(curGS) && hashMap.get(curGS).size() == curGS) {
                    ans.add(hashMap.get(curGS));
                    hashMap.remove(curGS);
                }
                // 4. 对不存在的组,创建新组直接插入。
                List<Integer> list = new ArrayList<>();
                list.add(i);
                hashMap.put(curGS, list);
            }
        }
        for (List<Integer> list : hashMap.values()) {
            ans.add(list);
        }
        return ans;
    }

    /**
     * 最优解：嵌套for循环+双指针
     * 执行用时： 2 ms , 在所有 Java 提交中击败了 100.00% 的用户
     * 内存消耗： 42.2 MB , 在所有 Java 提交中击败了 37.80% 的用户
     *
     * @author tiankai.me@gmail.com on 2022/8/12 18:47.
     */
    public List<List<Integer>> groupThePeopleV3(int[] groupSizes) {
        List<List<Integer>> result = new ArrayList<>();
        //1. 利用内循环，插入组并将已插入的原数组位置置为0，直到组内满员才终止。
        //2. 外循环遇到0元素直接跳过，否则创建新组后进入内循环。
        //3. 注意，可以使用数组长度与组剩余个数来限制内循环的终止条件
        for (int i = 0; i < groupSizes.length; i++) {
            // 跳过已处理的元素
            if (groupSizes[i] == 0) {
                continue;
            }
            List<Integer> list = new ArrayList<>();
            result.add(list);
            list.add(i);
            // 计算组内剩余元素的个数
            int size = groupSizes[i] - 1;
            // 在整个数组中查找同组内的元素，找到后重置为0，并计算组内剩余个数
            for (int j = i + 1; j < groupSizes.length && size > 0; j++) {
                if (groupSizes[j] == groupSizes[i]) {
                    list.add(j);
                    groupSizes[j] = 0;
                    size--;
                }
            }
        }
        return result;
    }

}
