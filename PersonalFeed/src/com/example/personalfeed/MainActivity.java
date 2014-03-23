package com.example.personalfeed;

import get_news.MainClass;
import get_news.NewsArticle;
import get_news.NewsArticleDetails;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import model.GoodNews;
import model.Personalize;
import model.TwitterModel;

import android.net.Uri;
import android.os.Bundle;
import android.os.StrictMode;
import android.app.Activity;
import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.Typeface;
import android.text.Spannable;
import android.text.style.ForegroundColorSpan;
import android.util.Log;
import android.view.Display;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.TextView.BufferType;

public class MainActivity extends Activity {
	public static ListView personalityListView;

	String[] values = new String[] { "Student", "Trader" };
	public static int width;
	public static int height;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		Display display = getWindowManager().getDefaultDisplay();
		Point size = new Point();
		display.getSize(size);
		width = size.x;
		height = size.y;
		
		
		
		

		
		setWebView();
		setDesignOfThePictures();

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	private void setWebView() {
		Button logginWithoutTwitter = (Button) findViewById(R.id.logginWithoutTwitter);
		logginWithoutTwitter.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				Intent intent = new Intent(MainActivity.this,
						NewsPage.class);
				startActivity(intent);
			}

		});

		
		Button logginWithTwitter = (Button) findViewById(R.id.logginWithTwitter);
		logginWithTwitter.setBackground(getResources().getDrawable(
				R.drawable.logintotwitter));

		logginWithTwitter.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				Intent intent = new Intent(MainActivity.this,
						TwitterActivity.class);
				startActivity(intent);
			}

		});

	}

	private void setDesignOfThePictures() {

		TextView perFeed = (TextView) findViewById(R.id.PerFeed);
		TextView yourPersonalizedNewsFeed = (TextView) findViewById(R.id.yourPersonalizedNewsFeed);
		TextView orLayble = (TextView) findViewById(R.id.orLayble);

		perFeed.setBackground(getResources().getDrawable(R.drawable.perfeed));

	}
	
}
