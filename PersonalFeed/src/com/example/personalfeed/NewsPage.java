package com.example.personalfeed;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
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

		for (final String key : TwitterActivity.news.keySet()) {
			View newView = new View(getBaseContext());
			newView = inflatedNewsView
					.inflator(
							getApplicationContext(),
							"http://s1.reutersmedia.net/resources/r/?m=02&d=20140322&t=2&i=868234325&w=&fh=&fw=&ll=700&pl=378&r=CBREA2L0XVV00",
							key);

		
			newView.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View arg0) {
					// ArticleView.webAddress = webViewaddress;
					Log.v("gggggsddffga", key + "ffedfgvvfdss");

				}

			});
			gridLayout.addView(newView);

		}

	}

}
