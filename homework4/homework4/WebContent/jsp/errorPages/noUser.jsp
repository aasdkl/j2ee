<%@ page session="false" import="util.Constants" language="java" pageEncoding="utf-8"%>

<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">  
	<meta http-equiv="refresh" content="3; url=<%=Constants.PROJECT_CONTEXT %>/LoginDisplayServlet">  
	<title>输入错误</title>
</head>
<body>
  <header id="title">
    <h1>学号或密码错误</h1>
  </header>
  <div id="main">
  	点击<a href="<%=Constants.PROJECT_CONTEXT %>/LoginDisplayServlet"><b> 此处 </b></a>重新登录（3秒后重新自动跳转）
  </div>
</body>
</html>