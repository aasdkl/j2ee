package model.dao.helpers;

import com.sun.org.apache.xml.internal.utils.ObjectPool;

import model.dao.helpers.entity.Query;


/**
 * 将数据库的细节CRUD操作封装
 * @author Administrator
 *
 */
public interface IDaoHelper {

	/**
	 * 增
	 * @param statement
	 * @return 
	 */
	public boolean create(Query query);
	
	/**
	 * 查
	 * @param entity 
	 * @param statement
	 * @return
	 */
	public Object[] retrieve(Query query);

	/**
	 * 改
	 * @param statement
	 * @return
	 */
	public boolean update(Query query);
	
	/**
	 * 删
	 * @param statement
	 * @return
	 */
	public boolean delete(Query query);
	
}
