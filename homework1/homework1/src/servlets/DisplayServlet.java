package servlets;

import java.io.IOException;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import util.Constants;

import database.ScoreFinder;
import database.StudentFinder;

/**
 * 学生登录，跟据学生的ID，查询当前课程成绩, 并根据成绩，确定返回结果
有不及格课程：警示页面
正常结果：标准页面
未知的学生ID：错误页面

 * Servlet implementation class DisplayServlet
 */
//@WebServlet("/DisplayServlet")
public class DisplayServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static final String LOGOUT_HTML = Constants.PROJECT_CONTEXT + "/LogoutServlet" ;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DisplayServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		StudentFinder studentFinder = new StudentFinder();
		ScoreFinder scoreFinder = new ScoreFinder();
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("logId");

		response.setCharacterEncoding("utf-8");  
        response.setContentType("text/html;charset=utf-8"); 
        StringBuilder htmlString = new StringBuilder(512);
        
        htmlString.append("<html><head><title>成绩查看</title></head><body>");
        htmlString.append(studentFinder.getStudentName(id)+", 你好。<br>");
        htmlString.append("你的成绩如下：<br>");
        htmlString.append("<table>");
        htmlString.append("<tr><th>课程号</th><th>课程名</th><th>成绩</th></tr>");
		
		Iterator<String[]> scores = scoreFinder.getStudentScore(id);

		boolean isAllPass = true;
		
		while (scores.hasNext()) {
			String[] eachScoreSet = (String[]) scores.next();
			htmlString.append("<tr><td>");
			htmlString.append(eachScoreSet[0]);
			htmlString.append("</td><td>");
			htmlString.append(eachScoreSet[1]);
			if (Integer.parseInt(eachScoreSet[2])<Constants.NoPassScore) {// 不及格
				isAllPass=false;
				htmlString.append("</td><td style='color:red'>");
			} else {
				htmlString.append("</td><td>");
			}
			htmlString.append(eachScoreSet[2]);
			htmlString.append("</td></tr>");
		}
		
		htmlString.append("</table>");

		if (isAllPass) {
			htmlString.append("全过了！恭喜你！<br>");
		}
		
		htmlString.append("<a href=\"");
		htmlString.append(response.encodeURL(LOGOUT_HTML));
		htmlString.append("\">退出登录</a>");

		htmlString.append("</body></html>");
		
		response.getWriter().print(htmlString.toString());;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
