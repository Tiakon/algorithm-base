package cn.tiakon.java.leetcode.string;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * 1374. 生成每种字符都是奇数个的字符串
 * https://leetcode.cn/problems/generate-a-string-with-characters-that-have-odd-counts/
 *
 * @author tiankai.me@gmail.com on 2022/8/16 19:23.
 */
public class LC1374GenerateStringWithChar {
    final Random random = new Random();

    /**
     * 模拟流程
     * 1.需要将n进行拆解，每次都随机生成一个奇数。
     * 2.同时利用数组与ASCII码来确保字符不重复和随机。
     *
     * @author tiankai.me@gmail.com on 2022/8/16 22:53.
     */
    public String generateTheString(int n) {
        final char[] chars = new char[n];
        final int[] nums = new int[26];
        int i = 0;
        while (n > i) {
            int asciiNum;
            // 生成出现奇数次和不重复的字母
            do { // i -> [1,n]
                i = random.nextInt(n) + 1;
                // asciiNum -> [97,122]
                asciiNum = (random.nextInt(26) + 97);
            } while (i % 2 == 0 || nums[asciiNum % 97] == 1);
            // 表示该字母已占用
            nums[asciiNum % 97] = 1;
            do {
                chars[--n] = (char) asciiNum;
            } while (--i > 0);
        }
        return String.valueOf(chars);
    }

    public boolean checkGenerateTheString(String s) {
        final char[] chars = s.toCharArray();
        Arrays.sort(chars);
        final Map<Character, Integer> hashMap = new HashMap<>();
        for (char aChar : chars) {
            hashMap.put(aChar, (hashMap.getOrDefault(aChar, 0) + 1) % 2);
        }
        return !hashMap.containsValue(0);
    }

}
