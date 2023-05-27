<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>

<table>
	<tr>
		<th>IDX</th>
		<td>${user.idx }</td>
	</tr>
	<tr>
		<th>userID</th>
		<td>${user.userId }</td>
	</tr>
	<tr>
		<th>userPW</th>
		<td>${user.userPw }</td>
	</tr>
	<tr>
		<th>userName</th>
		<td>${user.userName }</td>
	</tr>
	<tr>
		<th>age</th>
		<td>${user.age }</td>
	</tr>
	<tr>
		<th>birth</th>
		<td>${user.birth }</td>
	</tr>
	<tr>
		<th>email</th>
		<td>${user.email }</td>
	</tr>
	<tr>
		<th>gender</th>
		<td>${user.gender }</td>
	</tr>
	<tr>
		<td colspan="2"><a href="${cpath }/modify-form.jsp">수정하기</a></td>
	</tr>
</table>

</body>
</html>