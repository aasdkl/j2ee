package model.dao.helpers.entity;

import java.util.ArrayList;
import java.util.Iterator;

import util.Constants;

public class Query {
	
	private String poName;
	private String statement;
	private ArrayList<String> parameters = new ArrayList<String>();
	
	/**
	 * 无参数语句，对于po名会自动加上po位置前缀
	 * @param statement
	 */
	public Query(String statement, String poName){
		this(statement, null, poName);
	}

	/**
	 * 无参数语句，此时的返回值为java的基本类型
	 * @param statement
	 */
	public Query(String statement){
		this(statement, null, null);
	}

	/**
	 * 有参数语句，对于po名会自动加上po位置前缀
	 * @param statement
	 * @param parameters
	 */
	public Query(String statement, ArrayList<String> parameters, String poName){
		if (statement != null) {
			this.statement = statement;
		}
		if (parameters!=null) {
			this.parameters = parameters;
		}
		if (poName!=null) {
			this.poName = Constants.PO_DIRECTORY + poName;
		}
	}
	
	/**
	 * 有参数语句，此时的返回值为java的基本类型
	 * @param statement
	 * @param parameters
	 */
	public Query(String statement, ArrayList<String> parameters){
		if (statement != null) {
			this.statement = statement;
		}
		if (parameters!=null) {
			this.parameters = parameters;
		}
		if (poName!=null) {
			this.poName = Constants.PO_DIRECTORY + poName;
		}
	}

	/**
	 * 判断所要求的是否为po
	 */
	public boolean isRequiredPO(){
		return (poName==null)?false:true;
	}
	
	/**
	 * 获取语句
	 * @return
	 */
	public String getStatement() {
		return statement;
	}

	/**
	 * 获取所需要的po类名
	 * @return
	 */
	public String getPoName() {
		return poName;
	}

	/**
	 * 设置所需要的po类名，并且会自动加上po位置前缀
	 * @return
	 */
	public void setPoName(String poName) {
		this.poName = Constants.PO_DIRECTORY + poName;
	}
	
	/**
	 * 获取参数（会检查参数个数与语句缺少的参数数量是否匹配）
	 * @return
	 */
	public Iterator<String> getParameters() {
		checkMatch();
		return parameters.iterator();
	}
	
	/**
	 * 检查参数是否匹配
	 */
	private void checkMatch() {
		try {
			if (getRequiredNums()!=parameters.size()) {
				throw new Exception("SQL语句参数个数不匹配");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 计算语句需要的参数数量
	 */
	private int getRequiredNums() {
		int num = 0;
		for (int i = 0; i < statement.length(); i++) {
			if (statement.charAt(i)=='?') {
				num++;
			}
		}
		return num;
	}
	
}
