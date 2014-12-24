package vo;

import java.util.ArrayList;
import java.util.Iterator;

import util.Constants;

public class UserScore {
	String userName;
	boolean isAllPass = true;
	ArrayList<String[]> scores = new ArrayList<String[]>();
	
	public UserScore(String userName, Iterator<String[]> scores){
		this.userName = userName;
		while (scores.hasNext()) {
			String[] strings = (String[]) scores.next();
			this.scores.add(strings);
			if (Integer.valueOf(strings[2])<Constants.NoPassScore) {
				isAllPass = false;
			}
		}
	}
	
	public Iterator<String[]> getScores() {
		return scores.iterator();
	}
	
	public String getUserName() {
		return userName;
	}
	
	public boolean isAllPass() {
		return isAllPass;
	}
	
}
