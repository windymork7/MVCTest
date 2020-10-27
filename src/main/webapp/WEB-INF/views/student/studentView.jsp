<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	이름 : ${stu.name} <br>
	나이 : ${stu.age } <br>
	학년 : ${stu.classNum } <br>
	반 : ${stu.gradeNum } <br>
</body>
</html>