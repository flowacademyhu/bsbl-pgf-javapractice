package operations;

import twitter4j.*;

import java.util.ArrayList;

public class Stream {

    public void stream(TwitterStream twitterStream, String filter, boolean insertIntoDB) {
        ParseList parseList = new ParseList();
        ArrayList<String> dirtyWords = parseList.filteredWords();
        twitterStream.addListener(new StatusListener() {
            TweetsToDB tweetsToDB = new TweetsToDB();
            int tweetNumber = 1;
            @Override
            public void onStatus(Status status) {
                if(parseList.stringContainsItemFromList(status.getText(), dirtyWords)) {
                    System.out.println("SPAM");
                } else {
                    System.out.println(tweetNumber + " @" + status.getUser().getScreenName() + " - " + status.getText());
                    if(insertIntoDB) {
                        tweetsToDB.storeTweets(status);
                    }
                }
                tweetNumber++;
            }

            @Override
            public void onDeletionNotice(StatusDeletionNotice statusDeletionNotice) {
                System.out.println("Got a status deletion notice id:" + statusDeletionNotice.getStatusId());
            }

            @Override
            public void onTrackLimitationNotice(int numberOfLimitedStatuses) {
                System.out.println("Got track limitation notice:" + numberOfLimitedStatuses);
            }

            @Override
            public void onScrubGeo(long userId, long upToStatusId) {
                System.out.println("Got scrub_geo event userId:" + userId + " upToStatusId:" + upToStatusId);
            }

            @Override
            public void onStallWarning(StallWarning warning) {
                System.out.println("Got stall warning:" + warning);
            }

            @Override
            public void onException(Exception ex) {
                ex.printStackTrace();
            }
        });
        /*
        FilterQuery tweetFilterQuery = new FilterQuery();
        tweetFilterQuery.track(filter);
        tweetFilterQuery.language("de");
        twitterStream.filter(tweetFilterQuery);
        */
        twitterStream.sample("en");
    }
}
