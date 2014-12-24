package filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import util.Constants;

/**
 * Servlet Filter implementation class CheckLogin
 */

// 所有页面下都进行用户是否登录的验证
//@WebFilter(filterName="/CheckLoginFilter", urlPatterns={"/DisplayServlet"})

public class CheckLoginFilter implements Filter {

	private static final String LOGIN_URI = "/LoginDisplayServlet" ;
	private static final String DISPLAY_URI = "/ScoreDisplayServlet" ;
	private static final String DISPLAY_HTML = Constants.PROJECT_CONTEXT + DISPLAY_URI ;
	private static final String LOGIN_HTML = Constants.PROJECT_CONTEXT + LOGIN_URI ;
    /**
     * Default constructor. 
     */
    public CheckLoginFilter() {
    }

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
			
			HttpSession session=req.getSession(false);

			boolean isLogin;
			// 第一次打开网页
			if (session == null || session.getAttribute("isLogin")==null) {
				isLogin = false;
			} else {
				isLogin = (Boolean)(session.getAttribute("isLogin"));
			}
			// 未登录，准备进入查看成绩页面
			if (!isLogin && req.getRequestURI().endsWith(DISPLAY_URI)) {
				resp.sendRedirect(resp.encodeURL(LOGIN_HTML));
				return;
			// 已登录，准备进入登录页面
			} else if (isLogin && req.getRequestURI().endsWith(LOGIN_URI)) { 
        		resp.sendRedirect(resp.encodeURL(DISPLAY_HTML));
        		return;
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
