package cn.tiakon.java.leetcode.string;

import org.junit.Assert;
import org.junit.Test;

public class LC1592RearrangeSpacesBetweenWordsTest {

    @Test
    public void reorderSpacesTest() {
        final LC1592RearrangeSpacesBetweenWords lc1592RearrangeSpacesBetweenWords = new LC1592RearrangeSpacesBetweenWords();
        String text = "  this   is  a sentence ";
        String ans = "this   is   a   sentence";
        String reorderSpaces = lc1592RearrangeSpacesBetweenWords.reorderSpaces(text);
        Assert.assertEquals(ans, reorderSpaces);

        text = " practice   makes   perfect";
        ans = "practice   makes   perfect ";
        reorderSpaces = lc1592RearrangeSpacesBetweenWords.reorderSpaces(text);
        Assert.assertEquals(ans, reorderSpaces);

        text = "hello   world";
        ans = "hello   world";
        reorderSpaces = lc1592RearrangeSpacesBetweenWords.reorderSpaces(text);
        Assert.assertEquals(ans, reorderSpaces);

        text = "  walks  udp package   into  bar a";
        ans = "walks  udp  package  into  bar  a ";
        reorderSpaces = lc1592RearrangeSpacesBetweenWords.reorderSpaces(text);
        Assert.assertEquals(ans, reorderSpaces);

        text = "a";
        ans = "a";
        reorderSpaces = lc1592RearrangeSpacesBetweenWords.reorderSpaces(text);
        Assert.assertEquals(ans, reorderSpaces);

        text = " walks";
        ans = "walks ";
        reorderSpaces = lc1592RearrangeSpacesBetweenWords.reorderSpaces(text);
        Assert.assertEquals(ans, reorderSpaces);
    }

    @Test
    public void reorderSpacesV2Test() {
        final LC1592RearrangeSpacesBetweenWords lc1592RearrangeSpacesBetweenWords = new LC1592RearrangeSpacesBetweenWords();
        String text = "  this   is  a sentence ";
        String ans = "this   is   a   sentence";
        String reorderSpaces = lc1592RearrangeSpacesBetweenWords.reorderSpacesV2(text);
        Assert.assertEquals(ans, reorderSpaces);

        text = " practice   makes   perfect";
        ans = "practice   makes   perfect ";
        reorderSpaces = lc1592RearrangeSpacesBetweenWords.reorderSpacesV2(text);
        Assert.assertEquals(ans, reorderSpaces);

        text = "hello   world";
        ans = "hello   world";
        reorderSpaces = lc1592RearrangeSpacesBetweenWords.reorderSpacesV2(text);
        Assert.assertEquals(ans, reorderSpaces);

        text = "  walks  udp package   into  bar a";
        ans = "walks  udp  package  into  bar  a ";
        reorderSpaces = lc1592RearrangeSpacesBetweenWords.reorderSpacesV2(text);
        Assert.assertEquals(ans, reorderSpaces);

        text = "a";
        ans = "a";
        reorderSpaces = lc1592RearrangeSpacesBetweenWords.reorderSpacesV2(text);
        Assert.assertEquals(ans, reorderSpaces);

        text = " walks";
        ans = "walks ";
        reorderSpaces = lc1592RearrangeSpacesBetweenWords.reorderSpacesV2(text);
        Assert.assertEquals(ans, reorderSpaces);
    }

    @Test
    public void stringSplitTest() {
        String[] split = "  this   is  a sentence ".split("\\s+", -1);
        // 为什么是 6 而不是 4?
        // 注意 java String中的split函数，开头匹配正则表达式，结果会生成一个空子字串。
        Assert.assertNotEquals(4, split.length);
        Assert.assertEquals(6, split.length);

        split = "  this   is  a sentence ".trim().split("\\s+");
        Assert.assertEquals(4, split.length);
    }

}
