package cn.tiakon.java.leetcode.string;

/**
 * 28. 找出字符串中第一个匹配项的下标
 * https://leetcode.cn/problems/find-the-index-of-the-first-occurrence-in-a-string/
 *
 * @author tiankai.me@gmail.com on 2023/7/31 下午9:07.
 */
public class LC28 {
    public int strStr(String haystack, String needle) {
        if (haystack.length()<needle.length()) return -1;
        char[] c1 = haystack.toCharArray(),c2 = needle.toCharArray();
        int c1L = c1.length,c2L = c2.length;
        int l, ll=0, r = 0;
        for (l = 0; l < c1L && r < c2L; l++) {
            for (ll = l; ll < c1L && r < c2L; ll++) {
                if (c1[ll] == c2[r]) r++;
                else {
                    r = 0;
                    break;
                }
            }
        }
        l=Math.max(l,ll);
        return r == c2L ? l - r : -1;
    }

    /**
     *
     * 整体复杂度为:O((n−m)∗m)。
     * 空间复杂度：O(1)。
     *
     * @author tiankai.me@gmail.com on 2023/7/31 下午10:44.
     */
    public int strStrV2(String ss, String pp) {
        int n = ss.length(), m = pp.length();
        char[] s = ss.toCharArray(), p = pp.toCharArray();
        // 枚举原串的「发起点」
        for (int i = 0; i <= n - m; i++) {
            // 从原串的「发起点」和匹配串的「首位」开始，尝试匹配
            int a = i, b = 0;
            while (b < m && s[a] == p[b]) {
                a++;
                b++;
            }
            // 如果能够完全匹配，返回原串的「发起点」下标
            if (b == m) return i;
        }
        return -1;
    }

}
