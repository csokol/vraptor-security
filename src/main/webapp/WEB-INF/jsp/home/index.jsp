<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
    
<html>
<head>
<title>vraptor-security</title>
</head>
<body>

<h1>Admin</h1>

<h2>Olá ${user.username}</h2>

    <%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<sec:authorize access="hasRole('ROLE_ADMIN')">
	<h3>Essa msg é pro admin!</h3>
</sec:authorize>
<sec:authorize access="hasRole('ROLE_FINANCEIRO')">
	<h3>Essa msg é pro financeiro!</h3>
</sec:authorize>
<sec:authorize access="hasRole('ROLE_FINANCEIRO') or hasRole('ROLE_ADMIN')">
	<h3>Essa msg é pro financeiro e pro admin!</h3>
</sec:authorize>

</body>
</html>