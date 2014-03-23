package get_news;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import javax.net.ssl.HttpsURLConnection;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class MainClass {
	private static HttpsURLConnection connection;
	private static String fetchURL;
	private static String getURL;
	
	/**
	 * Method to get the list of news articles
	 * @return the list of news articles returned by the HTTPS request
	 * @throws IOException
	 */
	public static ArrayList<NewsArticle> getNews() throws IOException {
		String[] fetchFields = {"uniqueIdentifier", "headline"};
		String[] fetchLang = {"en", "id"};
		String[] fetchMax = {"10", "20", "50", "100"};
		fetchURL = "https://amers1.mobile13.cp.reutest.com/msf1.0/data/NewsArticles?$select=";

		for (String field : fetchFields) {
			fetchURL += field + ",";
		}
		
		fetchURL += "&$filter=Request/HeadlineLang%20eq%20%27" + fetchLang[0] + "%27";
		fetchURL += "&$top=" + fetchMax[0];
		
		Authentication auth = new Authentication(fetchURL,
				"eikonhack12@thomsonreuters.com", 
				"Password1");
		connection = auth.con();
		
		ArrayList<NewsArticle> listNews = new ArrayList<NewsArticle>();

		InputStream results = (InputStream) connection.getInputStream();
		BufferedReader br = new BufferedReader(new InputStreamReader(results));

		JSONParser parser = new JSONParser();
		try {
			Object obj = parser.parse(br);
			JSONObject jsonObject = (JSONObject) obj;

			JSONArray d = (JSONArray) jsonObject.get("d");
			for (int i = 0; i < d.size(); ++i) {
				JSONObject ob = (JSONObject) d.get(i);
				String headline = (String) ob.get("headline");
				String id = (String) ob.get("uniqueIdentifier");
				listNews.add(new NewsArticle(id, headline));
			}
		} catch (ParseException e) {
//			Returns null as the error message - so technically no error
//			System.err.println(e.getMessage());
		}

		return listNews;
	}
	
	/**
	 * Method to get one piece of news
	 * @param i uniqueIdentifier of the news article
	 * @return the news article with it's basic details (headline & content)
	 * @throws IOException 
	 */
	public static NewsArticleDetails getOneNews(String id) throws IOException {
		String[] getFields = {"BodyType", "Headline", "StoryText"};
		getURL = "https://amers1.mobile13.cp.reutest.com/msf1.0/data/NewsArticlesDetails?$select=";
		
		for (String field : getFields) {
			getURL += field + ",";
		}
		
		getURL += "&$filter=Request/StoryId%20eq%20%27" + id + "%27";
		
		Authentication auth = new Authentication(getURL,
				"eikonhack12@thomsonreuters.com", 
				"Password1");
		connection = auth.con();
		
		NewsArticleDetails oneNews = null;
		
		InputStream results = (InputStream) connection.getInputStream();
		BufferedReader br = new BufferedReader(new InputStreamReader(results));
		
		JSONParser parser = new JSONParser();
		try {
			Object o = parser.parse(br);
			JSONObject jsonObject = (JSONObject) o;
			JSONArray d = (JSONArray) jsonObject.get("d");
			
			// There is only one entry returned by the HTTPS request
			// because we used the uniqueIdentifier to get the article.
			// For this reason, we are free to use ".get(0)" to get one news.
			JSONObject obj = (JSONObject) d.get(0);
			String Id = (String) obj.get("Id");
			String Headline = (String) obj.get("Headline");
			String StoryText = (String) obj.get("StoryText");
			
			oneNews = new NewsArticleDetails(Id, Headline, StoryText);
		} catch (ParseException e) {
//			Returns null as the error message - so technically no error
//			System.err.println(e.getMessage());
		}
		
		return oneNews;
	}

	public static void main(String[] args) throws IOException {
		ArrayList<NewsArticle> alNAL = getNews();
		NewsArticleDetails nad;
		ArrayList<NewsArticleDetails> articles = new ArrayList<NewsArticleDetails>();
		
		for (NewsArticle nal : alNAL) {
			nad = getOneNews(nal.getUniqueIdentifier());
			articles.add(nad);
		}
	}
}
