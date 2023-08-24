package cn.tiakon.java.leetcode.string;

import org.junit.Assert;
import org.junit.Test;

/**
 * 389. 找不同
 * https://leetcode.cn/problems/find-the-difference
 * <p>
 * 136. 只出现一次的数字
 * https://leetcode.cn/problems/single-number/
 * <p>
 *
 * @author tiankai.me@gmail.com on 2022/11/10 上午10:39.
 */
public class LC136LC389FindTheDifference {
    /**
     * 利用字符的ASCII十进制值求累加和作差即可。
     *
     * @author tiankai.me@gmail.com on 2022/11/10 上午10:48.
     */
    public char findTheDifference(String s, String t) {
        int ans = 97;
        for (char c : t.toCharArray()) ans += c;
        for (char c : s.toCharArray()) ans -= c;
        return (char) (ans - 97);
    }

    // 利用异或运算,两个相同字符ASCII码的十进制数异或运算后等于0
    public char findTheDifferenceV2(String s, String t) {
        int ret = 0;
        for (int i = 0; i < s.length(); ++i) ret ^= s.charAt(i);
        for (int i = 0; i < t.length(); ++i) ret ^= t.charAt(i);
        return (char) ret;
    }

    // 利用异或运算,两个相同的数异或运算后等于0
    public int singleNumber(int[] nums) {
        int ans = 0;
        for (int num : nums) ans ^= num;
        return ans;
    }

    @Test
    public void findTheDifferenceTest() {
        LC136LC389FindTheDifference findTheDifference = new LC136LC389FindTheDifference();
        char ans = findTheDifference.findTheDifference("abc", "abcd");
        Assert.assertEquals('d', ans);
    }

    @Test
    public void singleNumberTest() {
        LC136LC389FindTheDifference findTheDifference = new LC136LC389FindTheDifference();
        int[] ints = new int[]{2, 2, 1};
        int ans = findTheDifference.singleNumber(ints);
        Assert.assertEquals(1, ans);

        ints = new int[]{4, 1, 2, 2, 1};
        ans = findTheDifference.singleNumber(ints);
        Assert.assertEquals(4, ans);

        ints = new int[]{2, 3, 5, 2, 1, 3, 5};
        ans = findTheDifference.singleNumber(ints);
        Assert.assertEquals(1, ans);
    }

}
