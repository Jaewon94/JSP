<%@page import="com.sun.rowset.internal.Row"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>



<c:set var="list" value="${dao.list() }" />
<table border="1" cellspacing="0" cellpadding="10">
	<tr>
		<th>IDX</th>
		<th>TITLE</th>
		<th>MEMO</th>
		<th>SDATE</th>
		<th>삭제</th>
	</tr>
	<c:forEach var="row" items="${list}">
		<tr>
			<td>${row.idx }</td>
			<td>${row.title }</td>
			<td>${row.memo }</td>
			<td>${row.sdate }</td>
			<td><a href="delete.jsp?idx=${row.idx }">삭제</a></td>
		</tr>
	</c:forEach>
</table>

</body>
</html>