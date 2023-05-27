<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="member.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="cpath" value="${pageContext.request.contextPath }" />
<c:set var="dao" value="${MemberDAO.getInstance() }" />
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

<header>
	<h1><a href="${cpath}">day08_member</a></h1>
	<div>DB : ${dao.test() }</div>
	<nav>
		<ul>
			<li><a href="${cpath}/list.jsp">전체목록</a></li>
			<li><a href="${cpath}/add.jsp">추가(가입)</a></li>

		</ul>
	</nav>
</header>
<hr>