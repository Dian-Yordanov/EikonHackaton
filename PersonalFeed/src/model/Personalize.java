package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Personalize {
	private Map<String, ArrayList<String>> friendsList;
	private Map<String, ArrayList<String>> personalizedMap;
	private RegularExpression regex;
	
	public Personalize(Map<String, ArrayList<String>> friendsList) {
		this.friendsList = friendsList;
		regex = new RegularExpression();
	}
	
	private void getPersonalizedFriendsList() {
		personalizedMap = new HashMap<String, ArrayList<String>>();
		for (String name : friendsList.keySet()) {
			ArrayList<String> tmp = friendsList.get(name);
			if (regex.getMatches(tmp.get(4)) || regex.getMatches(tmp.get(5))) {
				personalizedMap.put(name, tmp);
			}
		}
	}
	
	public String[] getPersonalizedUserNames() {
		getPersonalizedFriendsList();
		ArrayList<String> usernames = new ArrayList<String>();
		for (ArrayList<String> list : personalizedMap.values()) {
			usernames.add(list.get(1));
		}
		String[] finalArray = new String[usernames.size()];
		finalArray = usernames.toArray(finalArray);
		return finalArray;
	}
}
