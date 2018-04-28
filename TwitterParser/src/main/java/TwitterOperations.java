import credentials.*;
import operations.*;
import twitter4j.TwitterFactory;
import twitter4j.TwitterStream;
import twitter4j.TwitterStreamFactory;
import twitter4j.conf.Configuration;
import twitter4j.conf.ConfigurationBuilder;

import java.util.Calendar;
import java.util.Date;

public class TwitterOperations {
    public static void main(String[] args) {
        PostTweet postTweet = new PostTweet();
        ParseTimeLine parseTimeline = new ParseTimeLine();
        SearchByExpression searchByExpression = new SearchByExpression();
        Stream stream = new Stream();
        ConfigMaker configMaker = new ConfigMaker();
        ConfigurationBuilder configurationBuilder = configMaker.buildConfig();
        Configuration config = configurationBuilder.build();
        TwitterFactory twitterFactory = new TwitterFactory(config);
        TwitterStream twitterStream = new TwitterStreamFactory(config).getInstance();
        TwitterOperations twitterOperations = new TwitterOperations();
        Date date = twitterOperations.setTime(Integer.parseInt(args[4]), Integer.parseInt(args[5]), Integer.parseInt(args[6]));

        // Post tweet
        postTweet.createTweet("tweet", twitterFactory);
        // Post timed tweet
         TimedTweet timedTweet = new TimedTweet(date, twitterFactory);
        // Get timeline of a user
        parseTimeline.getTimeLine(args[0], twitterFactory, Integer.parseInt(args[1]), Integer.parseInt(args[2]));
        // Search for an expression
        searchByExpression.search(args[3], twitterFactory, 25, true);
        // Get a stream of tweets
        stream.stream(twitterStream, "berlin", false);
    }

    public Date setTime(int hour, int minute, int second) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, hour);
        calendar.set(Calendar.MINUTE, minute);
        calendar.set(Calendar.SECOND, second);
        return calendar.getTime();
    }
}