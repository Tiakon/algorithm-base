package cn.tiakon.java.leetcode.string;

import org.junit.Assert;
import org.junit.Test;

public class LC1455CheckIfWordAsPrefixTest {
    @Test
    public void isPrefixOfWordTest() {
        LC1455CheckIfWordAsPrefix lc1455CheckIfWordAsPrefix = new LC1455CheckIfWordAsPrefix();
        String sentence = "i love eating burger";
        String searchWord = "burg";
        int prefixOfWord = lc1455CheckIfWordAsPrefix.isPrefixOfWord(sentence, searchWord);
        Assert.assertEquals(4, prefixOfWord);

        sentence = "this problem is an easy problem";
        searchWord = "pro";
        prefixOfWord = lc1455CheckIfWordAsPrefix.isPrefixOfWord(sentence, searchWord);
        Assert.assertEquals(2, prefixOfWord);

        sentence = "i am tired";
        searchWord = "you";
        prefixOfWord = lc1455CheckIfWordAsPrefix.isPrefixOfWord(sentence, searchWord);
        Assert.assertEquals(-1, prefixOfWord);
    }

    @Test
    public void StringIndexTest() {
        System.out.println("burger".indexOf("burg"));
        System.out.println("problem".indexOf("pro"));
        System.out.println("tired".indexOf("you"));
    }
}
