package model.dao.helpers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.omg.CORBA.OBJ_ADAPTER;

import com.mysql.jdbc.Blob;
import com.sun.org.apache.bcel.internal.generic.NEW;
import com.sun.org.apache.xalan.internal.xsltc.compiler.Template;

import model.dao.helpers.entity.Query;
import util.Constants;

public final class DaoHelper implements IDaoHelper {

	private static IDaoHelper instance = new DaoHelper();
	private DataSource datasource = null;

	public static IDaoHelper getInstance() {
		return instance;
	}

	/**
	 * 资源池初始化
	 */
	private DaoHelper() {
		Properties properties = new Properties();
		properties.put(Context.PROVIDER_URL, Constants.DB_PROVIDER);// 即/目录，服务器地址
		properties.put(Context.INITIAL_CONTEXT_FACTORY,
				Constants.DB_CONTEXT_FACTORY);
		try {
			InitialContext jndiContext = new InitialContext(properties);
			datasource = (DataSource) jndiContext
					.lookup(Constants.DB_JDBC_NAME);
			jndiContext.close();
		} catch (NamingException e1) {
			e1.printStackTrace();
			System.err.println("资源池初始化错误");
			System.exit(1);
		}
	}

	@Override
	public Object[] retrieve(Query query) {
		Iterator<String> param = query.getParameters();
		Object[] resultObject = null;
		try (
			Connection connection = datasource.getConnection();
			PreparedStatement statement = connection.prepareStatement(query.getStatement());
		) {
			int i = 1;
			while (param.hasNext()) {
				String string = (String) param.next();
				statement.setString(i, string);
				++i;
			}
			try(ResultSet result = statement.executeQuery()) {
				//!修改jsp的scope为request，修改<%%>为getProperty，EL表达式
				//处理 result to po
				if (query.isRequiredPO()) {
					resultObject = ConvertResultSetToPO.parseDataEntityBeans(result, query.getPoName());
				} else {
					ArrayList<Object> temp = new ArrayList<Object>();
					while (result.next()) {
						temp.add(result.getObject(1));
					}
					resultObject = temp.toArray();
				}
			} catch (Exception e) {
				e.printStackTrace();
			} 
		} catch (SQLException e) {
			//http://docs.oracle.com/javase/7/docs/technotes/guides/language/try-with-resources.html
			//在try-with-resources 语句中, 任意的 catch 或者 finally 块都是在声明的资源被关闭以后才运行。
			e.printStackTrace();
		}
		
		return resultObject;
	}

	@Override
	public boolean create(Query query) {
		return false;
	}

	@Override
	public boolean update(Query query) {
		return false;
	}

	@Override
	public boolean delete(Query query) {
		return false;
	}

	// 看到一个很有趣的想法，把连接放到session中，但是session会延30min所以会拿着连接不用，占资源

}
