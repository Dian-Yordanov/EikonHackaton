package com.example.personalfeed;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Point;
import android.os.Bundle;
import android.view.Display;
import android.widget.ImageView;
import android.widget.TextView;

public class ArticleView  extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.article_view);
		

		ImageView pfheader = (ImageView) findViewById(R.id.pfheader);
		Bitmap header = BitmapFactory.decodeResource(getBaseContext()
				.getResources(), R.drawable.pfheader);
		Bitmap resizedBitmapFlag = Bitmap.createScaledBitmap(header,
				MainActivity.width * 42 / 100, 60, true);
		pfheader.setImageBitmap(resizedBitmapFlag);
		
		TextView articleText = (TextView) findViewById(R.id.articleText);

		articleText.setText(getString(R.string.articleText));
		
		ImageView headerPicture = (ImageView) findViewById(R.id.headerPicture);
		Bitmap downloadedBitmap = ImageDownloader.loadBitmap("http://s1.reutersmedia.net/resources/r/?m=02&d=20140322&t=2&i=868234325&w=&fh=&fw=&ll=580&pl=378&r=CBREA2L0XVV00");
		downloadedBitmap = Bitmap.createScaledBitmap(downloadedBitmap,
				MainActivity.width * 42 / 100, 250, true);
		headerPicture.setImageBitmap(downloadedBitmap);
		
	}

}
