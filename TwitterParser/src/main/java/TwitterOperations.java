import credentials.*;
import operations.*;
import twitter4j.TwitterFactory;
import twitter4j.TwitterStream;
import twitter4j.TwitterStreamFactory;
import twitter4j.conf.Configuration;
import twitter4j.conf.ConfigurationBuilder;

import java.io.IOException;

public final class TwitterOperations {
    public static void main(String[] args) {
        ParseCredentials parseCredentials = new ParseCredentials();
        Credentials credentials = parseCredentials.read();
        PostTweet postTweet = new PostTweet();
        ParseTimeLine parseTimeline = new ParseTimeLine();
        SearchByExpression searchByExpression = new SearchByExpression();
        Stream stream = new Stream();

        ConfigurationBuilder cb = new ConfigurationBuilder();
        cb.setDebugEnabled(true)
                .setOAuthConsumerKey(credentials.getConsumerKey())
                .setOAuthConsumerSecret(credentials.getConsumerSecret())
                .setOAuthAccessToken(credentials.getAccessToken())
                .setOAuthAccessTokenSecret(credentials.getAccessTokenSecret())
                .setTweetModeExtended(true);
        Configuration config = cb.build();
        TwitterFactory tf = new TwitterFactory(config);
        TwitterStream twitterStream = new TwitterStreamFactory(config).getInstance();

        //postTweet.createTweet("tweet", tf);
        //parseTimeline.getTimeLine(args[0], tf, Integer.parseInt(args[1]), Integer.parseInt(args[2]));
        //searchByExpression.search(args[3], tf, 50);
        stream.stream(twitterStream, "berlin");
    }
}