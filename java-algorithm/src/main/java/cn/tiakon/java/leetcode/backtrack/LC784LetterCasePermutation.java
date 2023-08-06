package cn.tiakon.java.leetcode.backtrack;

import java.util.*;

/**
 * 784. 字母大小写全排列
 * https://leetcode.cn/problems/letter-case-permutation/
 *
 * @author tiankai.me@gmail.com on 2022/8/24 10:56.
 */
public class LC784LetterCasePermutation {
    /**
     * 回溯算法-线性回溯
     * 1. 所有的回溯问题都可以抽象为树状结构。
     * 2. 根据树状结构编写代码逻辑，这次重点在如何对字母生成小写或大写的路径。
     * 3. 该题的访问顺序是线性访问，而非循环访问，所以不需要循环体，而是用递增。
     * <p>
     * 执行用时： 10 ms , 在所有 Java 提交中击败了 8.73% 的用户
     * 内存消耗： 42 MB , 在所有 Java 提交中击败了 61.52% 的用户
     *
     * @author tiankai.me@gmail.com on 2022/8/24 14:22.
     */
    public List<String> letterCasePermutation(String s) {
        if (s == null || s.length() > 12) {
            return Collections.emptyList();
        }
        final List<String> ans = new ArrayList<>();
        final Deque<Character> path = new ArrayDeque<>(s.length());
        backtrack(s, path, ans, 0);
        return ans;
    }

    public void backtrack(String s, Deque<Character> path, List<String> ans, int start) {
        if (path.size() == s.length()) {
            final Character[] characters = path.toArray(new Character[0]);
            StringBuilder builder = new StringBuilder();
            for (Character character : characters) {
                builder.append(character);
            }
            ans.add(builder.toString());
            return;
        }
        path.addLast(s.charAt(start));
        backtrack(s, path, ans, start + 1);
        if (Character.isLetter(s.charAt(start))) {
            path.removeLast();
            if (Character.isLowerCase(s.charAt(start))) path.addLast(Character.toUpperCase(s.charAt(start)));
            else path.addLast(Character.toLowerCase(s.charAt(start)));
            backtrack(s, path, ans, start + 1);
        }
        path.removeLast();
    }

    /**
     * 回溯算法
     * 1. 没有使用新的数据结构来收集路径，而是原地替换来的字母
     * 2. 字符异或 1<<5 后，可以实现小写转大写，大写转小写。
     * <p>
     * 执行用时： 1 ms , 在所有 Java 提交中击败了 99.96% 的用户
     * 内存消耗： 42.2 MB , 在所有 Java 提交中击败了 42.09% 的用户
     *
     * @author tiankai.me@gmail.com on 2022/8/24 14:38.
     */
    public List<String> letterCasePermutationV2(String s) {
        List<String> res = new ArrayList<>();
        char[] charArray = s.toCharArray();
        dfs(charArray, 0, res);
        return res;
    }

    private void dfs(char[] charArray, int index, List<String> res) {
        if (index == charArray.length) {
            res.add(new String(charArray));
            return;
        }
        dfs(charArray, index + 1, res);
        if (Character.isLetter(charArray[index])) {
            charArray[index] ^= 1 << 5;
            dfs(charArray, index + 1, res);
        }
    }

}
