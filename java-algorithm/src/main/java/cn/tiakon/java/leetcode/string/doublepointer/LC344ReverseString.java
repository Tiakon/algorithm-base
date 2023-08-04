package cn.tiakon.java.leetcode.string.doublepointer;

/**
 * 344. 反转字符串
 * https://leetcode.cn/problems/reverse-string/
 *
 * @author tiankai.me@gmail.com on 2022/8/11 22:56.
 */
public class LC344ReverseString {

    /**
     * 时间复杂度：O(N)
     * 空间复杂度：O(1)
     *
     * @author tiankai.me@gmail.com on 2022/8/11 23:21.
     */
    public void reverseString(char[] s) {
        int l = 0, r = s.length - 1;
        while (l < r) {
            swap(s, l, r);
            l++;
            r--;
        }
    }

    private void swap(char[] chars, int i1, int i2) {
        char temp = chars[i1];
        chars[i1] = chars[i2];
        chars[i2] = temp;
    }

    /**
     * 时间复杂度：O(N)O(N)，其中 NN 为字符数组的长度。一共执行了 N/2N/2 次的交换。
     * 空间复杂度：O(1)O(1)。只使用了常数空间来存放若干变量。
     *
     * @author tiankai.me@gmail.com on 2022/8/11 23:21.
     */
    public void reverseStringV2(char[] s) {
        int n = s.length;
        for (int left = 0, right = n - 1; left < right; ++left, --right) {
            char tmp = s[left];
            s[left] = s[right];
            s[right] = tmp;
        }
    }

}
