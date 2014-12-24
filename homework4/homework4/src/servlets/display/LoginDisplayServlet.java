package servlets.display;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import listeners.LoginListener;
import util.Constants;
import vo.UserCount;

/**
 * Servlet implementation class LoginDisplayServlet
 */
//@WebServlet("/LoginDisplayServlet")
public class LoginDisplayServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String LOGIN_HTML = Constants.HTML_CONTEXT+ "/login.jsp" ;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginDisplayServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession(true);
		session.setAttribute("isLogin", false);

		String username="";
		
		Cookie[] cookies = request.getCookies();
		if (cookies!=null) {
			for (Cookie eachCookie : cookies) {
				if (eachCookie.getName().equals("logId")) {
					username=eachCookie.getValue();
					break;
				}
			}
		}

		session.setAttribute("username", username);
		session.setAttribute("userCount", new UserCount(LoginListener.getAllCount(), LoginListener.getLogCount(), LoginListener.getTravelCount()));

		request.getRequestDispatcher(response.encodeURL(LOGIN_HTML)).forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
