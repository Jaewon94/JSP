<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>

<c:set var="result" value="${dao.delete(user.idx) }" />
<c:if test="${result != 0 } }">
	<c:remove var="user"/>
	<script>
		alert('삭제 성공');
		location.href='index.jsp';
	</script>
</c:if>
<c:if test="${result == 0 } }">
	<script>
		alert('삭제 실패');
		history.go(-1);
	</script>
</c:if>
</body>
</html>