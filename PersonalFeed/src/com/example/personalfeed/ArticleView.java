package com.example.personalfeed;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Point;
import android.net.Uri;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class ArticleView extends Activity {
	public static TextView title;
	public static TextView body;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.article_view);

		title = (TextView) findViewById(R.id.title);
title.setText(getBaseContext().getResources().getString(R.string.title));



		body = (TextView) findViewById(R.id.body);

body.setText(getBaseContext().getResources().getString(R.string.articleText));


	}

}
