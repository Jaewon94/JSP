<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>
<h1>여기는 홈입니다.</h1>

<c:set var="banner" value="${dao.test() }" />
<h3>banner : ${banner }</h3>
</body>
</html>