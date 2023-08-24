package cn.tiakon.java.leetcode.string;

/**
 * 14. 最长公共前缀
 * https://leetcode.cn/problems/longest-common-prefix/
 *
 * @author tiankai.me@gmail.com on 2022/10/27 下午6:54.
 */
public class LC14LongestCommonPrefix {
    /**
     * 暴力解法
     *
     * @author tiankai.me@gmail.com on 2022/10/27 下午10:17.
     */
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 1) return strs[0];
        String ans = "";
        for (int i = 0; i < strs.length; i++) {
            for (int j = i + 1; j < strs.length; j++) {
                String commonPrefix = getCommonPrefix(strs[i], strs[j]);
                if ("".equals(commonPrefix)) return "";
                if (("".equals(ans) && commonPrefix.length() > 0)
                        || commonPrefix.length() < ans.length()) ans = commonPrefix;
            }
        }
        return ans;
    }

    public String getCommonPrefix(String preStr, String nextStr) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < Math.min(preStr.length(), nextStr.length()); i++) {
            char c = preStr.charAt(i);
            if (c == nextStr.charAt(i)) builder.append(c);
            else break;
        }
        return builder.toString();
    }

    /**
     * 1. 公共前缀比所有字符串都短，先随便选一个.
     * 2. 公共前缀不匹配就让它变短
     *
     * @author tiankai.me@gmail.com on 2022/10/27 下午10:13.
     */
    public String longestCommonPrefixV2(String[] strs) {
        if (strs.length == 0) return "";
        //公共前缀比所有字符串都短，随便选一个先
        String s = strs[0];
        for (String string : strs) {
            while (!string.startsWith(s)) {
                if (s.length() == 0) return "";
                //公共前缀不匹配就让它变短！
                s = s.substring(0, s.length() - 1);
            }
        }
        return s;
    }

    /**
     *
     * @author tiankai.me@gmail.com on 2022/10/27 下午10:24.
     */
    public String longestCommonPrefixV3(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        String prefix = strs[0];
        int count = strs.length;
        for (int i = 1; i < count; i++) {
            prefix = longestCommonPrefix(prefix, strs[i]);
            if (prefix.length() == 0) break;
        }
        return prefix;
    }

    //通过记录公共前缀的最右边的位置下标,截取出公共前缀.
    public String longestCommonPrefix(String str1, String str2) {
        int length = Math.min(str1.length(), str2.length());
        int index = 0;
        while (index < length && str1.charAt(index) == str2.charAt(index)) {
            index++;
        }
        return str1.substring(0, index);
    }


}
