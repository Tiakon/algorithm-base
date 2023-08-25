package cn.tiakon.java.leetcode.string;

import java.util.Arrays;

/**
 * 567. 字符串的排列
 * https://leetcode.cn/problems/permutation-in-string/
 * https://leetcode.cn/problems/permutation-in-string/solution/zi-fu-chuan-de-pai-lie-by-leetcode-solut-7k7u/
 * 当两个字符串每个字符的个数均相等时，一个字符串才是另一个字符串的排列。
 *
 * @author tiankai.me@gmail.com on 2022/8/17 21:08.
 */
public class LC567PermutationInString {

    /**
     * 滑动窗口
     * 1. 利用字符的ascii码之和来确认字符串排列
     * 2. 防止abc==bbb 这种情况最后再确认具体字符是否完全一致。
     * 执行用时： 22 ms , 在所有 Java 提交中击败了 39.00% 的用户
     * 内存消耗： 41.4 MB , 在所有 Java 提交中击败了 45.25% 的用户
     *
     * @author tiankai.me@gmail.com on 2022/8/17 21:44.
     */
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false;
        char[] s1Chars = s1.toCharArray();
        char[] s2Chars = s2.toCharArray();
        int s1AsciiSum = 0;
        for (char s1Char : s1Chars) {
            s1AsciiSum += s1Char;
        }
        for (int i = 0; i <= s2Chars.length - s1Chars.length; i++) {
            int s2AsciiNum = s1AsciiSum;
            for (int j = i; j < i + s1Chars.length; j++) {
                s2AsciiNum -= s2Chars[j];
            }
            if (s2AsciiNum == 0) {
                boolean ans = true;
                final String substring = s2.substring(i, i + s1Chars.length);
                for (char s1Char : s1Chars) {
                    if (!substring.contains(String.valueOf(s1Char))) {
                        ans = false;
                        break;
                    }
                }
                if (ans) return true;
            }
        }
        return false;
    }

    /**
     * 使用String 字符操作API
     * 执行用时： 367 ms , 在所有 Java 提交中击败了 6.45% 的用户
     * 内存消耗： 42 MB , 在所有 Java 提交中击败了 6.61% 的用户
     *
     * @author tiankai.me@gmail.com on 2022/8/18 22:18.
     */
    public boolean checkInclusionV2(String s1, String s2) {
        if (s1.length() > s2.length()) return false;
        int s1AsciiSum = s1.codePoints().sum();
        String s1Sorted = Arrays.toString(s1.codePoints().sorted().toArray());
        for (int i = 0; i <= s2.length() - s1.length(); i++) {
            String substring = s2.substring(i, i + s1.length());
            if (s1AsciiSum == substring.codePoints().sum() && s1Sorted.equals(Arrays.toString(substring.codePoints().sorted().toArray()))) {
                return true;
            }
        }
        return false;
    }


    /**
     * 复杂度分析
     * <p>
     * 时间复杂度：O(n+m+∣Σ∣)，其中 n 是字符串 s1 的长度，m 是字符串 s2 的长度，Σ 是字符集，这道题中的字符集是小写字母，∣Σ∣=26。
     * 空间复杂度：O(∣Σ∣)。
     *
     * @author tiankai.me@gmail.com on 2022/8/19 0:06.
     */
    public boolean checkInclusionV3(String s1, String s2) {
        int n = s1.length(), m = s2.length();
        if (n > m) return false;
        int[] cnt1 = new int[26];
        int[] cnt2 = new int[26];
        for (int i = 0; i < n; ++i) {
            ++cnt1[s1.charAt(i) - 'a'];
            ++cnt2[s2.charAt(i) - 'a'];
        }
        if (Arrays.equals(cnt1, cnt2)) return true;
        for (int i = n; i < m; ++i) {
            ++cnt2[s2.charAt(i) - 'a'];     // 窗口右边界
            --cnt2[s2.charAt(i - n) - 'a']; // 窗口左边界
            if (Arrays.equals(cnt1, cnt2)) return true;
        }
        return false;
    }

    /**
     * 双指针
     * 通过在数组中统计字符个数，来实现滑动窗口的效果。
     * 子串的字符用--计算，母串的字符用++计算，
     * 当出现重复字符时，让左指针与右指针同时右移。
     * 复杂度分析
     * <p>
     * 时间复杂度：O(n+m+∣Σ∣)
     * 创建 cnt 需要 O(∣Σ∣) 的时间。
     * 遍历 s1 需要 O(n) 的时间。
     * 双指针遍历 s2 时，由于 left 和 right 都只会向右移动，故这一部分需要 O(m) 的时间。
     * <p>
     * 空间复杂度：O(∣Σ∣)。
     * <p>
     * 执行用时： 3 ms , 在所有 Java 提交中击败了 96.67% 的用户
     * 内存消耗： 41.2 MB , 在所有 Java 提交中击败了 77.32% 的用户
     *
     * @author tiankai.me@gmail.com on 2022/8/18 22:18.
     */
    public boolean checkInclusionV4(String s1, String s2) {
        int n = s1.length(), m = s2.length(), left = 0;
        if (n > m) return false;
        int[] cnt = new int[26];
        for (int i = 0; i < n; ++i) {
            --cnt[s1.charAt(i) - 'a'];
        }
        for (int right = 0; right < m; ++right) {
            int x = s2.charAt(right) - 'a';
            ++cnt[x];
            while (cnt[x] > 0) {
                --cnt[s2.charAt(left) - 'a'];
                ++left;
            }
            // 当 [left,right] 的长度恰好为 n 时，就意味着 cnt 的元素值之和为 0
            if (right - left + 1 == n) return true;
        }
        return false;
    }


}
