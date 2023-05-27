<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>

<c:set var="row" value="${dao.selectOne(param.idx) }" />

<table>
	<tr>
		<th>IDX</th>
		<td>${row.idx}</td>
	</tr>
	<tr>
		<th>NAME</th>
		<td>${row.name}</td>
	</tr>
	<tr>
		<th>NUMBER</th>
		<td>${row.pnum}</td>
	</tr>
	<tr>
		<th>favorites</th>
		<td>${row.favorites}</td>
	</tr>
	<tr>
		<td colspan="2">
			<a href="${cpath }/modify-form.jsp?idx=${row.idx }"><button>수정하기</button></a>
		</td>
	</tr>
</table>


</body>
</html>