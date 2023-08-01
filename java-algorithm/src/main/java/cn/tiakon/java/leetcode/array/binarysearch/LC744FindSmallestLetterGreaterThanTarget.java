package cn.tiakon.java.leetcode.array.binarysearch;

import org.junit.Assert;
import org.junit.Test;

/**
 * 744. 寻找比目标字母大的最小字母
 * https://leetcode.cn/problems/find-smallest-letter-greater-than-target/
 *
 * @author tiankai.me@gmail.com on 2022/12/6 下午4:43.
 */
public class LC744FindSmallestLetterGreaterThanTarget {
    // 二分法
    public char nextGreatestLetter(char[] letters, char target) {
        if (target >= letters[letters.length - 1]) return letters[0];
        int left = 0, right = letters.length - 1;
        while (left <= right) {
            int middle = left + ((right - left) >> 1);
            if (target < letters[middle]) right = middle - 1;
            else left = middle + 1;
        }
        return letters[left];
    }

    // 线性查找
    public char nextGreatestLetterV2(char[] letters, char target) {
        char nextGreater = letters[0];
        for (char letter : letters) {
            if (letter > target) {
                nextGreater = letter;
                break;
            }
        }
        return nextGreater;
    }

    @Test
    public void nextGreatestLetterTest() {
        LC744FindSmallestLetterGreaterThanTarget letterGreaterThanTarget = new LC744FindSmallestLetterGreaterThanTarget();
        char[] letters = new char[]{'c', 'f', 'j'};
        char ans = letterGreaterThanTarget.nextGreatestLetter(letters, 'z');
        Assert.assertEquals('c', ans);

        ans = letterGreaterThanTarget.nextGreatestLetter(letters, 'a');
        Assert.assertEquals('c', ans);

        ans = letterGreaterThanTarget.nextGreatestLetter(letters, 'c');
        Assert.assertEquals('f', ans);

        ans = letterGreaterThanTarget.nextGreatestLetter(letters, 'd');
        Assert.assertEquals('f', ans);

        ans = letterGreaterThanTarget.nextGreatestLetter(letters, 'g');
        Assert.assertEquals('j', ans);

        ans = letterGreaterThanTarget.nextGreatestLetter(letters, 'j');
        Assert.assertEquals('c', ans);
    }

}
