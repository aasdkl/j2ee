package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;


/**
 * 提供搜索成绩的相关方法。
 * @author 121250185
 */
public class ScoreFinder {

	/**
	 * <h2>getStudentScore：</h2>
	 * <br>&nbsp;&nbsp;&nbsp;&nbsp;
	 * public ArrayList<String[]> getStudentScore(String id)
	 * <br><br>
	 * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	 * 在数据库中搜索指定id的学生成绩。
	 * <br><br>
	 * @param id - 学生学号
	 * @return 返回学生每门课成绩的迭代器，其中学生成绩格式为[课程id, 课程名, 分数]
	 */
	public Iterator<String[]> getStudentScore(String id){
		Connection connection = LinkHelper.getConnection();
		PreparedStatement statement;
		ArrayList<String[]> scoreSet = new ArrayList<String[]>();
		try {
			statement = connection.prepareStatement(
					"select course.id, course.name, score.score "
					+ "from score, course "
					+ "where score.student=? and course.id=score.course");
			statement.setString(1, id);
			
			ResultSet result = statement.executeQuery();

			while (result.next()) {
				String[] s = new String[]{
						result.getString(1),
						result.getString(2),
						result.getString(3)
						};
				scoreSet.add(s);
			}
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return scoreSet.iterator();
	}
	
}