package model.dao.helpers;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.lang.reflect.Array;

import model.dao.helpers.entity.MethodEntity;
import model.dao.helpers.entity.TableEntity;

/**
 * 实现结果集到Entity/VO/PO转换
 * 
 * @author http://blog.csdn.net/stevene/article/details/575141
 */

public class ConvertResultSetToPO {
	/**
	 * 结果集到Entity/VO/PO转换
	 * 
	 * @param result
	 * @param poName
	 * @throws Exception
	 * @return Object[]
	 */
	public static Object[] parseDataEntityBeans(ResultSet result, String poName)
			throws Exception {
		// 注册po实体 
		Class classEntity = Class.forName(poName);

		// 获取实体中定义的方法
		Map<String, MethodEntity> methodMap = new HashMap<String, MethodEntity>();
		for (int i = 0; i < classEntity.getDeclaredMethods().length; i++) {
			MethodEntity tempMethod = new MethodEntity();
			Method actualMethod = classEntity.getDeclaredMethods()[i];
			// 方法的名称，转换为全大写的键
			String methodName = actualMethod.getName();
			String methodKey = methodName.toUpperCase();
			// 方法的参数
			Class[] paramTypes = actualMethod.getParameterTypes();

			tempMethod.setMethodName(methodName);
			tempMethod.setMethodParamTypes(paramTypes);

			// 存在处理方法重载
			if (methodMap.containsKey(methodKey)) {
				System.err.println("可能具有重载方法。");
			} else {
				methodMap.put(methodKey, tempMethod);
			}
		}

		// 处理ResultSet结构体信息
		TableEntity dataTable = null;
		List<Object> listResult = new ArrayList<Object>();
		if (result != null) {
			ResultSetMetaData rsMetaData = result.getMetaData();
			int columnCount = rsMetaData.getColumnCount();
			dataTable = new TableEntity(columnCount);
			// 获取字段名称，类型
			for (int i = 0; i < columnCount; i++) {
				String columnName = rsMetaData.getColumnName(i + 1);
				int columnType = rsMetaData.getColumnType(i + 1);
				dataTable.setColumnName(columnName, i);
				dataTable.setColumnType(columnType, i);
			}
		}

		// 处理ResultSet数据信息
		while (result.next()) {
			// 调用方法，根据字段名在methodMap中查找对应的set方法
			Object objResult = parseObjectFromResultSet(result, dataTable,
					classEntity, methodMap);
			listResult.add(objResult);
		}

		// 以数组方式返回
		Object objResutlArray = Array.newInstance(classEntity,
				listResult.size());
		listResult.toArray((Object[]) objResutlArray);

		return (Object[]) objResutlArray;
	}

	/**
	 * 从Resultset中解析出单行记录对象，存储在实体对象中
	 */
	private static Object parseObjectFromResultSet(ResultSet rs,
			TableEntity dataTable, Class classEntity,
			Map<String, MethodEntity> methodMap) throws Exception {

		Object objEntity = classEntity.newInstance();
		Method method = null;

		int columnCount = dataTable.getColumnCount();
		String[] columnNames = dataTable.getColumnNames();

		for (int i = 0; i < columnCount; i++) {
			// 获取字段值
			Object objColumnValue = rs.getObject(columnNames[i]);
			// HashMap中的方法名key值
			String methodKey = null;
			// 获取set方法名
			if (columnNames[i] != null) {
				methodKey = "SET" + columnNames[i].toUpperCase();
			}
			if (methodKey != null) {
				// 判断字段的类型,方法名，参数类型
				try {
					MethodEntity methodEntity = methodMap.get(methodKey);
					String methodName = methodEntity.getMethodName();
					Class[] paramTypes = methodEntity.getMethodParamTypes();
					
					method = classEntity.getMethod(methodName, paramTypes);

					// 如果重载方法数 > 1，则判断是否有java.lang.IllegalArgumentException异常，循环处理
					try {
						// Long转换为long
						if (objColumnValue instanceof Long) {
							objColumnValue = ((Long) objColumnValue).longValue();
						}
						// 设置参数,实体对象，实体对象方法参数
						method.invoke(objEntity, new Object[] { objColumnValue });
					} catch (IllegalArgumentException e) {
						// 存在重载方法
						System.err.println("可能1：可能具有重载方法。\n可能2：数据表可能有id列，会被隐式重载。");
						e.printStackTrace();
					}
				} catch (NoSuchMethodException e) {
					throw new NoSuchMethodException();
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		}
		return objEntity;
	}
	
}
