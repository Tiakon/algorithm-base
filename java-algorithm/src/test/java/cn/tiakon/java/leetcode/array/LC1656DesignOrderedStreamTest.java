package cn.tiakon.java.leetcode.array;

import cn.tiakon.java.leetcode.datastructure.ListNode;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC1656DesignOrderedStreamTest {


    @Test
    public void OrderedStreamTest() {
        final LC1656DesignOrderedStream.OrderedStream orderedStream = new LC1656DesignOrderedStream.OrderedStream(5);
        List<String> list = new ArrayList<>();
        Assert.assertEquals(list, orderedStream.insert(3, "ccccc"));

        list.add("aaaaa");
        Assert.assertEquals(list, orderedStream.insert(1, "aaaaa"));

        list = new ArrayList<>();
        list.add("bbbbb");
        list.add("ccccc");
        Assert.assertEquals(list, orderedStream.insert(2, "bbbbb"));

        list = new ArrayList<>();
        Assert.assertEquals(list, orderedStream.insert(5, "eeeee"));

        list = new ArrayList<>();
        list.add("ddddd");
        list.add("eeeee");
        Assert.assertEquals(list, orderedStream.insert(4, "ddddd"));
    }

    @Test
    public void OrderedStreamV2Test() {
        final LC1656DesignOrderedStream.OrderedStreamV2 orderedStream = new LC1656DesignOrderedStream.OrderedStreamV2(5);
        List<String> list = new ArrayList<>();
        Assert.assertEquals(list, orderedStream.insert(3, "ccccc"));

        list.add("aaaaa");
        Assert.assertEquals(list, orderedStream.insert(1, "aaaaa"));

        list = new ArrayList<>();
        list.add("bbbbb");
        list.add("ccccc");
        Assert.assertEquals(list, orderedStream.insert(2, "bbbbb"));

        list = new ArrayList<>();
        Assert.assertEquals(list, orderedStream.insert(5, "eeeee"));

        list = new ArrayList<>();
        list.add("ddddd");
        list.add("eeeee");
        Assert.assertEquals(list, orderedStream.insert(4, "ddddd"));
    }

    @Test
    public void ListNodeArrayTest() {
        final ListNode[] listNodes = new ListNode[10];
        for (int i = 0; i < listNodes.length; i++) {
            Assert.assertNull(listNodes[i]);
        }
        String[] ss = new String[10];
        for (String s : ss) {
            Assert.assertNull(s);
        }
        ss = new String[10];
        Arrays.fill(ss, "");
        for (String s : ss) {
            Assert.assertEquals("", s);
        }
    }

}
