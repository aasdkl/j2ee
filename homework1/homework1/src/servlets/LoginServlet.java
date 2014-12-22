package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import util.Constants;

/**
 * Servlet implementation class
 * 
 */

// @WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private static final String DISPLAY_HTML = Constants.PROJECT_CONTEXT + "/DisplayServlet" ;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		response.setCharacterEncoding("utf-8");  
        response.setContentType("text/html;charset=utf-8"); 
		response.getWriter().print("<html><head><title>登录成功</title></head><body>正在跳转……</body></html>");

		session.setAttribute("isLogin", true);
		session.setAttribute("logId", request.getParameter("logId"));
		
		response.sendRedirect(response.encodeURL(DISPLAY_HTML));
	}

}
