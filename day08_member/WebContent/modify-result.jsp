<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>

<c:set var="result" value="${dao.modify(param.idx, param.userPw, param.email)}"/>
<h1>result : ${result }</h1>

<c:if test="${result != 0 }">
	<c:remove var="user"/>
	<script>
		alert('수정 성공');
		location.href='index.jsp';
	</script>
</c:if>
<c:if test="${result == 0 }">
	<script>
		alert('수정 실패');
		history.go(-1);
	</script>
</c:if>

</body>
</html>