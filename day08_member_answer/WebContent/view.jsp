<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>

<c:set var="dto" value="${dao.selectOne(param.idx) }" />

<h3>회원 정보</h3>

<ul>
	<li>userId : ${dto.userId }</li>
	<li>userPw : ********</li>
	<li>userName : ${dto.userName }</li>
	<li>birth :  ${dto.birth } </li>
	<li>email : ${dto.email } </li>
	<li>gender : ${dto.gender }</li>
	<li>age : ${dto.age }</li>
</ul>

<p>
	<a href="${cpath }/modify.jsp?idx=${dto.idx}">수정</a>
	<a href="${cpath }/delete.jsp?idx=${dto.idx}">삭제</a>
</p>
</body>
</html>