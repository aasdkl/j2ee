package model.dao.factory;

import model.dao.CourseDAO;
import model.dao.ScoreDAO;
import model.dao.StudentDAO;
import model.dao.impl.CourseDAOImpl;
import model.dao.impl.ScoreDAOImpl;
import model.dao.impl.StudentDAOImpl;

public class DAOFactoryImpl implements DAOFactory{
	
	private static DAOFactory instance = new DAOFactoryImpl();

	private DAOFactoryImpl(){}
	
	public static DAOFactory getInstance(){
		return instance;
	}
	
	public ScoreDAO getScoreDAO(){
		return new ScoreDAOImpl();
	}
	
	public StudentDAO getStudentDAO(){
		return new StudentDAOImpl();
	}
	
	public CourseDAO getCourseDAO(){
		return new CourseDAOImpl();
	}
}
