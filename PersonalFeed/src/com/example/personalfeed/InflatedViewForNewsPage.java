package com.example.personalfeed;

import java.util.ArrayList;

import com.novoda.imageloader.core.util.DirectLoader;

import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.AsyncTask;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class InflatedViewForNewsPage extends LinearLayout {
	public static View inflatedViewNews;
	public static LayoutInflater newsView;
	public static LinearLayout mainLayout;
	static ImageView newsPicture;
	
	
	public static String urlForPictureForThread;

	public InflatedViewForNewsPage(Context context) {
		super(context);
	}

	public View inflator(Context context, String urlForPicture, String title) {
		urlForPictureForThread = urlForPicture;

		newsView = LayoutInflater.from(getContext());
		inflatedViewNews = newsView.inflate(R.layout.view_for_inflating_news,
				mainLayout, false);
		newsPicture = (ImageView) inflatedViewNews
				.findViewById(R.id.newsImageView);

		TextView textView1 = (TextView) inflatedViewNews
				.findViewById(R.id.newsTextView);
		textView1.setBackgroundColor(Color.rgb(62, 62, 62));

		LayoutParams paramsExample = new LayoutParams(
				MainActivity.width * 42 / 100, 80, 1.0f);
		paramsExample.setMargins(10, 0, 0, 0);

		AssetManager mngr = getContext().getAssets();
		Typeface face = Typeface.createFromAsset(mngr,
				"fonts/helveticaneue-webfont.ttf");
		textView1.setTypeface(face);

		textView1.setLayoutParams(paramsExample);
		textView1.setTextColor(Color.rgb(255, 168, 0));
		textView1.setTextSize(11);

		if (title.length() > 50) {
			title = title.substring(0, 50) + "...";
		}

		textView1.setText(title);

		textView1.setPadding(8, 13, 5, 0);
		new ImageLoaderTask().execute(urlForPictureForThread, newsPicture);
		return inflatedViewNews;

	}

	public View inflator(Context context, String urlForPicture, String title, String className){
		urlForPictureForThread = urlForPicture;
		final String className1 = className;
		
		newsView = LayoutInflater.from(getContext());
		inflatedViewNews = newsView.inflate(R.layout.view_for_inflating_news,
				mainLayout, false);
		newsPicture = (ImageView) inflatedViewNews
				.findViewById(R.id.newsImageView);
		
		newsPicture.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
		
				Intent intent = new Intent(getContext(), ArticleView.class);
				intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
				getContext().startActivity(intent); 
			}

		});

		TextView textView1 = (TextView) inflatedViewNews
				.findViewById(R.id.newsTextView);
		textView1.setBackgroundColor(Color.rgb(62, 62, 62));

		LayoutParams paramsExample = new LayoutParams(
				MainActivity.width * 42 / 100, 80, 1.0f);
		paramsExample.setMargins(10, 0, 0, 0);

		AssetManager mngr = getContext().getAssets();
		Typeface face = Typeface.createFromAsset(mngr,
				"fonts/helveticaneue-webfont.ttf");
		textView1.setTypeface(face);

		textView1.setLayoutParams(paramsExample);
		textView1.setTextColor(Color.rgb(255, 168, 0));
		textView1.setTextSize(11);

		if (title.length() > 50) {
			title = title.substring(0, 50) + "...";
		}

		textView1.setText(title);

		textView1.setPadding(8, 13, 5, 0);
		new ImageLoaderTask().execute(urlForPictureForThread, newsPicture);
		return inflatedViewNews;

	}

	protected class ImageLoaderTask extends AsyncTask<Object, Void, Bitmap> {
		String urlEndAwayString;
		ImageView hostTeam;
		Bitmap resizedBitmapFlag;

		@Override
		protected Bitmap doInBackground(Object... params) {
			urlEndAwayString = (String) params[0];
			hostTeam = (ImageView) params[1];

			Bitmap b = new DirectLoader().download(urlEndAwayString);

			resizedBitmapFlag = Bitmap.createScaledBitmap(b,MainActivity.width * 42 / 100, 250, true);
			return resizedBitmapFlag;
		}

		@Override
		protected void onPostExecute(Bitmap result) {
			hostTeam.setImageBitmap(resizedBitmapFlag);
		}

	}

}
