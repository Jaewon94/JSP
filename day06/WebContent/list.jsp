<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>
<c:set var="list" value="${dao.selectAll() }"/>
<table border="1" cellspacing="0" cellpadding="10">
	<tr>
		<th>IDX</th>
		<th>UserId</th>
		<th>UserPw</th>
		<th>UserName</th>
		<th>age</th>
		<th>email</th>
		<th>birth</th>
		<th>gender</th>
	</tr>
	<c:forEach var="member" items="${list}">
		<tr>
			<td>${member.idx }</td>
			<td>${member.userId }</td>
			<td>${member.userPw }</td>
			<td>${member.userName }</td>
			<td>${member.age }</td>
			<td>${member.email }</td>
			<td>${member.birth }</td>
			<td>${member.gender }</td>

		</tr>
	</c:forEach>
</table>
</body>
</html>