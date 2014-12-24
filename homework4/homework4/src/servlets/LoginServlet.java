package servlets;

import java.io.IOException;
import java.net.CookieStore;

import javax.print.attribute.ResolutionSyntax;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.ws.RespectBinding;
import javax.xml.ws.Response;

import com.sun.xml.internal.bind.v2.model.core.ID;

import listeners.LoginListener;
import util.Constants;

/**
 * Servlet implementation class
 * 
 */

// @WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private static final String DISPLAY_HTML = Constants.PROJECT_CONTEXT + "/ScoreDisplayServlet" ;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().print("<html><head><title>登录成功</title></head><body>正在跳转……</body></html>");

		HttpSession session = request.getSession(false);
		session.setAttribute("isLogin", true);
		session.setAttribute("logId", request.getParameter("logId"));
		
		Cookie cookie = new Cookie("logId", request.getParameter("logId"));
		cookie.setMaxAge(Constants.ONE_DAY);
		response.addCookie(cookie);
		
		// 设置人数
		LoginListener.userLogin();
		
		response.sendRedirect(response.encodeURL(DISPLAY_HTML));
	}

}
