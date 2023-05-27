<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>


<c:set var="row" value="${dao.selectOne(param.idx) }" />
<form action="${cpath }/modify-result.jsp" method="post">

 <table>
 	
	<tr>
		<th>IDX</th>
		<td>${row.idx}</td>
	</tr>
	<tr>
		<th>NAME</th>
		<td><input type="text" name="name" value="${row.name}"></td>
	</tr>
	<tr>
		<th>NUMBER</th>
		<td><input type="text" name="pnum" value="${row.pnum}"></td>
	</tr>
	<tr>
		<th>favorites</th>
		<td>${row.favorites}</td>
	</tr>
	<tr>
		<td>
			<input type="hidden" name="idx" value="${row.idx }">
			<input type="submit" value="수정">
		</td>
	</tr>
</table>
</form>

</body>
</html>