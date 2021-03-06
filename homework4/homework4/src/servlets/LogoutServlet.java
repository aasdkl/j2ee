package servlets;

import java.io.IOException;
import java.nio.channels.SeekableByteChannel;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import listeners.LoginListener;
import util.Constants;

/**
 * Servlet implementation class
 * 
 */

// @WebServlet("/LogoutServlet")
public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private static final String LOGIN_HTML = Constants.PROJECT_CONTEXT + "/LoginDisplayServlet" ;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();

		session.setAttribute("isLogin",false);
		session.setAttribute("logId", "");
		
		response.getWriter().print("<html><head><title>登出成功</title></head><body>正在跳转……</body></html>");
		
		LoginListener.userLogout();

		response.sendRedirect(response.encodeURL(LOGIN_HTML));
	}

}
