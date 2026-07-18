package Hard;

import java.util.*;

class Tweet {
    int tweetId;
    int time;

    Tweet(int tweetId, int time) {
        this.tweetId = tweetId;
        this.time = time;
    }
}

class Node {
    int userId;
    int index;
    Tweet tweet;

    Node(int userId, int index, Tweet tweet) {
        this.userId = userId;
        this.index = index;
        this.tweet = tweet;
    }
}

class Twitter {
    int time;
    HashMap<Integer, HashSet<Integer>> followMap;
    HashMap<Integer, List<Tweet>> tweetMap;

    public Twitter() {
        time = 0;
        followMap = new HashMap<>();
        tweetMap = new HashMap<>();
    }

    public void postTweet(int userId, int tweetId) {
        if (!tweetMap.containsKey(userId)) {
            tweetMap.put(userId, new ArrayList<>());
        }

        tweetMap.get(userId).add(new Tweet(tweetId,time++));

    }

    public List<Integer> getNewsFeed(int userId) {
        List<Integer> feed = new ArrayList<>();

        PriorityQueue<Node> pq =
                new PriorityQueue<>((a, b) -> b.tweet.time - a.tweet.time);

        // user's own tweets
        if (tweetMap.containsKey(userId)) {
            List<Tweet> tweets = tweetMap.get(userId);
            int last = tweets.size() - 1;

            pq.offer(new Node(userId, last, tweets.get(last)));
        }

        // followed users' tweets
        if (followMap.containsKey(userId)) {

            for (int followee : followMap.get(userId)) {

                if (!tweetMap.containsKey(followee))
                    continue;

                List<Tweet> tweets = tweetMap.get(followee);
                int last = tweets.size() - 1;

                pq.offer(new Node(followee, last, tweets.get(last)));
            }
        }

        while (!pq.isEmpty() && feed.size() < 10) {

            Node curr = pq.poll();

            feed.add(curr.tweet.tweetId);

            if (curr.index > 0) {

                List<Tweet> tweets = tweetMap.get(curr.userId);

                pq.offer(new Node(
                        curr.userId,
                        curr.index - 1,
                        tweets.get(curr.index - 1)
                ));
            }
        }

        return feed;
    }

    public void follow(int followerId, int followeeId) {
        if (!followMap.containsKey(followerId)) {
            followMap.put(followerId, new HashSet<>());
        }

        followMap.get(followerId).add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        if (followMap.containsKey(followerId)) {
            followMap.get(followerId).remove(followeeId);
        }
    }
}

public class DesignTwitter {
    public static void main(String[] args) {
        Twitter twitter = new Twitter();

        twitter.postTweet(1, 5);
        System.out.println(twitter.getNewsFeed(1)); // [5]

        twitter.follow(1, 2);

        twitter.postTweet(2, 6);
        System.out.println(twitter.getNewsFeed(1)); // [6, 5]

        twitter.unfollow(1, 2);
        System.out.println(twitter.getNewsFeed(1)); // [5]
    }
}
