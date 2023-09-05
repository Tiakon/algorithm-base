package cn.tiakon.java.leetcode.linked;

import cn.tiakon.java.leetcode.linked.design.LC355Twitter;
import cn.tiakon.java.utils.MathRandomUtil;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class LC355TwitterTest {
    @Test
    public void case01Test() {
        LC355Twitter twitter = new LC355Twitter();
        twitter.postTweet(1, 5); // 用户 1 发送了一条新推文 (用户 id = 1, 推文 id = 5)
        List<Integer> ans = twitter.getNewsFeed(1);// 用户 1 的获取推文应当返回一个列表，其中包含一个 id 为 5 的推文
        Assert.assertEquals("5", MathRandomUtil.listToString(ans));
        twitter.follow(1, 2);    // 用户 1 关注了用户 2
        twitter.postTweet(2, 6); // 用户 2 发送了一个新推文 (推文 id = 6)
        ans = twitter.getNewsFeed(1);  // 用户 1 的获取推文应当返回一个列表，其中包含两个推文，id 分别为 -> [6, 5] 。推文 id 6 应当在推文 id 5 之前，因为它是在 5 之后发送的
        Assert.assertEquals("6,5", MathRandomUtil.listToString(ans));
        twitter.unfollow(1, 2);  // 用户 1 取消关注了用户 2
        ans = twitter.getNewsFeed(1);  // 用户 1 获取推文应当返回一个列表，其中包含一个 id 为 5 的推文。因为用户 1 已经不再关注用户 2
        Assert.assertEquals("5", MathRandomUtil.listToString(ans));
    }
}
