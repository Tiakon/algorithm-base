package cn.tiakon.java.leetcode.hashtable;

import org.junit.Assert;
import org.junit.Test;

public class LC706Test {
    @Test
    public void case01Test() {
        final LC706MyHashMap map = new LC706MyHashMap();
        map.put(1, 1);
        Assert.assertEquals(1, map.get(1));
        map.put(2, 2);
        Assert.assertEquals(2, map.get(2));
        Assert.assertEquals(-1, map.get(3));
        map.put(2, 1); // map 现在为 [[1,1], [2,1]]（更新已有的值）
        Assert.assertEquals(2, map.size);
        Assert.assertEquals(1, map.get(2));
        map.remove(2); // 删除键为 2 的数据，map 现在为 [[1,1]]
        Assert.assertEquals(-1, map.get(2));
        Assert.assertEquals(1, map.size);
    }

    @Test
    public void case02Test() {
        final LC706MyHashMap map = new LC706MyHashMap();
        map.put(13, 1);
        map.put(26, 1);
        map.put(39, 1);
        map.put(14, 1);
        map.put(28, 1);
        map.put(42, 1);
        map.put(15, 1);
        map.put(30, 1);
        map.put(45, 1);
        map.put(16, 1);
        map.put(32, 1);
        map.put(48, 1);
        Assert.assertEquals(1, map.get(45));
        Assert.assertEquals(12, map.size);

        map.remove(28);
        map.remove(14);
        map.remove(16);
        Assert.assertEquals(9, map.size);
        Assert.assertEquals(-1, map.get(28));
        Assert.assertEquals(-1, map.get(14));
        Assert.assertEquals(-1, map.get(16));
        map.put(60, 1);
        Assert.assertEquals(1, map.get(42));
        Assert.assertEquals(1, map.get(15));
        Assert.assertEquals(1, map.get(48));

    }

    @Test
    public void case03Test() {
        final LC706MyHashMap map = new LC706MyHashMap();
        map.remove(27);
        map.put(65, 65);
        map.remove(19);
        map.remove(0);
        Assert.assertEquals(-1, map.get(18));
        map.put(42, 0);
        Assert.assertEquals(-1, map.get(19));
        map.remove(42);
        Assert.assertEquals(1, map.size);
        map.put(17, 90);
        map.put(31, 76);
        map.put(48, 71);
        map.put(5, 50);
        map.put(7, 68);
        Assert.assertEquals(6, map.size);
        map.put(73, 74);
        map.put(85, 18);
        map.put(74, 95);
        Assert.assertEquals(9, map.size);
        map.put(84, 82);
        map.put(59, 29);
        map.put(71, 71);
        Assert.assertEquals(12, map.size);
        map.remove(42);
        map.put(51, 40);
        map.put(33, 76);
        Assert.assertEquals(14, map.size);
        Assert.assertEquals(90, map.get(17));
        Assert.assertEquals(-1, map.get(42));
    }

    @Test
    public void case04Test() {
        int capacity, count = 0;
        for (capacity = 16; capacity <Integer.MAX_VALUE; ) {
            capacity = (capacity >= (Integer.MAX_VALUE) >> 1) ? Integer.MAX_VALUE : capacity << 1;
            count++;
        }
        System.out.println("capacity " + capacity);
        System.out.println("count " + count);
    }
}
