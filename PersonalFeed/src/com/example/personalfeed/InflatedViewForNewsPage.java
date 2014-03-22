package com.example.personalfeed;

import java.util.ArrayList;

import android.content.Context;
import android.graphics.Bitmap;
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

	public View inflator(Context context) {

		newsView = LayoutInflater.from(getContext());		
		inflatedViewNews = newsView.inflate(
				R.layout.view_for_inflating_news, mainLayout, false);
		setPicture();
		
		
		return inflatedViewNews;

		
	}
	private void setPicture(){
		newsPicture = (ImageView) inflatedViewNews.findViewById(R.id.newsImageView);			
		resizedBitmapFlag = Bitmap.createScaledBitmap(ImageDownloader.loadBitmap("http://i.telegraph.co.uk/multimedia/archive/01711/Google_1711397c.jpg")
				, MainActivity.width/2, 300, true);
		newsPicture.setImageBitmap(resizedBitmapFlag);
	}
}
