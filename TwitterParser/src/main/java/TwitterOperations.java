import credentials.*;
import operations.*;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

public final class TwitterOperations {
    public static void main(String[] args) {
        ParseCredentials parseCredentials = new ParseCredentials();
        Credentials credentials = parseCredentials.read();
        PostTweet postTweet = new PostTweet();
        ParseTimeLine parseTimeline = new ParseTimeLine();

        ConfigurationBuilder cb = new ConfigurationBuilder();
        cb.setDebugEnabled(true)
                .setOAuthConsumerKey(credentials.getConsumerKey())
                .setOAuthConsumerSecret(credentials.getConsumerSecret())
                .setOAuthAccessToken(credentials.getAccessToken())
                .setOAuthAccessTokenSecret(credentials.getAccessTokenSecret());
        TwitterFactory tf = new TwitterFactory(cb.build());

        postTweet.createTweet("tweet", tf);
        parseTimeline.getTimeLine(args[0], tf, Integer.parseInt(args[1]), Integer.parseInt(args[2]));
    }
}