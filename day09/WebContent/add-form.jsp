<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>

<form action="${cpath }/add-result.jsp">
	<p><input type="text" name="name" placeholder="이름 입력" required></p>
	<p><input type="text" name="pnum" placeholder="번호 입력" required></p>
	<p><input type="submit" value="추가하기"></p>
</form>
</body>
</html>