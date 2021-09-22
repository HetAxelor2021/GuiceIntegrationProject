<%@page import="com.hh.web.model.Alien"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body bgcolor="cyan">
	in show alien
	<%-- 
		Alien  a1 = (Alien)request.getAttribute("alien");
	--%>
	<%
		Alien a1 = (Alien)session.getAttribute("alien");	
	
		out.println(a1);
	%>
</body>
</html>