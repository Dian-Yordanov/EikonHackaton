package com.example.personalfeed;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class NewsPage extends Activity {
	private GridLayout gridLayout;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.news_page);

		gridLayout = (GridLayout) findViewById(R.id.GridLayout1);

		ImageView pfheader = (ImageView) findViewById(R.id.pfheader);
		Bitmap header = BitmapFactory.decodeResource(getBaseContext()
				.getResources(), R.drawable.pfheader);
		Bitmap resizedBitmapFlag = Bitmap.createScaledBitmap(header,
				MainActivity.width * 42 / 100, 60, true);
		pfheader.setImageBitmap(resizedBitmapFlag);
		
		
		
		InflatedViewForNewsPage inflatedNewsView = new InflatedViewForNewsPage(
				getApplicationContext());

		gridLayout.addView(inflatedNewsView.inflator(getApplicationContext()));
		gridLayout.addView(inflatedNewsView.inflator(getApplicationContext()));
		gridLayout.addView(inflatedNewsView.inflator(getApplicationContext()));
		gridLayout.addView(inflatedNewsView.inflator(getApplicationContext()));
		gridLayout.addView(inflatedNewsView.inflator(getApplicationContext()));
		gridLayout.addView(inflatedNewsView.inflator(getApplicationContext()));
		gridLayout.addView(inflatedNewsView.inflator(getApplicationContext()));
		gridLayout.addView(inflatedNewsView.inflator(getApplicationContext()));
		gridLayout.addView(inflatedNewsView.inflator(getApplicationContext()));
		gridLayout.addView(inflatedNewsView.inflator(getApplicationContext()));
		gridLayout.addView(inflatedNewsView.inflator(getApplicationContext()));
		gridLayout.addView(inflatedNewsView.inflator(getApplicationContext()));
	}

}
