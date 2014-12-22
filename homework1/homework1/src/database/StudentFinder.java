package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 提供搜索学生信息的相关方法。
 * @author 121250185
 */
public final class StudentFinder {

	/**
	 * <h2>getStudentName：</h2>
	 * <br>&nbsp;&nbsp;&nbsp;&nbsp;
	 * public String getStudentName(String id)
	 * <br><br>
	 * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	 * 在数据库中搜索指定id的学生名字。
	 * <br><br>
	 * @param id - 学生学号
	 * @return 如果id存在返回学生名字，否则返回""
	 */
	public String getStudentName(String id){
		Connection connection = LinkHelper.getConnection();
		PreparedStatement statement;
		String result = "";
		try {
			statement = connection.prepareStatement(
					"select name from student where id=?");
			statement.setString(1, id);
			
			ResultSet resultSet = statement.executeQuery();

			if (resultSet.next()) {
				result = resultSet.getString(1);
			}

			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	/**
	 * <h2>isLoginSuccess：</h2>
	 * <br>&nbsp;&nbsp;&nbsp;&nbsp;
	 * public boolean isLoginSuccess(String id, String password)
	 * <br><br>
	 * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	 * 在数据库中搜索(id,password)字符对，判断是否存在该组合的用户
	 * <br><br>
	 * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	 * <b>注：</b>
	 * 在数据库中密码使用md5加密
	 * <br><br>
	 * @param id - 学生学号
	 * @param password - 密码
	 * @return 成功登录返回true，失败返回false
	 */
	public boolean isLoginSuccess(String id, String password){
		Connection connection = LinkHelper.getConnection();
		PreparedStatement statement;
		try {
			
			statement = connection.prepareStatement(
					"select count(*) from student where id=? and password=md5(?);");
			statement.setString(1, id);
			statement.setString(2, password);
			
			ResultSet result = statement.executeQuery();

			if (result.next()) {
				if (result.getInt(1)>0) {
					connection.close();
					return true;
				}
			}

			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}
}
