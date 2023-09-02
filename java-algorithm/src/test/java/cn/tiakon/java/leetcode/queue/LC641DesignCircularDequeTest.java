package cn.tiakon.java.leetcode.queue;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Random;

public class LC641DesignCircularDequeTest {

    @Test
    public void ArrayDequeTest() {
        Deque deque = new ArrayDeque(3);
        deque.addLast(1);
        deque.addLast(2);
        deque.addFirst(3);
        deque.addFirst(4);
        // 超过初始容量的值并不会报错
        Assert.assertEquals(4, deque.size());
        Assert.assertEquals(2, deque.getLast());
        Assert.assertEquals(2, deque.peekLast());
        deque.addLast(4);
        Assert.assertEquals(4, deque.getFirst());
    }

    @Test
    public void MyCircularDequeTest() {
        // 设置容量大小为3
        LC641DesignCircularDeque.MyCircularDeque circularDeque = new LC641DesignCircularDeque.MyCircularDeque(10);
        Assert.assertTrue(circularDeque.insertLast(1));
        Assert.assertTrue(circularDeque.insertLast(2));
        Assert.assertTrue(circularDeque.insertLast(6));
        Assert.assertTrue(circularDeque.insertLast(7));
        Assert.assertTrue(circularDeque.insertFront(3));
        Assert.assertTrue(circularDeque.insertFront(4));
        Assert.assertTrue(circularDeque.insertFront(5));
        Assert.assertTrue(circularDeque.deleteLast());
        Assert.assertTrue(circularDeque.deleteFront());
        Assert.assertTrue(circularDeque.deleteLast());
        Assert.assertEquals(2, circularDeque.getRear());
        Assert.assertFalse(circularDeque.isFull());
        Assert.assertTrue(circularDeque.deleteLast());
        Assert.assertTrue(circularDeque.insertFront(4));
        Assert.assertEquals(4, circularDeque.getFront());
        Assert.assertEquals(1, circularDeque.getRear());
    }

    @Test
    public void MyCircularDequeBenchmarkTest() {
        final Random random = new Random();
        for (int i = 0; i < 1000; i++) {
            // [0,1000]
            final int k = random.nextInt(1001);
            final LC641DesignCircularDeque.MyCircularDeque myCircularDeque = new LC641DesignCircularDeque.MyCircularDeque(k);
            final Deque<Integer> deque = new ArrayDeque<>();
            // [0,k]
            for (int j = 0; j < 5000; j++) {
                // [0,1000]
                final int value = random.nextInt(1001);
                if (random.nextInt() > 0.5) {
                    if (myCircularDeque.isFull()) {
                        continue;
                    }
                    if (random.nextInt() > 0.5) {
                        deque.addFirst(value);
                        myCircularDeque.insertFront(value);
                        Assert.assertEquals((int) deque.peekFirst(), myCircularDeque.getFront());
                    } else {
                        deque.addLast(value);
                        myCircularDeque.insertLast(value);
                        Assert.assertEquals((int) deque.peekLast(), myCircularDeque.getRear());
                    }
                } else {
                    if (myCircularDeque.isEmpty()) {
                        continue;
                    }
                    if (random.nextInt() > 0.5) {
                        Assert.assertEquals((int) deque.getFirst(), myCircularDeque.getFront());
                        deque.removeFirst();
                        myCircularDeque.deleteFront();
                    } else {
                        Assert.assertEquals((int) deque.getLast(), myCircularDeque.getRear());
                        deque.removeLast();
                        myCircularDeque.deleteLast();
                    }
                }
            }
        }
    }

    @Test
    public void MyCircularDequeWithArrayTest() {
        // 设置容量大小为3
        LC641DesignCircularDeque.MyCircularDequeWithArray circularDeque = new LC641DesignCircularDeque.MyCircularDequeWithArray(3);
        Assert.assertTrue(circularDeque.insertLast(1));
        Assert.assertTrue(circularDeque.insertLast(2));
        Assert.assertTrue(circularDeque.insertFront(3));
        Assert.assertFalse(circularDeque.insertFront(4));
        Assert.assertEquals(2, circularDeque.getRear());
        Assert.assertTrue(circularDeque.isFull());
        Assert.assertTrue(circularDeque.deleteLast());
        Assert.assertTrue(circularDeque.insertFront(4));
        Assert.assertEquals(4, circularDeque.getFront());
    }

    @Test
    public void MyCircularDequeWithArrayBenchmarkTest() {
        final Random random = new Random();
        for (int i = 0; i < 1000; i++) {
            // [0,1000]
            final int k = random.nextInt(1001);
            final LC641DesignCircularDeque.MyCircularDequeWithArray dequeWithArray = new LC641DesignCircularDeque.MyCircularDequeWithArray(k);
            final Deque<Integer> deque = new ArrayDeque<>();
            // [0,k]
            for (int j = 0; j < 5000; j++) {
                // [0,1000]
                final int value = random.nextInt(1001);
                if (random.nextInt() > 0.5) {
                    if (dequeWithArray.isFull()) {
                        continue;
                    }
                    if (random.nextInt() > 0.5) {
                        deque.addFirst(value);
                        dequeWithArray.insertFront(value);
                        Assert.assertEquals((int) deque.peekFirst(), dequeWithArray.getFront());
                    } else {
                        deque.addLast(value);
                        dequeWithArray.insertLast(value);
                        Assert.assertEquals((int) deque.peekLast(), dequeWithArray.getRear());
                    }
                } else {
                    if (dequeWithArray.isEmpty()) {
                        continue;
                    }
                    if (random.nextInt() > 0.5) {
                        Assert.assertEquals((int) deque.getFirst(), dequeWithArray.getFront());
                        deque.removeFirst();
                        dequeWithArray.deleteFront();
                    } else {
                        Assert.assertEquals((int) deque.getLast(), dequeWithArray.getRear());
                        deque.removeLast();
                        dequeWithArray.deleteLast();
                    }
                }
            }
        }
    }

}
