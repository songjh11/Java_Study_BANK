<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>

<c:if test="${member eq null}">
<a href="./member/login">Login</a><br>
<a href="./member/join">Join</a><br>
</c:if>
<c:if test="${not empty member}">
<a href="#">Logout</a><br>
<a href="#">My Page</a><br>
</c:if>
<hr>
<a href="./bankbook/list">List</a><br>
<a href="./bankbook/add">Add</a><br>
<a href="./member/search">Member Search</a><br>

</body>
</html>
