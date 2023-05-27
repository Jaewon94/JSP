<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>

<form action="modify-result.jsp" method="post">
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
		<td><input name="userPw" type="password" placeholder="PW 입력" required></td>
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
		<td><input name="email" type="email" placeholder="email 입력"  value="${user.email }required"></td>
	</tr>
	<tr>
		<th>gender</th>
		<td>${user.gender }</td>
	</tr>
	<tr>
		<td>
			<input name="idx" type="hidden" value="${user.idx}">
			<input type="submit" value="수정">
		</td>
	</tr>
</table>
	
</form>

</body>
</html>