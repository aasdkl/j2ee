package model.dao.helpers.entity;

/**
 * 数据库的表结构定义
 * 
 * @author http://blog.csdn.net/stevene/article/details/575141
 */

public class TableEntity {
	// 数据库中字段的数量
	private int columnCount;
	// 数据库中字段的名称
	private String[] columnNames;
	// 数据库中字段的类型
	private int[] columnTypes;

	/**
	 * 默认构造函数. 相当于使用new Tabel(0)
	 */
	public TableEntity() {
		this(0);
	}

	/**
	 * 初始化构造器.
	 * 
	 * @param columnCount
	 */
	public TableEntity(int columnCount) {
		this.columnCount = columnCount;
		this.columnNames = new String[columnCount];
		this.columnTypes = new int[columnCount];
	}

	// ===================getter==================

	/**
	 * 获取字段数量.
	 * 
	 * @return
	 */
	public int getColumnCount() {
		return columnCount;
	}

	/**
	 * 获取字段名称
	 * 
	 * @return
	 */
	public String[] getColumnNames() {
		return columnNames;
	}

	/**
	 * 获取第index个字段的名称，如果index字段不存在，则抛出ArrayIndexOutOfBoundsException异常
	 * 
	 * @param index
	 * @return
	 */
	public String getColumnName(int index) {
		if (index <= this.columnCount) {
			return this.columnNames[index];
		} else {
			throw new ArrayIndexOutOfBoundsException();
		}
	}

	/**
	 * 获取字段类型
	 * 
	 * @return
	 */
	public int[] getColumnTypes() {
		return columnTypes;
	}

	/**
	 * 获取第index个字段的属性，如果index字段不存在，则抛出ArrayIndexOutOfBoundsException异常
	 * 
	 * @param index
	 * @return
	 */
	public int getColumnType(int index) {
		if (index <= this.columnCount) {
			return this.columnTypes[index];
		} else {
			throw new ArrayIndexOutOfBoundsException();
		}
	}

	// ===================setter==================

	/**
	 * 设置字段名称
	 */
	public void setColumnNames(String[] columnNames) {
		this.columnNames = columnNames;
	}

	/**
	 * 设置第index个字段名称，如果index字段不存在，则抛出ArrayIndexOutOfBoundsException异常
	 */
	public void setColumnName(String columnName, int index) {
		if (index <= this.columnCount) {
			this.columnNames[index] = columnName;
		} else {
			throw new ArrayIndexOutOfBoundsException();
		}
	}

	/**
	 * 设置字段属性
	 */
	public void setColumnTypes(int[] columnTypes) {
		this.columnTypes = columnTypes;
	}

	/**
	 * 设置第index个字段属性，如果index字段不存在，则抛出ArrayIndexOutOfBoundsException异常
	 */
	public void setColumnType(int columnType, int index) {
		if (index <= this.columnCount) {
			this.columnTypes[index] = columnType;
		} else {
			throw new ArrayIndexOutOfBoundsException();
		}
	}

}
