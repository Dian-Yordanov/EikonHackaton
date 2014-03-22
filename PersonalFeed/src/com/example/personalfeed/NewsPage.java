package com.example.personalfeed;

import android.app.Activity;
import android.os.Bundle;
import android.widget.LinearLayout;

public class NewsPage extends Activity {
	private static LinearLayout mainLayout;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.news_page);
		mainLayout = (LinearLayout) findViewById(R.id.inflatedNewsLayout);

		InflatedViewForNewsPage inflatedNewsView = new InflatedViewForNewsPage(
				getApplicationContext());
		mainLayout.addView(inflatedNewsView.inflator(getApplicationContext()));

	}

}
