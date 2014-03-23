package get_news;

public class NewsArticleDetails {
	private String uniqueIdentifier;
	private String headline;
	private String content;
	
	public NewsArticleDetails(String i, String h, String c) {
		uniqueIdentifier = i;
		headline = h;
		content = c;
	}
	
	public String getId() {
		return uniqueIdentifier;
	}
	
	public void setId(String id) {
		this.uniqueIdentifier = id;
	}
	
	public String getHeadline() {
		return headline;
	}
	
	public void setHeadline(String headline) {
		this.headline = headline;
	}
	
	public String getContent() {
		return content;
	}
	
	public void setContent(String content) {
		this.content = content;
	}
	
	@Override
	public String toString() {
		String s = "";
		s += "- - - - - - - - - - - - - - - START - - - - - - - - - - - - - - -\n";
		s += "HEADLINE: " + headline + "\n\n";
		s += "CONTENT: " + content + "\n";
		s += "- - - - - - - - - - - - - - - END - - - - - - - - - - - - - - -\n\n";
		return s;
	}
}
