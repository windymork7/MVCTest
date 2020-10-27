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

<%
	String conPath = request.getContextPath();
%>

<form action="<%=conPath %>/member/creaete">
	이름 : <input type="text" name="name" value="${member.name }">	<br>
	아이디 : <input type="text" name="id" value="${member.id }">	<br>
	<button type="submit">전송</button>
</form>

</body>
</html>