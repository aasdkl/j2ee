package model.dao.impl;

import java.util.ArrayList;
import java.util.Iterator;

import model.dao.CourseDAO;
import model.dao.helpers.DaoHelper;
import model.dao.helpers.IDaoHelper;
import model.dao.helpers.entity.Query;
import model.po.CoursePO;

public final class CourseDAOImpl implements CourseDAO {

	@Override
	public boolean add(CoursePO coursePO) {
		return false;
	}

	@Override
	public boolean remove(CoursePO coursePO) {
		return false;
	}

	@Override
	public boolean update(CoursePO coursePO) {
		return false;
	}

	@Override
	public Iterator<CoursePO> get(String courseId) {
		ArrayList<CoursePO> coursePOs = new ArrayList<CoursePO>();
		IDaoHelper helper = DaoHelper.getInstance();
		String statement = "select * from course where course.id=?";
		ArrayList<String> param = new ArrayList<String>();
		param.add(courseId);

		Query query = new Query(statement, param, "CoursePO");
		Object[] result = helper.retrieve(query);
		for (Object each : result) {
			if (each instanceof CoursePO) {
				coursePOs.add((CoursePO) each);
			}
		}
		return coursePOs.iterator();
	}

}
