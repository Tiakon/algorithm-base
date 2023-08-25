package cn.tiakon.java.leetcode.string;

/**
 * 9. 回文数
 * https://leetcode.cn/problems/palindrome-number/
 *
 * @author tiankai.me@gmail.com on 2022/10/24 上午10:55.
 */
public class LC9PalindromeNumber {

    /**
     * 临界条件:
     * 1. 负数不可能是回文数.
     * 2. 大于等于10且个位为0的数,不可能是回文数.
     * <p>
     * 通过反转整数的后一半与前一半是否相同,来判断该整数是否是回文数.
     *
     * 执行用时： 4 ms , 在所有 Java 提交中击败了 100.00% 的用户
     * 内存消耗： 40.7 MB , 在所有 Java 提交中击败了 71.39% 的用户
     * 通过测试用例： 11510 / 11510
     *
     * 复杂度分析:
     * 时间复杂度：O(logn)，对于每次迭代，我们会将输入除以 10，因此时间复杂度为 O(logn)。
     * 空间复杂度：O(1)。我们只需要常数空间存放若干变量。
     *
     * @author tiankai.me@gmail.com on 2022/10/24 下午2:30.
     */
    public static boolean isPalindrome(int x) {
        if (x < 0 || (x >= 10 && x % 10 == 0)) return false;
        int reverseNum = 0;
        while (x > reverseNum) {
            int last = x % 10;
            reverseNum = reverseNum * 10 + last;
            x = x / 10;
        }
        return (x == reverseNum) || (reverseNum / 10 == x);
    }

    public static boolean isPalindromeWithString(int x) {
        if (x < 0 || (x >= 10 && x % 10 == 0)) return false;
        char[] chars = String.valueOf(x).toCharArray();
        for (int i = 0; i < chars.length / 2; i++) {
            if (chars[i] != chars[chars.length - 1 - i]) return false;
        }
        return true;
    }

    public static boolean isPalindromeV2(int x) {
        if (x < 0 || (x >= 10 && x % 10 == 0)) return false;
        int size = getLengthWithNum(x);
        int[] ints = getArrayWithNum(x, size);
        for (int i = 0; i < size / 2; i++) {
            if (ints[i] != ints[size - 1 - i]) return false;
        }
        return true;
    }

    /**
     * 统计数字的长度
     * @author tiankai.me@gmail.com on 2022/10/24 下午3:27.
     */
    public static int getLengthWithNum(int x) {
        int size = 1;
        while (x >= 10) {
            size++;
            x = x / 10;
        }
        return size;
    }

    /**
     * 将数字转成数组
     * @author tiankai.me@gmail.com on 2022/10/24 下午3:27.
     */
    public static int[] getArrayWithNum(int x, int size) {
        int[] ints = new int[size];
        for (int i = 0; i < size; i++) {
            int pow01 = (int) Math.pow(10, size - 1 - i);
            ints[i] = x / pow01;
            x = x % pow01;
        }
        return ints;
    }

}
