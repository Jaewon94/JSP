<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>

<form action="add-result.jsp" method="post">
	<p><input name="sdate" type="date" required></p>
	<p><input name="title" type="text" placeholder="제목 입력" required></p>
	<p><input name="memo" type="text" placeholder="내용 입력" required></p>
	<p><input type="submit" value="추가"></p>
</form>
</body>
</html>