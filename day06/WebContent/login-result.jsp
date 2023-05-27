<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>
	
	<jsp:useBean id="input" class="member1.MemberDTO" />
	<jsp:setProperty property="*" name="input"/>
	
	<c:set var="user" value="<%= dao.login(input.getUserId(), input.getUserPw())%>" scope="session"/>
	
	<c:if test="${empty user }">
		<script>
			alert('로그인 실패');
			history.go(-1);
		</script>
	</c:if>
	<c:if test="${not empty user}">
		<script>
			location.href='index.jsp';
		</script>
	</c:if>
</body>
</html>