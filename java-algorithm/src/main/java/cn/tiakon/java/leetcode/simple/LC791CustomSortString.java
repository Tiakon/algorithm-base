package cn.tiakon.java.leetcode.simple;

import org.junit.Test;

// https://leetcode-cn.com/problems/custom-sort-string/
public class LC791CustomSortString {

    public static void main(String[] args) {
        String S = "cba";
        String T = "abcd";
        System.out.println(customSortString(S, T));
    }

    //一种巧妙的实现方法是统计 T 中每个字符出现的次数，把结果存储在数组 count 中，count[char] 表示字符 char 出现的次数。
    //然后把在 S 中出现的字符按照在 S 中的相对顺序排列，剩余字符添加到当前字符串的后面，最终排好序的字符串顺序为 S + (未在 S 中出现的字符)。
    public static String customSortString(String S, String T) {
        // 下标标识26个英文字母，数组的值代表字母出现的次数
        int[] count = new int[26];
        for (char c : T.toCharArray()) {
            count[c - 'a']++;
        }

        // 使用 StringBuilder 拼接最终结果
        StringBuilder ans = new StringBuilder();

        // 按照排序顺序追加字符
        for (char c : S.toCharArray()) {
            for (int i = 0; i < count[c - 'a']; ++i)
                ans.append(c);
            count[c - 'a'] = 0;
        }

        // 追加剩余字符到结果中
        for (char c = 'a'; c <= 'z'; ++c)
            for (int i = 0; i < count[c - 'a']; ++i)
                ans.append(c);

        return ans.toString();
    }

    // char 类型可以转换成 int 类型，代表 ASCII码（ASCII 表中字母对应的数值）。
    @Test
    public void ASCII01Test() {
        System.out.println("H" + "A"); //HA
        //  ASCII 表H=72 和a=97
        System.out.println('H' + 'a'); //169
    }

}
