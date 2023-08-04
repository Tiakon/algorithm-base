package cn.tiakon.java.utils;

import cn.tiakon.java.leetcode.datastructure.ListNode;

import java.util.List;

/**
 * @author tiankai.me@gmail.com on 2022/8/25 14:28.
 */
public class ListUtils {

    public static String listEmbeddedToString(List<List<Integer>> ans) {
        final StringBuilder builder = new StringBuilder();
        for (List<Integer> cols : ans) {
            builder.append("[");
            for (Integer col : cols) {
                builder.append(",").append(col);
            }
            builder.append("]");
        }
        return builder.toString().replace("[,", "[");
    }

    public static String listCharEmbeddedToString(List<List<Character>> ans) {
        final StringBuilder builder = new StringBuilder();
        for (List<Character> cols : ans) {
            builder.append("[");
            for (Character col : cols) {
                builder.append(",").append(col);
            }
            builder.append("]");
        }
        return builder.toString().replace("[,", "[");
    }

    public static String listStringEmbeddedToString(List<List<String>> ans) {
        final StringBuilder builder = new StringBuilder();
        for (List<String> cols : ans) {
            builder.append("[");
            for (String col : cols) {
                builder.append(",").append(col);
            }
            builder.append("]");
        }
        return builder.toString().replace("[,", "[");
    }

    public static String listToString(List<?> lists) {
        final StringBuilder builder = new StringBuilder();
        for (Object s : lists) {
            builder.append(",").append(s);
        }
        return builder.toString().replaceFirst(",", "");
    }

    // 打印链表
    public static String printListNode(ListNode head) {
        if (head == null) return "";
        StringBuilder builder = new StringBuilder();
        ListNode node = head;
        while (node != null) {
            builder.append(node.val).append(" ");
            node=node.next;
        }
        return builder.toString();
    }

    // 逆序打印链表
    public static void printListNodeReversed(ListNode head) {
        if (head == null) return;
        printListNodeReversed(head.next);
        System.out.println(head.val);
    }
}
