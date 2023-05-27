<%@page import="ex01.Test2"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%
	Test2 ob6 = Test2.getInstance();

%>
<fieldset>
	<legend>ex01-directive.jsp</legend>
	<ul>
		<li>ob6 : <%=ob6 %></li>
	</ul>
</fieldset>