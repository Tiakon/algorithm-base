package cn.tiakon.java.leetcode.linked;

import cn.tiakon.java.leetcode.datastructure.ListNode;

/**
 * 2. 两数相加
 * https://leetcode.cn/problems/add-two-numbers/
 *
 * @author Created by Tiakon on 2019/1/9 11:23.
 */
public class LC02AddTwoNumbers {

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode currentNode1 = l1;
        ListNode currentNode2 = l2;
        ListNode sumNode = new ListNode((int) currentNode1.val + (int) currentNode2.val);
        ListNode preNode = sumNode;
        ListNode nextNode1 = currentNode1.next;
        ListNode nextNode2 = currentNode2.next;
        ListNode firstNode = new ListNode((int) nextNode1.val + (int) nextNode2.val);
        sumNode.next = firstNode;
        ListNode next2Node1 = nextNode1.next;
        ListNode next2Node2 = nextNode2.next;
        ListNode secondNode = new ListNode((int) next2Node1.val + (int) next2Node2.val);
        firstNode.next = secondNode;
        return sumNode;
    }

    public static void main(String[] args) {
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
        ListNode newNode = addTwoNumbers(list1Node1, list2Node1);
        ListNode currentNode = newNode;
//        ListNode currentNode = list1Node1;
//        ListNode currentNode = list2Node1;
        do {
            System.out.println(currentNode.val);
            currentNode = currentNode.next;
        } while (currentNode != null);

    }
}

