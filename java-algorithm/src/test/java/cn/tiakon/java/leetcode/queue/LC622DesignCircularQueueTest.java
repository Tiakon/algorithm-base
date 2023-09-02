package cn.tiakon.java.leetcode.queue;

import org.junit.Assert;
import org.junit.Test;

public class LC622DesignCircularQueueTest {

    @Test
    public void MyCircularQueueTest() {
        LC622DesignCircularQueue.MyCircularQueue circularQueue = new LC622DesignCircularQueue.MyCircularQueue(3); // 设置长度为 3
        Assert.assertTrue(circularQueue.enQueue(1));
        Assert.assertTrue(circularQueue.enQueue(2));
        Assert.assertTrue(circularQueue.enQueue(3));
        Assert.assertFalse(circularQueue.enQueue(4));

        Assert.assertEquals(3, circularQueue.Rear());
        Assert.assertFalse(circularQueue.enQueue(3));
        Assert.assertTrue(circularQueue.isFull());
        Assert.assertTrue(circularQueue.deQueue());
        Assert.assertTrue(circularQueue.enQueue(4));
    }


}
