<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>

<c:set var="result" value="${dao.insert(param.name, param.pnum) }" />

<c:if test="${result != 0 }" >
	<script>
		alert('추가 성공');
		location.href='list.jsp';
	</script>
</c:if>
<c:if test="${result == 0 }" >
	<script>
		alert('추가 실패');
		history.go(-1);
	</script>
</c:if>
</body>
</html>