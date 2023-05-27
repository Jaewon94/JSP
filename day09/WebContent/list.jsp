<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>

<c:set var="list" value="${dao.selectAll() }" />
<table>
  <tr>
    <th>IDX</th>
    <th>NAME</th>
    <th>PHONE NUMBER</th>
    <th>FAVORATES</th>
    <th>즐겨찾기</th>
    <th>삭제</th>
  </tr>
  <c:forEach var="row" items="${list }">
	  <tr>
	    <td>${row.idx }</td>
	    <td><a href="${cpath }/info.jsp?idx=${row.idx}">${row.name }</a></td>
	    <td>${row.pnum }</td>
	    <td class="star">${row.favorites == 1? '★' : '☆' }</td>
	    <td><a href="${cpath }/status.jsp?idx=${row.idx}"><button>즐겨찾기</button></a></td>
	    <td><a href="${cpath }/delete.jsp?idx=${row.idx}"><button>삭제</button></a></td>
	  </tr>
  </c:forEach>
</table>


</body>
</html>