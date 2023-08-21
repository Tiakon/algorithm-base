package cn.tiakon.java.leetcode.array;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class LC1282GroupThePeopleTest {

    @Test
    public void groupThePeopleTest() {
        final LC1282GroupThePeople lc1282GroupThePeople = new LC1282GroupThePeople();

        int[] groupSizes = new int[]{3, 3, 3, 3, 3, 1, 3};
        List<List<Integer>> ans = lc1282GroupThePeople.groupThePeople(groupSizes);
        List<List<Integer>> expecteds = new ArrayList<>();
        List<Integer> list1 = new ArrayList<>();
        list1.add(0);
        list1.add(1);
        list1.add(2);
        List<Integer> list2 = new ArrayList<>();
        list2.add(3);
        list2.add(4);
        list2.add(6);
        List<Integer> list3 = new ArrayList<>();
        list3.add(5);
        expecteds.add(list1);
        expecteds.add(list2);
        expecteds.add(list3);
        Assert.assertEquals(expecteds, ans);

        groupSizes = new int[]{2, 1, 3, 3, 3, 2};
        ans = lc1282GroupThePeople.groupThePeople(groupSizes);
        expecteds = new ArrayList<>();
        list1 = new ArrayList<>();
        list1.add(0);
        list1.add(5);
        list2 = new ArrayList<>();
        list2.add(1);
        list3 = new ArrayList<>();
        list3.add(2);
        list3.add(3);
        list3.add(4);
        expecteds.add(list1);
        expecteds.add(list2);
        expecteds.add(list3);
        Assert.assertEquals(expecteds, ans);

        groupSizes = new int[]{2, 1, 1, 2, 1};
        ans = lc1282GroupThePeople.groupThePeople(groupSizes);
        expecteds = new ArrayList<>();
        list1 = new ArrayList<>();
        list1.add(1);
        list2 = new ArrayList<>();
        list2.add(2);
        list3 = new ArrayList<>();
        list3.add(4);
        List list4 = new ArrayList<>();
        list4.add(0);
        list4.add(3);
        expecteds.add(list4);
        expecteds.add(list1);
        expecteds.add(list2);
        expecteds.add(list3);
        Assert.assertEquals(expecteds, ans);

    }

    @Test
    public void groupThePeopleV2Test() {
        final LC1282GroupThePeople lc1282GroupThePeople = new LC1282GroupThePeople();

        int[] groupSizes = new int[]{3, 3, 3, 3, 3, 1, 3};
        List<List<Integer>> ans = lc1282GroupThePeople.groupThePeopleV2(groupSizes);
        List<List<Integer>> expecteds = new ArrayList<>();
        List<Integer> list1 = new ArrayList<>();
        list1.add(0);
        list1.add(1);
        list1.add(2);
        List<Integer> list2 = new ArrayList<>();
        list2.add(3);
        list2.add(4);
        list2.add(6);
        List<Integer> list3 = new ArrayList<>();
        list3.add(5);
        expecteds.add(list1);
        expecteds.add(list3);
        expecteds.add(list2);
        Assert.assertEquals(expecteds, ans);

        groupSizes = new int[]{2, 1, 3, 3, 3, 2};
        ans = lc1282GroupThePeople.groupThePeopleV2(groupSizes);
        expecteds = new ArrayList<>();
        list1 = new ArrayList<>();
        list1.add(0);
        list1.add(5);
        list2 = new ArrayList<>();
        list2.add(1);
        list3 = new ArrayList<>();
        list3.add(2);
        list3.add(3);
        list3.add(4);

        expecteds.add(list2);
        expecteds.add(list1);
        expecteds.add(list3);
        Assert.assertEquals(expecteds, ans);

        groupSizes = new int[]{2, 1, 1, 2, 1};
        ans = lc1282GroupThePeople.groupThePeopleV2(groupSizes);
        expecteds = new ArrayList<>();
        list1 = new ArrayList<>();
        list1.add(1);
        list2 = new ArrayList<>();
        list2.add(2);
        list3 = new ArrayList<>();
        list3.add(4);
        List list4 = new ArrayList<>();
        list4.add(0);
        list4.add(3);
        expecteds.add(list1);
        expecteds.add(list2);
        expecteds.add(list3);
        expecteds.add(list4);
        Assert.assertEquals(expecteds, ans);

    }

    @Test
    public void groupThePeopleV3Test() {
        final LC1282GroupThePeople lc1282GroupThePeople = new LC1282GroupThePeople();

        int[] groupSizes = new int[]{3, 3, 3, 3, 3, 1, 3};
        List<List<Integer>> ans = lc1282GroupThePeople.groupThePeopleV3(groupSizes);
        List<List<Integer>> expecteds = new ArrayList<>();
        List<Integer> list1 = new ArrayList<>();
        list1.add(0);
        list1.add(1);
        list1.add(2);
        List<Integer> list2 = new ArrayList<>();
        list2.add(3);
        list2.add(4);
        list2.add(6);
        List<Integer> list3 = new ArrayList<>();
        list3.add(5);
        expecteds.add(list1);
        expecteds.add(list2);
        expecteds.add(list3);
        Assert.assertEquals(expecteds, ans);

        groupSizes = new int[]{2, 1, 3, 3, 3, 2};
        ans = lc1282GroupThePeople.groupThePeopleV3(groupSizes);
        expecteds = new ArrayList<>();
        list1 = new ArrayList<>();
        list1.add(0);
        list1.add(5);
        list2 = new ArrayList<>();
        list2.add(1);
        list3 = new ArrayList<>();
        list3.add(2);
        list3.add(3);
        list3.add(4);

        expecteds.add(list1);
        expecteds.add(list2);
        expecteds.add(list3);
        Assert.assertEquals(expecteds, ans);

        groupSizes = new int[]{2, 1, 1, 2, 1};
        ans = lc1282GroupThePeople.groupThePeopleV3(groupSizes);
        expecteds = new ArrayList<>();
        list1 = new ArrayList<>();
        list1.add(1);
        list2 = new ArrayList<>();
        list2.add(2);
        list3 = new ArrayList<>();
        list3.add(4);
        List list4 = new ArrayList<>();
        list4.add(0);
        list4.add(3);
        expecteds.add(list4);
        expecteds.add(list1);
        expecteds.add(list2);
        expecteds.add(list3);
        Assert.assertEquals(expecteds, ans);

    }
}
