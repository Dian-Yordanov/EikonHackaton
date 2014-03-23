package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import twitter4j.HashtagEntity;
import twitter4j.ResponseList;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.User;
import twitter4j.auth.RequestToken;
import twitter4j.conf.ConfigurationBuilder;

import com.google.common.primitives.Longs;

/**
 * Twitter class for connection to twitter.com and authorize the app for sending
 * tweets.
 * 
 * @see Twitter
 * @author Alex Telek
 * @version 2.6, 21/3/2014
 */
public class TwitterModel {
	private Twitter twitter;
	private ConfigurationBuilder cb;
	private RequestToken requestToken;
	private Map<String, ArrayList<String>> followingData;

	/**
	 * Constructor of the class. It configure the application with the consumer
	 * key and the consumer secret key
	 * 
	 * @see ConfigurationBuilder
	 */
	public TwitterModel() {
		followingData = new HashMap<String, ArrayList<String>>();
		cb = new ConfigurationBuilder();
		// the following is set without accesstoken- desktop client
		cb.setDebugEnabled(true)
				.setOAuthConsumerKey("HXiyIBf5VSf9H9KrCvBkg")
				.setOAuthConsumerSecret(
						"aICj6oqqLY5T0kHuAkMe8SFaw4aiqByCBKoEBGQBg");
	}

	/**
	 * Initialize method, which create the connection between the user and the
	 * twitter It will set the <code>requestToken</code>, which will give us an
	 * authorization link
	 * 
	 * @throws TwitterException
	 *             if the requestToken cannot be retrieved due to Internet
	 *             connection
	 */
	public void initialise() throws TwitterException {
		try {
			twitter = new TwitterFactory(cb.build()).getInstance();
			requestToken = twitter.getOAuthRequestToken();
		} catch (IllegalStateException ie) {
			// It's a error when the consumer key/secret is not valid, but it is
			// already set
		}
	}

	/**
	 * Tweet method for getting the accessToken, using the requestToken and the
	 * retrieved pin. It also sends the tweet.
	 * 
	 * @param status
	 *            The new status message that will be send
	 * @param pin
	 *            The PIN from the website, its for the authentication
	 * @throws TwitterException
	 *             If the pin is invalid
	 */
	public void tweet(String status, String pin) throws TwitterException {
		if (pin.length() > 0) {
			twitter.getOAuthAccessToken(requestToken, pin);
		} else {
			twitter.getOAuthAccessToken(requestToken);
		}
		twitter.updateStatus(status);
	}

	public Map<String, ArrayList<String>> fetchUsersFriends()
			throws TwitterException {
		int start = 0;
		int finish = 100;
		ArrayList<Long> IDS = new ArrayList<Long>();
		long[] friendsID = twitter.getFriendsIDs(twitter.getId(), -1).getIDs();
		boolean check = true;
		while (check) {
			for (int i = start; i < finish; i++) {
				// get first 100
				IDS.add(friendsID[i]);
				// if at the end, stop
				if (friendsID.length - 1 == i) {
					check = false;
					break;
				}
			}
			// set values for next 100
			start = start + 100;
			finish = finish + 100;
			long[] ids = Longs.toArray(IDS);
			ResponseList<User> userName = twitter.lookupUsers(ids);
			// clear so long[] holds max 100 at any given time
			IDS.clear();
			for (User u : userName) {
				ArrayList<String> names = new ArrayList<String>();
				names.add(String.valueOf(u.getId()));
				names.add(u.getScreenName());
				names.add(u.getURL());
				names.add(u.getLocation());
				names.add(u.getDescription());
				names.add(u.getStatus().getText());
				followingData.put(u.getName(), names);
			}
		}
		return followingData;
	}

	public ArrayList<String> getFriendsTimeline(String[] usernames) {
		ArrayList<String> wordToMatch = new ArrayList<String>();
		try {
			ResponseList<User> users = twitter.lookupUsers(usernames);
			for (User user : users) {
				if (user.getStatus() != null) {
					List<Status> statuses = twitter.getUserTimeline(user.getId());
					for (Status status3 : statuses) {
						for (HashtagEntity hashtagEntity : status3.getHashtagEntities()) {
							if (wordToMatch.contains(hashtagEntity.getText())) {
								break;
							}
							wordToMatch.add(hashtagEntity.getText());
						}
					}
				}
			}
		} catch (TwitterException exc) {}
		return wordToMatch;
	}

	public void setPin(String pin) throws TwitterException {
		if (pin.length() > 0) {
			twitter.getOAuthAccessToken(requestToken, pin);
		} else {
			twitter.getOAuthAccessToken(requestToken);
		}
	}

	/**
	 * Getting the url address for the authentication
	 * 
	 * @return URL the url for the authentication and getting the pin
	 */
	public String getTwitterAuthorizationURL() {
		return requestToken.getAuthorizationURL();
	}
}
