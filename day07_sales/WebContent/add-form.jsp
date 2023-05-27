<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>

<form action="add-result.jsp" method="post">
	<p><input name="name" type="text" placeholder="이름 입력"></p>
	<p><input name="price" type="number" placeholder="가격 입력"></p>
	<p><input name="cnt" type="number" placeholder="갯수 입력"></p>
	<p><input type="submit" value="추가하기"></p>
</form>
</body>
</html>