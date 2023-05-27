<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="member.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="cpath" value="${pageContext.request.contextPath }" />
<c:set var="dao" value="${MemberDAO.getInstance() }"></c:set>
<%
	request.setCharacterEncoding("UTF-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	header {
		display: flex;
		align-items: center;
	}
	header div {
		flex:1;
	
	}
	
	header > div:last-child {
		display: flex;
		justify-content: flex-end;
	}
	p > a {
		margin-right: 10px;
	}
	
</style>
</head>
<body>

<c:if test="${user == null }">
	<header>
		<div class="userName">user : null </div>
		<div><a href="${cpath }/index.jsp"><img src="img/logo.png" width="250px"></a></div>
		<div>
			<p><a href="${cpath }/login-form.jsp">로그인</a></p>
			<p><a href="${cpath }/join-form.jsp">회원가입</a></p>
		</div>
	</header>
</c:if>
<c:if test="${user != null }">
	<header>
		<div class="userName">user : ${user.userName} </div>
		<a href="${cpath }/index.jsp"><img src="img/logo.png" width="250px"></a>
		<div>
			<p><a href="${cpath }/logout.jsp">로그아웃</a></p>
			<p><a href="${cpath }/info.jsp">회원정보</a></p>
			<p><a href="${cpath }/list.jsp">회원리스트</a></p>
			<p><a href="${cpath }/delete.jsp">회원 탈퇴</a>
		</div>
	</header>
</c:if>