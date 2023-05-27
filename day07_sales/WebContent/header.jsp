<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	request.setCharacterEncoding("UTF-8");
%>
<jsp:useBean id="dao" class="sales.SalesDAO" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>sales</title>
<style>
	.toolBox  {
	display: flex;
	justify-content: space-around;
	align-items: center;
	}
	
	.normal {
		background-color: blue;
		color: white;
	}
	.cancel {
		background-color: red;
		color: white;
	}
</style>
</head>
<body>

<div class="toolBox">
	<p><a href="list.jsp">목록</a></p>
	<p><a href="add-form.jsp">추가</a></p>
</div>
<hr>
