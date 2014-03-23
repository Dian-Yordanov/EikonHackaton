//package main;
//
//import get_news.MainClass;
//import get_news.NewsArticle;
//import get_news.NewsArticleDetails;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.Map;
//import java.util.Scanner;
//
//import android.util.Log;
//
//import model.GoodNews;
//import model.Personalize;
//import model.TwitterModel;
//import twitter4j.TwitterException;
//
//public class Main {
//	public static void main(String[] args) {
//		TwitterModel twitter = new TwitterModel();
//		Personalize personalize;
//		try {
//			twitter.initialise();
//			//Scanner scan = new Scanner(System.in);
//			Log.v("id",twitter.getTwitterAuthorizationURL());
//			//String pin = scan.nextLine();
//			twitter.setPin(pin);
//			//scan.close();
//		} catch (TwitterException e) {
//			e.printStackTrace();
//		}
//		
//		Map<String, ArrayList<String>> friendList;
//		try {
//			friendList = twitter.fetchUsersFriends();
//			personalize = new Personalize(friendList);
//			String[] usernames = personalize.getPersonalizedUserNames();
//			ArrayList<String> wordsToMatch = twitter.getFriendsTimeline(usernames);
//			
//			GoodNews processNews = new GoodNews(wordsToMatch);
//			ArrayList<NewsArticle> alNAL = MainClass.getNews();
//			NewsArticleDetails nad;
//			ArrayList<NewsArticleDetails> articles = new ArrayList<NewsArticleDetails>();
//			
//			for (NewsArticle nal : alNAL) {
//				nad = MainClass.getOneNews(nal.getUniqueIdentifier());
//				articles.add(nad);
//			}
//			System.out.println(articles.size());
//			Map<String, String> news = new HashMap<String, String>();
//			for (int i = 0; i < articles.size(); i++) {
//				String headLine = articles.get(i).getHeadline();
//				String body = articles.get(i).getContent();
//				if (processNews.isGoodNews(headLine, body)) {
//					news.put(headLine, body);
//				}
//			}
//		} catch (Exception ex) {
//			ex.printStackTrace();
//		}
//	}
//}
