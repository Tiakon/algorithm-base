package cn.tiakon.java.leetcode.linked;

import org.junit.Assert;
import org.junit.Test;

public class LC707DesignLinkedListTest {
    @Test
    public void case01Test() {
        // ["MyLinkedList","addAtHead","addAtTail","addAtIndex","get","deleteAtIndex","get"]
        // [[],[1],[3],[1,2],[1],[1],[1]]
        final LC707DesignDoubleLinkedList designDoubleLinkedList = new LC707DesignDoubleLinkedList();
        designDoubleLinkedList.addAtHead(1);
        designDoubleLinkedList.addAtTail(3);
        designDoubleLinkedList.addAtIndex(1, 2);
        Assert.assertEquals(1, designDoubleLinkedList.get(0));
        Assert.assertEquals(2, designDoubleLinkedList.get(1));
        Assert.assertEquals(3, designDoubleLinkedList.get(2));
        designDoubleLinkedList.deleteAtIndex(1);
        Assert.assertEquals(3, designDoubleLinkedList.get(1));
        designDoubleLinkedList.deleteAtIndex(0);
        Assert.assertEquals(3, designDoubleLinkedList.get(0));
    }
}
