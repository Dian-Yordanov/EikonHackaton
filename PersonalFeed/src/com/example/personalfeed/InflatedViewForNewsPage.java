package com.example.personalfeed;

import java.util.ArrayList;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class InflatedViewForNewsPage extends LinearLayout {
	public static View inflatedViewNews;
	public static LayoutInflater newsView;
	public static LinearLayout mainLayout;
	ImageView newsPicture;
	Bitmap resizedBitmapFlag;

	public InflatedViewForNewsPage(Context context) {
		super(context);
	}

	public View inflator(Context context, String urlForPicture, String title) {

		newsView = LayoutInflater.from(getContext());
		inflatedViewNews = newsView.inflate(R.layout.view_for_inflating_news,
				mainLayout, false);
		setPicture(urlForPicture);
		
		TextView textView1 = (TextView) inflatedViewNews
				.findViewById(R.id.newsTextView);
		textView1.setBackgroundColor(Color.rgb(62, 62, 62));

		LayoutParams paramsExample = new LayoutParams(
				MainActivity.width * 42 / 100, 80, 1.0f);
		 paramsExample.setMargins(10,0,0,0);
		    
		textView1.setLayoutParams(paramsExample);
		textView1.setTextColor(Color.rgb(255, 168, 0));
		textView1.setText(title);
		
	   
		return inflatedViewNews;

	}

	private void setPicture(String urlForPicture) {
		newsPicture = (ImageView) inflatedViewNews
				.findViewById(R.id.newsImageView);
		resizedBitmapFlag = Bitmap
				.createScaledBitmap(
						ImageDownloader
								.loadBitmap(urlForPicture),
						MainActivity.width * 42 / 100, 250, true);
		newsPicture.setImageBitmap(resizedBitmapFlag);
	}
}
