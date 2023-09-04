package cn.tiakon.java.leetcode.linked;

import cn.tiakon.java.leetcode.linked.design.LC1670DesignFrontMiddleBackQueue;
import org.junit.Assert;
import org.junit.Test;

public class LC1670DesignFrontMiddleBackQueueTest {
    @Test
    public void case01Test() {
        LC1670DesignFrontMiddleBackQueue frontMiddleBackQueue = new LC1670DesignFrontMiddleBackQueue();
        frontMiddleBackQueue.pushFront(1);   // [1]
        frontMiddleBackQueue.pushBack(2);    // [1, 2]
        frontMiddleBackQueue.pushMiddle(3);  // [1, 3, 2]
        frontMiddleBackQueue.pushMiddle(4);  // [1, 4, 3, 2]
        int ans = frontMiddleBackQueue.popFront();     // 返回 1 -> [4, 3, 2]
        Assert.assertEquals(1, ans);
        ans = frontMiddleBackQueue.popMiddle();    // 返回 3 -> [4, 2]
        Assert.assertEquals(3, ans);
        ans = frontMiddleBackQueue.popMiddle();    // 返回 4 -> [2]
        Assert.assertEquals(4, ans);
        ans = frontMiddleBackQueue.popBack();      // 返回 2 -> []
        Assert.assertEquals(2, ans);
        ans = frontMiddleBackQueue.popFront();     // 返回 -1 -> [] （队列为空）
        Assert.assertEquals(-1, ans);
        Assert.assertEquals(frontMiddleBackQueue.size, 0);
    }

    @Test
    public void case02Test() {
        LC1670DesignFrontMiddleBackQueue frontMiddleBackQueue = new LC1670DesignFrontMiddleBackQueue();
        frontMiddleBackQueue.pushMiddle(1);         // [1]
        frontMiddleBackQueue.pushMiddle(2);         // [2,1]
        frontMiddleBackQueue.pushMiddle(3);         // [2,3,1]
        int ans = frontMiddleBackQueue.popMiddle();     // 返回 3 -> [2,1]
        Assert.assertEquals(3, ans);
        ans = frontMiddleBackQueue.popMiddle();         // 返回 2 -> [1]
        Assert.assertEquals(2, ans);
        ans = frontMiddleBackQueue.popMiddle();         // 返回 1 -> []
        Assert.assertEquals(1, ans);
        Assert.assertEquals(frontMiddleBackQueue.size, 0);
    }

    @Test
    public void case03Test() {
        LC1670DesignFrontMiddleBackQueue frontMiddleBackQueue = new LC1670DesignFrontMiddleBackQueue();
        frontMiddleBackQueue.pushMiddle(8);
        int ans = frontMiddleBackQueue.popMiddle();
        Assert.assertEquals(8, ans);
        ans = frontMiddleBackQueue.popFront();
        Assert.assertEquals(-1, ans);
        ans = frontMiddleBackQueue.popBack();
        Assert.assertEquals(-1, ans);
        ans = frontMiddleBackQueue.popMiddle();
        Assert.assertEquals(-1, ans);
        frontMiddleBackQueue.pushMiddle(-1);
        frontMiddleBackQueue.pushMiddle(10);
        Assert.assertEquals(frontMiddleBackQueue.size, 2);
    }

    @Test
    public void case04Test() {
        LC1670DesignFrontMiddleBackQueue frontMiddleBackQueue = new LC1670DesignFrontMiddleBackQueue();
        int ans = frontMiddleBackQueue.popMiddle();
        Assert.assertEquals(-1, ans);
        frontMiddleBackQueue.pushMiddle(3);     // [3]
        frontMiddleBackQueue.pushFront(6);      // [6,3]
        frontMiddleBackQueue.pushMiddle(6);     // [6,6,3]
        frontMiddleBackQueue.pushMiddle(3);     // [6,3,6,3]
        ans = frontMiddleBackQueue.popMiddle();     // 3 -> [6,6,3]
        Assert.assertEquals(3, ans);
        frontMiddleBackQueue.pushMiddle(7);
        ans = frontMiddleBackQueue.popMiddle();
        Assert.assertEquals(7, ans);
        frontMiddleBackQueue.pushMiddle(8);
        Assert.assertEquals(frontMiddleBackQueue.size, 4);
    }

    @Test
    public void case05Test() {
        LC1670DesignFrontMiddleBackQueue frontMiddleBackQueue = new LC1670DesignFrontMiddleBackQueue();
        int ans = frontMiddleBackQueue.popMiddle();
        Assert.assertEquals(-1, ans);
        frontMiddleBackQueue.pushMiddle(713258);
        ans = frontMiddleBackQueue.popMiddle();
        Assert.assertEquals(713258, ans);
        frontMiddleBackQueue.pushMiddle(354113);
        frontMiddleBackQueue.pushMiddle(37856);

        ans = frontMiddleBackQueue.popMiddle();
        Assert.assertEquals(37856, ans);
        ans = frontMiddleBackQueue.popMiddle();
        Assert.assertEquals(354113, ans);
        frontMiddleBackQueue.pushMiddle(261343);
        ans = frontMiddleBackQueue.popMiddle();
        Assert.assertEquals(261343, ans);

        ans = frontMiddleBackQueue.popFront();
        Assert.assertEquals(-1, ans);
        ans = frontMiddleBackQueue.popMiddle();
        Assert.assertEquals(-1, ans);
        ans = frontMiddleBackQueue.popMiddle();
        Assert.assertEquals(-1, ans);

        frontMiddleBackQueue.pushFront(458649);
        ans = frontMiddleBackQueue.popFront();
        Assert.assertEquals(458649, ans);
        frontMiddleBackQueue.pushMiddle(962224);
        frontMiddleBackQueue.pushMiddle(638446);

        ans = frontMiddleBackQueue.popMiddle();
        Assert.assertEquals(638446, ans);
        ans = frontMiddleBackQueue.popMiddle();
        Assert.assertEquals(962224, ans);
        ans = frontMiddleBackQueue.popFront();
        Assert.assertEquals(-1, ans);
        frontMiddleBackQueue.pushFront(694620);

        ans = frontMiddleBackQueue.popFront();
        Assert.assertEquals(694620, ans);

        ans = frontMiddleBackQueue.popMiddle();
        Assert.assertEquals(-1, ans);

        ans = frontMiddleBackQueue.popMiddle();
        Assert.assertEquals(-1, ans);

        ans = frontMiddleBackQueue.popBack();
        Assert.assertEquals(-1, ans);

        ans = frontMiddleBackQueue.popMiddle();
        Assert.assertEquals(-1, ans);

    }
}
