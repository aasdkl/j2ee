package filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.Constants;
import database.StudentFinder;

/**
 * Servlet Filter implementation class isIdExistFilter
 */

//@WebFilter(filterName="/CheckExistFilter", urlPatterns={"/LoginServlet"})

public class CheckExistFilter implements Filter {

	private static final String LOGIN_HTML = Constants.PROJECT_CONTEXT + Constants.HTML_CONTEXT + "/login.html" ;
	private static final String NO_USER_HTML = Constants.ERROR_CONTEXT + "/noUser.html" ;

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		if (request instanceof HttpServletRequest && response instanceof HttpServletResponse) {
			HttpServletResponse resp = (HttpServletResponse) response;
			HttpServletRequest req = (HttpServletRequest) request;
			
			String id = (String) req.getParameter("logId");
			String pw = (String) req.getParameter("logPassword");

			if (id==null || id.equals("") || pw==null || pw.equals("")) {
				// 错误页面
				resp.sendRedirect(resp.encodeURL(NO_USER_HTML));
				return;
			} else {
				if (!new StudentFinder().isLoginSuccess(id, pw)) {
//					// 不存在
					resp.sendRedirect(resp.encodeURL(NO_USER_HTML));
					return;
				}
			}
		}
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
	}

}
