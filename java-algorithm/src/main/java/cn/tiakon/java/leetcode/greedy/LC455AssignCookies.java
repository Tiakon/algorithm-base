package cn.tiakon.java.leetcode.greedy;

import java.util.Arrays;

/**
 * 455. 分发饼干
 * https://leetcode.cn/problems/assign-cookies/
 *
 * @author tiankai.me@gmail.com on 2022/11/21 下午4:44.
 */
public class LC455AssignCookies {

    /**
     * 1.先排序
     * 2.先满足胃口大的孩子,
     *
     * @author tiankai.me@gmail.com on 2022/11/22 上午11:33.
     */
    public int findContentChildren(int[] g, int[] s) {
        int m = g.length - 1, n = s.length - 1;
        int res = 0;
        Arrays.sort(g);
        Arrays.sort(s);
        while (m >= 0 && n >= 0) {
            if (g[m] <= s[n]) {
                res++;
                m--;
                n--;
            } else if (g[m] > s[n]) {
                m--;
            }
        }
        return res;
    }


}
