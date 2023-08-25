package cn.tiakon.java.leetcode.string;

import org.junit.Assert;
import org.junit.Test;

import java.time.Instant;

/**
 * 5. 最长回文子串
 * https://leetcode.cn/problems/longest-palindromic-substring/
 *
 * @author tiankai.me@gmail.com on 2022/11/1 下午2:50.
 */
public class LC5LongestPalindromicSubstring {

    /**
     * @author tiankai.me@gmail.com on 2022/11/1 下午6:28.
     */
    public String longestPalindrome(String s) {
        if (s.length() <= 1) return s;
        int[] ans = new int[3];// 长度,左下标,右下标
        for (int i = 0; i < s.length(); i++) {
            for (int j = s.length(); j > i; j--) {
                String s1 = s.substring(i, j);
                if (isPalindrome(s1) && s1.length() > ans[0]) {
                    ans[0] = s1.length();
                    ans[1] = i;
                    ans[2] = j;
                }
                if (ans[0] > j - i) break;
            }
        }
        return s.substring(ans[1], ans[2]);
    }

    public Boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left++) != s.charAt(right--)) return false;
        }
        return true;
    }

    /**
     * 中心扩展法
     * <p>
     * 执行用时： 2 ms , 在所有 Java 提交中击败了 99.86% 的用户
     * 内存消耗： 41.2 MB , 在所有 Java 提交中击败了 83.56% 的用户
     * 通过测试用例： 140 / 140
     *
     * @author tiankai.me@gmail.com on 2022/11/1 下午6:15.
     */
    public String longestPalindromeV2(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
//         保存起始位置，测试了用数组似乎能比全局变量稍快一点
        int[] range = new int[2];
        char[] str = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
//             把回文看成中间的部分全是同一字符，左右部分相对称
//             找到下一个与当前字符不同的字符
            i = findLongest(str, i, range);
        }
        return s.substring(range[0], range[1] + 1);
    }

    public static int findLongest(char[] str, int low, int[] range) {
//         查找中间部分
        int high = low;
        while (high < str.length - 1 && str[high + 1] == str[low]) {
            high++;
        }
//         定位中间部分的最后一个字符
        int ans = high;
//         从中间向左右扩散
        while (low > 0 && high < str.length - 1 && str[low - 1] == str[high + 1]) {
            low--;
            high++;
        }
//         记录最大长度
        if (high - low > range[1] - range[0]) {
            range[0] = low;
            range[1] = high;
        }
        return ans;
    }


    @Test
    public void isPalindromeTest() {
        LC5LongestPalindromicSubstring longestPalindromicSubstring = new LC5LongestPalindromicSubstring();
        String s = "babadabab";
        Boolean ans = longestPalindromicSubstring.isPalindrome(s);
        Assert.assertTrue(ans);

        s = "babad";
        ans = longestPalindromicSubstring.isPalindrome(s);
        Assert.assertFalse(ans);

        s = "abdba";
        ans = longestPalindromicSubstring.isPalindrome(s);
        Assert.assertTrue(ans);

        s = "baab";
        ans = longestPalindromicSubstring.isPalindrome(s);
        Assert.assertTrue(ans);

    }

    @Test
    public void longestPalindromeTest() {

        LC5LongestPalindromicSubstring longestPalindromicSubstring = new LC5LongestPalindromicSubstring();
        String s = "babadabab";
        long epochSecond = Instant.now().toEpochMilli();
        String ans = longestPalindromicSubstring.longestPalindrome(s);
        Assert.assertEquals("babadabab", ans);
        long end = Instant.now().toEpochMilli() - epochSecond;
        System.out.println(end);
        s = "baabdbaba";
        ans = longestPalindromicSubstring.longestPalindrome(s);
        Assert.assertEquals("abdba", ans);

        s = "babadbaab";
        ans = longestPalindromicSubstring.longestPalindrome(s);
        Assert.assertEquals("baab", ans);

        s = "ab";
        ans = longestPalindromicSubstring.longestPalindrome(s);
        Assert.assertEquals("a", ans);

        epochSecond = Instant.now().toEpochMilli();
        s = "okfzopfdxngrcukpqwmgyfbwzkqegoglsqszdihswhcnwaajuiagxscrwoicsdvyowbowaddignjgsjrhhhookusgnykutrkpogmvruwdkpjucslsoluhnooysjichvobriksbanovvynfwtooygdtflnchtgcycjiziytrhsomevozdxxbiwiuxrhxtyefogphgavlhbvdjpcosexyrmphcyuhqymnzkngqyitzekwimveydjrxkhvhckqcjetpmhxzisdlkhmotwcgejllzdmfwrbpzuxcawgamamkziewwqnxpvyhvmzulivwrngrsnarsmeunbpbnnvvlxllvniskaerpawflwfdozfsmovvjtymsgnvmfepidyffwjxpvpgwceukgfplqcyccejatqqmefquirgztnyawkruasuitnjldxgmmqzzvwltetjyenbicgabtnkpfdcanggcensptcgyyygnkbvcgmvzichisofakajqtsfogqewegawcjtylxavxdxdznzyxyvvupnwfxogyjmbayeminbzthyidymnmuoevrgfbdpodbdrznmosuispnmimrglgrkdrdsjmyacfmuntvgpjaginmyknawgonibhifpyhqoswyefidrtsqgwqviseayzxqwgelgtnvxlrdhpnuhxhianiqjiyygagwwmyklszbyhcykhejijhnfmrsagsbfthmzmzractm";
        ans = longestPalindromicSubstring.longestPalindrome(s);
        Assert.assertEquals("nbpbn", ans);
        end = Instant.now().toEpochMilli() - epochSecond;
        System.out.println(end);

        epochSecond = Instant.now().toEpochMilli();
        s = "jcwwnkwiajicysmdueefqjnrokunucidhgkswbgjkkrujkxkxeanrpjvpliomxztalhmvcldnqmkslkprhgtwlnsnygbzdvtdbsdzsdjggzgmhogknpfhtgjmclrkgfqdbiagwrqqcnagosnqrnpapxfrtrhzlyhszdtgkqggmewqmwugrbufiwfvtjhczqgcwpcyjioeacggiwyinpkyxrpxhglrtojgjmmswxnvirfsrbhmpqgjyyagjqfwkqkjkumywvgfutmiwihwnnhbfxcijaoiyxbdnrckexqfhsmmxflaneccyaoqoxfbaylcvvpfafsikebzcdufvhluldguwsmrtjaljpcjestranfrvgvytozxpcvnwquhnsxlmzkehwopgxvifajmrlwqiqylgxibnypxwpkggxevyfoxywfsfpjbzfxxysgxgwxrzkwdqlkrpajlltzqfqshdokibakkhydizsgwbygqulljqmtxkwepitsukwjlrrmsjptwabtlqytprkkuxtqdmptctkfabxsohrfrqvrbjfbppfkpthosveoppiywkkuoasefviegormlqkqlbhnhblkmglxcbszblfipsyumcrjrkrnzplkveznbtdbtlcptgswhiqsjugqrvujkzuwvoxbjremyxqqzxkgerhgtidsefyemtmstsznvgohexdgetqbhrxaomzsamapxhjibfvtbquhowyrwyxthpwvmfyyqsyibemnfbwkddtyoijzwfxhossylygxmnznpegtgvlrsreepkrcdgbujkghrgtsxwlvxrgrqxnvgqkppbkrxjupjfjcsfzepdemaulfetn";
        ans = longestPalindromicSubstring.longestPalindrome(s);
        Assert.assertEquals("lbhnhbl", ans);
        end = Instant.now().toEpochMilli() - epochSecond;
        System.out.println(end);

    }
}
