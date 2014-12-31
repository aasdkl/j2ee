package model.po;

import java.io.Serializable;

public class ScorePO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -516879821745649975L;
	
	private long student;
	private long course;
	private int score;

	public ScorePO() {
		super();
	}
	
	public long getCourse() {
		return course;
	}

	public int getScore() {
		return score;
	}

	public long getStudent() {
		return student;
	}

	public void setCourse(long course) {
		this.course = course;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public void setStudent(long student) {
		this.student = student;
	}

}
