<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>

<c:set var="dto" value="${dao.changeStatus(param.idx) }"/>

<c:if test="${dto == 1 }">
	<script>
		location.href='list.jsp'
	</script>
</c:if>

<c:if test="${dto == 0}">
	<script>
		alert('실패');
	</script>
</c:if>
</body>
</html>