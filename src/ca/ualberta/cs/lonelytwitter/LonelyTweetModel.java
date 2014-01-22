package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

public abstract class LonelyTweetModel
{
	private String text;
	private Date timestamp;
	protected boolean important;
	
	
	public String getText()
	{
	
		return text;
	}
	
	public abstract void setText(String text);
	public abstract int getImportant();
	

	
	public Date getTimestamp()
	{
	
		return timestamp;
	}
	
	public void setTimestamp(Date timestamp)
	{
	
		this.timestamp = timestamp;
	}

	public LonelyTweetModel(String text, Date timestamp)
	{

		super();
		this.text = text;
		this.timestamp = timestamp;
	}
	
	public LonelyTweetModel(String text)
	{

		super();
		this.text = text;
		this.timestamp = new Date();
	}
	
	@Override
	public String toString()
	{
		return timestamp.toString()+ " | " + text;
	}
	
}
