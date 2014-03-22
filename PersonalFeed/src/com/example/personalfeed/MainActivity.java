package com.example.personalfeed;

import java.util.ArrayList;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.Color;
import android.graphics.Typeface;
import android.text.Spannable;
import android.text.style.ForegroundColorSpan;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.TextView.BufferType;

public class MainActivity extends Activity {
	public static ListView personalityListView;

	String[] values = new String[] { "Student", "Trader" };

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		setDesign();
		setWebView();

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	private void setDesign() {
		TextView PerFeed = (TextView) findViewById(R.id.PerFeed);

	}

	private void setWebView() {
		Button logginWithTwitter = (Button) findViewById(R.id.logginWithTwitter);
		 
		logginWithTwitter.setOnClickListener(new OnClickListener() {
 
		  @Override
		  public void onClick(View arg0) {
		    Intent intent = new Intent(MainActivity.this, LogginWithTwitter.class);
		    startActivity(intent);
		  }
 
		});
		
	}
}
