package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

public class importantTweetModel extends LonelyTweetModel
{

	public importantTweetModel(String text)
	{

		super(text);
		// TODO Auto-generated constructor stub
	}
	
	public importantTweetModel(String text, Date timestamp)
	{

		super(text,timestamp);
		// TODO Auto-generated constructor stub
	}

	
	public void setText(String text)
	{
	
		
	}

	@Override
	public int getImportant()
	{

		// TODO Auto-generated method stub
		return 1;
	}
}
