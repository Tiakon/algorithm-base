package cn.tiakon.java.leetcode.string;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * 953. 验证外星语词典
 * https://leetcode.cn/problems/verifying-an-alien-dictionary/
 * 剑指 Offer II 034. 外星语言是否排序
 * https://leetcode.cn/problems/lwyVBB/
 *
 * @author tiankai.me@gmail.com on 2022/11/15 下午10:43.
 */
public class LC953VerifyingAlienDictionary {
    public boolean isAlienSortedMy(String[] words, String order) {
        Map<Character, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < order.length(); i++) {
            hashMap.put(order.charAt(i), i);
        }
        for (int i = 1; i < words.length; i++) {
            String preWord = words[i - 1];
            String word = words[i];
            int j = 0, preLen = preWord.length(), curLen = word.length();
            while (j < preLen || j < curLen) {
                char preChar = j < preLen ? preWord.charAt(j) : ' ';
                char curChar = j < curLen ? word.charAt(j) : ' ';
                if (preChar != curChar) {
                    Integer preIndex = hashMap.getOrDefault(preChar, -1);
                    Integer curIndex = hashMap.getOrDefault(curChar, -1);
                    if (preIndex > curIndex) return false;
                    if (preIndex < curIndex) break;
                }
                ++j;
            }
        }
        return true;
    }

    public boolean isAlienSorted(String[] words, String order) {
        int[] ints = new int[26];
        for (int i = 0; i < order.length(); i++) ints[order.charAt(i) - 'a'] = i;
        for (int i = 1; i < words.length; i++) {
            String preWord = words[i - 1];
            String word = words[i];
            int j = 0, preLen = preWord.length(), curLen = word.length();
            boolean isRight = false;
            while (j < preLen && j < curLen) {
                char preChar = preWord.charAt(j);
                char curChar = word.charAt(j);
                if (preChar != curChar) {
                    int preIndex = ints[preChar - 'a'];
                    int curIndex = ints[curChar - 'a'];
                    if (preIndex > curIndex) return false;
                    if (preIndex < curIndex && (j == preLen - 1 || j == curLen - 1)) isRight = true;
                    if (preIndex < curIndex) break;
                }
                ++j;
            }
            if (!isRight && preLen > curLen) return false;
        }
        return true;
    }

    public boolean isAlienSortedV2(String[] words, String order) {
        int[] index = new int[26];
        for (int i = 0; i < order.length(); ++i) {
            index[order.charAt(i) - 'a'] = i;
        }
        for (int i = 1; i < words.length; i++) {
            boolean valid = false;
            for (int j = 0; j < words[i - 1].length() && j < words[i].length(); j++) {
                int prev = index[words[i - 1].charAt(j) - 'a'];
                int curr = index[words[i].charAt(j) - 'a'];
                if (prev < curr) {
                    valid = true;
                    break;
                } else if (prev > curr) {
                    return false;
                }
            }
            if (!valid) {
                /* 比较两个字符串的长度 */
                if (words[i - 1].length() > words[i].length()) {
                    return false;
                }
            }
        }
        return true;
    }

    @Test
    public void isAlienSortedTest() {
        LC953VerifyingAlienDictionary verifyingAlienDictionary = new LC953VerifyingAlienDictionary();
        String[] words = new String[]{"hello", "leetcode"};
        String order = "hlabcdefgijkmnopqrstuvwxyz";
        Assert.assertTrue(verifyingAlienDictionary.isAlienSorted(words, order));

        words = new String[]{"word", "world", "row"};
        order = "worldabcefghijkmnpqstuvxyz";
        Assert.assertFalse(verifyingAlienDictionary.isAlienSorted(words, order));

        words = new String[]{"apple", "app"};
        order = "abcdefghijklmnopqrstuvwxyz";
        Assert.assertFalse(verifyingAlienDictionary.isAlienSorted(words, order));

        words = new String[]{"fxasxpc", "dfbdrifhp", "nwzgs", "cmwqriv", "ebulyfyve", "miracx", "sxckdwzv", "dtijzluhts", "wwbmnge", "qmjwymmyox"};
        order = "zkgwaverfimqxbnctdplsjyohu";
        Assert.assertFalse(verifyingAlienDictionary.isAlienSorted(words, order));

        words = new String[]{"apap", "app"};
        order = "abcdefghijklmnopqrstuvwxyz";
        Assert.assertTrue(verifyingAlienDictionary.isAlienSorted(words, order));
    }
}
