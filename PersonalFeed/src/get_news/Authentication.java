package get_news;

import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

import org.apache.commons.codec.binary.Base64;

public class Authentication {
	private String urlString;
	private String username;
	private String password;

	/**
	 * Constructor for the authentication procedure
	 * 
	 * @param u
	 *            URL
	 * @param l
	 *            Username
	 * @param p
	 *            Password
	 */
	public Authentication(String u, String l, String p) {
		urlString = u;
		username = l;
		password = p;
	}

	public HttpsURLConnection con() {
		HttpsURLConnection connection = null;
		try {
			URL url = new URL(urlString);
			connection = (HttpsURLConnection) url.openConnection();
			
			connection.setRequestProperty("Authorization", getB64Auth());
			connection.setRequestProperty("Accept", "application/json");
			connection.setRequestProperty("User-Agent", 
					"Mozilla/5.0 (Macintosh; Intel Mac OS X 10_9_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/33.0.1750.152 Safari/537.36");
			
//			System.err.println(connection.getResponseCode() + ": " + connection.getResponseMessage());
			
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return connection;
	}

	private String getB64Auth() {
		String cred = username + ":" + password;
		String auth = "Basic " + new String(Base64.encodeBase64(cred.getBytes()));
		return auth;
	}
}