package model.dao;

import java.util.Iterator;

import model.po.CoursePO;

public interface CourseDAO extends BaseDAO<CoursePO> {
	@Override
	public boolean add(CoursePO coursePO);

	@Override
	public boolean remove(CoursePO coursePO);

	@Override
	public boolean update(CoursePO coursePO);

	/**
	 * 根据课程id查找
	 */
	@Override
	public Iterator<CoursePO> get(String courseId);
}
