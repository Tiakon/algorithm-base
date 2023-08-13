package cn.tiakon.java.leetcode.simulation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 2456. 最流行的视频创作者
 * https://leetcode.cn/problems/most-popular-video-creator/submissions/
 *
 * @author tiankai.me@gmail.com on 2022/10/31 上午10:48.
 */
public class LC2456MostPopularVideoCreator {

    /**
     * 执行用时： 60 ms , 在所有 Java 提交中击败了 100.00% 的用户
     * 内存消耗： 93 MB , 在所有 Java 提交中击败了 100.00% 的用户
     * 通过测试用例： 82 / 82
     *
     * @author tiankai.me@gmail.com on 2022/10/30 下午1:37.
     */
    public List<List<String>> mostPopularCreator(String[] creators, String[] ids, int[] views) {
        // 1. 基于人名统计播放量
        // 2. 给出播放最高的人
        // 3. 找到播放最高的视频名称
        Map<String, Long[]> hashMap = new HashMap<>();
        long playSumMax = 0L;
        for (int i = 0; i < creators.length; i++) {
            String name = creators[i];
            Long[] part;
            if (!hashMap.containsKey(name)) {
                part = new Long[3];
                // playSum
                part[0] = (long) views[i];
                // playMaxIndex
                part[2] = (long) i;
                // playMax
                part[1] = (long) views[i];
                hashMap.put(name, part);
            } else {
                part = hashMap.get(name);
                part[0] += (long) views[i];
                if (views[i] > part[1] || views[i] == part[1] && ids[i].compareTo(ids[Math.toIntExact(part[2])]) < 0)
                    part[2] = (long) i;
                part[1] = Math.max(views[i], part[1]);
                hashMap.put(name, part);
            }
            playSumMax = Math.max(playSumMax, part[0]);
        }
        List<List<String>> ans = new ArrayList<>();
        for (Map.Entry<String, Long[]> stringEntry : hashMap.entrySet()) {
            String name = stringEntry.getKey();
            Long[] part = stringEntry.getValue();
            if (part[0].equals(playSumMax)) {
                List<String> names = new ArrayList<>();
                names.add(name);
                names.add(ids[Math.toIntExact(part[2])]);
                ans.add(names);
            }
        }
        return ans;
    }


}
