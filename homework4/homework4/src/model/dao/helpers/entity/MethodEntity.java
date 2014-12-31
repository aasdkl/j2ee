package model.dao.helpers.entity;

import java.util.ArrayList;

/**
 * 方法结构定义
 * 
 * @author http://blog.csdn.net/stevene/article/details/575141
 */

@SuppressWarnings("rawtypes")
public class MethodEntity {
	// 方法名称
	private String methodName;
	// 方法参数类型
	private Class[] methodParamTypes;

	/**
	 * 默认构造函数
	 */
	public MethodEntity() {
	}

	// ===================getter====================
	/**
	 * 获取参数名称
	 * 
	 * @return
	 */
	public String getMethodName() {
		return methodName;
	}

	/**
	 * 获取方法参数类型
	 * 
	 * @return
	 */
	public Class[] getMethodParamTypes() {
		return methodParamTypes;
	}

	// ===================getter====================

	/**
	 * 设置参数名称
	 * 
	 * @param string
	 */
	public void setMethodName(String string) {
		methodName = string;
	}

	/**
	 * 设置参数类型列表
	 * 
	 * @param classes
	 */
	public void setMethodParamTypes(Class[] classes) {
		methodParamTypes = classes;
	}

}
