package cn.tiakon.java.leetcode.string;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

/**
 * 709. 转换成小写字母
 * https://leetcode.cn/problems/to-lower-case/
 * <p>
 * 1790. 仅执行一次字符串交换能否使两个字符串相等
 * https://leetcode.cn/problems/check-if-one-string-swap-can-make-strings-equal/
 * <p>
 * 1309. 解码字母到整数映射
 * https://leetcode.cn/problems/decrypt-string-from-alphabet-to-integer-mapping/
 * <p>
 * 1704. 判断字符串的两半是否相似
 * https://leetcode.cn/problems/determine-if-string-halves-are-alike/
 *
 * @author tiankai.me@gmail.com on 2022/11/11 下午9:19.
 */
public class LC1790AndLC709AndLC1309AndLC1704 {

    // 利用ASCII码字符十进制值大小写之间的差值.
    public String toLowerCase(String s) {
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] >= 65 && chars[i] <= 90) chars[i] = (char) (chars[i] + 32);
        }
        return new String(chars);
    }

    /**
     * 大写变小写、小写变大写 : 字符 ^= 32;
     * 大写变小写、小写变小写 : 字符 |= 32;
     * 小写变大写、大写变大写 : 字符 &= -33;
     *
     * @author tiankai.me@gmail.com on 2022/11/11 下午9:20.
     */
    public String toLowerCaseV2(String s) {
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] >= 65 && chars[i] <= 90) chars[i] |= 32;
        }
        return new String(chars);
    }


    /**
     * 执行用时： 0 ms , 在所有 Java 提交中击败了 100.00% 的用户
     * 内存消耗： 39.3 MB , 在所有 Java 提交中击败了 84.23% 的用户
     * 通过测试用例： 132 / 132
     * <p>
     * 通过数组来确定每个字符串中字符出现频次是否一致.
     * 对比两个字符串中字符时,超过两次不同即可跳出返回false.
     *
     * @author tiankai.me@gmail.com on 2022/11/11 下午9:47.
     */
    public boolean areAlmostEqual(String s1, String s2) {
        if (s1.equals(s2)) return true;
        int[] ints = new int[26];
        int ans = 0, i = 0;
        while (i < s1.length()) {
            char c1 = s1.charAt(i), c2 = s2.charAt(i++);
            ++ints[c1 - 97];
            --ints[c2 - 97];
            if (c1 != c2) ans += 1;
            if (ans > 2) return false;
        }
        for (int n : ints) if (n != 0) return false;
        return true;
    }

    /**
     * 简单模拟
     * 使用 a 和 b 记录不同的位置下标，初始值为 -1，若「不同位置超过 2 个」或「只有 1 个」直接返回 false，若「不存在不同位置」或「不同位置字符相同」，则返回 true。
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     *
     * @author tiankai.me@gmail.com on 2022/11/11 下午10:10.
     */
    public boolean areAlmostEqualV2(String s1, String s2) {
        int n = s1.length(), a = -1, b = -1;
        for (int i = 0; i < n; i++) {
            if (s1.charAt(i) == s2.charAt(i)) continue;
            if (a == -1) a = i;
            else if (b == -1) b = i;
            else return false;
        }
        if (a == -1) return true;
        if (b == -1) return false;
        return s1.charAt(a) == s2.charAt(b) && s1.charAt(b) == s2.charAt(a);
    }

    /**
     * 解题思路
     * 利用字符中ASCII码表的偏移与固定差求和可以实现将数字转字符的效果。
     * 1~9 之间的映射规则：字符本身+偏移值48，即可得到对应字母字符。
     * 10#~19#之间的映射规则：十位字符本身+个位字符-偏移值26，即可对应字母字符。
     * 20#~26#之间的映射规则：十位字符本身+个位字符-偏移值17，即可对应字母字符。
     * <p>
     * 执行用时： 0 ms , 在所有 Java 提交中击败了 100.00% 的用户
     * 内存消耗： 39.1 MB , 在所有 Java 提交中击败了 96.99% 的用户
     * 通过测试用例： 40 / 40
     *
     * @author tiankai.me@gmail.com on 2022/11/11 下午10:25.
     */
    public String freqAlphabets(String s) {
        char[] chars = s.toCharArray();
        int j = 0;
        for (int i = 0; i < chars.length; i++, j++) {
            char c = chars[i];
            if (c < 51 && i + 2 < chars.length && chars[i + 2] == 35) {
                int ascii = chars[i] + chars[i + 1] + chars[i + 2];
                if (c == 49) ascii -= 26;
                else ascii -= 17;
                chars[j] = (char) ascii;
                i += 2;
            } else chars[j] = (char) (chars[i] + 48);
        }
        return new String(chars).substring(0, j);
    }

    @Test
    public void freqAlphabetsTest() {
        LC1790AndLC709AndLC1309AndLC1704 lc = new LC1790AndLC709AndLC1309AndLC1704();
        String str = "10#11#12";
        String ans = lc.freqAlphabets(str);
        Assert.assertEquals("jkab", ans);

        str = "1326#";
        ans = lc.freqAlphabets(str);
        Assert.assertEquals("acz", ans);
    }


    public boolean halvesAreAlike(String s) {
        // a e i o u A E I O U
        boolean[] lowBoolean = new boolean[26];
        lowBoolean['a' - 97] = true;
        lowBoolean['e' - 97] = true;
        lowBoolean['i' - 97] = true;
        lowBoolean['o' - 97] = true;
        lowBoolean['u' - 97] = true;
        boolean[] upperBoolean = new boolean[26];
        upperBoolean['A' - 65] = true;
        upperBoolean['E' - 65] = true;
        upperBoolean['I' - 65] = true;
        upperBoolean['O' - 65] = true;
        upperBoolean['U' - 65] = true;
        int ans = 0, j = s.length() / 2;
        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            if (i < j) {
                if (c >= 97 && lowBoolean[c - 97]) ++ans;
                else if (c >= 65 && c <= 90 && upperBoolean[c - 65]) ++ans;
            } else {
                if (c >= 97 && lowBoolean[c - 97]) --ans;
                else if (c >= 65 && c <= 90 && upperBoolean[c - 65]) --ans;
            }
        }
        return ans == 0;
    }

    public int distinctAverages(int[] nums) {
        Arrays.sort(nums);
        int i = 0, j = nums.length - 1;
        Set<Double> hashSet = new HashSet<>();
        while (i < j) hashSet.add((nums[i++] + nums[j--]) / 2.0);
        return hashSet.size();
    }

    public int countGoodStringsV2(int low, int high, int zero, int one) {
        int ans = 0;
        char[] ones = new char[one];
        char[] zeros = new char[zero];
        Arrays.fill(ones, '1');
        Arrays.fill(zeros, '0');

        return ans % ((int) Math.pow(10, 9) + 7);
    }

    /**
     * 好字符串深度优先遍历(超时)
     *
     * @author tiankai.me@gmail.com on 2022/11/13 上午10:21.
     */
    public int countGoodStrings(int low, int high, int zero, int one) {
        int ans = 0;
        char[] ones = new char[one];
        char[] zeros = new char[zero];
        Arrays.fill(ones, '1');
        Arrays.fill(zeros, '0');
        Deque<String> path = new ArrayDeque<>();
        ans = dfs(low, high, ans, 0, path, new String(ones), new String(zeros));
        return ans % ((int) Math.pow(10, 9) + 7);
    }

    public int dfs(int low, int high, int ans, int size, Deque<String> path, String ones, String zeros) {
        if (low <= size && size <= high) ans += 1;
        if (high <= size) return ans;
        path.push(zeros);
        ans = dfs(low, high, ans, size + zeros.length(), path, ones, zeros);
        path.poll();
        path.push(ones);
        ans = dfs(low, high, ans, size + ones.length(), path, ones, zeros);
        path.poll();
        return ans;
    }

    @Test
    public void countGoodStringsTest() {
        LC1790AndLC709AndLC1309AndLC1704 lc = new LC1790AndLC709AndLC1309AndLC1704();
        int low = 3, high = 3, zero = 1, one = 1;
        int ans = lc.countGoodStrings(low, high, zero, one);
        Assert.assertEquals(8, ans);

        low = 2;
        high = 3;
        zero = 1;
        one = 2;
        ans = lc.countGoodStrings(low, high, zero, one);
        Assert.assertEquals(5, ans);
    }

    public int subarrayLCM(int[] nums, int k) {
        int ans = 0, l = 0, r = 0;
        while (l <= r && r < nums.length) {
            if (nums[r] == k) {
                ++r;
                ++ans;
            } else if (k % nums[r] == 0) ++r;
            else {
                r += 1;
                l = r;
            }
        }
        return ans;
    }

}
