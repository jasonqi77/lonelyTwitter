package ca.ualberta.cs.lonelytwitter;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Date;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.google.gson.Gson;

public class LonelyTwitterActivity extends Activity {

	private static final String FILENAME = "file7.sav";
	private EditText bodyText;
	private ListView oldTweetsList;
	private ArrayList<LonelyTweetModel> tweets;
	private ArrayAdapter<LonelyTweetModel> adapter;
	private Gson gson = new Gson();
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		bodyText = (EditText) findViewById(R.id.body);
		Button saveButton = (Button) findViewById(R.id.save);
		oldTweetsList = (ListView) findViewById(R.id.oldTweetsList);

		saveButton.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
				setResult(RESULT_OK);
				String text = bodyText.getText().toString();
				NormalTweetModel tweet = new NormalTweetModel (text);
				saveInFile(tweet);
				tweets.add(tweet);
				adapter.notifyDataSetChanged();

			}
		});
	}

	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
		loadFromFile();
		adapter = new ArrayAdapter<LonelyTweetModel>(this,
				R.layout.list_item, tweets);
		oldTweetsList.setAdapter(adapter);
	}

	private void loadFromFile() {
        tweets = new ArrayList<LonelyTweetModel>();
        //formattedText = new ArrayList<String>();
        try {
                FileInputStream fis = openFileInput(FILENAME);
                BufferedReader in = new BufferedReader(new InputStreamReader(fis));
                String line = in.readLine();
                while (line != null) {
                        System.out.println(line);
                        LonelyTweetModel json = gson.fromJson(line, NormalTweetModel.class);
                        tweets.add(json);
                        //formattedText.add(tweetView.formatTweet(json));
                        line = in.readLine();
                }

        } catch (FileNotFoundException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
        } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
        }
}
	
	private void saveInFile(LonelyTweetModel tweet) {
		try {
			FileOutputStream fos = openFileOutput(FILENAME,
					Context.MODE_APPEND);
			BufferedWriter out = new BufferedWriter(new OutputStreamWriter(fos));
			String json = gson.toJson(tweet);
			//fos.write(new String(date.toString() + " | " + text)
				//	.getBytes());
			out.write(json+ "\n");
			out.close();
			fos.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}