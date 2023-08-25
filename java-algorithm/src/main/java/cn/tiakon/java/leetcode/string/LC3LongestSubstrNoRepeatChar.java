package cn.tiakon.java.leetcode.string;

import java.util.HashMap;
import java.util.Map;

/**
 * 3. 无重复字符的最长子串
 * https://leetcode.cn/problems/longest-substring-without-repeating-characters/
 *
 * @author tiankai.me@gmail.com on 2022/8/17 15:37.
 */
public class LC3LongestSubstrNoRepeatChar {

    /**
     * 滑动窗口+遍历+哈希表
     * 复杂度分析
     * 时间复杂度 : O(n^2)
     * 空间复杂度 : O(1)
     * 执行用时： 34 ms , 在所有 Java 提交中击败了 13.85% 的用户
     * 内存消耗： 41.7 MB , 在所有 Java 提交中击败了 33.90% 的用户
     * 该答案有个缺点：
     * 1. 左指针需要依次递增，增加了很多无谓的循环。
     * 2. 最大长度要根据map的大小计算，还有维护map中的值。
     *
     * @author tiankai.me@gmail.com on 2022/8/17 18:51.
     */
    public int lengthOfLongestSubstring(String s) {
        final char[] chars = s.toCharArray();
        int maxLength = 0, right = 0;
        Map<Integer, Character> hashMap = new HashMap<>();
        for (int left = 0; left < chars.length; left++) {
            while (hashMap.containsValue(chars[left])) {
                hashMap.remove(right++);
            }
            hashMap.put(left, chars[left]);
            maxLength = Math.max(maxLength, hashMap.size());
        }
        return maxLength;
    }

    /**
     * 滑动窗口优化后
     * 1. 利用哈希表确认是否重复。
     * 2. 利用左右指针计算窗口长度。
     * 这样只需遍历一次就可以得到最后结果
     * 复杂度分析
     * 时间复杂度 : O(n)
     * 空间复杂度 : O(1)
     * 执行用时： 4 ms , 在所有 Java 提交中击败了 86.77% 的用户
     * 内存消耗： 41.3 MB , 在所有 Java 提交中击败了 81.11% 的用户
     * char[] chars = s.toCharArray() 与 s.charAt(x) 前者取值效率更高
     *
     * @author tiankai.me@gmail.com on 2022/8/17 18:51.
     */
    public int lengthOfLongestSubstringV2(String s) {
        final char[] chars = s.toCharArray();
        Map<Character, Integer> hashMap = new HashMap<>();
        int max = 0, left = 0;
        for (int right = 0; right < chars.length; right++) {
            if (hashMap.containsKey(chars[right])) {
                // 当出现重复字符时，利用重复字符找到它在数组中的位置，并将窗口左边界右移一位
                left = Math.max(hashMap.get(chars[right]) + 1, left);
            }
            max = Math.max(max, right - left + 1);
            hashMap.put(chars[right], right);
        }
        return max;
    }

    /**
     * 滑动窗口+双指针原地计算最大长度
     * 复杂度分析
     * 时间复杂度 : ？？？
     * 空间复杂度 : O(1)
     * 执行用时： 4 ms , 在所有 Java 提交中击败了 86.77% 的用户
     * 内存消耗： 41.2 MB , 在所有 Java 提交中击败了 89.28% 的用户
     *
     * @author tiankai.me@gmail.com on 2022/8/17 18:51.
     */
    public int lengthOfLongestSubstringV3(String s) {
        final char[] chars = s.toCharArray();
        int maxLength = 0, left = 0, right;
        for (right = 1; right < chars.length; right++) {
            int cur = left;
            while (cur < right) {
                if (chars[cur++] == chars[right]) {
                    maxLength = Math.max(maxLength, right - left);
                    left++;
                    right--;
                    break;
                }
            }
        }
        return "".equals(s) ? 0 : Math.max(maxLength, right - left);
    }

}
