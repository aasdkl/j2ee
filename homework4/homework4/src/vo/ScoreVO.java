package vo;

import java.awt.color.ICC_ColorSpace;

import util.Constants;
import util.Tools;
import model.po.CoursePO;
import model.po.ScorePO;

public class ScoreVO {
	private String courseId;
	private String courseName;
	private int score;
	private boolean isPass;

	public ScoreVO() {
		super();
	}

	public ScoreVO(ScorePO scorePO, CoursePO coursePO) {
		super();
		
		courseId = Tools.formatIdString(coursePO.getId(), Constants.COURSE_ID_LENGTH);

		courseName = coursePO.getName();
		score = scorePO.getScore();
		if (score < Constants.NO_PASS_SCORE) {
			isPass = false;
		} else {
			isPass = true;
		}
	}

	public String getCourseId() {
		return courseId;
	}

	public void setCourseId(String courseId) {
		this.courseId = Tools.formatIdString(courseId, Constants.COURSE_ID_LENGTH);
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public boolean isPass() {
		return isPass;
	}

	public void setPass(boolean isPass) {
		this.isPass = isPass;
	}

}
