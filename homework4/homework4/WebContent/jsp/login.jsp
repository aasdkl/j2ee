<%@ page language="java" pageEncoding="utf-8"%>
<%@ page import="util.Constants"%>
<jsp:useBean id="userCount" scope="session" type="vo.UserCount" />

<!DOCTYPE html>
<html>
<head>
<meta http-equiv='Cache-Control' content='no-cache'>
<meta http-equiv='Pragma' content='no-cache'>
<meta http-equiv='expires' content='0'>
<meta charset='UTF-8'>
<title>请登录</title>
</head>
<body>
	<header id='title'>
		<h1>登录</h1>
	</header>
	<div id='main'>
		<form role='form' id='loginForm'
			action='<%=Constants.PROJECT_CONTEXT%>/LoginServlet' method='get'>
			<!--[if IE]>帐号：<![endif]-->
			<input type='text' name='logId' id='logId' placeholder='请在此输入学号'
				value='<%=session.getAttribute("username")%>' required='required'><br />
			<!--[if IE]>密码：<![endif]-->
			<input type='password' name='logPassword' id='logPassword'
				placeholder='请在此输入密码' required='required'><br /> <input
				type='submit' id='submit' value='登录(Enter)'>
		</form>
	</div>
	<br />总用户数：<%=userCount.getAllUserCount()%>，已登录用户数：<%=userCount.getLogUserCount()%>，游客数：<%=userCount.getTravelUserCount()%>

</body>
</html>
