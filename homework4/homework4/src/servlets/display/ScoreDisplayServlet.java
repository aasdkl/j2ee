package servlets.display;

import java.io.IOException;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import listeners.LoginListener;
import util.Constants;
import vo.UserCount;
import vo.UserScore;
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
public class ScoreDisplayServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static final String DISPLAY_HTML = Constants.HTML_CONTEXT+ "/score.jsp" ;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ScoreDisplayServlet() {
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

		UserCount uCount = (UserCount) session.getAttribute("userCount");
		uCount.setCounts(LoginListener.getAllCount(), LoginListener.getLogCount(), LoginListener.getTravelCount());
		session.setAttribute("userCount", uCount);

		UserScore uScore = new UserScore(studentFinder.getStudentName(id), scoreFinder.getStudentScore(id));
		session.setAttribute("userScore", uScore);
		
		request.getRequestDispatcher(response.encodeURL(DISPLAY_HTML)).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
