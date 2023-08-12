package cn.tiakon.java.leetcode.linked;

import cn.tiakon.java.leetcode.datastructure.ListNode;
import org.junit.Test;

public class LC02AddTwoNumbersTest {
    @Test
    public void case01Test() {

        final LC02AddTwoNumbers addTwoNumbers = new LC02AddTwoNumbers();

        ListNode list1Node1 = new ListNode(3);
        ListNode list1Node2 = new ListNode(4);
        list1Node1.next = list1Node2;
        ListNode list1Node3 = new ListNode(2);
        list1Node2.next = list1Node3;

        ListNode list2Node1 = new ListNode(4);
        ListNode list2Node2 = new ListNode(6);
        list2Node1.next = list2Node2;
        ListNode list2Node3 = new ListNode(5);
        list2Node2.next = list2Node3;
        ListNode newNode = addTwoNumbers.addTwoNumbers(list1Node1, list2Node1);
        ListNode currentNode = newNode;
//        ListNode currentNode = list1Node1;
//        ListNode currentNode = list2Node1;
        do {
            System.out.println(currentNode.val);
            currentNode = currentNode.next;
        } while (currentNode != null);
    }
}
