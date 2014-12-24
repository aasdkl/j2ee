<%@page import="java.util.Iterator"%>
<%@ page language="java" pageEncoding="utf-8"%>
<%@ page import="util.Constants"%>
<jsp:useBean id="userCount" scope="session" type="vo.UserCount" />
<jsp:useBean id="userScore" scope="session" type="vo.UserScore" />

<!DOCTYPE html>
<html>
<head>
<meta http-equiv='Cache-Control' content='no-cache'>
<meta http-equiv='Pragma' content='no-cache'>
<meta http-equiv='expires' content='0'>
<meta charset='UTF-8'>
<title>成绩查看</title>
</head>
<body>	
	<header id='title'>
		<h1>成绩查看</h1>
	</header>
	<div id='main'>
		<%=userScore.getUserName()%>, 你好。<br>
		你的成绩如下：<br>
		<table>
			<tr><th>课程号</th><th>课程名</th><th>成绩</th></tr>
		<% Iterator<String[]> t = userScore.getScores();
		while (t.hasNext()) { 
			String[] eachScoreSet = (String[]) t.next();%>
			<tr><td>
			<%=eachScoreSet[0]%>
			</td><td>
			<%=eachScoreSet[1]%>
			<%if (Integer.parseInt(eachScoreSet[2])<Constants.NoPassScore) {// 不及格%>
				</td><td style='color:red'>
			<%} else {%>
				</td><td>
			<%}%>
			<%=eachScoreSet[2]%>
			</td></tr>
		<%}%>
		
		
			
		</table>
		<%if (userScore.isAllPass()) {%>
			全过了！恭喜你！<br>
		<%}%>
		<a href="<%=response.encodeURL(Constants.PROJECT_CONTEXT+"/LogoutServlet")%>">退出登录</a>
	</div>
	<br />总用户数：<%=userCount.getAllUserCount()%>，已登录用户数：<%=userCount.getLogUserCount()%>，游客数：<%=userCount.getTravelUserCount()%>

</body>
</html>
