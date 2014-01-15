package ca.ualberta.cs.lonelytwitter;



public class ConcreteTweetView implements TweetView
{

	public String formatTweet(LonelyTweetModel lt)
	{

		// TODO Auto-generated method stub
		return lt.getTimestamp().toString()+" | " + lt.getText();
	}

}
