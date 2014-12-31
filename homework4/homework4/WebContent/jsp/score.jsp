<%@ page import="java.util.Iterator, util.Constants, vo.ScoreVO" language="java" pageEncoding="utf-8"%>
<jsp:useBean id="userCount" scope="session" type="vo.OnlineUserVO" />
<jsp:useBean id="userScore" scope="session" type="vo.ScoreListVO" />

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
		<%=userScore.getStudentName()%>, 你好。<br>
		你的成绩如下：<br>
		<table>
			<tr><th>课程号</th><th>课程名</th><th>成绩</th></tr>
		<% Iterator<ScoreVO> t = userScore.getScores();
		while (t.hasNext()) { 
			ScoreVO eachScore = t.next();%>
			<tr><td>
			<%=eachScore.getCourseId()%>
			</td><td>
			<%=eachScore.getCourseName()%>
			<%
				if (!eachScore.isPass()) {// 不及格
			%>
				</td><td style='color:red'>
			<%} else {%>
				</td><td>
			<%}%>
			<%=eachScore.getScore()%>
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
