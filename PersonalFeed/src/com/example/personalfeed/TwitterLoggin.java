package com.example.personalfeed;
import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;
 
public class TwitterLoggin extends Activity {
 
	private WebView webView;
 
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.twitter_loggin);
 
		WebView webView = (WebView) findViewById(R.id.twitterWebView);
		webView.getSettings().setJavaScriptEnabled(true);
		webView.loadUrl("https://twitter.com/");
 
	}
 
}