package model;

public class RegularExpression {
	private static final String[] keywords = {"news", "breaking news",
			"report", "journalist", "top news", "technology", "apple",
			"president", "businesses", "alert", "analysis", "features", "sport",
			"explore", "discover", "stories", "breaking", "daily", "headline",
			"information", "news feed", "finance", "trade", "stock", "crash",
			"stock market", "international news", "president", "embassy", "minister", "government"};

	public RegularExpression() {
	}

	public boolean getMatches(String toMatch) {
		for (String str : keywords) {
			if ((toMatch.toLowerCase()).contains(str)) {
				return true;
			}
		}
		return false;
	}
}
