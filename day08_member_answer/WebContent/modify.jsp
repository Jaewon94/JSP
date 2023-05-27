<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>

<c:set var="dto" value="${dao.selectOne(param.idx) }"/>

<form action="modify-action.jsp" method="post">
	<table>
		<tr>
			<td>ID</td>
			<td><input type="text" name="userId" placeholder="ID" value="${dto.userId }" readonly></td>
		</tr>
		<tr>
			<td>Password</td>
			<td><input type="password" name="userPw" placeholder="PW" required></td>
		</tr>
		<tr>
			<td>Name</td>
			<td><input type="text" name="userName" placeholder="Name" value="${dto.userName }" required></td>
		</tr>
		<tr>
			<td>Email</td>
			<td><input type="email" name="email" placeholder="foo@bar.com" value="${dto.email }" required></td>
		</tr>
		<tr>
			<td>Birth</td>
			<td><input type="date" name="birth" value="${dto.birth }" required></td>
		</tr>
		<tr>
			<td>Gender</td>
			<td><select name="gender" required>
				<option value="">==성별==</option>
				<option value="남성" ${dto.gender=='남성' ? 'selected' : '' }>남성</option>
				<option value="여성" ${dto.gender=='여성' ? 'selected' : '' }>여성</option>
			</select></td>
		</tr>
		<tr>
			<td>Age</td>
			<td><input type="number" name="age" placeholder="Age" value="${dto.age }" required></td>
		</tr>
		<tr>
			<td colspan="2">
				<input type="submit" value="수정하기">
			</td>
		</tr>
	</table>
</form>

</body>
</html>