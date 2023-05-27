<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>

<form action="${cpath }/join-result.jsp" method="post">
	<p><input name="userId" type="text" placeholder="ID 입력" required></p>
	<p><input name="userPw" type="password" placeholder="PW 입력" required></p>
	<p><input name="userName" type="text" placeholder="이름 입력" required></p>
	<p><input name="age" type="number" placeholder="나이 입력" required></p>
	<p><input name="birth" type="date" placeholder="생일 입력" required></p>
	<p><input name="email" type="email" placeholder="email 입력"></p>
	<p><input name="gender" type="text" placeholder="성별 입력"></p>
	<p><input type="submit" value="가입하기"></p>
</form>

</body>
</html>