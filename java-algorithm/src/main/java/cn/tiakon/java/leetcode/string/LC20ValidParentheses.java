package cn.tiakon.java.leetcode.string;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 20. 有效的括号
 * https://leetcode.cn/problems/valid-parentheses/
 *
 * @author tiankai.me@gmail.com on 2022/10/25 下午1:55.
 */
public class LC20ValidParentheses {
    /**
     * 可以利用符号在ascii码表中十进制的差值来确定括号是否匹配.
     * 40:(
     * 41:)
     * 91:[
     * 93:]
     * 123:{
     * 125:}
     * @author tiankai.me@gmail.com on 2022/10/25 下午3:20.
     */
    public boolean isValid(String s) {
        if (s == null || s.length() == 0 || s.length() % 2 == 1) return false;
        char[] chars = s.toCharArray();
        Deque<Character> deque = new ArrayDeque<>();
        for (char c : chars) {
            if (!deque.isEmpty() && (c - deque.peek() == 1 || c - deque.peek() == 2)) deque.poll();
            else deque.push(c);
        }
        return deque.isEmpty();
    }

    public boolean isValid(char aChar, char bChar) {
        switch (aChar) {
            case '(':
                return bChar == ')';
            case '{':
                return bChar == '}';
            case '[':
                return bChar == ']';
            default:
                return false;
        }
    }

}
