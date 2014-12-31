package vo;

import sun.security.action.GetBooleanAction;
import listeners.LoginListener;

public class OnlineUserVO {
	private int allUserCount;
	private int logUserCount;
	private int travelUserCount;
	
	public OnlineUserVO(int allUserCount, int logUserCount, int travelUserCount){
		this.allUserCount = allUserCount;
		this.logUserCount = logUserCount;
		this.travelUserCount = travelUserCount;
	}
	
	public int getAllUserCount() {
		return allUserCount;
	}
	
	public int getLogUserCount() {
		return logUserCount;
	}
	
	public int getTravelUserCount() {
		return travelUserCount;
	}

	public void setCounts(int allCount, int logCount, int travelCount) {
		this.allUserCount = allCount;
		this.logUserCount = logCount;
		this.travelUserCount = travelCount;
	}
}
