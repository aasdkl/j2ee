package model.dao;

import java.util.Iterator;

import model.po.StudentPO;

public interface StudentDAO extends BaseDAO<StudentPO>{
	@Override
	public boolean add(StudentPO studentPO);

	@Override
	public boolean remove(StudentPO studentPO);

	@Override
	public boolean update(StudentPO studentPO);

	/**
	 * 根据修学生id查找学生
	 */
	@Override
	public Iterator<StudentPO> get(String studentId);

	/**
	 * 判断用户的id和密码，返回是否登录成功
	 * @return
	 */
	public boolean isLoginSuccess(String studentId, String password);

}
