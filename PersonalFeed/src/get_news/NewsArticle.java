package get_news;

public class NewsArticle {
	private String uniqueIdentifier;
	private String headline;
	
	public NewsArticle(String i, String h) {
		uniqueIdentifier = i;
		headline = h;
	}
	
	public String getHeadline() {
		return headline;
	}
	
	public String getUniqueIdentifier() {
		return uniqueIdentifier;
	}

	@Override
	public String toString() {
		String s = "";
		s += "- - - - - - - - - - - - - - - START - - - - - - - - - - - - - - -\n";
		s += "HEADLINE: " + uniqueIdentifier + "\n";
		s += "CONTENT: " + headline + "\n";
		s += "- - - - - - - - - - - - - - - END - - - - - - - - - - - - - - -\n\n";
		return s;
	}
}
