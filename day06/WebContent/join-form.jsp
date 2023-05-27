<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>

<form action="join-result.jsp" method="post">
	<p><input name="userId" type="text" placeholder="ID 입력" required></p>
	<p><input name="userPw" type="password" placeholder="PW 입력" required></p>
	<p><input name="userName" type="text" placeholder="이름 입력" required></p>
	<p><input name="age" type="number" placeholder="나이 입력" required></p>
	<p><input name="email" type="email" placeholder="email 입력" required></p>
	<p><input name="birth" type="text" placeholder="생일 입력 (-로 구분)" required></p>
	<p><select name="gender" required>
		<option value="">==성별==</option>
		<option value="남성">남성</option>
		<option value="여성">여성</option>
	</select></p>
	<p><input type="submit" value="회원가입"></p>
</form>

</body>
</html>