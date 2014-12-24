<%@ page language="java" pageEncoding="utf-8"%>
<%@ page import="util.Constants"%>

<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">  
	<title>页面不存在-404</title>
</head>
<body>
  <header id="title">
    <h1>您访问的页面不存在</h1>
  </header>
  <div id="main">
  	点击<a href="<%=Constants.PROJECT_CONTEXT %>/LoginDisplayServlet"><b> 此处 </b></a>返回
  </div>
</body>
</html>