package servlets.display;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import listeners.LoginListener;
import model.dao.ScoreDAO;
import model.dao.StudentDAO;
import model.dao.factory.DAOFactory;
import model.dao.factory.DAOFactoryImpl;
import model.dao.impl.ScoreDAOImpl;
import model.dao.impl.StudentDAOImpl;
import model.po.CoursePO;
import model.po.ScorePO;
import model.po.StudentPO;
import util.Constants;
import vo.OnlineUserVO;
import vo.ScoreListVO;
import vo.ScoreVO;

/**
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
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("logId");

		DAOFactory dao = DAOFactoryImpl.getInstance();

		StudentPO studentPO = dao.getStudentDAO().get(id).next();
		Iterator<ScorePO> scores = dao.getScoreDAO().get(id);
		
		ScoreListVO scoreListVO = new ScoreListVO(studentPO);
		
		while (scores.hasNext()) {
			ScorePO scorePO = (ScorePO) scores.next();
			CoursePO coursePO = dao.getCourseDAO().get(String.valueOf(scorePO.getCourse())).next();
			ScoreVO scoreVO = new ScoreVO(scorePO, coursePO);
			scoreListVO.addScore(scoreVO);
		}
		
		session.setAttribute("userScore", scoreListVO);

		OnlineUserVO uCount = (OnlineUserVO) session.getAttribute("userCount");
		uCount.setCounts(LoginListener.getAllCount(), LoginListener.getLogCount(), LoginListener.getTravelCount());
		session.setAttribute("userCount", uCount);
		
		request.getRequestDispatcher(response.encodeURL(DISPLAY_HTML)).forward(request, response);
	}


}
