package com.example.personalfeed;

import get_news.MainClass;
import get_news.NewsArticle;
import get_news.NewsArticleDetails;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import twitter4j.TwitterException;

import model.GoodNews;
import model.Personalize;
import model.TwitterModel;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;

public class TwitterActivity extends Activity {
	public static EditText getPin;
	public static Map<String, String> news;
	public static String TwitterID;

	public static TwitterModel twitter = new TwitterModel();

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.twitter_activity);
		StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder()
				.permitAll().build();
		StrictMode.setThreadPolicy(policy);
		
		WebView twitterwv = (WebView) findViewById(R.id.twitterLogginView);
		twitterwv.getSettings().setJavaScriptEnabled(true);
		twitterwv.setWebViewClient(new WebViewClient());

		getPin = (EditText) findViewById(R.id.writeID);

		Button settupID = (Button) findViewById(R.id.settupId);
		try {
			twitter.initialise();
			// Scanner scan = new Scanner(System.in);

			
			TwitterID = twitter.getTwitterAuthorizationURL();
			twitterwv.loadUrl(TwitterID);

			Log.v("idTwitter", twitter.getTwitterAuthorizationURL());
			
			// String pin = scan.nextLine();
			// TODO

			// scan.close();

		} catch (twitter4j.TwitterException e) {
			e.printStackTrace();
		}
	settupID.setOnClickListener(new OnClickListener() {
		@Override
		public void onClick(View arg0) {
				try {
			twitter.setPin(getPin.getText().toString());
			} catch (TwitterException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			twitterIntegration();
			Log.v("map",news.keySet().toString());
			Intent intent = new Intent(getBaseContext(),
					NewsPage.class);
			startActivity(intent);
		}
		
		});

	}

	private static void twitterIntegration() {

		Personalize personalize;

		Map<String, ArrayList<String>> friendList;
		try {
			friendList = twitter.fetchUsersFriends();
			personalize = new Personalize(friendList);
			String[] usernames = personalize.getPersonalizedUserNames();
			ArrayList<String> wordsToMatch = twitter
					.getFriendsTimeline(usernames);

			GoodNews processNews = new GoodNews(wordsToMatch);
			ArrayList<NewsArticle> alNAL = MainClass.getNews();
			NewsArticleDetails nad;
			ArrayList<NewsArticleDetails> articles = new ArrayList<NewsArticleDetails>();

			for (NewsArticle nal : alNAL) {
				nad = MainClass.getOneNews(nal.getUniqueIdentifier());
				articles.add(nad);
			}
			System.out.println(articles.size());
			news = new HashMap<String, String>();
			for (int i = 0; i < articles.size(); i++) {
				String headLine = articles.get(i).getHeadline();
				String body = articles.get(i).getContent();
				if (processNews.isGoodNews(headLine, body)) {
					news.put(headLine, body);
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	
}