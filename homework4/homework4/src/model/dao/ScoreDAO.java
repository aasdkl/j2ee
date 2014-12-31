package model.dao;

import java.util.Iterator;

import model.po.ScorePO;

public interface ScoreDAO extends BaseDAO<ScorePO>{
	@Override
	public boolean add(ScorePO coursePO);

	@Override
	public boolean remove(ScorePO coursePO);

	@Override
	public boolean update(ScorePO coursePO);

	/**
	 * 根据修学生id查找成绩
	 */
	@Override
	public Iterator<ScorePO> get(String studentId);

}
