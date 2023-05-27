<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>

<jsp:useBean id="dto" class="schedule.ScheduleDTO" />
<jsp:setProperty property="*" name="dto"/>

<c:set var="add" value="${dao.add(dto) }"/>

<c:if test="${ add != 0}">
	<script>
		alert('추가 성공');
		location.href='list.jsp';
	</script>
</c:if>
<c:if test="${ add == 0}">
	<script>
		alert('추가 실패');
		history.go(-1);
	</script>
</c:if>


</body>
</html>