<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>

<c:set var="list" value="${dao.selectAll() }" />


<table border="1" cellspacing="0" cellpadding="10">
	<tr bgcolor="silver">
		<th>IDX</th>
		<th>NAME</th>
		<th>PRICE</th>
		<th>CNT</th>
		<th>STATUS</th>
	</tr>
	
	<c:forEach var="dto" items="${list}">
		<tr>
			<td>${dto.idx }</td>
			<td>${dto.name }</td>
			<td>${dto.price }</td>
			<td>${dto.cnt }</td>
			<td>
				<a href="changeStatus.jsp?idx=${dto.idx}">
					<button class="${dto.status == 1? 'normal' : 'cancel'}">
						${dto.status == 1 ? '정상' : '취소' }
					</button>
				</a>
			</td>
		</tr>
	</c:forEach>
</table>
</body>
</html>