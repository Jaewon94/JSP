<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>

<h3>회원 가입</h3>
	
<form action="add-action.jsp" method="post">
	<table>
		<tr>
			<td>ID</td>
			<td><input type="text" name="userId" placeholder="ID" required></td>
		</tr>
		<tr>
			<td>Password</td>
			<td><input type="password" name="userPw" placeholder="PW" required></td>
		</tr>
		<tr>
			<td>Name</td>
			<td><input type="text" name="userName" placeholder="Name" required></td>
		</tr>
		<tr>
			<td>Email</td>
			<td><input type="email" name="email" placeholder="foo@bar.com" required></td>
		</tr>
		<tr>
			<td>Birth</td>
			<td><input type="date" name="birth" required></td>
		</tr>
		<tr>
			<td>Gender</td>
			<td><select name="gender" required>
				<option value="">==성별==</option>
				<option value="남성">남성</option>
				<option value="여성">여성</option>
			</select></td>
		</tr>
		<tr>
			<td>Age</td>
			<td><input type="number" name="age" placeholder="Age" required></td>
		</tr>
		<tr>
			<td colspan="2">
				<input type="submit" value="회원가입">
			</td>
		</tr>
	</table>
</form>

</body>
</html>