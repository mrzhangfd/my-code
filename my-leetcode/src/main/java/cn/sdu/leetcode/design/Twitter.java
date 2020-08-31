package cn.sdu.leetcode.design;

import java.util.*;

/**
 * 355 设计推特
 *
 * @author icatzfd
 * Created on 2020/8/23 15:09.
 */
class Tweet{
    int tweetId;

    public Tweet(int tweetId) {
        this.tweetId = tweetId;
    }
}
class User{
    int userId;
    Set<User> follow;
    Set<Tweet> tweets;

    public User(int userId) {
        this.userId = userId;
    }
}
public class Twitter {
    //所有的用户
    Set<User> users;

    //所有的推文
    Set<Tweet> tweets;

    //用户 与其关注者
    Map<Integer,Set<Integer>> mapFollow;

    Map<Integer,Set<Integer>> mapTweet;

    Map<Integer,User> mapUser;

    /** Initialize your data structure here. */
    public Twitter() {
        users=new HashSet<>();
        tweets=new HashSet<>();
        mapUser=new HashMap<>();
    }

    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
       User user=mapUser.get(userId);
       users.add(user);
       Tweet tweet=new Tweet(tweetId);
       user.tweets.add(tweet);
    }

    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
        return null;
    }

    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {

    }

    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {

    }
}
