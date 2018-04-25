import twitter4j.*;
import twitter4j.auth.AccessToken;
import twitter4j.auth.RequestToken;
import twitter4j.conf.ConfigurationBuilder;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

public final class TwitterOperations {
    public static void main(String[] args) {
        ConfigurationBuilder cb = new ConfigurationBuilder();
        cb.setDebugEnabled(true)
                .setOAuthConsumerKey("***")
                .setOAuthConsumerSecret("***")
                .setOAuthAccessToken("***")
                .setOAuthAccessTokenSecret("***");
        TwitterFactory tf = new TwitterFactory(cb.build());

        TwitterOperations to = new TwitterOperations();
        /*
        try {
            to.createTweet("This my first tweet through TwitterAPI.", tf);
        } catch (TwitterException e) {
            e.printStackTrace();
        }
        */
        to.getTimeline("realDonaldTrump", tf, 6, 100);
    }

    public void createTweet(String tweet, TwitterFactory tf) throws TwitterException {
        Twitter twitter = tf.getInstance();
        Status status = twitter.updateStatus(tweet);
    }

    public void getTimeline(String userName, TwitterFactory tf, int pageNumber, int count) {
        Twitter twitter = tf.getInstance();
        try {
            List<Status> statuses;
            Paging page = new Paging (pageNumber, count);
            User user = twitter.showUser(userName);
            statuses = twitter.getUserTimeline(user.getId(), page);
            int tweetNumber = 1;
            for (Status status : statuses) {
                System.out.println(tweetNumber + " @" + status.getUser().getScreenName() + " - " + status.getText());
                tweetNumber++;
            }
        } catch (TwitterException te) {
            te.printStackTrace();
            System.out.println("Failed to get timeline: " + te.getMessage());
            System.exit(-1);
        }
    }
}