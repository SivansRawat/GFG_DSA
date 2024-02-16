//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.math.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        Twitter obj = new Twitter();
        int total_queries = sc.nextInt();

        while (total_queries-- > 0) {
            int query = sc.nextInt();

            // if query = 1, postTweet()
            // if query = 2, getNewsFeed()
            // if query = 3, follow()
            // if query = 4, unfollow()

            if (query == 1) {
                int userId = sc.nextInt(), tweetId = sc.nextInt();

                obj.postTweet(userId, tweetId);
            } else if (query == 2) {
                int userId = sc.nextInt();

                List<Integer> vec = obj.getNewsFeed(userId);
                for (int a : vec) System.out.print(a + " ");
                System.out.println();
            } else if (query == 3) {
                int follower = sc.nextInt(), followee = sc.nextInt();
                obj.follow(follower, followee);
            } else {
                int follower = sc.nextInt(), followee = sc.nextInt();
                obj.unfollow(follower, followee);
            }
        }
    }
}

// } Driver Code Ends


// User function Template for Java
class Tweet{
    int user_id;
    int tweet_id;
    Tweet(int user_id,int tweet_id){
        this.user_id = user_id;
        this.tweet_id = tweet_id;
    }
}

class Twitter {

    
    // Initialize your data structure here
    ArrayList<Tweet> tweets;
    HashMap<Integer,HashSet<Integer>> followers;
    
    Twitter() {
        followers = new HashMap<>();
        tweets = new ArrayList<>();
    }

    // Compose a new tweet
    void postTweet(int userId, int tweetId) {
        tweets.add(new Tweet(userId,tweetId));
    }
    
    boolean isFollower(int followerId,int userId){
        if(followers.containsKey(userId)){
            if(followers.get(userId).contains(followerId)){
                return true;
            }
        }
        return false;
    }

    // Retrieve the 10 most recent tweet ids as mentioned in question
    List<Integer> getNewsFeed(int userId) {
        
        List<Integer> recents_tweets = new ArrayList<>();
        
        int count = 0;
        
        for(int i = tweets.size() - 1;i>=0;i--){
            Tweet t = tweets.get(i);
            
            if(t == null){continue;}
            
            if( (t.user_id == userId || isFollower(t.user_id,userId) ) && count < 10){
                recents_tweets.add(t.tweet_id);
                count++;
            }
        }
        
        return recents_tweets;
    }

    // Follower follows a followee. If the operation is invalid, it should be a
    // no-op.
    void follow(int followerId, int followeeId) {
        if(!followers.containsKey(followerId)){
            followers.put(followerId,new HashSet<>());
        }
        
        followers.get(followerId).add(followeeId);
    }

    // Follower unfollows a followee. If the operation is invalid, it should be
    // a no-op.
    void unfollow(int followerId, int followeeId) {
        if(followers.containsKey(followerId)){
            if(followers.get(followerId).contains(followeeId)){
                followers.get(followerId).remove(followeeId);
            }
            else{}
        }
    }
}