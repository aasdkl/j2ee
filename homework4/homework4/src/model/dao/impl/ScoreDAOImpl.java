package model.dao.impl;

import java.util.ArrayList;
import java.util.Iterator;

import model.dao.BaseDAO;
import model.dao.ScoreDAO;
import model.dao.helpers.DaoHelper;
import model.dao.helpers.IDaoHelper;
import model.dao.helpers.entity.Query;
import model.po.ScorePO;

/**
 * 提供搜索成绩的相关方法。
 * 
 * @author 121250185
 */
public final class ScoreDAOImpl implements ScoreDAO {

	@Override
	public boolean add(ScorePO scorePO) {
		return false;
	}

	@Override
	public boolean remove(ScorePO scorePO) {
		return false;
	}

	@Override
	public boolean update(ScorePO scorePO) {
		return false;
	}

	@Override
	public Iterator<ScorePO> get(String studentId) {
		ArrayList<ScorePO> scorePOs = new ArrayList<ScorePO>();
		IDaoHelper helper = DaoHelper.getInstance();
		String statement = "select * from score where score.student=?";
		ArrayList<String> param = new ArrayList<String>();
		param.add(studentId);

		Query query = new Query(statement, param, "ScorePO");
		Object[] result = helper.retrieve(query);
		for (Object each : result) {
			if (each instanceof ScorePO) {
				scorePOs.add((ScorePO) each);
			}
		}
		return scorePOs.iterator();
	}


}