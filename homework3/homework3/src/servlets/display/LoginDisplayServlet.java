package servlets.display;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.Constants;

/**
 * Servlet implementation class LoginDisplayServlet
 */
//@WebServlet("/LoginDisplayServlet")
public class LoginDisplayServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
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
		StringBuilder str = new StringBuilder();
		str.append("<!DOCTYPE html><html><head><meta http-equiv='Cache-Control' content='no-cache'><meta http-equiv='Pragma' content='no-cache'><meta http-equiv='expires' content='0'><meta charset='UTF-8'><title>请登录</title></head>");
		str.append("<body><header id='title'><h1>登录</h1></header>");
		str.append("<div id='main'><form role='form' id='loginForm' action='"+Constants.PROJECT_CONTEXT+"/LoginServlet' method='get'>");
		str.append("<!--[if IE]>帐号：<![endif]--><input type='text' name='logId' id='logId' placeholder='请在此输入学号' required='required'><br/>");
		str.append("<!--[if IE]>密码：<![endif]--><input type='password' name='logPassword' id='logPassword' placeholder='请在此输入密码' required='required'><br/>");
		str.append("<input type='submit' id='submit' value='登录(Enter)'></form>");
		str.append("</div>");
		str.append("</body></html>");
		response.getWriter().print(str.toString());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
