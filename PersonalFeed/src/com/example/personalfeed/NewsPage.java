package com.example.personalfeed;

import java.util.ArrayList;

import com.novoda.imageloader.core.util.DirectLoader;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class NewsPage extends Activity {
	private GridLayout gridLayout;
	public static Bitmap b;
	static Bitmap resizedBitmapFlag;

	ArrayList<String> url = new ArrayList<String>();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.news_page);

		url.add("http://i.imgur.com/yBwDaKV.jpg?1");
		
		
		gridLayout = (GridLayout) findViewById(R.id.GridLayout1);

		ImageView pfheader = (ImageView) findViewById(R.id.pfheader);
		Bitmap header = BitmapFactory.decodeResource(getBaseContext()
				.getResources(), R.drawable.pfheader);
		Bitmap resizedBitmapFlag = Bitmap.createScaledBitmap(header,
				MainActivity.width * 42 / 100, 60, true);
		pfheader.setImageBitmap(resizedBitmapFlag);

		InflatedViewForNewsPage inflatedNewsView = new InflatedViewForNewsPage(
				getApplicationContext());
		gridLayout.addView(inflatedNewsView.inflator(getApplicationContext(),
				"One of the coolest looking dogs I've ever seen."));

		 gridLayout.addView(inflatedNewsView.inflator(getApplicationContext(),
		 "An adorable skulk of foxes."));
		// gridLayout.addView(inflatedNewsView.inflator(getApplicationContext(),"http://i.imgur.com/yBwDaKV.jpg?1","Such Fashions. Very Stylish. Wow."));
		// gridLayout.addView(inflatedNewsView.inflator(getApplicationContext(),"http://thomsonreuters.com/images/300x225/RTR2HYXY-SIU.jpg","Technology and regulatory strain: Where's your breaking point?"));
		// gridLayout.addView(inflatedNewsView.inflator(getApplicationContext(),"http://thomsonreuters.com/images/300x225/RTR2JBUQ.jpg","Igniting worldwide policy debate of the digital economy"));
		// gridLayout.addView(inflatedNewsView.inflator(getApplicationContext(),"http://thomsonreuters.com/images/300x225/RTR3A44H.jpg","Latest Ones to Watch report provides a sneak peek into the pharmaceutical drug pipeline"));
		// gridLayout.addView(inflatedNewsView.inflator(getApplicationContext(),"http://thomsonreuters.com/images/300x225/RTR2M3AI.jpg","Helping our customers adapt to a changing market"));
		// gridLayout.addView(inflatedNewsView.inflator(getApplicationContext(),"http://thomsonreuters.com/images/300x225/beatles.jpg","Celebrating 50 years of Beatlemania with \"Fab Four\"-related scholarly works"));
		// gridLayout.addView(inflatedNewsView.inflator(getApplicationContext(),"http://thomsonreuters.com/images/misc-img/copd-infographic.jpg","Research shows greater focus on preventative therapies for COPD treatment"));
		// gridLayout.addView(inflatedNewsView.inflator(getApplicationContext(),"http://thomsonreuters.com/images/300x225/RTX155U51.jpg","Disruptive forces ahead for law firm market"));

	}

	@Override
	protected void onResume() {
		super.onResume();
		/**
		 * TODO Don't use the direct loader like this. It's useful for
		 * downloading a Bitmap to display in a notification. You need to handle
		 * the threading yourself.
		 */
		new Thread() {
			@Override
			public void run() {
				String urlStart = url.get(0);
				b = new DirectLoader().download(urlStart);
				setImageView(b);

			}
		}.start();
	}

	public void setImageView(final Bitmap bitmap) {
		runOnUiThread(new Runnable() {
			@Override
			public void run() {
				resizedBitmapFlag = Bitmap.createScaledBitmap(b,
						MainActivity.width * 42 / 100, 250, true);

				InflatedViewForNewsPage.setPicture().setImageBitmap(resizedBitmapFlag);

			}
		});
	}

}
