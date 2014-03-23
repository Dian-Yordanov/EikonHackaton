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
import android.widget.Button;
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
		

		Button shareOnTwitter = (Button) findViewById(R.id.shareOnTwitter);
		
		shareOnTwitter.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {

				String url = "https://twitter.com/intent/tweet?source=webclient&text=TWEET+THIS!";
				Intent i = new Intent(Intent.ACTION_VIEW);
				i.setData(Uri.parse(url));
				startActivity(i);
			}

		});

		
	}

}
