package model;

import java.util.ArrayList;

public class GoodNews {
	private ArrayList<String> keywords;
	
	public GoodNews(ArrayList<String> keywords) {
		this.keywords = keywords;
	}
	
	public boolean isGoodNews(String headline, String body) {
		for (String str : keywords) {
			if (headline.contains(str) || body.contains(str)) {
				return true;
			}
		}
		return false;
	}
}
