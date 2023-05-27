<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>

<c:set var="list" value="${dao.list() }" /> 

<table border="1px" cellspacing="0" cellpadding="10">	
  <tr bgcolor="silver">
    <th>IDX</th>
    <th>USERID</th>
    <th>USERPW</th>
    <th>USERNAME</th>
    <th>AGE</th>
    <th>BIRTH</th>
    <th>EMAIL</th>
    <th>GENDER</th>
  </tr>
  <c:forEach var="row" items="${list}">
	  <tr>
	    <td>${row.idx }</td>
	    <td>${row.userId }</td>
	    <td>${row.userPw }</td>
	    <td>${row.userName }</td>
	    <td>${row.age }</td>
	    <td>${row.birth }</td>
	    <td>${row.email }</td>
	    <td>${row.gender }</td>
	  </tr>
  </c:forEach>
  
</table>


</body>
</html>