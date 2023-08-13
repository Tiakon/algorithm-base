package cn.tiakon.java.leetcode.simulation;

import java.util.List;

/**
 * 1773. 统计匹配检索规则的物品数量
 * https://leetcode.cn/problems/count-items-matching-a-rule/
 *
 * @author tiankai.me@gmail.com on 2022/10/29 下午10:40.
 */
public class LC1773CountItemsMatchingRule {
    public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        int ans = 0;
        int index = getIndex(ruleKey);
        for (List<String> item : items) {
            if (ruleValue.equals(item.get(index))) ans++;
        }
        return ans;
    }

    public int getIndex(String ruleKey) {
        switch (ruleKey) {
            case "type":
                return 0;
            case "color":
                return 1;
            case "name":
                return 2;
            default:
                return -1;
        }
    }

    public int countMatchesV2(List<List<String>> items, String k, String v) {
        int ans = 0, idx = k.charAt(0) == 't' ? 0 : k.charAt(0) == 'c' ? 1 : 2;
        for (List<String> item : items) {
            if (item.get(idx).equals(v)) ans++;
        }
        return ans;
    }

}
