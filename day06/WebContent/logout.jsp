<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>

<c:remove var="user"/>

<c:if test="${empty user }"> 
	<script>
		alert('로그아웃 완료');
		location.href='index.jsp';
	</script>
</c:if>


</body>
</html>