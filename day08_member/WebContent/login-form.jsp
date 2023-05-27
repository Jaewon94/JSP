<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>

<form action="login-result.jsp" method="post">
	<p><input name="userId" type="text" placeholder="ID 입력" required/></p>
	<p><input name="userPw" type="password" placeholder="PW 입력" required/></p>
	<p><input type="submit" value="로그인"></p>
</form>
</body>
</html>