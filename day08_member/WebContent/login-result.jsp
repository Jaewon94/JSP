<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>

<c:set var="user" value="${dao.login(param.userId, param.userPw) }" scope="session"/>

<c:if test="${user == null }">
	<script>
		alert('로그인 실패');
		history.go(-1);
	</script>
</c:if>
<c:if test="${user != null }">
	<script>
		alert('로그인 성공');
		location.href='index.jsp';
	</script>
</c:if>
</body>
</html>