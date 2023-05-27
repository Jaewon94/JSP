<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="phonebook.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="cpath" value="${pageContext.request.contextPath }" />
<c:set var="dao" value="${PhonebookDAO.getInstance()}"></c:set>
<% request.setCharacterEncoding("UTF-8");%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Phone Book</title>
<style>
	header {
		display: flex;
		justify-content: space-around;
		align-items: center;
	}
	header > p {
		flex:1;
		justify-content: center;
	}
	.star{
		color: red;
	}
</style>
</head>
<body>

<header>
	<p><a href="${cpath }/list.jsp">목록</a></p>
	<p><a href="${cpath }/add-form.jsp">추가</a></p>
	<p>
		<form action="${cpath }/search.jsp">
			<input type="search" name="search">
			<input type="submit" value="검색">
		</form>
	</p>
</header>
<hr>
