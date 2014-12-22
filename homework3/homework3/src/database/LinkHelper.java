package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.sun.org.apache.regexp.internal.recompile;

import util.Constants;

public class LinkHelper {

	static InitialContext jndiContext = null;
	static DataSource datasource = null;
	static Properties properties = new Properties();

	private static void init() {
		properties.put(javax.naming.Context.PROVIDER_URL, "jnp:///");
		properties.put(javax.naming.Context.INITIAL_CONTEXT_FACTORY,
				"org.apache.naming.java.javaURLContextFactory");
		try {
			jndiContext = new InitialContext(properties);
			datasource = (DataSource) jndiContext.lookup("java:comp/env/jdbc"
					+ Constants.PROJECT_CONTEXT);
		} catch (NamingException e1) {
			e1.printStackTrace();
		}

	}

	public static synchronized Connection getConnection() {

		try {
			if (jndiContext == null || datasource==null 
					|| properties.get(javax.naming.Context.PROVIDER_URL)==null
					|| properties.get(javax.naming.Context.INITIAL_CONTEXT_FACTORY)==null) {
				init();
			}
			Connection connection = datasource.getConnection();
			return connection;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
