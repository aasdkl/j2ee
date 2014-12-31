package model.dao;

import java.io.Serializable;
import java.util.Iterator;

/**
 * 基本的数据操作，包括增删改查
 * @author Administrator
 *
 * @param <T>
 */
public interface BaseDAO<T extends Serializable> {

	/**
	 * 新增数据
	 * @param entity
	 * @return
	 */
	public boolean add(T entity);

	/**
	 * 删除数据
	 * @param entity
	 * @return
	 */
	public boolean remove(T entity);

	/**
	 * 更新数据
	 * @param entity
	 * @return
	 */
	public boolean update(T entity);

	/**
	 * 查找数据
	 * @param entity
	 * @return
	 */
	public Iterator<T> get(String id);
}
