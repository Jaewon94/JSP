<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ex03-logout.jsp</title>
</head>
<body>
<%
	session.invalidate();
	response.sendRedirect("ex02-form.jsp");
%>
</body>
</html>