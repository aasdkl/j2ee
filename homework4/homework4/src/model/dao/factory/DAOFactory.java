package model.dao.factory;

import model.dao.CourseDAO;
import model.dao.ScoreDAO;
import model.dao.StudentDAO;

public interface DAOFactory {

	public ScoreDAO getScoreDAO();

	public StudentDAO getStudentDAO();

	public CourseDAO getCourseDAO();
}
