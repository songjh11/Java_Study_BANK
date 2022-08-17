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

<c:if test="${sessionScope.member eq null}">
<a href="./member/login.do">Login</a><br>
<a href="./member/join.do">Join</a><br>
</c:if>
<c:if test="${not empty sessionScope.member}">
<h3>${sessionScope.member.userName}님 환영합니다</h3>
<a href="./member/logout.do">Logout</a><br>
<a href="#">My Page</a><br>
</c:if>
<hr>
<a href="./bankbook/list.do">List</a><br>
<a href="./bankbook/add.do">Add</a><br>
<a href="./member/search.do">Member Search</a><br>
<a href="./board/list.do">글 목록 보기</a>

</body>
</html>
