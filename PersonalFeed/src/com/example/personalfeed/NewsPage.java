package com.example.personalfeed;

import android.app.Activity;
import android.os.Bundle;
import android.widget.GridLayout;
import android.widget.LinearLayout;

public class NewsPage extends Activity {
	private GridLayout gridLayout;
	private static LinearLayout mainLayout1;
	private static LinearLayout mainLayout2;
	private static LinearLayout mainLayout3;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.news_page);
		
		gridLayout = (GridLayout) findViewById(R.id.GridLayout1);
		
		
		
		InflatedViewForNewsPage inflatedNewsView = new InflatedViewForNewsPage(
				getApplicationContext());
		

		gridLayout.addView(inflatedNewsView.inflator(getApplicationContext()));
		gridLayout.addView(inflatedNewsView.inflator(getApplicationContext()));
		gridLayout.addView(inflatedNewsView.inflator(getApplicationContext()));
		gridLayout.addView(inflatedNewsView.inflator(getApplicationContext()));
		
		

	}

}
