<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="cpath" value="${pageContext.request.contextPath}"/>
<% request.setCharacterEncoding("UTF-8"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Day06 (member1)</title>
<link rel="stylesheet" href="style.css" >

</head>
<body>
	<jsp:useBean id="dao" class="member1.MemberDAO" />
	
	
	<c:if test="${empty user}">
		<header>
			<div class="nick">user : 없음</div>
			<div class="logo"><img src="img/logo.png" width="250px"></div>
			<div class="tools">
				<p><a href="login-form.jsp">로그인</a></p>
				<p><a href="join-form.jsp">회원가입</a></p>
			</div>
		</header>
	</c:if>
	<c:if test="${not empty user }">
		<header>
			<div class="nick">user : ${user.userName }</div>
			<div class="logo"><a href="index.jsp"><img src="img/logo.png" width="250px"></a></div>
			<div class="tools">
				<p><a href="logout.jsp">로그아웃</a></p>
				<p><a href="list.jsp">리스트</a></p>
				<p><a href="delete.jsp?idx=${user.idx }">회원탈퇴</a></p>
			</div>
		</header>
	</c:if>
	<hr>
</body>
</html>