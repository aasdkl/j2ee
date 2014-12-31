package vo;

import java.util.ArrayList;
import java.util.Iterator;

import org.apache.catalina.filters.AddDefaultCharsetFilter;

import util.Constants;
import model.po.StudentPO;

public class ScoreListVO {

	private String studentName;
	private ArrayList<ScoreVO> scores = new ArrayList<ScoreVO>();
	private boolean isAllPass = true;
	
	public ScoreListVO() {
		super();
	}

	public ScoreListVO(StudentPO student) {
		super();
		studentName = student.getName();
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public Iterator<ScoreVO> getScores() {
		return scores.iterator();
	}

	public void setScores(ArrayList<ScoreVO> scores) {
		this.scores = scores;
	}
	
	public void addScore(ScoreVO score) {
		scores.add(score);
		if (!score.isPass()) {
			isAllPass = false;
		}
	}

	public boolean isAllPass() {
		return isAllPass;
	}

}
