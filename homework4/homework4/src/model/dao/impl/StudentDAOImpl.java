package model.dao.impl;

import java.util.ArrayList;
import java.util.Iterator;

import model.dao.StudentDAO;
import model.dao.helpers.DaoHelper;
import model.dao.helpers.IDaoHelper;
import model.dao.helpers.entity.Query;
import model.po.ScorePO;
import model.po.StudentPO;

/**
 * 提供搜索学生信息的相关方法。
 * @author 121250185
 */
public final class StudentDAOImpl implements StudentDAO{	

	@Override
	public boolean add(StudentPO studentPO) {
		return false;
	}

	@Override
	public boolean remove(StudentPO studentPO) {
		return false;
	}

	@Override
	public boolean update(StudentPO studentPO) {
		return false;
	}

	@Override
	public Iterator<StudentPO> get(String studentId) {
		ArrayList<StudentPO> studentPOs = new ArrayList<StudentPO>();
		IDaoHelper helper = DaoHelper.getInstance();
		String statement = "select name from student where id=?";
		ArrayList<String> param = new ArrayList<String>();
		param.add(studentId);

		Query query = new Query(statement, param, "StudentPO");
		Object[] result = helper.retrieve(query);
		
		for (Object each : result) {
			if (each instanceof StudentPO) {
				studentPOs.add((StudentPO) each);
			}
		}
		return studentPOs.iterator();

	}

	@Override
	public boolean isLoginSuccess(String studentId, String password) {
		IDaoHelper helper = DaoHelper.getInstance();
		String statement = "select count(*) from student where id=? and password=md5(?)";
		ArrayList<String> param = new ArrayList<String>();
		param.add(studentId);
		param.add(password);

		Query query = new Query(statement, param);
		Object[] result = helper.retrieve(query);
		
		for (Object each : result) {
			if (each instanceof Long && (Long) each > 0) {
				return true;
			}
		}
		return false;
	}
	
	
	
}
