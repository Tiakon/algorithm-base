package cn.tiakon.java.leetcode.linked.design;

import java.util.*;

/**
 * 355. 设计推特
 * https://leetcode.cn/problems/design-twitter/
 *
 * @author tiankai.me@gmail.com on 2023-09-04 21:58.
 */
public class LC355Twitter {
    List<User> tweetList;
    Map<Integer, Set<Integer>> tweetMap;

    public LC355Twitter() {
        tweetList = new ArrayList<>();
        tweetMap = new HashMap<>();
    }

    public void postTweet(int userId, int tweetId) {
        tweetList.add(new User(userId, tweetId));
    }

    public List<Integer> getNewsFeed(int userId) {
        List<Integer> ans = new ArrayList<>();
        final Set<Integer> followeeSet = tweetMap.getOrDefault(userId, null);
        for (int i = tweetList.size() - 1; i >= 0 && ans.size() < 10; --i) {
            User user = tweetList.get(i);
            if (user.userId == userId || (followeeSet != null && followeeSet.contains(user.userId)))
                ans.add(user.tweetId);
        }
        return ans;
    }

    public void follow(int followerId, int followeeId) {
        Set<Integer> followeeSet = tweetMap.getOrDefault(followerId, new HashSet<>());
        followeeSet.add(followeeId);
        tweetMap.put(followerId, followeeSet);
    }

    public void unfollow(int followerId, int followeeId) {
        Set<Integer> followeeIdList = tweetMap.getOrDefault(followerId, null);
        if (followeeIdList != null && !followeeIdList.isEmpty()) followeeIdList.remove(followeeId);
    }
}

class User {
    int userId;
    int tweetId;
    public User(int userId, int tweetId) {
        this.userId = userId;
        this.tweetId = tweetId;
    }
}

