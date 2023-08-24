package cn.tiakon.java.leetcode.string;

import java.util.ArrayList;
import java.util.List;

/**
 * 1408. 数组中的字符串匹配
 * https://leetcode.cn/problems/string-matching-in-an-array/
 *
 * @author tiankai.me@gmail.com on 2022/8/21 21:44.
 */
public class LC1408StringMatchingArray {
    /**
     * 两次遍历
     * 复杂度分析
     * 时间复杂度：O(n^2×L^2)，其中 n 是字符串数组的长度，L 是字符串数组中最长字符串的长度。使用 KMP 字符串匹配算法可以将时间复杂度优化到 O(n^2 ×T)，其中 T 是字符串数组中所有字符串的平均长度。
     * 空间复杂度：O(1)。返回值不计入空间复杂度。如果使用 KMP 字符串匹配算法，那么对应的空间复杂度为 O(T)。
     * 执行用时： 3 ms , 在所有 Java 提交中击败了 93.68% 的用户
     * 内存消耗： 40.5 MB , 在所有 Java 提交中击败了 43.34% 的用户
     *
     * @author tiankai.me@gmail.com on 2022/8/21 22:47.
     */
    public List<String> stringMatching(String[] words) {
        Boolean[] isDeleted = new Boolean[words.length];
        List<String> ans = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            if (isDeleted[i] == null) {
                for (int j = 0; j < words.length; j++) {
                    if (i != j && isDeleted[j] == null && words[i].contains(words[j])) {
                        isDeleted[j] = true;
                        ans.add(words[j]);
                    }
                }
            }
        }
        return ans;
    }

}
