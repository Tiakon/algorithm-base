package cn.tiakon.java.leetcode.string;

import cn.tiakon.java.utils.MathRandomUtil;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class LC1408StringMatchingArrayTest {

    @Test
    public void stringMatchingTest() {
        LC1408StringMatchingArray lc1408StringMatchingArray = new LC1408StringMatchingArray();

        String[] strings = new String[]{"mass", "as", "hero", "superhero",};
        List<String> list = lc1408StringMatchingArray.stringMatching(strings);
        String res = MathRandomUtil.listToString(list);
        Assert.assertEquals("as,hero", res);

        strings = new String[]{"leetcode", "et", "code"};
        list = lc1408StringMatchingArray.stringMatching(strings);
        res = MathRandomUtil.listToString(list);
        Assert.assertEquals("et,code", res);

        strings = new String[]{"blue", "green", "bu"};
        list = lc1408StringMatchingArray.stringMatching(strings);
        res = MathRandomUtil.listToString(list);
        Assert.assertEquals("", res);

        strings = new String[]{"blue", "aabluebb", "aabluebbcc", "aabluebbccdd", "aabluebbccddee"};
        list = lc1408StringMatchingArray.stringMatching(strings);
        res = MathRandomUtil.listToString(list);
        Assert.assertEquals("blue,aabluebb,aabluebbcc,aabluebbccdd", res);
    }
}
