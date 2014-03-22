package com.example.personalfeed;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

public class InflatedViewForNewsPage extends LinearLayout {
	public static View inflatedViewNews;
	public static LayoutInflater newsView;
	public static LinearLayout mainLayout;

	public InflatedViewForNewsPage(Context context) {
		super(context);
	}

	public View inflator(Context context) {

		newsView = LayoutInflater.from(getContext());

		inflatedViewNews = newsView.inflate(
				R.layout.view_for_inflating_news, mainLayout, false);
		return inflatedViewNews;

	}
}
