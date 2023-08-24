package cn.tiakon.java.leetcode.linked;

import cn.tiakon.java.leetcode.datastructure.Node;
import org.junit.Test;

public class LC138CopyListWithRandomPointerTest {

    final LC138CopyListWithRandomPointer lc138CopyListWithRandomPointer = new LC138CopyListWithRandomPointer();

    @Test
    public void case01Test() {
        final Node node1 = new Node(1);
        final Node node10 = new Node(10, node1);
        final Node node11 = new Node(11, node10);
        final Node node13 = new Node(13, node11);
        final Node node7 = new Node(7, node13);
        node13.random = node7;
        node11.random = node1;
        node10.random = node11;
        node1.random = node7;
        final Node ans = lc138CopyListWithRandomPointer.copyRandomList(node7);
        System.out.println(ans);
    }


    @Test
    public void case02Test() {
        final Node node1 = new Node(1);
        final Node node10 = new Node(10, node1);
        final Node node11 = new Node(11, node10);
        final Node node13 = new Node(13, node11);
        final Node node7 = new Node(7, node13);
        node13.random = node7;
        node11.random = node1;
        node10.random = node11;
        node1.random = node7;
        final Node ans = lc138CopyListWithRandomPointer.copyRandomListV2(node7);
        System.out.println(ans);
    }
}
