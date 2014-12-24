package listeners;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import org.apache.catalina.startup.UserConfig;



/**
 * Application Lifecycle Listenesr implementation class LoginListener
 *
 */
@WebListener
public class LoginListener implements HttpSessionListener {
	private static int allCount = 0;
	private static int logCount = 0;
	
	public synchronized void sessionCreated(HttpSessionEvent event) {
		allCount++;
	}

	public synchronized void sessionDestroyed(HttpSessionEvent event) {
		if((boolean)event.getSession().getAttribute("isLogin")){
			if (logCount > 0) {
				logCount--;
			} else {
				logCount = 0;
			}
		}
		if (allCount > 0) {
			allCount--;
		} else {
			allCount = 0;
		}
	}
	
	public static int getAllCount() {
		return allCount;
	}

	public static int getLogCount() {
		return logCount;
	}
	
	public static int getTravelCount() {
		return allCount-logCount;
	}

	public synchronized static void userLogin() {
		logCount++;
	}
	
	public synchronized static void userLogout() {
		if (logCount > 0) {
			logCount--;
		} else {
			logCount = 0;
		}
	}

}