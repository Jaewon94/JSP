<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>

<c:set var="list" value="${dao.selectAll() }" />

<table border="1" cellspacing="0" cellpadding="10">
	<thead bgcolor="silver">
		<tr>
			<th>IDX</th>
			<th>USERID</th>
			<th>USERPW</th>
			<th>USERNAME</th>
			<th>BIRTH</th>
			<th>EMAIL</th>
			<th>GENDER</th>
			<th>AGE</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="dto" items="${list}">
			<tr>	
				<td>${dto.idx }</td>
				<td><a href="${cpath }/view.jsp?idx=${dto.idx}">${dto.userId }</a></td>
				<td>${dto.userPw }</td>
				<td>${dto.userName }</td>
				<td>${dto.birth }</td>
				<td>${dto.email }</td>
				<td>${dto.gender }</td>
				<td>${dto.age }</td>
			</tr>
		</c:forEach>
	</tbody>
</table>

</body>
</html>