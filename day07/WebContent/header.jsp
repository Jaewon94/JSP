<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="dao" class="schedule.ScheduleDAO"/>
<% request.setCharacterEncoding("UTF-8");%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	.headerBox {
		display: flex;
		justify-content: space-around;
		align-items: center;
		
	}
	a {
	color: black;
	text-decoration: none;
	}
</style>
</head>
<body>

<div class="headerBox">
	<p><a href="list.jsp">전체목록</a></p>
	<p><a href="add-form.jsp">추가</a></p>
</div>

<hr>