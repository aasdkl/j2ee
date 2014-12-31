package util;

public class Constants {
	public static final int ONE_DAY = 24*60*60;
	public static final String HTML_CONTEXT = "/jsp";
	public static final String PROJECT_CONTEXT = "/homework4";
	public static final String ERROR_CONTEXT = PROJECT_CONTEXT+HTML_CONTEXT+"/errorPages";

	public static final int NO_PASS_SCORE = 60;
	public static final int COURSE_ID_LENGTH = 8;

	public static final String PO_DIRECTORY = "model.po.";
	
	
//	======================数据库相关常量============================
	
	public static final String DB_PROVIDER = "jnp:///";
	public static final String DB_CONTEXT_FACTORY = "org.apache.naming.java.javaURLContextFactory";
	public static final String DB_JDBC_NAME = "java:comp/env/jdbc" + PROJECT_CONTEXT;
	
}
