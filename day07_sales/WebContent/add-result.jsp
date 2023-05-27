<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>

<jsp:useBean id="input" class="sales.SalesDTO" />
<jsp:setProperty property="*" name="input"/>


<c:set var="result" value="${dao.add(input) }" />
<c:if test="${result !=0 }">
	<script>
		location.href='list.jsp';
	</script>
</c:if>
<c:if test="${result ==0 }">
	<script>
		alert('실패');
		location.go(-1);
	</script>
</c:if>
</body>
</html>